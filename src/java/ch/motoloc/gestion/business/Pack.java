package ch.motoloc.gestion.business;

import java.util.List;

/**
 * Classe Pack
 * @author irina.fessemaz
 */
public class Pack extends Forfait {
    
    private int nbWeekends;

    public Pack() {
    }

    public Pack(int nbWeekends, int nbJours, MotoModele motoModele, List<Reservation> reservations) {
        super(nbJours, motoModele, reservations);
        this.nbWeekends = nbWeekends;
    }

    public int getNbWeekends() {
        return nbWeekends;
    }

    public void setNbWeekends(int nbWeekends) {
        this.nbWeekends = nbWeekends;
    }
    
    
    
}
