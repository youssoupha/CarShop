package fr.utbm.to52.carshop.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class BaseSQLiteDao {

    protected SQLiteDatabase sqLiteDatabase = null;

    protected DatabaseHelper databaseHelper = null;

    public BaseSQLiteDao(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public SQLiteDatabase open() {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        return sqLiteDatabase;
    }

    public void close() {
        sqLiteDatabase.close();
    }

    public SQLiteDatabase getDatabase(){
        return sqLiteDatabase;
    }
}
