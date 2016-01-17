package fr.utbm.to52.carshop.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fr.utbm.to52.carshop.utils.DataBaseUtils.DatabaseInfoProvider;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, DatabaseInfoProvider.DATABASE_NAME, null, DatabaseInfoProvider.DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseInfoProvider.genSQLiteCreateEntries());
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(DatabaseInfoProvider.genSQLiteDeleteEntries());
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
