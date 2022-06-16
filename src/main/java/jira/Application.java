package jira;

import jira.session.SessionUser;
import jira.ui.BaseMenu;
/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/14:31 (Tuesday)
 * jira/IntelliJ IDEA
 */

public class Application {
    public static SessionUser sessionUser = null;
    public static void main(String[] args) {
        BaseMenu.baseMenu();
        main(args);

        //hello
    }
}
