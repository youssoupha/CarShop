package fr.utbm.to52.carshop.utils.DataBaseUtils;

/**
 * {@inheritDoc}
 * An extend for the foreign key columns
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class FKColumn extends Column {

    private String foreignTable;
    private String foreignColumn;

    /**
     * Construct a foreign key constraint
     * @param foreignTable the foreign key referenced table
     * @param foreignColumn the foreign key referenced column
     */
    FKColumn(String javaName, String columnName, String columnType, String columnConstraints, String foreignTable, String foreignColumn) {
        super(javaName, columnName, columnType, columnConstraints);
        this.foreignTable = foreignTable;
        this.foreignColumn = foreignColumn;
    }

    /**
     * A string generated at the end of a create table statement in SQLite
     * @return the foreign key constraint string to complete into statement
     */
    String genFKCreateTableString() {
        return "FOREIGN KEY (" + columnName + ") REFERENCES " + foreignTable + "( " + foreignColumn + ")";
    }
}
