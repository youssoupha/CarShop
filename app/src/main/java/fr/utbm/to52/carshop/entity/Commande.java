package fr.utbm.to52.carshop.entity;

import java.util.Date;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class Commande {
    private long idCommande;
    private Date dateCommande;
    private Date dateLivraison;
    private long idFacture;
    private Facture facture;
    private long idClient;
    private Client client;

    public Commande(Date dateCommande, Date dateLivraison, long idClient, Client client) {
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.idClient = idClient;
        this.client = client;
    }

    public long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(long idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(long idFacture) {
        this.idFacture = idFacture;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
