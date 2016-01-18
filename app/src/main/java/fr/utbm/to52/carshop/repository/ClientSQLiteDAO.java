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

import fr.utbm.to52.carshop.entity.Article;
import fr.utbm.to52.carshop.entity.Client;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Column;
import fr.utbm.to52.carshop.utils.DataBaseUtils.DatabaseInfoProvider;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Table;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class ClientSQLiteDAO extends BaseSQLiteDao implements BaseDAO<Client> {

    /**
     * The table client used for operations
     */
    private final Table clientTable;

    public ClientSQLiteDAO(Context context, Table clientTable) {
        super(context);

        this.clientTable = DatabaseInfoProvider.getMapOfDatabaseTables().get("CLIENT");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Client ins(Client obj) {
        Client client = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = clientTable.getColumns();

        values.put(columns.get("emailClient").toString(), client.getEmailClient());
        values.put(columns.get("nomClient").toString(), client.getNomClient());
        values.put(columns.get("pNomClient").toString(), client.getPNomClient());
        values.put(columns.get("adressClient").toString(), client.getAdressClient());

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        values.put(columns.get("dateNaissClient").toString(), formatter.format(client.getDateNaissClient()));

        client.setIdClient(sqLiteDatabase.insert(clientTable.getTableName(), null, values));

        return client;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void upd(Client obj) {
        Client client = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = clientTable.getColumns();

        values.put(columns.get("idClient").toString(), client.getIdClient());
        values.put(columns.get("emailClient").toString(), client.getEmailClient());
        values.put(columns.get("nomClient").toString(), client.getNomClient());
        values.put(columns.get("pNomClient").toString(), client.getPNomClient());
        values.put(columns.get("adressClient").toString(), client.getAdressClient());

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        values.put(columns.get("dateNaissClient").toString(), formatter.format(client.getDateNaissClient()));

        sqLiteDatabase.update(
                clientTable.getTableName(),
                values,
                clientTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(client.getIdClient())});
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void del(long id) {
        sqLiteDatabase.delete(
                clientTable.getTableName(),
                clientTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(id)});
    }

    @Override
    public List<Client> get() {
        Cursor c = sqLiteDatabase.rawQuery("select * from " + clientTable.getTableName(), null);

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

        List<Client> clients = new ArrayList<>();

        while(c.moveToNext()) {
            c.moveToFirst();
            Client client = null;
            try {
                client = new Client(
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4),
                        formatter.parse(c.getString(5))
                );
            } catch (ParseException e) {
                e.printStackTrace();
            }
            client.setIdClient(c.getLong(0));
            clients.add(client);
        }
        c.close();
        return clients;
    }
}
