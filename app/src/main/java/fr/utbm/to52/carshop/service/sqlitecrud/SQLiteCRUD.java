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

    public void ins(T obj) {
        dao.ins(obj);
    }

    public void upd(T obj) {
        dao.upd(obj);
    }

    public void del(T obj) {
        dao.del(obj);
    }

    public List<T> get() {
        return dao.get();
    }
}
