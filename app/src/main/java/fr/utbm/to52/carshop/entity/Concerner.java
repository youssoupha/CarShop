package fr.utbm.to52.carshop.entity;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class Concerner {

    private Long idConcerner;
    private Long idCommande;
    private Long idArticle;
    private Commande commande;
    private Article article;
    private int qte;

    public Concerner(Long idCommande, Long idArticle, Commande commande, Article article, int qte) {
        this.idCommande = idCommande;
        this.idArticle = idArticle;
        this.commande = commande;
        this.article = article;
        this.qte = qte;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Long getIdConcerner() {
        return idConcerner;
    }

    public void setIdConcerner(Long idConcerner) {
        this.idConcerner = idConcerner;
    }
}
