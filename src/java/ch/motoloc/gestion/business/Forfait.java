package ch.motoloc.gestion.business;

import java.util.List;

/**
 * Classe Forfait
 * @author irina.fessemaz
 */
public class Forfait {
    
    private int nbJours;
    private MotoModele motoModele;
    private List<Reservation> reservations;

    public Forfait() {
    }

    public Forfait(int nbJours, MotoModele motoModele, List<Reservation> reservations) {
        this.nbJours = nbJours;
        this.motoModele = motoModele;
        this.reservations = reservations;
    }

    public int getNbJours() {
        return nbJours;
    }

    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    public MotoModele getMotoModele() {
        return motoModele;
    }

    public void setMotoModele(MotoModele motoModele) {
        this.motoModele = motoModele;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    
    
    
    
}
