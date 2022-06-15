package uz.jl.jira.configs;

import uz.jl.jira.mappers.BaseMapper;
import uz.jl.jira.repository.auth.UserRepository;
import uz.jl.jira.services.auth.UserService;

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
