package jira.domains.auth;

import jira.domains.BaseEntity;
import jira.enums.Role;
import lombok.*;


import java.time.LocalDateTime;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/15:03 (Tuesday)
 * jira/IntelliJ IDEA
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User implements BaseEntity {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private Role role = Role.ADMIN;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
