package uz.jl.jira.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/15:13 (Tuesday)
 * jira/IntelliJ IDEA
 */

@Setter
@Getter
public class ErrorVO {
    private String friendlyMessage;
    private String developerMessage;
    private Integer status;
    private Timestamp timestamp;

    @Builder
    public ErrorVO(String friendlyMessage, String developerMessage, Integer status) {
        this.friendlyMessage = friendlyMessage;
        this.developerMessage = developerMessage;
        this.status = status;
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
    }
}
