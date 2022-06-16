package jira.ui;

import jira.configs.ApplicationContextHolder;
import jira.criteria.UserCriteria;
import jira.services.auth.UserService;
import jira.utils.Color;
import jira.utils.Reader;
import jira.utils.Writer;
import jira.vo.auth.UserCreateVO;
import jira.vo.auth.UserVO;
import jira.vo.response.Data;
import jira.vo.response.ResponseEntity;

import java.util.List;
import java.util.Scanner;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/15:44 (Tuesday)
 * jira/IntelliJ IDEA
 */
public class UI {

    private final static UserService userService = ApplicationContextHolder.getBean(UserService.class);

    public static void main(String[] args) {
        Writer.println("User Create -> 1");
        Writer.println("User List -> 2");
        String choice = new Scanner(System.in).next();
        if (choice.equals("1")) userCreate();
        else if (choice.equals("2")) userList();
        else System.exit(0);
        main(args);
    }

    private static void userList() {
        ResponseEntity<Data<List<UserVO>>> responseData = userService.findAll(new UserCriteria());
        Data<List<UserVO>> data = responseData.getData();
        if (data.isSuccess()) {
            Writer.println(responseData.getData(), Color.GREEN);
        } else {
            Writer.println(data.getError(), Color.RED);
        }
    }

    private static void userCreate() {
        UserCreateVO.UserCreateVOBuilder builder = UserCreateVO.builder();
        builder.userName(Reader.read("Username : "));
        builder.password(Reader.read("Password : "));
        UserCreateVO userCreateVO = builder.build();
        ResponseEntity<Data<Long>> responseData = userService.create(userCreateVO);
        if (responseData.getData().isSuccess()) {
            Writer.println(responseData.getData(), Color.GREEN);
        }
        else {
            Writer.println(responseData.getData().getError(), Color.RED);
        }
    }
}
