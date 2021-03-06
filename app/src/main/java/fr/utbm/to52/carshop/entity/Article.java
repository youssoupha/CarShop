package fr.utbm.to52.carshop.entity;

import android.provider.BaseColumns;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class Article {

    private Long idArticle;
    private String nomArticle;
    private String photo;
    private double prixUnitaire;
    private int qte;
    private Long idTypeArticle;
    private TypeArticle typeArticle;

    public Article(String nomArticle, String photo, double prixUnitaire, int qte, Long idTypeArticle, TypeArticle typeArticle) {
        this.nomArticle = nomArticle;
        this.photo = photo;
        this.prixUnitaire = prixUnitaire;
        this.qte = qte;
        this.idTypeArticle = idTypeArticle;
        this.typeArticle = typeArticle;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Long getIdTypeArticle() {
        return idTypeArticle;
    }

    public void setIdTypeArticle(Long idTypeArticle) {
        this.idTypeArticle = idTypeArticle;
    }

    public TypeArticle getTypeArticle() {
        return typeArticle;
    }

    public void setTypeArticle(TypeArticle typeArticle) {
        this.typeArticle = typeArticle;
    }
}
