package fr.utbm.to52.carshop.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.utbm.to52.carshop.entity.Article;
import fr.utbm.to52.carshop.entity.Concerner;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Column;
import fr.utbm.to52.carshop.utils.DataBaseUtils.DatabaseInfoProvider;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Table;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class ConcernerSQLiteDAO extends BaseSQLiteDao implements BaseDAO<Concerner> {

    /**
     * The table concerner used for operations
     */
    private final Table concernerTable;

    public ConcernerSQLiteDAO(Context context, Table concernerTable) {
        super(context);

        this.concernerTable = DatabaseInfoProvider.getMapOfDatabaseTables().get("CONCERNER");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ins(Concerner obj) {
        Concerner concerner = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = concernerTable.getColumns();

        values.put(columns.get("idCommande").toString(), concerner.getIdCommande());
        values.put(columns.get("idArticle").toString(), concerner.getIdArticle());
        values.put(columns.get("qte").toString(), concerner.getQte());

        concerner.setIdConcerner(sqLiteDatabase.insert(concernerTable.getTableName(), null, values));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void upd(Concerner obj) {
        Concerner concerner = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = concernerTable.getColumns();

        values.put(columns.get("idConcerner").toString(), concerner.getIdConcerner());
        values.put(columns.get("idCommande").toString(), concerner.getIdCommande());
        values.put(columns.get("idArticle").toString(), concerner.getIdArticle());
        values.put(columns.get("qte").toString(), concerner.getQte());

        sqLiteDatabase.update(
                concernerTable.getTableName(),
                values,
                concernerTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(concerner.getIdConcerner())});
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void del(Concerner obj) {
        sqLiteDatabase.delete(
                concernerTable.getTableName(),
                concernerTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(obj.getIdConcerner())});
    }

    @Override
    public List<Concerner> get() {
        Cursor c = sqLiteDatabase.rawQuery("select * from " + concernerTable.getTableName(), null);
        List<Concerner> concerners = new ArrayList<>();

        while(c.moveToNext()) {
            c.moveToFirst();
            Concerner concerner = new Concerner(
                    c.getLong(1),
                    c.getLong(2),
                    null,
                    null,
                    c.getInt(3)
            );
            concerner.setIdConcerner(c.getLong(0));
            concerners.add(concerner);
        }
        c.close();
        return concerners;
    }
}
