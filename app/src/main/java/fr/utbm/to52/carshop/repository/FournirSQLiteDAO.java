package fr.utbm.to52.carshop.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.utbm.to52.carshop.entity.Commande;
import fr.utbm.to52.carshop.entity.Fournir;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Column;
import fr.utbm.to52.carshop.utils.DataBaseUtils.DatabaseInfoProvider;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Table;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class FournirSQLiteDAO extends BaseSQLiteDao implements BaseDAO<Fournir> {

    /**
     * The table fournir used for operations
     */
    private final Table fournirTable;

    public FournirSQLiteDAO(Context context, Table fournirTable) {
        super(context);

        this.fournirTable = DatabaseInfoProvider.getMapOfDatabaseTables().get("FOURNIR");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ins(Fournir obj) {
        Fournir fournir = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = fournirTable.getColumns();

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

        values.put(columns.get("idArticle").toString(), fournir.getIdArticle());
        values.put(columns.get("idFournisseur").toString(), fournir.getIdFournisseur());
        values.put(columns.get("qte").toString(), fournir.getQteFournie());
        values.put(columns.get("dateDemandeApprov").toString(), formatter.format(fournir.getDateDemandeApprov()));
        values.put(columns.get("dateLivraison").toString(), formatter.format(fournir.getDateLivraison()));

        fournir.setIdFournir(sqLiteDatabase.insert(fournirTable.getTableName(), null, values));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void upd(Fournir obj) {
        Fournir fournir = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = fournirTable.getColumns();

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

        values.put(columns.get("idFournir").toString(), fournir.getIdFournir());
        values.put(columns.get("idArticle").toString(), fournir.getIdArticle());
        values.put(columns.get("idFournisseur").toString(), fournir.getIdFournisseur());
        values.put(columns.get("qte").toString(), fournir.getQteFournie());
        values.put(columns.get("dateDemandeApprov").toString(), formatter.format(fournir.getDateDemandeApprov()));
        values.put(columns.get("dateLivraison").toString(), formatter.format(fournir.getDateLivraison()));

        sqLiteDatabase.update(
                fournirTable.getTableName(),
                values,
                fournirTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(fournir.getIdFournir())});
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void del(Fournir obj) {
        sqLiteDatabase.delete(
                fournirTable.getTableName(),
                fournirTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(obj.getIdFournir())});
    }

    @Override
    public List<Fournir> get() {
        Cursor c = sqLiteDatabase.rawQuery("select * from " + fournirTable.getTableName(), null);

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

        List<Fournir> fournirs = new ArrayList<>();

        while(c.moveToNext()) {
            c.moveToFirst();
            Fournir fournir = null;
            try {
                fournir = new Fournir(
                        c.getLong(1),
                        c.getLong(2),
                        null,
                        null,
                        c.getLong(3),
                        formatter.parse(c.getString(4)),
                        formatter.parse(c.getString(5))
                );
            } catch (ParseException e) {
                e.printStackTrace();
            }
            fournir.setIdFournir(c.getLong(0));
            fournirs.add(fournir);
        }
        c.close();
        return fournirs;
    }
}
