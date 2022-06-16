package jira.vo.response;

import lombok.Getter;
import lombok.ToString;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/15:09 (Tuesday)
 * jira/IntelliJ IDEA
 */

@Getter
@ToString
public class Data<T> {
    private T body;
    private ErrorVO error;
    private Integer total;

    private boolean success;


    public Data(T body) {
        this.body = body;
        this.success = true;
    }

    public Data(T body, Integer total) {
        this.success = true;
        this.body = body;
        this.total = total;
    }

    public Data(ErrorVO error) {
        this.error = error;
        this.success = false;
    }
}
