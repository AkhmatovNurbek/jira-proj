package jira.ui;

import jira.ui.ProjectManager.ProjectManager;

public class ManagerUI {

    public static void managerPage() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.managerDepartment();
    }
}
