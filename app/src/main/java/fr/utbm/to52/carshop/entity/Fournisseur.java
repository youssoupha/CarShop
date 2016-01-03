package fr.utbm.to52.carshop.entity;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>
 */
public class Fournisseur {
    private long idFournisseur;
    private String codeFournisseur;
    private String nomFournisseur;
    private String adressFournisseur;

    public Fournisseur(String codeFournisseur, String nomFournisseur, String adressFournisseur) {
        this.codeFournisseur = codeFournisseur;
        this.nomFournisseur = nomFournisseur;
        this.adressFournisseur = adressFournisseur;
    }

    public long getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getCodeFournisseur() {
        return codeFournisseur;
    }

    public void setCodeFournisseur(String codeFournisseur) {
        this.codeFournisseur = codeFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getAdressFournisseur() {
        return adressFournisseur;
    }

    public void setAdressFournisseur(String adressFournisseur) {
        this.adressFournisseur = adressFournisseur;
    }
}
