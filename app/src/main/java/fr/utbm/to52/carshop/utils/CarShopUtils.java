package fr.utbm.to52.carshop.utils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class CarShopUtils {
    public final static String CONNECTION_TASK="connexion";

    public final static String INSERT_CLIENT_TASK = "insertclient";
    public final static String DELETE_CLIENT_TASK = "deleteclient";
    public final static String UPDATE_CLIENT_TASK = "updateclient";
    public final static String ALL_CLIENTS_TASK = "allclients";

    public final static String INSERT_ARTICLE_TASK = "insertarticle";
    public final static String DELETE_ARTICLE_TASK = "deletearticle";
    public final static String UPDATE_ARTICLE_TASK = "updatearticle";
    public final static String ALL_ARTICLES_TASK = "allarticles";


    public static String SERVER_ADDRESS = "http://localhost/";


    public static String DO_READ_CLIENT_URL() {
        return SERVER_ADDRESS + "carshop/client.php";
    }

    public static String DO_CLIENT_URL() {
        return SERVER_ADDRESS + "carshop/clientEdit.php";
    }

    public static String DO_ARTICLE_URL() {
        return SERVER_ADDRESS + "carshop/articleEdit.php";
    }
    public static String DO_READ_ARTICLE_URL() {
        return SERVER_ADDRESS + "carshop/article.php";
    }





    public static List<NameValuePair> BUILD_INSERT_ARTICLE_VALUES(String fieldName, String modifType, String edited, String ID_ARTICLE, String ID_TYPE, String NOM_ARTICLE, String PU, String QTE) {
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        if(modifType!=null) urlParameters.add(new BasicNameValuePair("modifType", modifType));
        if(fieldName!=null) urlParameters.add(new BasicNameValuePair("marque", fieldName));
        if(edited!=null) urlParameters.add(new BasicNameValuePair("prix", edited));
        if(ID_ARTICLE!=null) urlParameters.add(new BasicNameValuePair("detail", ID_ARTICLE));
        if(ID_TYPE!=null) urlParameters.add(new BasicNameValuePair("adresse", ID_TYPE));
        if(NOM_ARTICLE!=null) urlParameters.add(new BasicNameValuePair("NOM_ARTICLE", NOM_ARTICLE));
        if(PU!=null) urlParameters.add(new BasicNameValuePair("PU", PU));
        if(QTE!=null) urlParameters.add(new BasicNameValuePair("QTE", QTE));

        return urlParameters;
    }


    /*
    public final static String INSERT_ARTICLE_TASK = "insertarticle";
    public final static String DELETE_ARTICLE_TASK = "deletearticle";
    public final static String UPDATE_ARTICLE_TASK = "updatearticle";
    public final static String ALL_ARTICLES_TASK = "allarticles";

    public final static String INSERT_ARTICLE_TASK = "insertarticle";
    public final static String DELETE_ARTICLE_TASK = "deletearticle";
    public final static String UPDATE_ARTICLE_TASK = "updatearticle";
    public final static String ALL_ARTICLES_TASK = "allarticles";

    public final static String INSERT_ARTICLE_TASK = "insertarticle";
    public final static String DELETE_ARTICLE_TASK = "deletearticle";
    public final static String UPDATE_ARTICLE_TASK = "updatearticle";
    public final static String ALL_ARTICLES_TASK = "allarticles";
    */
}
