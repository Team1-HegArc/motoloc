package ch.motoloc.gestion.business;

import java.util.List;

/**
 * Classe MotoModele
 * @author irina.fessemaz
 */
public class MotoModele {
    
    private String libelle;
    private int puissance;
    private Boolean abs;
    private int nbCoffres;
    private String description;
    private List<Moto> motos;

    public MotoModele() {
    }

    public MotoModele(String libelle, int puissance, Boolean abs, int nbCoffres, String description, List<Moto> motos) {
        this.libelle = libelle;
        this.puissance = puissance;
        this.abs = abs;
        this.nbCoffres = nbCoffres;
        this.description = description;
        this.motos = motos;
    }

    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public Boolean isAbs() {
        return abs;
    }

    public void setAbs(Boolean abs) {
        this.abs = abs;
    }

    public int getNbCoffres() {
        return nbCoffres;
    }

    public void setNbCoffres(int nbCoffres) {
        this.nbCoffres = nbCoffres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }
    
    
}
