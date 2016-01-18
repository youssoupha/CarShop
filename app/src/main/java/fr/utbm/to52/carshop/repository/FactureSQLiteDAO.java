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
import fr.utbm.to52.carshop.entity.Facture;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Column;
import fr.utbm.to52.carshop.utils.DataBaseUtils.DatabaseInfoProvider;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Table;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class FactureSQLiteDAO extends BaseSQLiteDao implements BaseDAO<Facture> {

    /**
     * The table facture used for operations
     */
    private final Table factureTable;

    public FactureSQLiteDAO(Context context, Table factureTable) {
        super(context);

        this.factureTable = DatabaseInfoProvider.getMapOfDatabaseTables().get("FACTURE");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Facture ins(Facture obj) {
        Facture facture = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = factureTable.getColumns();

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        values.put(columns.get("dateFacture").toString(), formatter.format(facture.getDateFacture()));

        facture.setIdFacture(sqLiteDatabase.insert(factureTable.getTableName(), null, values));

        return facture;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void upd(Facture obj) {
        Facture facture = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = factureTable.getColumns();

        values.put(columns.get("idFacture").toString(), facture.getIdFacture());
        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        values.put(columns.get("dateFacture").toString(), formatter.format(facture.getDateFacture()));

        sqLiteDatabase.update(
                factureTable.getTableName(),
                values,
                factureTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(facture.getIdFacture())});
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void del(long id) {
        sqLiteDatabase.delete(
                factureTable.getTableName(),
                factureTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(id)});
    }

    @Override
    public List<Facture> get() {
        Cursor c = sqLiteDatabase.rawQuery("select * from " + factureTable.getTableName(), null);

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

        List<Facture> factures = new ArrayList<>();

        while(c.moveToNext()) {
            c.moveToFirst();
            Facture facture = null;
            try {
                facture = new Facture(
                        formatter.parse(c.getString(2)),
                        c.getLong(1),
                        null
                );
            } catch (ParseException e) {
                e.printStackTrace();
            }
            facture.setIdFacture(c.getLong(0));
            factures.add(facture);
        }
        c.close();
        return factures;
    }
}
