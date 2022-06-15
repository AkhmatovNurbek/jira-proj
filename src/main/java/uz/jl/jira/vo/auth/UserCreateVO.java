package uz.jl.jira.vo.auth;

import lombok.*;
import uz.jl.jira.vo.BaseVO;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/15:40 (Tuesday)
 * jira/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class UserCreateVO implements BaseVO {
    private String userName;
    private String password;
}
