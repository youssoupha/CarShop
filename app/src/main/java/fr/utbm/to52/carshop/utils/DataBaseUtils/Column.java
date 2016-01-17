package fr.utbm.to52.carshop.utils.DataBaseUtils;

/**
 * This class contains all information about a SQLite Column to be used by repository classes such as DatabaseHandler
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class Column {

    protected final String javaName;
    protected final String columnName;
    protected String columnType;
    protected String columnConstraints;

    /**
     * Construct an object representing the database columns providing all info about it
     * @param javaName the name of the entity used to handle this database column
     * @param columnName the name of the column into database
     * @param columnType the type of the column
     * @param columnConstraints the constraints of the columns
     */
    Column(String javaName, String columnName, String columnType, String columnConstraints) {
        this.javaName = javaName;
        this.columnName = columnName;
        this.columnType = columnType;
        this.columnConstraints = columnConstraints;
    }

    /**
     * This getter used to return the Java variable name corresponding to the column
     * @return the java name of the variable
     */
    public String getJavaName() {
        return javaName;
    }

    @Override
    public String toString() {
        return columnName;
    }

    /**
     * Generate a string used for the create table statement
     * @return the column name an all its constraint to be
     */
    String genCreateTableString() {
        return columnName + " " + columnType + " " + columnConstraints == null ? "" : columnConstraints;
    }
}
