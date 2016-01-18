package fr.utbm.to52.carshop.service;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.apache.http.NameValuePair;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import fr.utbm.to52.carshop.entity.Article;
import fr.utbm.to52.carshop.entity.Client;
import fr.utbm.to52.carshop.entity.Commande;
import fr.utbm.to52.carshop.entity.Concerner;
import fr.utbm.to52.carshop.entity.Facture;
import fr.utbm.to52.carshop.entity.Fournir;
import fr.utbm.to52.carshop.entity.Fournisseur;
import fr.utbm.to52.carshop.entity.TypeArticle;
import fr.utbm.to52.carshop.utils.CarShopUtils;
import fr.utbm.to52.carshop.utils.RequestHttpEntity;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class RequestService extends AsyncTask<String, Void, String> {

    private static  String postUrl=null;
    private static  boolean postVerif=false;
    private static List<NameValuePair> postParam=null;
    private static  String result=null;
    private static AppCompatActivity from;
    private static ProgressBar progressBar;
    private static String taskType;

    public static String getPostUrl() {
        return postUrl;
    }

    public static void setPostUrl(String postUrl) {
        RequestService.postUrl = postUrl;
    }

    public static boolean isPostVerif() {
        return postVerif;
    }

    public static void setPostVerif(boolean postVerif) {
        RequestService.postVerif = postVerif;
    }

    public static List<NameValuePair> getPostParam() {
        return postParam;
    }

    public static void setPostParam(List<NameValuePair> postParam) {
        RequestService.postParam = postParam;
    }

    public static String getResult() {
        return result;
    }

    public static void setResult(String result) {
        RequestService.result = result;
    }

    public static AppCompatActivity getFrom() {
        return from;
    }

 
    public static  String getTaskType() {
        return taskType;
    }

    public static void setTaskType(String taskType) {
        taskType = taskType;
    }

    @Override
    protected String doInBackground(String... urls) {
        String output = null;
        if(postVerif){
            try {
                output = RequestHttpEntity.sendPost(postUrl, postParam);
            } catch (Exception e) {
                e.printStackTrace();
            }
            postVerif=false;
        }else {
            //Envoyer la liste des requetes
            for (String url : urls) {
                try {
                    output = RequestHttpEntity.sendGet3(url);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        return output;
    }




    @Override
    protected void onPostExecute(String output) {
        if(output!=null) {
            switch (taskType) {


                case CarShopUtils.UID:
                    if (output.equalsIgnoreCase("OK")) {

                    } else if (output.equalsIgnoreCase("ERROR")) {
                        Toast.makeText(from.getApplicationContext(), "Echec !", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(from.getApplicationContext(), "Erreur de connexion !", Toast.LENGTH_LONG).show();
                    }
                    break;


                case CarShopUtils.READ:
                    result = output;
                    if(!result.equalsIgnoreCase("")) {
                        //output;
                    }else {
                        Toast.makeText(from.getApplicationContext(), "Pas!", Toast.LENGTH_LONG).show();
                    }
                    break;



            }
        } else {

            Toast.makeText(from.getApplicationContext(), "Le serveur ne retourne rien !", Toast.LENGTH_SHORT).show();
        }
        //result=output;progressBar.setVisibility(View.GONE);
    }





    public static String addUpdateDeleteArticle(String fieldName, String modifType, Article a) {

        try {
            // Tache d'envoie de la requete
            RequestService task = new RequestService();
            switch (modifType) {
                case "Add":
                    task.setTaskType(CarShopUtils.INSERT_ARTICLE_TASK);
                    break;
                case "Edit":
                    task.setTaskType(CarShopUtils.UPDATE_ARTICLE_TASK);
                    break;
                case "Del":
                    task.setTaskType(CarShopUtils.DELETE_ARTICLE_TASK);
                    break;
            }

            postVerif=true;
            postUrl= CarShopUtils.DO_UID_URL("article");
            postParam=CarShopUtils.BUILD_ARTICLE_VALUES(
                    fieldName,
                    modifType,
                    String.valueOf(a.getIdArticle()),
                    String.valueOf(a.getIdTypeArticle()),
                    a.getNomArticle(),
                    String.valueOf(a.getPrixUnitaire()),
                    String.valueOf(a.getQte()));
            task.execute(postUrl);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String addUpdateDeleteClient(String fieldName, String modifType, Client c) {

        try {
            // Tache d'envoie de la requete
            RequestService task = new RequestService();
            switch (modifType) {
                case "Add":
                    task.setTaskType(CarShopUtils.INSERT_CLIENT_TASK);
                    break;
                case "Edit":
                    task.setTaskType(CarShopUtils.UPDATE_CLIENT_TASK);
                    break;
                case "Del":
                    task.setTaskType(CarShopUtils.DELETE_CLIENT_TASK);
                    break;
            }

            postVerif=true;
            postUrl= CarShopUtils.DO_UID_URL("client");
            DateFormat f = new SimpleDateFormat("YYYY-MM-dd");
            postParam=CarShopUtils.BUILD_CLIENT_VALUES(
                    fieldName,
                    modifType,
                    String.valueOf(c.getIdClient()),
                    c.getEmailClient(),
                    c.getNomClient(),
                    c.getPNomClient(),
                    c.getAdressClient(),
                    f.format(c.getDateNaissClient()));
            task.execute(postUrl);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String addUpdateDeleteCommande(String fieldName, String modifType, Commande c) {

        try {
            // Tache d'envoie de la requete
            RequestService task = new RequestService();
            switch (modifType) {
                case "Add":
                    task.setTaskType(CarShopUtils.INSERT_COMMANDE_TASK);
                    break;
                case "Edit":
                    task.setTaskType(CarShopUtils.UPDATE_COMMANDE_TASK);
                    break;
                case "Del":
                    task.setTaskType(CarShopUtils.DELETE_COMMANDE_TASK);
                    break;
            }

            postVerif=true;
            postUrl= CarShopUtils.DO_UID_URL("commande");
            DateFormat f = new SimpleDateFormat("YYYY-MM-dd");
            postParam=CarShopUtils.BUILD_COMMANDE_VALUES(
                    fieldName,
                    modifType,
                    String.valueOf(c.getIdCommande()),
                    f.format(c.getDateCommande()),
                    f.format(c.getDateLivraison()),
                    String.valueOf(c.getClient()));
            task.execute(postUrl);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String addUpdateDeleteConcerner(String fieldName, String modifType, Concerner c) {

        try {
            // Tache d'envoie de la requete
            RequestService task = new RequestService();
            switch (modifType) {
                case "Add":
                    task.setTaskType(CarShopUtils.INSERT_CONCERNER_TASK);
                    break;
                case "Edit":
                    task.setTaskType(CarShopUtils.UPDATE_CONCERNER_TASK);
                    break;
                case "Del":
                    task.setTaskType(CarShopUtils.DELETE_CONCERNER_TASK);
                    break;
            }

            postVerif=true;
            postUrl= CarShopUtils.DO_UID_URL("concerner");
            DateFormat f = new SimpleDateFormat("YYYY-MM-dd");
            postParam=CarShopUtils.BUILD_CONCERNER_VALUES(
                    fieldName,
                    modifType,
                    String.valueOf(c.getIdConcerner()),
                    String.valueOf(c.getIdCommande()),
                    String.valueOf(c.getIdArticle()),
                    String.valueOf(c.getQte()));
            task.execute(postUrl);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String addUpdateDeleteFacture(String fieldName, String modifType, Facture f) {

        try {
            // Tache d'envoie de la requete
            RequestService task = new RequestService();
            switch (modifType) {
                case "Add":
                    task.setTaskType(CarShopUtils.INSERT_FACTURE_TASK);
                    break;
                case "Edit":
                    task.setTaskType(CarShopUtils.UPDATE_FACTURE_TASK);
                    break;
                case "Del":
                    task.setTaskType(CarShopUtils.DELETE_FACTURE_TASK);
                    break;
            }

            postVerif=true;
            postUrl= CarShopUtils.DO_UID_URL("facture");
            DateFormat ft = new SimpleDateFormat("YYYY-MM-dd");
            postParam=CarShopUtils.BUILD_FACTURE_VALUES(
                    fieldName,
                    modifType,
                    String.valueOf(f.getIdFacture()),
                    String.valueOf(f.getIdCommande()),
                    ft.format(f.getDateFacture()));
            task.execute(postUrl);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String addUpdateDeleteFournir(String fieldName, String modifType, Fournir f) {

        try {
            // Tache d'envoie de la requete
            RequestService task = new RequestService();
            switch (modifType) {
                case "Add":
                    task.setTaskType(CarShopUtils.INSERT_FOURNIR_TASK);
                    break;
                case "Edit":
                    task.setTaskType(CarShopUtils.UPDATE_FOURNIR_TASK);
                    break;
                case "Del":
                    task.setTaskType(CarShopUtils.DELETE_FOURNIR_TASK);
                    break;
            }

            postVerif=true;
            postUrl= CarShopUtils.DO_UID_URL("fournir");
            DateFormat ft = new SimpleDateFormat("YYYY-MM-dd");
            postParam=CarShopUtils.BUILD_FOURNIR_VALUES(
                    fieldName,
                    modifType,
                    String.valueOf(f.getIdFournir()),
                    String.valueOf(f.getIdArticle()),
                    String.valueOf(f.getIdFournisseur()),
                    String.valueOf(f.getQteFournie()),
                    ft.format(f.getDateDemandeApprov()),
                    ft.format(f.getDateLivraison()));
            task.execute(postUrl);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String addUpdateDeleteFournisseur(String fieldName, String modifType, Fournisseur f) {

        try {
            // Tache d'envoie de la requete
            RequestService task = new RequestService();
            switch (modifType) {
                case "Add":
                    task.setTaskType(CarShopUtils.INSERT_FOURNISSEUR_TASK);
                    break;
                case "Edit":
                    task.setTaskType(CarShopUtils.UPDATE_FOURNISSEUR_TASK);
                    break;
                case "Del":
                    task.setTaskType(CarShopUtils.DELETE_FOURNISSEUR_TASK);
                    break;
            }

            postVerif=true;
            postUrl= CarShopUtils.DO_UID_URL("fournisseur");
            postParam=CarShopUtils.BUILD_FOURNISSEUR_VALUES(
                    fieldName,
                    modifType,
                    String.valueOf(f.getIdFournisseur()),
                    f.getCodeFournisseur(),
                    f.getNomFournisseur(),
                    f.getAdressFournisseur());
            task.execute(postUrl);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String addUpdateDeleteTypeArticle(String fieldName, String modifType, TypeArticle t) {

        try {
            // Tache d'envoie de la requete
            RequestService task = new RequestService();
            switch (modifType) {
                case "Add":
                    task.setTaskType(CarShopUtils.INSERT_TYPE_ARTICLE_TASK);
                    break;
                case "Edit":
                    task.setTaskType(CarShopUtils.UPDATE_TYPE_ARTICLE_TASK);
                    break;
                case "Del":
                    task.setTaskType(CarShopUtils.DELETE_TYPE_ARTICLE_TASK);
                    break;
            }

            postVerif=true;
            postUrl= CarShopUtils.DO_UID_URL("typeArticle");
            postParam=CarShopUtils.BUILD_TYPE_ARTICLE_VALUES(
                    fieldName,
                    modifType,
                    String.valueOf(t.getIdType()),
                    t.getNomType());
            task.execute(postUrl);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public static String getAll(String table){

        try {
            // Tache d'envoie de la requete
            postVerif=false;
            RequestService task = new RequestService();
            switch (table){
                case "article":
                    task.setTaskType(CarShopUtils.ALL_ARTICLES_TASK);
                    break;
                case "client":
                    task.setTaskType(CarShopUtils.ALL_CLIENTS_TASK);
                    break;
                case "commande":
                    task.setTaskType(CarShopUtils.ALL_COMMANDES_TASK);
                    break;
                case "concerner":
                    task.setTaskType(CarShopUtils.ALL_CONCERNERS_TASK);
                    break;
                case "facture":
                    task.setTaskType(CarShopUtils.ALL_FACTURES_TASK);
                    break;
                case "fournir":
                    task.setTaskType(CarShopUtils.ALL_FOURNIRS_TASK);
                    break;
                case "fournisseur":
                    task.setTaskType(CarShopUtils.ALL_FOURNISSEURS_TASK);
                    break;
                case "typeArticle":
                    task.setTaskType(CarShopUtils.ALL_TYPE_ARTICLES_TASK);
                    break;
            }
            task.execute(CarShopUtils.DO_READ(table));

        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }


}
