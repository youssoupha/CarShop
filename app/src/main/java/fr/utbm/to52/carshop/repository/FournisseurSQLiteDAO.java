package fr.utbm.to52.carshop.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.utbm.to52.carshop.entity.Article;
import fr.utbm.to52.carshop.entity.Fournisseur;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Column;
import fr.utbm.to52.carshop.utils.DataBaseUtils.DatabaseInfoProvider;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Table;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class FournisseurSQLiteDAO extends BaseSQLiteDao implements BaseDAO<Fournisseur> {

    /**
     * The table fournisseur used for operations
     */
    private final Table fournisseurTable;

    public FournisseurSQLiteDAO(Context context, Table fournisseurTable) {
        super(context);

        this.fournisseurTable = DatabaseInfoProvider.getMapOfDatabaseTables().get("FOURNISSEUR");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ins(Fournisseur obj) {
        Fournisseur fournisseur = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = fournisseurTable.getColumns();


        values.put(columns.get("codeFournisseur").toString(), fournisseur.getCodeFournisseur());
        values.put(columns.get("nomFournisseur").toString(), fournisseur.getNomFournisseur());
        values.put(columns.get("adressFournisseur").toString(), fournisseur.getAdressFournisseur());

        fournisseur.setIdFournisseur(sqLiteDatabase.insert(fournisseurTable.getTableName(), null, values));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void upd(Fournisseur obj) {
        Fournisseur fournisseur = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = fournisseurTable.getColumns();

        values.put(columns.get("idFournisseur").toString(), fournisseur.getIdFournisseur());
        values.put(columns.get("codeFournisseur").toString(), fournisseur.getCodeFournisseur());
        values.put(columns.get("nomFournisseur").toString(), fournisseur.getNomFournisseur());
        values.put(columns.get("adressFournisseur").toString(), fournisseur.getAdressFournisseur());

        sqLiteDatabase.update(
                fournisseurTable.getTableName(),
                values,
                fournisseurTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(fournisseur.getIdFournisseur())});
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void del(Fournisseur obj) {
        sqLiteDatabase.delete(
                fournisseurTable.getTableName(),
                fournisseurTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(obj.getIdFournisseur())});
    }

    @Override
    public List<Fournisseur> get() {
        Cursor c = sqLiteDatabase.rawQuery("select * from " + fournisseurTable.getTableName(), null);
        List<Fournisseur> fournisseurs = new ArrayList<>();

        while(c.moveToNext()) {
            c.moveToFirst();
            Fournisseur fournisseur = new Fournisseur(
                    c.getString(1),
                    c.getString(2),
                    c.getString(3)
            );
            fournisseur.setIdFournisseur(c.getLong(0));
            fournisseurs.add(fournisseur);
        }
        c.close();
        return fournisseurs;
    }
}
