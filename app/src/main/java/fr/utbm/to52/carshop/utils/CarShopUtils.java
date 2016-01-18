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


    public final static String UID = "UPDATE";
    public final static String READ = "READ";

    public final static String INSERT_CLIENT_TASK = "insertclient";
    public final static String DELETE_CLIENT_TASK = "deleteclient";
    public final static String UPDATE_CLIENT_TASK = "updateclient";
    public final static String ALL_CLIENTS_TASK = "allclients";

    public final static String INSERT_ARTICLE_TASK = "insertarticle";
    public final static String DELETE_ARTICLE_TASK = "deletearticle";
    public final static String UPDATE_ARTICLE_TASK = "updatearticle";
    public final static String ALL_ARTICLES_TASK = "allarticles";

    public final static String INSERT_COMMANDE_TASK = "insertcommande";
    public final static String DELETE_COMMANDE_TASK = "deletecommande";
    public final static String UPDATE_COMMANDE_TASK = "updatecommande";
    public final static String ALL_COMMANDES_TASK = "allcommandes";

    public final static String INSERT_CONCERNER_TASK = "insertconcerner";
    public final static String DELETE_CONCERNER_TASK = "deleteconcerner";
    public final static String UPDATE_CONCERNER_TASK = "updateconcerner";
    public final static String ALL_CONCERNERS_TASK = "allconcerners";

    public final static String INSERT_FACTURE_TASK = "insertfacture";
    public final static String DELETE_FACTURE_TASK = "deletefacture";
    public final static String UPDATE_FACTURE_TASK = "updatefacture";
    public final static String ALL_FACTURES_TASK = "allfactures";

    public final static String INSERT_FOURNIR_TASK = "insertfournir";
    public final static String DELETE_FOURNIR_TASK = "deletefournir";
    public final static String UPDATE_FOURNIR_TASK = "updatefournir";
    public final static String ALL_FOURNIRS_TASK = "allfournirs";

    public final static String INSERT_FOURNISSEUR_TASK = "insertfournisseur";
    public final static String DELETE_FOURNISSEUR_TASK = "deletefournisseur";
    public final static String UPDATE_FOURNISSEUR_TASK = "updatefournisseur";
    public final static String ALL_FOURNISSEURS_TASK = "allfournisseurs";

    public final static String INSERT_TYPE_ARTICLE_TASK = "inserttypearticle";
    public final static String DELETE_TYPE_ARTICLE_TASK = "deletetypearticle";
    public final static String UPDATE_TYPE_ARTICLE_TASK = "updatetypearticle";
    public final static String ALL_TYPE_ARTICLES_TASK = "alltypearticles";

    public static String SERVER_ADDRESS = "http://localhost/";


    public static String DO_READ(String table) {
        return SERVER_ADDRESS + "carshop/"+table+".php";
    }

    public static String DO_UID_URL(String table) {
        return SERVER_ADDRESS + "carshop/"+table+"Edit.php";
    }

    public static List<NameValuePair> BUILD_ARTICLE_VALUES(
            String fieldName,
            String modifType,
            String idArticle,
            String idType,
            String nomArticle,
            String pu,
            String qte) {
        List<NameValuePair> urlParameters = new ArrayList<>();
        if(modifType!=null) urlParameters.add(new BasicNameValuePair("modifType", modifType));
        if(fieldName!=null) urlParameters.add(new BasicNameValuePair("fieldName", fieldName));
        if(idArticle!=null) urlParameters.add(new BasicNameValuePair("ID_ARTICLE", idArticle));
        if(idType!=null) urlParameters.add(new BasicNameValuePair("ID_TYPE", idType));
        if(nomArticle!=null) urlParameters.add(new BasicNameValuePair("NOM_ARTICLE", nomArticle));
        if(pu!=null) urlParameters.add(new BasicNameValuePair("PU", pu));
        if(qte!=null) urlParameters.add(new BasicNameValuePair("QTE", qte));

        return urlParameters;
    }

    public static List<NameValuePair> BUILD_CLIENT_VALUES(
            String fieldName,
            String modifType,
            String idClient,
            String emailClient,
            String nomClient,
            String pNomClient,
            String adressClient,
            String dateNaissClient) {
        List<NameValuePair> urlParameters = new ArrayList<>();
        if(modifType!=null) urlParameters.add(new BasicNameValuePair("modifType", modifType));
        if(fieldName!=null) urlParameters.add(new BasicNameValuePair("fieldName", fieldName));
        if(idClient!=null) urlParameters.add(new BasicNameValuePair("ID_CLIENT", idClient));
        if(emailClient!=null) urlParameters.add(new BasicNameValuePair("MAIL_CLI", emailClient));
        if(nomClient!=null) urlParameters.add(new BasicNameValuePair("NOM_CLI", nomClient));
        if(pNomClient!=null) urlParameters.add(new BasicNameValuePair("PNOM_CLI", pNomClient));
        if(adressClient!=null) urlParameters.add(new BasicNameValuePair("ADRESS_CLI", adressClient));
        if(dateNaissClient!=null) urlParameters.add(new BasicNameValuePair("DATENAISS_CLI", dateNaissClient));

        return urlParameters;
    }

    public static List<NameValuePair> BUILD_COMMANDE_VALUES(
            String fieldName,
            String modifType,
            String idCommande,
            String dateCommande,
            String dateLivraison,
            String idClient) {
        List<NameValuePair> urlParameters = new ArrayList<>();
        if(modifType!=null) urlParameters.add(new BasicNameValuePair("modifType", modifType));
        if(fieldName!=null) urlParameters.add(new BasicNameValuePair("fieldName", fieldName));
        if(idCommande!=null) urlParameters.add(new BasicNameValuePair("ID_COMMANDE", idCommande));
        if(dateCommande!=null) urlParameters.add(new BasicNameValuePair("DATE_COMMANDE", dateCommande));
        if(dateLivraison!=null) urlParameters.add(new BasicNameValuePair("DATE_LIVRAISON", dateLivraison));
        if(idClient!=null) urlParameters.add(new BasicNameValuePair("ID_CLIENT", idClient));

        return urlParameters;
    }

    public static List<NameValuePair> BUILD_CONCERNER_VALUES(
            String fieldName,
            String modifType,
            String idConcerner,
            String idCommande,
            String idArticle,
            String qte) {
        List<NameValuePair> urlParameters = new ArrayList<>();
        if(modifType!=null) urlParameters.add(new BasicNameValuePair("modifType", modifType));
        if(fieldName!=null) urlParameters.add(new BasicNameValuePair("fieldName", fieldName));
        if(idConcerner!=null) urlParameters.add(new BasicNameValuePair("ID_CONCERNER", idConcerner));
        if(idCommande!=null) urlParameters.add(new BasicNameValuePair("ID_COMMANDE", idCommande));
        if(idArticle!=null) urlParameters.add(new BasicNameValuePair("ID_ARTICLE", idArticle));
        if(qte!=null) urlParameters.add(new BasicNameValuePair("QUANTITE", qte));

        return urlParameters;
    }

    public static List<NameValuePair> BUILD_FACTURE_VALUES(
            String fieldName,
            String modifType,
            String idFacture,
            String dateFacture,
            String idCommande) {
        List<NameValuePair> urlParameters = new ArrayList<>();
        if(modifType!=null) urlParameters.add(new BasicNameValuePair("modifType", modifType));
        if(fieldName!=null) urlParameters.add(new BasicNameValuePair("fieldName", fieldName));
        if(idFacture!=null) urlParameters.add(new BasicNameValuePair("ID_FACTURE", idFacture));
        if(idCommande!=null) urlParameters.add(new BasicNameValuePair("ID_COMMANDE", idCommande));
        if(dateFacture!=null) urlParameters.add(new BasicNameValuePair("DATE_FACTURE", dateFacture));

        return urlParameters;
    }

    public static List<NameValuePair> BUILD_FOURNIR_VALUES(
            String fieldName,
            String modifType,
            String idFournir,
            String idArticle,
            String idFournisseur,
            String qteFournie,
            String dateDemandeApprov,
            String dateLivraison) {
        List<NameValuePair> urlParameters = new ArrayList<>();
        if(modifType!=null) urlParameters.add(new BasicNameValuePair("modifType", modifType));
        if(fieldName!=null) urlParameters.add(new BasicNameValuePair("fieldName", fieldName));
        if(idFournir!=null) urlParameters.add(new BasicNameValuePair("ID_FOURNIR", idFournir));
        if(idArticle!=null) urlParameters.add(new BasicNameValuePair("ID_ARTICLE", idArticle));
        if(idFournisseur!=null) urlParameters.add(new BasicNameValuePair("ID_FOURNISSEUR", idFournisseur));
        if(qteFournie!=null) urlParameters.add(new BasicNameValuePair("QUANTITE_FOURNIE", qteFournie));
        if(dateDemandeApprov!=null) urlParameters.add(new BasicNameValuePair("DATE_APPROV", dateDemandeApprov));
        if(dateLivraison!=null) urlParameters.add(new BasicNameValuePair("DATE_LIVRAISON", dateLivraison));

        return urlParameters;
    }

    public static List<NameValuePair> BUILD_FOURNISSEUR_VALUES(
            String fieldName,
            String modifType,
            String idFournisseur,
            String codeFournisseur,
            String nomFournisseur,
            String adressFournisseur) {
        List<NameValuePair> urlParameters = new ArrayList<>();
        if(modifType!=null) urlParameters.add(new BasicNameValuePair("modifType", modifType));
        if(fieldName!=null) urlParameters.add(new BasicNameValuePair("fieldName", fieldName));
        if(idFournisseur!=null) urlParameters.add(new BasicNameValuePair("ID_FOURNISSEUR", idFournisseur));
        if(codeFournisseur!=null) urlParameters.add(new BasicNameValuePair("CODE_FOURN", codeFournisseur));
        if(nomFournisseur!=null) urlParameters.add(new BasicNameValuePair("NOM_FOURN", nomFournisseur));
        if(adressFournisseur!=null) urlParameters.add(new BasicNameValuePair("ADRESSE_FOURN", adressFournisseur));

        return urlParameters;
    }

    public static List<NameValuePair> BUILD_TYPE_ARTICLE_VALUES(
            String fieldName,
            String modifType,
            String idType,
            String nomType) {
        List<NameValuePair> urlParameters = new ArrayList<>();
        if(modifType!=null) urlParameters.add(new BasicNameValuePair("modifType", modifType));
        if(fieldName!=null) urlParameters.add(new BasicNameValuePair("fieldName", fieldName));
        if(idType!=null) urlParameters.add(new BasicNameValuePair("ID_TYPE", idType));
        if(nomType!=null) urlParameters.add(new BasicNameValuePair("NOM_TYPE", nomType));

        return urlParameters;
    }

}
