package ch.motoloc.gestion.business;

/**
 * Classe Supplement
 * @author irina.fessemaz
 */
public class Supplement {
    
    private String libelle;
    private double prix;

    public Supplement() {
    }

    public Supplement(String libelle, double prix) {
        this.libelle = libelle;
        this.prix = prix;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    
}
