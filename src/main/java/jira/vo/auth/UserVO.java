package jira.vo.auth;

import jira.domains.auth.User;
import jira.enums.Role;
import jira.vo.GenericVO;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/15:41 (Tuesday)
 * jira/IntelliJ IDEA
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO extends GenericVO {
    private String userName;
    private String password;

    private Role role = Role.USER;
    private LocalDateTime createdAt;

    public UserVO(User user) {
        super(user.getId());
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.createdAt = user.getCreatedAt();
        this.role = user.getRole();
    }

    @Builder(builderMethodName = "childBuilder")
    public UserVO(Long id, String userName, String password, LocalDateTime createdAt , Role role) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.createdAt = createdAt;
        this.role = role;
    }
}
