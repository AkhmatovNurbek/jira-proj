package uz.jl.jira.services;

import lombok.NonNull;
import uz.jl.jira.criteria.GenericCriteria;
import uz.jl.jira.vo.GenericVO;
import uz.jl.jira.vo.response.Data;
import uz.jl.jira.vo.response.ResponseEntity;

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
