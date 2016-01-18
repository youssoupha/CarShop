package fr.utbm.to52.carshop.service.mysqlcrud;

import java.util.List;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public interface MysqlBaseCRUD <T> {

    void ins(T obj);

    void upd(T obj);

    void del(T obj);

    List<T> get();
}
