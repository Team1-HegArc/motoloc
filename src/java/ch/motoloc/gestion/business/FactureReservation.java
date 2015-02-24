package ch.motoloc.gestion.business;

import java.util.List;

/**
 * Classe FactureReservation
 * @author irina.fessemaz
 */
public class FactureReservation extends Facture {
    
    private Reservation reservation;
    private List<Facturation> facturations;
    private List<Paiement> paiements;
    
}
