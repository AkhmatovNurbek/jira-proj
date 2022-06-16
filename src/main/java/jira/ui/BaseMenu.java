package jira.ui;

import jira.configs.ApplicationContextHolder;
import jira.services.auth.UserService;
import jira.utils.Color;
import jira.utils.Reader;
import jira.utils.Writer;

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

    }

    private static void signIn() {

    }
}
