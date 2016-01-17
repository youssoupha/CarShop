package fr.utbm.to52.carshop.utils;







import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;



/**
 *
 */
public class RequestHttpArticle {
    private static final String USER_AGENT = "Mozilla/5.0";
    // HTTP GET request send by Terminal


    public static String sendGet3(String uri) throws Exception {
        String valeur="";
        HttpURLConnection httpURLConnection = null;

        try{
            URL url = new URL(uri);
            //Log.v(TAG, url.toString());
            // Creation de la connexion
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.connect();
            // Envoie de la requete
            int responseCode = httpURLConnection.getResponseCode();
            // Crï¿½ation de flux pour la rï¿½ponse
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream())
            );
            String inputLine;
            StringBuffer response = new StringBuffer();
            // Boucler jusqu'ï¿½ ce qu'il ne reste plus de flux ï¿½ rï¿½cupï¿½rer
            switch (responseCode){
                case HttpURLConnection.HTTP_OK:
                    while((inputLine = in.readLine())!= null){
                        response.append(inputLine);
                    }
                    in.close();
                    //Log.v(TAG, response.toString());

                    valeur = response.toString();

                    break;
                case HttpURLConnection.HTTP_NOT_FOUND:

                    valeur = "Error: Server Not found 404";

                    break;
                case HttpURLConnection.HTTP_INTERNAL_ERROR:

                    valeur = ("Error:Server error 500");

                    break;
            }

        }catch (MalformedURLException m){
            m.printStackTrace();
        }catch (IOException io){
            io.printStackTrace();

            valeur = "Error:Server error 500";

        }finally {
            httpURLConnection.disconnect();
        }
        return valeur;

    }




    // HTTP POST request
    public static String sendPost(String urlS,String param)  {
        String valeur="";
        HttpURLConnection httpURLConnection = null;
        URL url = null;
        try {
            url = new URL(urlS);

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            String urlParameters=param;

            OutputStream os = httpURLConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(param);
            writer.flush();
            writer.close();
            os.close();

            httpURLConnection.connect();
            // Envoie de la requete
            int responseCode = httpURLConnection.getResponseCode();
            // Crï¿½ation de flux pour la rï¿½ponse
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream())
            );
            String inputLine;
            StringBuffer response = new StringBuffer();
            // Boucler jusqu'ï¿½ ce qu'il ne reste plus de flux ï¿½ rï¿½cupï¿½rer
            switch (responseCode){
                case HttpURLConnection.HTTP_OK:
                    while((inputLine = in.readLine())!= null){
                        response.append(inputLine);
                    }
                    in.close();
                    //Log.v(TAG, response.toString());

                    valeur = response.toString();

                    break;
                case HttpURLConnection.HTTP_NOT_FOUND:

                    valeur = "Error: Server Not found 404";

                    break;
                case HttpURLConnection.HTTP_INTERNAL_ERROR:

                    valeur = ("Error:Server error 500");

                    break;
            }

        }catch (MalformedURLException m){
            m.printStackTrace();
        }catch (IOException io){
            io.printStackTrace();

            valeur = "Error:Server error 500";

        }finally {
            httpURLConnection.disconnect();
        }
        return valeur;

    }


    // HTTP POST request
    public static String sendPost(String url, List<NameValuePair> urlParameters) throws Exception {


        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);



        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
 		/*System.out.println("\nSending 'POST' request to URL : " + url);
 		System.out.println("Post parameters : " + post.getEntity());
 		System.out.println("Response Code : " + 
                                     response.getStatusLine().getStatusCode());*/

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());

        return result.toString();
    }


    public static void main(String[] args) {
        try {
            //sendPost("http://192.168.0.101:8080/catalogue_web/traitement", Constants.BUILD_INSERT_ARTICLE_VALUES("opel 2&marque=Opel", "Opel", "0", "belle voiture", "Belfort", "1", "djibril3fr@yahoo.fr", "Belfort", "90000", null, "2"));
            //System.out.println("valeur :"+sendPost("http://192.168.0.101:8080/catalogue_web/traitement", "add=add&designation=opel 2&marque=Opel&prix=0&detail=belle voiture &target=ANDROID&adresse=Belfort &client=djibril3fr@yahoo.fr&email=djibril3fr@yahoo.fr&ville=Belfort &codepostal=Belfort &image=null&quantite=2&email=djibril3fr@yahoo.fr"));
            System.out.println("valeur :"+sendGet3(CarShopUtils.DO_READ_CLIENT_URL()));
            // sendGet2("http://192.168.0.103:8080/catalogue_web/catalogueserver?mac=1212");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
