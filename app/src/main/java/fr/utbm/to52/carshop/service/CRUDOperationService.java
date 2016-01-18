package fr.utbm.to52.carshop.service;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.to52.carshop.service.mysqlcrud.MysqlBaseCRUD;
import fr.utbm.to52.carshop.service.sqlitecrud.SQLiteCRUD;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class CRUDOperationService {

    private Context context;

    CRUDOperationService(Context context) {
        this.context = context;
    }

    public <T> void addToDb(T e, SQLiteCRUD<T> sqLiteCRUD, MysqlBaseCRUD<T> mysqlCRUD) {
        mysqlCRUD.ins(e);
        sqLiteCRUD.ins(e);
    }

    public <T> void editFromDb(T e, SQLiteCRUD<T> sqLiteCRUD, MysqlBaseCRUD<T> mysqlCRUD) {
        mysqlCRUD.upd(e);
        sqLiteCRUD.upd(e);
    }

    public <T> void delFromDb(T e, SQLiteCRUD<T> sqLiteCRUD, MysqlBaseCRUD<T> mysqlCRUD) {
        mysqlCRUD.del(e);
        sqLiteCRUD.del(e);
    }

    public <T> List<T> getFromDB (T e, SQLiteCRUD<T> sqLiteCRUD, MysqlBaseCRUD<T> mysqlCRUD) {
        List<T> list = new ArrayList<>();
        if(ConnectionMonitoringService.isConnectedToNetwork(context))
            list.addAll(mysqlCRUD.get());
        else
            list.addAll(sqLiteCRUD.get());

        return list;
    }

}