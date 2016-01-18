package fr.utbm.to52.carshop.repository;

import android.database.Cursor;

import java.util.List;

/**
 * An interface that describes the content of a DAO
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public interface BaseDAO<T>{

    /**
     * Insert an object into database
     * @param obj the object to insert
     * @return the object as it is in the database
     */
    void ins(T obj);

    /**
     * Update an object into the database
     * @param obj the object to update
     */
    void upd(T obj);

    /**
     * Delete an object from database
     * @param obj the object to delete
     */
    void del(T obj);

    /**
     * Return an existing object from database
     * @return the object as it is into DB
     */
    List<T> get();
}
