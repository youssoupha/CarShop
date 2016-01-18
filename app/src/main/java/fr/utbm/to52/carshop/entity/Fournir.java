package fr.utbm.to52.carshop.entity;

import java.util.Date;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class Fournir {
    private Long idFournir;
    private Long idArticle;
    private Long idFournisseur;
    private Article article;
    private Fournisseur fournisseur;
    private long qteFournie;
    private Date dateDemandeApprov;
    private Date dateLivraison;

    public Fournir(Long idArticle,
                   Long idFournisseur,
                   Article article,
                   Fournisseur fournisseur,
                   long qteFournie,
                   Date dateDemandeApprov,
                   Date dateLivraison) {
        this.idArticle = idArticle;
        this.idFournisseur = idFournisseur;
        this.article = article;
        this.fournisseur = fournisseur;
        this.qteFournie = qteFournie;
        this.dateDemandeApprov = dateDemandeApprov;
        this.dateLivraison = dateLivraison;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public Long getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public long getQteFournie() {
        return qteFournie;
    }

    public void setQteFournie(long qteFournie) {
        this.qteFournie = qteFournie;
    }

    public Date getDateDemandeApprov() {
        return dateDemandeApprov;
    }

    public void setDateDemandeApprov(Date dateDemandeApprov) {
        this.dateDemandeApprov = dateDemandeApprov;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Long getIdFournir() {
        return idFournir;
    }

    public void setIdFournir(Long idFournir) {
        this.idFournir = idFournir;
    }
}
