package fr.utbm.to52.carshop.utils.DataBaseUtils;

/**
 * {@inheritDoc}
 * A variant for primary keys
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class PKColumn extends Column {

    /**
     * {@inheritDoc}
     * The column created is a primary key column
     */
    PKColumn(String javaName, String columnName, String columnType, String columnConstraints) {
        super(javaName, columnName, columnType, columnConstraints);
    }

    /**
     * {@inheritDoc}
     * This time the generated string allows to create a primary key
     */
    @Override
    String genCreateTableString() {
        return columnName + " PRIMARY  KEY " + columnType + " " + columnConstraints;
    }
}
