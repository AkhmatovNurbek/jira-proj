package uz.jl.jira.repository;


/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/14:41 (Tuesday)
 * jira/IntelliJ IDEA
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.jl.jira.mappers.BaseMapper;

/**
 * @param <R> -> Any sup class of Repository interface
 * @param <M> -> Any sup class of BaseMapper interface
 */

public abstract class AbstractRepository<
        R extends Repository,
        M extends BaseMapper> {

    protected final R repository;
    protected final M mapper;
    protected final Gson gson;

    protected AbstractRepository(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("YYYY-MM-dd HH:mm:ss")
                .create();
    }
}
