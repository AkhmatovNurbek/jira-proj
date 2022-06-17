package jira.ui.ProjectManager;

import jira.domains.auth.Organization;
import jira.domains.auth.User;
import jira.repository.auth.UserRepository;
import jira.utils.Color;
import jira.utils.Reader;
import jira.utils.Writer;
import lombok.SneakyThrows;

import java.util.*;


public class ProjectManager implements ProjectChange {

    private Organization.Project project = new Organization.Project();
    private Organization.Project.Column.Task task = new Organization.Project.Column.Task();



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

    @SneakyThrows
    @Override
    public void crudProject() {
        Writer.println(" <1> Create project");
        Writer.println(" <2> Show projects");
        Writer.println(" <3> Change project");
        Writer.println(" <4> Delete project");
        Writer.println("Enter option: ", Color.BLUE);
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> createProject();
            case 2 -> showProject();
            case 3 -> changeProject();
            case 4 -> deleteProject();
            default -> {
                Writer.println("Not found option", Color.RED);
                Writer.print("Try again!");
                Thread.sleep(3000);
            }
        }
    }

    @Override
    public void giveTask() {
        for (User user : UserRepository.users) {
            Writer.println("Username: "+user.getUserName());
            Writer.println("E-mail: "+user.getEmail());
            Writer.println("Id: "+user.getId());
        }
        Writer.println("Enter user id: ");
        Long id = new Scanner(System.in).nextLong();
        for (User user : UserRepository.users) {
            if (user.getId().equals(id)){
                project.setColumns(new ArrayList<>());
            }
        }

    }

    @Override
    public void createProject() {
        project.setId(System.currentTimeMillis());
        project.setName("Task1");
    }

    @Override
    public void showProject() {

    }

    @Override
    public void changeProject() {

    }

    @Override
    public void deleteProject() {

    }
}
