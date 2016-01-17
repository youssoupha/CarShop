package fr.utbm.to52.carshop.entity;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class TypeArticle {

    private Long idType;
    private String nomType;

    public TypeArticle(String nomType) {
        this.nomType = nomType;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }
}
