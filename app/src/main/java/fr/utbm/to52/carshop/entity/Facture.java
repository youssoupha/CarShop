package fr.utbm.to52.carshop.entity;

import java.util.Date;

/**
 * Created by MomsKébé on 03/01/2016.
 */
public class Facture {

    private long idFacture;
    private Date dateFacture;
    private long idCommande;
    private Commande commande;

    public Facture(Date dateFacture, long idCommande, Commande commande) {
        this.dateFacture = dateFacture;
        this.idCommande = idCommande;
        this.commande = commande;
    }

    public long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(long idFacture) {
        this.idFacture = idFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(long idCommande) {
        this.idCommande = idCommande;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
