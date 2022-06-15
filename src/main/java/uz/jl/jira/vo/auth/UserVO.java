package uz.jl.jira.vo.auth;

import lombok.*;
import uz.jl.jira.domains.auth.User;
import uz.jl.jira.vo.GenericVO;

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
    private LocalDateTime createdAt;

    public UserVO(User user) {
        super(user.getId());
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.createdAt = user.getCreatedAt();
    }

    @Builder(builderMethodName = "childBuilder")
    public UserVO(Long id, String userName, String password, LocalDateTime createdAt) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.createdAt = createdAt;
    }
}
