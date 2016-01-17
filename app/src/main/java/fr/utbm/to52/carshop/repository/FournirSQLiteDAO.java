package fr.utbm.to52.carshop.repository;

import android.content.ContentValues;
import android.content.Context;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

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
    public Fournir ins(Fournir obj) {
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

        return fournir;
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
    public void del(long id) {
        sqLiteDatabase.delete(
                fournirTable.getTableName(),
                fournirTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(id)});
    }

    @Override
    public Fournir get(long id) {
        return null;
    }
}
