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
public class RequestHttpEntity {
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
            int responseCode = httpURLConnection.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream())
            );
            String inputLine;
            StringBuffer response = new StringBuffer();
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
            int responseCode = httpURLConnection.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream())
            );
            String inputLine;
            StringBuffer response = new StringBuffer();
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

}
