package fr.utbm.to52.carshop.entity;

import java.util.Date;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class Client {
    private long idClient;
    private String emailClient;
    private String nomClient;
    private String pNomClient;
    private String adressClient;
    private Date dateNaissClient;

    public Client(String emailClient, String nomClient, String pNomClient, String adressClient, Date dateNaissClient) {
        this.emailClient = emailClient;
        this.nomClient = nomClient;
        this.pNomClient = pNomClient;
        this.adressClient = adressClient;
        this.dateNaissClient = dateNaissClient;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getpNomClient() {
        return pNomClient;
    }

    public void setpNomClient(String pNomClient) {
        this.pNomClient = pNomClient;
    }

    public Date getDateNaissClient() {
        return dateNaissClient;
    }

    public void setDateNaissClient(Date dateNaissClient) {
        this.dateNaissClient = dateNaissClient;
    }

    public String getAdressClient() {
        return adressClient;
    }

    public void setAdressClient(String adressClient) {
        this.adressClient = adressClient;
    }
}
