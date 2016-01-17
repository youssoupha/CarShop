package fr.utbm.to52.carshop.repository;

import android.content.ContentValues;
import android.content.Context;

import java.util.Map;

import fr.utbm.to52.carshop.entity.Article;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Column;
import fr.utbm.to52.carshop.utils.DataBaseUtils.DatabaseInfoProvider;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Table;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class ArticleSQLiteDAO extends BaseSQLiteDao implements BaseDAO<Article> {

    /**
     * The table article used for operations
     */
    private final Table articleTable;

    public ArticleSQLiteDAO(Context context, Table articleTable) {
        super(context);

        this.articleTable = DatabaseInfoProvider.getMapOfDatabaseTables().get("ARTICLE");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Article ins(Article obj) {
        Article article = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = articleTable.getColumns();

        values.put(columns.get("nomArticle").toString(), article.getNomArticle());
        values.put(columns.get("photo").toString(), article.getPhoto());
        values.put(columns.get("prixUnitaire").toString(), article.getPrixUnitaire());
        values.put(columns.get("qte").toString(), article.getQte());
        values.put(columns.get("idTypeArticle").toString(), article.getIdTypeArticle());

        article.setIdArticle(sqLiteDatabase.insert(articleTable.getTableName(), null, values));

        return article;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void upd(Article obj) {
        Article article = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = articleTable.getColumns();

        values.put(columns.get("idArticle").toString(), article.getIdArticle());
        values.put(columns.get("nomArticle").toString(), article.getNomArticle());
        values.put(columns.get("photo").toString(), article.getPhoto());
        values.put(columns.get("prixUnitaire").toString(), article.getPrixUnitaire());
        values.put(columns.get("qte").toString(), article.getQte());
        values.put(columns.get("idTypeArticle").toString(), article.getIdTypeArticle());

        sqLiteDatabase.update(
                articleTable.getTableName(),
                values,
                articleTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(article.getIdArticle())});
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void del(long id) {
        sqLiteDatabase.delete(
                articleTable.getTableName(),
                articleTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(id)});
    }

    @Override
    public Article get(long id) {
        return null;
    }
}
