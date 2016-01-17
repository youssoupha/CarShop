package fr.utbm.to52.carshop.utils.DataBaseUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contains all information about a SQLite Table to be used by repository classes such as DatabaseHandler
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class Table {

    private final String tableName;
    private final PKColumn primaryKey;
    private final Map<String, Column> columns = new HashMap<>();

    /**
     * Construct a table object representing a database table
     * To create a table you will need a primary key and an undefined number of column (can either be zero)
     * @param tableName the name of the table into database
     * @param primaryKey the default primary key (we assume for now that there will be only one, the id)
     * @param columnsList the columns of the table
     */
    Table(String tableName, PKColumn primaryKey, Column...columnsList) {
        this.tableName = tableName;
        this.primaryKey = primaryKey;

        for (Column column : columnsList) {
            columns.put(column.javaName, column);
        }
    }

    /**
     * Creates a CREATE TABLE statement with all the data provided by the object
     * @return the CREATE TABLE statement string to be used by repository classes
     */
    String genCreateTableStatement() {
        //Begin the string with the table name and its primaryKey
        String statement = "CREATE TABLE " + tableName + "(" +
                "\n  " + primaryKey.genCreateTableString();
        //Next is setting all columns, saving the FK keys by the way for further
        List<String> fkList = new ArrayList<>();
        for (String key: columns.keySet()) {
            Column column = columns.get(key);

            statement += "\n, " + column.genCreateTableString();

            if(column instanceof FKColumn)
                fkList.add(key);
        }
        //Then set the foreign keys
        for(String key : fkList) {
            FKColumn column = (FKColumn) columns.get(key);

            statement += "\n, " + column.genFKCreateTableString();
        }

        //Finally end the statement
        statement += ");";
        return statement;
    }

    /**
     * The name of the represented table into database
     * @return the table name
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @return the primary key column
     */
    public PKColumn getPrimaryKey() {
        return primaryKey;
    }

    /**
     * @return The columns of the tables
     */
    public Map<String, Column> getColumns() {
        return columns;
    }

    /**
     * Creates a drop table statement
     * @return the drop table statement
     */
    public String genDropTableStatement() {
        return "DROP TABLE IF EXISTS " + tableName + ";";
    }

    @Override
    public boolean equals(Object o) {
        return (o == null || !(o instanceof Table) ? null : this.tableName.equals(((Table) o).tableName));
    }
}
