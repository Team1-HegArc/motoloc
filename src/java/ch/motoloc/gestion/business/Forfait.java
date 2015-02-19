package ch.motoloc.gestion.business;

import java.util.Date;
import java.util.Set;

/**
 * Classe Forfait
 * @author irina.fessemaz
 */
public class Forfait {
    
    private int nbJours;
    private MotoModele motoModele;
    private Set<Reservation> reservations;
    private Date date;
    private double prix;
    private Set<FactureForfait> factures;
  
}
