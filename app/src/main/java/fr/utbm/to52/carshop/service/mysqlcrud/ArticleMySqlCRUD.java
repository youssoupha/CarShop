package fr.utbm.to52.carshop.service.mysqlcrud;

import java.util.List;

import fr.utbm.to52.carshop.entity.Article;
import fr.utbm.to52.carshop.service.RequestService;
import fr.utbm.to52.carshop.utils.CarShopUtils;
import fr.utbm.to52.carshop.utils.RequestHttpArticle;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class ArticleMySqlCRUD implements MysqlBaseCRUD<Article> {
    @Override
    public Article ins(Article obj) {
        RequestService.setTaskType(CarShopUtils.UID);
        RequestService.addOrUpdate("ARTICLE",null,"Add",null,null,String.valueOf(obj.getIdTypeArticle()), obj.getNomArticle(), String.valueOf(obj.getPrixUnitaire()), String.valueOf(obj.getQte()));
        return null;
    }

    @Override
    public void upd(Article obj) {

    }

    @Override
    public void del(long id) {

    }

    @Override
    public Article get(long id) {
        return null;
    }

    @Override
    public List<Article> get() {
        return null;
    }
}
