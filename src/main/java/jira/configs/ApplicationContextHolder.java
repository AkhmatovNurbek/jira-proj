package jira.configs;

import jira.mappers.BaseMapper;
import jira.repository.auth.UserRepository;
import jira.services.auth.UserService;


public class ApplicationContextHolder {

    public static <T> T getBean(Class<T> clazz) {
        return switch (clazz.getSimpleName()) {
            case "UserService" -> (T) UserService.getInstance();
            case "UserRepository" -> (T) UserRepository.getInstance();
            case "BaseMapper" -> (T) new BaseMapper() {
            };
            default -> throw new RuntimeException("Bean with name '%s' not found".formatted(clazz.getSimpleName()));
        };
    }

}
