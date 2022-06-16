package jira.repository;

import jira.criteria.GenericCriteria;
import jira.domains.BaseEntity;


import java.io.Serializable;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/14:57 (Tuesday)
 * jira/IntelliJ IDEA
 */
public interface GenericCRUDRepository<
        E extends BaseEntity,
        C extends GenericCriteria,
        ID extends Serializable
        > extends GenericRepository<E, C, ID> {

    void create(E entity);

    void update(E entity);

    void deleteByID(ID id);
}
