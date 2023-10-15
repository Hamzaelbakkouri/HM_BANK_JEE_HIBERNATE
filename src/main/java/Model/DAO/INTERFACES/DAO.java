package Model.DAO.INTERFACES;

import java.util.Optional;

public interface DAO<T, V> {
    Optional<T> insert(T t);
    Optional<T> getOne(V t);
}
