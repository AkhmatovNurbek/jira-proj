package jira.repository.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jira.criteria.UserCriteria;
import jira.domains.auth.User;
import jira.enums.Role;
import jira.repository.GenericCRUDRepository;
import jira.vo.auth.UserCreateVO;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


import java.io.*;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/14:45 (Tuesday)
 * jira/IntelliJ IDEA
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository implements GenericCRUDRepository<User, UserCriteria, Long> {

    private static UserRepository instance;
    private static final List<User> users = load();

    private static List<User> load() {
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/jira/services/users.json"));
            Type type = new TypeToken<List<User>>(){}.getType();
            List<User> users1 = gson.fromJson(reader , type);
            return users1;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // TODO: 6/15/2022 load data from file here
    }




    @Override
    public void create(User entity) {
        entity.setId(System.currentTimeMillis());
        entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        users.add(entity);
        try {
            FileWriter fileWriter = new FileWriter("src/main/java/jira/services/users.json");
            Gson gson =new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(users,fileWriter);
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void deleteByID(Long aLong) {

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> findAll(UserCriteria criteria) {
        return Optional.of(users);
    }


    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public static Optional<User> findByUsername(UserCreateVO userCreateVO) {
        return users.stream()
                .filter(user -> user.getUserName().equalsIgnoreCase(userCreateVO.getUserName())
                        && user.getPassword().equals(userCreateVO.getPassword()))
                .findFirst();
    }

    public static Optional<User> findByUsername(Long id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
