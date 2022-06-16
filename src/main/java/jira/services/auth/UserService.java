package jira.services.auth;

import jira.configs.ApplicationContextHolder;
import jira.criteria.UserCriteria;
import jira.domains.auth.User;
import jira.mappers.BaseMapper;
import jira.repository.AbstractRepository;
import jira.repository.auth.UserRepository;
import jira.services.GenericCRUDService;
import jira.vo.auth.UserCreateVO;
import jira.vo.auth.UserUpdateVO;
import jira.vo.auth.UserVO;
import jira.vo.response.Data;
import jira.vo.response.ErrorVO;
import jira.vo.response.ResponseEntity;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserService extends AbstractRepository<UserRepository, BaseMapper> implements
        GenericCRUDService<UserVO, UserCreateVO, UserUpdateVO, UserCriteria, Long> {

    private static UserService instance;


    private UserService(UserRepository repository, BaseMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull UserCreateVO dto) {
        User user = new User();
        Optional<User> userOptional = repository.findByUsername(dto);
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(new Data<>(ErrorVO
                    .builder()
                    .friendlyMessage("User Name '%s already taken".formatted(dto.getUserName()))
                    .status(400)
                    .build()));
        }

        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        repository.create(user);

        return new ResponseEntity<>(new Data<>(user.getId()));
    }

    @Override
    public ResponseEntity<Data<Void>> delete(@NonNull Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> update(@NonNull UserUpdateVO dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<UserVO>> findById(@NonNull Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<UserVO>>> findAll(@NonNull UserCriteria criteria) {

        List<UserVO> userList = repository.findAll(criteria)
                .orElse(new ArrayList<>())
                .stream().map(UserVO::new)
                .toList();

        return new ResponseEntity<>(new Data<>(userList, userList.size()));
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService(
                    ApplicationContextHolder.getBean(UserRepository.class),
                    ApplicationContextHolder.getBean(BaseMapper.class)
            );
        }
        return instance;
    }


    public ResponseEntity<Data<UserVO>>  checkIn(UserCreateVO userCreatVO) {
        User user = new User();
        Optional<User> userOptional = repository.findByUsername(userCreatVO);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(new Data<>(ErrorVO
                    .builder()
                    .friendlyMessage("User Name '%s not found".formatted(userCreatVO.getUserName()))
                    .status(400)
                    .build()));
        }
        return new ResponseEntity<>(new Data<>(new UserVO(user)));
    }
}
