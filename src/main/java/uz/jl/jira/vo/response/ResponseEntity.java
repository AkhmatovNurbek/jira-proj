package uz.jl.jira.vo.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.jl.jira.vo.response.Data;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/15:10 (Tuesday)
 * jira/IntelliJ IDEA
 */

@Getter
@Setter
@ToString
public class ResponseEntity<T> {
    private T data;
    private Integer status;


    public ResponseEntity(T data) {
        this.data = data;
        this.status = 200;
    }

    public ResponseEntity(T data, Integer status) {
        this.data = data;
        this.status = status;
    }
}
