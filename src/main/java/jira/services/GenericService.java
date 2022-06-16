package jira.services;

import jira.criteria.GenericCriteria;
import jira.vo.GenericVO;
import jira.vo.response.Data;
import jira.vo.response.ResponseEntity;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/15:07 (Tuesday)
 * jira/IntelliJ IDEA
 */
public interface GenericService<
        Vo extends GenericVO,
        C extends GenericCriteria,
        ID extends Serializable> {

    ResponseEntity<Data<Vo>> findById(@NonNull ID id);

    ResponseEntity<Data<List<Vo>>> findAll(@NonNull C criteria);
}
