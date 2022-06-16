package jira.ui;

import jira.utils.Color;
import jira.utils.Reader;
import jira.utils.Writer;

import java.io.IOException;

public class AdminUI {

    public static void adminPage() throws IOException {
        Writer.println("CRUD User   -> 1");
        Writer.println("CRUD Project   -> 2");
        Writer.println("Back        -> 0");
        String choice = Reader.read("?: ");

        switch (choice){
            case "1" -> crudUser();
            case "2" -> crudProject();
            case "0" -> BaseMenu.baseMenu();
            default -> Writer.println("Wrong choice", Color.RED);
        }

        adminPage();
    }


    private static void crudUser() {
        Writer.println("Create User    -> 1");
    }
    private static void crudProject() {

    }


}
