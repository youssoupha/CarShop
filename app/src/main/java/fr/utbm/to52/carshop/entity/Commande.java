package fr.utbm.to52.carshop.entity;

import java.util.Date;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class Commande {
    private Long idCommande;
    private Date dateCommande;
    private Date dateLivraison;
    private Long idFacture;
    private Facture facture;
    private Long idClient;
    private Client client;

    public Commande(Date dateCommande, Date dateLivraison, Long idClient, Client client) {
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.idClient = idClient;
        this.client = client;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
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

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
