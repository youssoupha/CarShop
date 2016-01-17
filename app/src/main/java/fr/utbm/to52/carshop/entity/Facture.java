package fr.utbm.to52.carshop.entity;

import java.util.Date;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class Facture {

    private Long idFacture;
    private Date dateFacture;

    public Facture(Long idFacture, Date dateFacture) {
        this.idFacture = idFacture;
        this.dateFacture = dateFacture;
    }

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }
}
