package ch.motoloc.gestion.business;

import java.util.Date;
import java.util.List;

/**
 * Classe Reservation
 * @author irina.fessemaz
 */
public class Reservation {
    
    private Date dateDebut;
    private Date dateFin;
    private Moto moto;
    private ReservationStatut statut;
    private FactureReservation facture;
    private Forfait forfait;
    private List<Supplement> supplements;  
}
