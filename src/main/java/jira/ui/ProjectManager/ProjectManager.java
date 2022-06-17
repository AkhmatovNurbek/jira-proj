package jira.ui.ProjectManager;

import jira.utils.Color;
import jira.utils.Writer;
import lombok.SneakyThrows;

import java.util.Scanner;

public class ProjectManager implements ProjectChange {

    @SneakyThrows
    public void managerDepartment() {
        Writer.println(" <1> CRUD own project");
        Writer.println(" <2> Give tasks to users");
        Writer.print("Enter option: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> crudProject();
            case 2 -> giveTask();
            default -> {
                Writer.println("Not found option", Color.RED);
                Writer.print("Try again!");
                Thread.sleep(3000);
            }
        }
    }

    @Override
    public void crudProject() {

    }

    @Override
    public void giveTask() {

    }
}
