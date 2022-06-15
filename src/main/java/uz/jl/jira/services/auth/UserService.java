package uz.jl.jira.services.auth;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import uz.jl.jira.configs.ApplicationContextHolder;
import uz.jl.jira.criteria.UserCriteria;
import uz.jl.jira.domains.auth.User;
import uz.jl.jira.mappers.BaseMapper;
import uz.jl.jira.repository.AbstractRepository;
import uz.jl.jira.repository.auth.UserRepository;
import uz.jl.jira.services.GenericCRUDService;
import uz.jl.jira.vo.auth.UserCreateVO;
import uz.jl.jira.vo.auth.UserUpdateVO;
import uz.jl.jira.vo.auth.UserVO;
import uz.jl.jira.vo.response.Data;
import uz.jl.jira.vo.response.ErrorVO;
import uz.jl.jira.vo.response.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserService extends AbstractRepository<UserRepository, BaseMapper> implements
        GenericCRUDService<UserVO, UserCreateVO, UserUpdateVO, UserCriteria, Long> {

    private static UserService instance;


    private UserService(UserRepository repository, BaseMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull UserCreateVO dto) {
        User user = new User();
        Optional<User> userOptional = repository.findByUsername(dto.getUserName());
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(new Data<>(ErrorVO
                    .builder()
                    .friendlyMessage("User Name '%s already taken".formatted(dto.getUserName()))
                    .status(400)
                    .build()));
        }

        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        repository.create(user);

        return new ResponseEntity<>(new Data<>(user.getId()));
    }

    @Override
    public ResponseEntity<Data<Void>> delete(@NonNull Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> update(@NonNull UserUpdateVO dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<UserVO>> findById(@NonNull Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<UserVO>>> findAll(@NonNull UserCriteria criteria) {

        List<UserVO> userList = repository.findAll(criteria)
                .orElse(new ArrayList<>())
                .stream().map(UserVO::new)
                .toList();

        return new ResponseEntity<>(new Data<>(userList, userList.size()));
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService(
                    ApplicationContextHolder.getBean(UserRepository.class),
                    ApplicationContextHolder.getBean(BaseMapper.class)
            );
        }
        return instance;
    }

}
