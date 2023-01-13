package Modele.DAO;

import java.sql.SQLException;
import java.util.Collection;

public interface DaoT<T> {
    public void create(T tupple) throws SQLException;

    public void update(T tupple) throws SQLException;

    public void delete(T tupple) throws SQLException;

    public Collection<T> findAll() throws SQLException;
}
