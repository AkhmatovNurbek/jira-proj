package jira;

import jira.session.SessionUser;
import jira.ui.BaseMenu;

import java.io.IOException;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/14:31 (Tuesday)
 * jira/IntelliJ IDEA
 */

public class Application {
    public static SessionUser sessionUser = null;
    public static void main(String[] args) throws IOException {
        BaseMenu.baseMenu();
        main(args);
    }
}
