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

import fr.utbm.to52.carshop.entity.Client;
import fr.utbm.to52.carshop.entity.Commande;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Column;
import fr.utbm.to52.carshop.utils.DataBaseUtils.DatabaseInfoProvider;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Table;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class CommandeSQLiteDAO extends BaseSQLiteDao implements BaseDAO<Commande> {

    /**
     * The table commande used for operations
     */
    private final Table commandeTable;

    public CommandeSQLiteDAO(Context context, Table commandeTable) {
        super(context);

        this.commandeTable = DatabaseInfoProvider.getMapOfDatabaseTables().get("COMMANDE");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Commande ins(Commande obj) {
        Commande commande = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = commandeTable.getColumns();

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

        values.put(columns.get("dateCommande").toString(), formatter.format(commande.getDateCommande()));
        values.put(columns.get("dateLivraison").toString(), formatter.format(commande.getDateLivraison()));
        values.put(columns.get("idClient").toString(), commande.getIdClient());

        commande.setIdCommande(sqLiteDatabase.insert(commandeTable.getTableName(), null, values));

        return commande;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void upd(Commande obj) {
        Commande commande = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = commandeTable.getColumns();

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

        values.put(columns.get("idCommande").toString(), commande.getIdCommande());
        values.put(columns.get("dateCommande").toString(), formatter.format(commande.getDateCommande()));
        values.put(columns.get("dateLivraison").toString(), formatter.format(commande.getDateLivraison()));
        values.put(columns.get("idClient").toString(), commande.getIdClient());

        sqLiteDatabase.update(
                commandeTable.getTableName(),
                values,
                commandeTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(commande.getIdCommande())});
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void del(long id) {
        sqLiteDatabase.delete(
                commandeTable.getTableName(),
                commandeTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(id)});
    }

    @Override
    public List<Commande> get() {
        Cursor c = sqLiteDatabase.rawQuery("select * from " + commandeTable.getTableName(), null);

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

        List<Commande> commandes = new ArrayList<>();

        while(c.moveToNext()) {
            c.moveToFirst();
            Commande commande = null;
            try {
                commande = new Commande(
                        formatter.parse(c.getString(1)),
                        formatter.parse(c.getString(2)),
                        c.getLong(3),
                        null
                );
            } catch (ParseException e) {
                e.printStackTrace();
            }
            commande.setIdCommande(c.getLong(0));
            commandes.add(commande);
        }
        c.close();
        return commandes;
    }
}
