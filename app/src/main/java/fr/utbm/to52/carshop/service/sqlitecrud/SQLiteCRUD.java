package fr.utbm.to52.carshop.service.sqlitecrud;

import java.util.List;

import fr.utbm.to52.carshop.repository.BaseDAO;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class SQLiteCRUD<T> {

    private final BaseDAO<T> dao;

    public SQLiteCRUD(BaseDAO<T> dao) {
        this.dao = dao;
    }

    T ins(T obj) {
        return dao.ins(obj);
    }

    void upd(T obj) {
        dao.upd(obj);
    }

    void del(long id) {
        dao.del(id);
    }

    List<T> get() {
        return dao.get();
    }
}
