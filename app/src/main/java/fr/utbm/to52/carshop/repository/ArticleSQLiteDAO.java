package fr.utbm.to52.carshop.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;
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
    public void ins(Article obj) {
        Article article = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = articleTable.getColumns();

        values.put(columns.get("nomArticle").toString(), article.getNomArticle());
        values.put(columns.get("photo").toString(), article.getPhoto());
        values.put(columns.get("prixUnitaire").toString(), article.getPrixUnitaire());
        values.put(columns.get("qte").toString(), article.getQte());
        values.put(columns.get("idTypeArticle").toString(), article.getIdTypeArticle());

        article.setIdArticle(sqLiteDatabase.insert(articleTable.getTableName(), null, values));
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
    public void del(Article obj) {
        sqLiteDatabase.delete(
                articleTable.getTableName(),
                articleTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(obj.getIdArticle())});
    }

    @Override
    public List<Article> get() {
        Cursor c = sqLiteDatabase.rawQuery("select * from " + articleTable.getTableName(), null);
        List<Article> articles = new ArrayList<>();

        while(c.moveToNext()) {
            c.moveToFirst();
            Article article = new Article(
                    c.getString(1),
                    c.getString(2),
                    c.getDouble(3),
                    c.getInt(4),
                    c.getLong(5),
                    null
            );
            article.setIdArticle(c.getLong(0));
            articles.add(article);
        }
        c.close();
        return articles;
    }
}
