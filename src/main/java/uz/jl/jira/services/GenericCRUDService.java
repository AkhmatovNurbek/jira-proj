package uz.jl.jira.services;

import lombok.NonNull;
import uz.jl.jira.criteria.GenericCriteria;
import uz.jl.jira.vo.BaseVO;
import uz.jl.jira.vo.GenericVO;
import uz.jl.jira.vo.response.Data;
import uz.jl.jira.vo.response.ResponseEntity;

import java.io.Serializable;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/15:15 (Tuesday)
 * jira/IntelliJ IDEA
 */

/**
 * @param <CVO> -> Value Object to persist new entity
 * @param <UVO> -> Update Value Object to update existing entity
 * @param <ID>  -> Id(Primary Key of Entity)
 */
public interface GenericCRUDService<
        VO extends GenericVO,
        CVO extends BaseVO,
        UVO extends GenericVO,
        C extends GenericCriteria,
        ID extends Serializable> extends GenericService<VO, C, ID> {
    ResponseEntity<Data<ID>> create(@NonNull CVO dto);

    ResponseEntity<Data<Void>> delete(@NonNull ID id);

    ResponseEntity<Data<Void>> update(@NonNull UVO dto);

}
