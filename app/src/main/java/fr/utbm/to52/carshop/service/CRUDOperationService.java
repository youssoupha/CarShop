package fr.utbm.to52.carshop.service;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.apache.http.NameValuePair;

import java.util.List;

import fr.utbm.to52.carshop.utils.CarShopUtils;
import fr.utbm.to52.carshop.utils.RequestHttpArticle;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class CRUDOperationService extends AsyncTask<String, Void, String> {
private static  String postUrl=null;
private static  boolean postVerif=false;
private static List<NameValuePair> postParam=null;
private static  String result=null;
private  static AppCompatActivity from;
private static ProgressBar progressBar;
private String taskType;

    public static String getPostUrl() {
        return postUrl;
    }

    public static void setPostUrl(String postUrl) {
        CRUDOperationService.postUrl = postUrl;
    }

    public static boolean isPostVerif() {
        return postVerif;
    }

    public static void setPostVerif(boolean postVerif) {
        CRUDOperationService.postVerif = postVerif;
    }

    public static List<NameValuePair> getPostParam() {
        return postParam;
    }

    public static void setPostParam(List<NameValuePair> postParam) {
        CRUDOperationService.postParam = postParam;
    }

    public static String getResult() {
        return result;
    }

    public static void setResult(String result) {
        CRUDOperationService.result = result;
    }

    public static AppCompatActivity getFrom() {
        return from;
    }

    public static void setFrom(AppCompatActivity from) {
        CRUDOperationService.from = from;
    }

    public static ProgressBar getProgressBar() {
        return progressBar;
    }

    public static void setProgressBar(ProgressBar progressBar) {
        CRUDOperationService.progressBar = progressBar;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    @Override
    protected String doInBackground(String... urls) {
        String output = null;
        if(postVerif){
            try {
                output = RequestHttpArticle.sendPost(postUrl, postParam);
            } catch (Exception e) {
                e.printStackTrace();
            }
            postVerif=false;
        }else {
            //Envoyer la liste des requetes
            for (String url : urls) {
                try {
                    output = RequestHttpArticle.sendGet3(url);
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


                case CarShopUtils.INSERT_CLIENT_TASK:
                    if (output.equalsIgnoreCase("OK")) {
                        //MainActivity.setMsg("CREATE");
                    /*Intent intent = new Intent(from, TabMenuActivity.class);
                    from.startActivity(intent);*/
                        //Toast.makeText(from.getApplicationContext(), "Demande de don envoyé", Toast.LENGTH_SHORT).show();

                    } else if (output.equalsIgnoreCase("ERROR")) {
                        Toast.makeText(from.getApplicationContext(), "Echec de demande de don !", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(from.getApplicationContext(), "Erreur de connexion !", Toast.LENGTH_LONG).show();
                    }
                    break;


                case CarShopUtils.ALL_CLIENTS_TASK:
                    result = output;
                    if(!result.equalsIgnoreCase("")) {
                        //output;
                    }else {
                        Toast.makeText(from.getApplicationContext(), "Pas de postulants !", Toast.LENGTH_LONG).show();
                    }
                    break;

                case CarShopUtils.INSERT_ARTICLE_TASK:
                    if (output.equalsIgnoreCase("OK")) {
                        //MainActivity.setMsg("CREATE");
                    /*Intent intent = new Intent(from, TabMenuActivity.class);
                    from.startActivity(intent);*/
                        //Toast.makeText(from.getApplicationContext(), "Demande de don envoyé", Toast.LENGTH_SHORT).show();

                    } else if (output.equalsIgnoreCase("ERROR")) {
                        Toast.makeText(from.getApplicationContext(), "Echec de demande de don !", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(from.getApplicationContext(), "Erreur de connexion !", Toast.LENGTH_LONG).show();
                    }
                    break;


                case CarShopUtils.ALL_ARTICLES_TASK:
                    result = output;
                    if(!result.equalsIgnoreCase("")) {
                        //output;
                    }else {
                        Toast.makeText(from.getApplicationContext(), "Pas de postulants !", Toast.LENGTH_LONG).show();
                    }
                    break;


            }
        } else {

            Toast.makeText(from.getApplicationContext(), "Le serveur ne retourne rien !", Toast.LENGTH_SHORT).show();
        }
        //result=output;progressBar.setVisibility(View.GONE);
    }





    // add article to Server
    public static String addOrUpdateArticle(String fieldName, String modifType, String edited, String ID_ARTICLE, String ID_TYPE, String NOM_ARTICLE, String PU, String QTE) {

        try {
            // Tache d'envoie de la requete
            CRUDOperationService task = new CRUDOperationService();
            task.setTaskType(CarShopUtils.INSERT_ARTICLE_TASK);

            postVerif=true;
            postUrl= CarShopUtils.DO_ARTICLE_URL();
            postParam=CarShopUtils.BUILD_INSERT_ARTICLE_VALUES( fieldName,  modifType,  edited,  ID_ARTICLE,  ID_TYPE,  NOM_ARTICLE,PU, QTE);
            System.out.println(CarShopUtils.BUILD_INSERT_ARTICLE_VALUES(fieldName, modifType, edited, ID_ARTICLE, ID_TYPE, NOM_ARTICLE, PU, QTE));
            task.execute(CarShopUtils.DO_ARTICLE_URL());
        } catch (Resources.NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }
    public static String getAllArticles(){

        try {
            // Tache d'envoie de la requete
            postVerif=false;
            CRUDOperationService task = new CRUDOperationService();
            task.setTaskType(CarShopUtils.ALL_ARTICLES_TASK);
            System.out.println(CarShopUtils.DO_READ_ARTICLE_URL());

            task.execute(CarShopUtils.DO_READ_ARTICLE_URL());

        } catch (Resources.NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return  result;


    }



    public static String getAllClients(){

        try {
            // Tache d'envoie de la requete
            postVerif=false;
            CRUDOperationService task = new CRUDOperationService();
            task.setTaskType(CarShopUtils.ALL_CLIENTS_TASK);
            System.out.println(CarShopUtils.DO_READ_CLIENT_URL());

            task.execute(CarShopUtils.DO_READ_CLIENT_URL());

        } catch (Resources.NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return  result;


    }






}



