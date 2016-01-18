package fr.utbm.to52.carshop.service.mysqlcrud;

import java.util.List;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public interface MysqlBaseCRUD <T> {

    T ins(T obj);

    void upd(T obj);

    void del(long id);

    List<T> get();
}
