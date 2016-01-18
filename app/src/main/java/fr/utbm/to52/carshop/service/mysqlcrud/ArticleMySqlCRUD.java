package fr.utbm.to52.carshop.service.mysqlcrud;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.to52.carshop.entity.Article;
import fr.utbm.to52.carshop.service.RequestService;
import fr.utbm.to52.carshop.utils.CarShopUtils;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class ArticleMySqlCRUD implements MysqlBaseCRUD<Article> {
    @Override
    public void ins(Article obj) {
        RequestService.setTaskType(CarShopUtils.INSERT_ARTICLE_TASK);
        RequestService.addUpdateDeleteArticle(String.valueOf(obj.getIdArticle()), "Add", obj);
    }

    @Override
    public void upd(Article obj) {
        RequestService.setTaskType(CarShopUtils.UPDATE_ARTICLE_TASK);
        RequestService.addUpdateDeleteArticle(String.valueOf(obj.getIdArticle()), "Edit", obj);
    }

    @Override
    public void del(Article obj) {
        RequestService.setTaskType(CarShopUtils.DELETE_ARTICLE_TASK);
        RequestService.addUpdateDeleteArticle(String.valueOf(obj.getIdArticle()), "Del", obj);
    }

    @Override
    public List<Article> get() {
        List<Article> articles = new ArrayList<>();
        //TODO Parse the getAll request
        return null;
    }
}
