package jira.ui;

import jira.Application;
import jira.configs.ApplicationContextHolder;
import jira.domains.auth.User;
import jira.enums.Role;
import jira.repository.auth.UserRepository;
import jira.services.auth.UserService;
import jira.session.SessionUser;
import jira.utils.Color;
import jira.utils.Reader;
import jira.utils.Writer;
import jira.vo.auth.UserCreateVO;
import jira.vo.auth.UserVO;
import jira.vo.response.Data;


import jira.vo.response.ResponseEntity;

import java.util.Optional;

public class BaseMenu {

    private final static UserService userService = ApplicationContextHolder.getBean(UserService.class);
    public static void baseMenu() {

        Writer.println("-----------------", Color.PURPLE);
        Writer.println("    BASIC MENU", Color.GREEN);
        Writer.println("-----------------", Color.PURPLE);
        Writer.println("Sign In     -> 1");
        Writer.println("Sign Up     -> 2");
        Writer.println("Quit        -> 0");
        Writer.println("-----------------", Color.PURPLE);
        String choice = Reader.read("?: ");
        Writer.println("-----------------", Color.PURPLE);

        switch (choice){
            case "1" -> signIn();
            case "2" -> signUp();
            case "0" -> System.exit(0);
        }
    }

    private static void signUp() {
        UserCreateVO userCreatVO = UserCreateVO
                .builder()
                .userName(Reader.read("Username :"))
                .password(Reader.read("Password :"))
                .email(Reader.read("Email :"))
                .build();
        ResponseEntity<Data<Long>> responseData = userService.create(userCreatVO);
        if(responseData.getData().isSuccess()){
            Optional<User> userOptional = UserRepository.findByUsername(responseData.getData().getBody());
            Application.sessionUser = new SessionUser();
            if(userOptional.isPresent()){
                Application.sessionUser.setId(userOptional.get().getId());
                Application.sessionUser.setUsername(userOptional.get().getUserName());
                Writer.println("Successfully created", Color.GREEN);
            }
            else{
                Writer.println("Not found user", Color.RED);
            }
        }
        else Writer.println(responseData.getData().getError().getFriendlyMessage() , Color.RED);

    }


    private static void signIn() {
        UserCreateVO userCreatVO = UserCreateVO
                .builder()
                .userName(Reader.read("Username :"))
                .password(Reader.read("Password :"))
                .build();
        ResponseEntity<Data<UserVO>> dataResponseUser = userService.checkIn(userCreatVO);


        if(dataResponseUser.getData().isSuccess()){
            Role role = dataResponseUser.getData().getBody().getRole();
            switch (role){
                case USER -> UserUI.userPage();
                case ADMIN ->AdminUI.adminPage();
                case MANAGER -> ManagerUI.managerPage();
                case SUPER_ADMIN ->SuperAdminUI.superAdminPage();
                //aaa
            }
        }
    }
}
