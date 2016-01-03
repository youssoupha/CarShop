package fr.utbm.to52.carshop.entity;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class Concerner {
    private long idCommande;
    private long idArticle;
    private Commande commande;
    private Article article;
    private int qte;

    public Concerner(long idCommande, long idArticle, Commande commande, Article article, int qte) {
        this.idCommande = idCommande;
        this.idArticle = idArticle;
        this.commande = commande;
        this.article = article;
        this.qte = qte;
    }

    public long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(long idCommande) {
        this.idCommande = idCommande;
    }

    public long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(long idArticle) {
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
}
