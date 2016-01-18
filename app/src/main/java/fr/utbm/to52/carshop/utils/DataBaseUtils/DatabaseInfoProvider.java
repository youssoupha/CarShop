package fr.utbm.to52.carshop.utils.DataBaseUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public final class DatabaseInfoProvider {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CAR_SHOP";

    public static final List<Table> getDataBaseTables(){
        List<Table> tables = new ArrayList<>();

        //Create tables
        /******************************** TypeArticle *******************************/
        PKColumn idType = new PKColumn("idType", "ID_TYPE", "INTEGER", "AUTOINCREMENT");
        Column nomType = new Column("nomType", "NOM_TYPE", "TEXT", null);

        Table typeArticle = new Table("TYPE_ARTICLE", idType, nomType);
        tables.add(typeArticle);
        /******************************** Article ***********************************/
        PKColumn idArticle = new PKColumn("idArticle", "ID_ARTICLE", "INTEGER", "AUTOINCREMENT");
        Column nomArticle = new Column("nomArticle", "NOM_ARTICLE", "TEXT", null);
        Column photo = new Column("photo", "PHOTO_ARTICLE", "TEXT", null);;
        Column prixUnitaire = new Column("prixUnitaire", "PU_ARTICLE", "REAL", null);
        Column qte = new Column("qte", "QTE_ARTICLE", "INTEGER", null);
        FKColumn idTypeArticle = new FKColumn("idTypeArticle", "ID_TYPE", "INTEGER", null, "TYPE_ARTICLE", "ID_TYPE");

        Table article = new Table("ARTICLE", idArticle, nomArticle, photo, prixUnitaire, qte, idTypeArticle);
        tables.add(article);
        /********************************* Client *************************************/
        PKColumn idClient = new PKColumn("idClient", "ID_CLI", "INTEGER", "AUTOINCREMENT");
        Column emailClient = new Column("emailClient", "EMAIL_CLI", "TEXT", null);
        Column nomClient = new Column("nomClient", "NOM_CLI", "TEXT", null);;
        Column pNomClient = new Column("pNomClient", "PNOM_CLI", "TEXT", null);;
        Column adressClient = new Column("adressClient", "ADRESS_CLI", "TEXT", null);;
        Column dateNaissClient = new Column("dateNaissClient", "DATENAISS_CLI", "TEXT", null);

        Table client = new Table("CLIENT", idClient, emailClient, nomClient, pNomClient, adressClient, dateNaissClient);
        tables.add(client);

        /********************************** Commande *********************************/
        PKColumn idCommande = new PKColumn("idCommande", "ID_COMMANDE", "INTEGER", "AUTOINCREMENT");
        Column dateCommande = new Column("dateCommande", "DATE_COMMANDE", "TEXT", null);
        Column dateLivraison = new Column("dateLivraison", "DATE_LIVRAISON", "TEXT", null);
        FKColumn idClientComm = new FKColumn("idClient", "ID_CLI", "INTEGER", null, "CLIENT", "ID_CLI");

        Table commande = new Table("COMMANDE", idCommande, dateCommande, dateLivraison, idClientComm);
        tables.add(commande);
        /********************************** Facture **********************************/

        PKColumn idFacture = new PKColumn("idFacture", "ID_FACTURE", "INTEGER", "AUTOINCREMENT");
        FKColumn idCommandefact = new FKColumn("idCommande", "ID_COMMANDE", "INTEGER", null, "COMMANDE", "ID_COMMANDE");
        Column dateFacture = new Column("dateFacture", "DATE_FACT", "TEXT", null);

        Table facture = new Table("FACTURE", idFacture, idCommandefact, dateFacture);
        tables.add(facture);

        /************************************ Concerner ********************************/
        PKColumn idConcerner =  new PKColumn("idConcerner", "ID_CONCERNER", "INTERGER", "AUTOINCREMENT");
        FKColumn idCommandeCon = new FKColumn("idCommande", "ID_COMMANDE", "INTEGER", null, "COMMANDE", "ID_COMMANDE");
        FKColumn idArticleCon = new FKColumn("idArticle", "ID_ARTICLE", "INTEGER", null, "ARTICLE", "ID_ARTICLE");
        Column qteCon = new Column("qte", "QTE", "INTEGER", null);

        Table concerner = new Table("CONCERNER", idConcerner, idCommandeCon, idArticleCon, qteCon);
        tables.add(concerner);

        /************************************** Fournisseur ******************************/
        PKColumn idFournisseur = new PKColumn("idFournisseur", "ID_FOURNISSEUR", "INTEGER", "AUTOINCREMENT");
        Column codeFournisseur = new Column("codeFournisseur", "CODE_FOURNISSEUR", "TEXT", null);
        Column nomFournisseur = new Column("nomFournisseur", "NOM_FOURNISSEUR", "TEXT", null);
        Column adressFournisseur = new Column("adressFournisseur", "ADRESS_FOURNISSEUR", "TEXT", null);

        Table fournisseur = new Table("FOURNISSEUR", idFournisseur, codeFournisseur, nomFournisseur, adressFournisseur);
        tables.add(fournisseur);

        /************************************** Fournir ******************************/
        PKColumn idFournir =  new PKColumn("idFournir", "ID_FOURNIR", "INTERGER", "AUTOINCREMENT");
        FKColumn idArticleFourn = new FKColumn("idArticle", "ID_ARTICLE", "INTEGER", null, "ARTICLE", "ID_ARTICLE");
        FKColumn idFournisseurFourn= new FKColumn("idFournisseur", "ID_FOURNISSEUR", "INTEGER", null, "FOURNISSEUR", "ID_FOURNISSEUR");
        Column qteFournie = new Column("qteFournie", "QTE", "INTEGER", null);
        Column dateDemandeApprov = new Column("dateDemandeApprov", "DATE_DEMANDE_APPROV", "TEXT", null);
        Column dateLivraisonFourn = new Column("dateLivraison", "DATE_LIVRAISON", "TEXT", null);

        Table fournir = new Table("FOURNIR", idFournir, idArticleFourn, idFournisseurFourn, qteFournie, dateDemandeApprov, dateLivraisonFourn);
        tables.add(fournir);

        return tables;
    }

    public static final Map<String, Table> getMapOfDatabaseTables() {
        Map<String, Table> databaseMap = new HashMap<>();
        for(Table table : getDataBaseTables()) {
            databaseMap.put(table.getTableName(), table);
        }
        return databaseMap;
    }

    public static final String genSQLiteCreateEntries() {
        String statement = "--------------- GENERATED SQLITE CREATE TABLE STATEMENT ---------------";

        for(Table table : getDataBaseTables()) {
            statement += "\n" + table.genCreateTableStatement();
        }

        return statement;
    }

    public static final String genSQLiteDeleteEntries() {
        String statement = "--------------- GENERATED SQLITE DROP TABLE STATEMENT ---------------";

        for(Table table : getDataBaseTables()) {
            statement += "\n" + table.genDropTableStatement();
        }

        return statement;
    }

}
