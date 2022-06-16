package jira.session;


import jira.enums.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class SessionUser {
    private Long id;
    private String username;
    private Role role;
}
