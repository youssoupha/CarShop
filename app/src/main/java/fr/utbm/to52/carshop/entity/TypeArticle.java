package fr.utbm.to52.carshop.entity;

/**
 * Created by MomsKébé on 03/01/2016.
 */
public class TypeArticle {

    private long idType;
    private String nomType;

    public TypeArticle(String nomType) {
        this.nomType = nomType;
    }

    public long getIdType() {
        return idType;
    }

    public void setIdType(long idType) {
        this.idType = idType;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }
}
