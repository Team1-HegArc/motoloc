package ch.motoloc.gestion.business;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe FactureReservation
 * @author irina.fessemaz
 */

@Entity
@Table(name="INVOICE_BOOKING")
public class FactureReservation extends Facture {
    
    @OneToOne
    @JoinColumn(name="FK_BOOKING")
    private Reservation reservation;
    
    //A vérifier
    @OneToMany
    private List<Supplement> supplements;
    
    //A vérifier
    @OneToMany
    private List<Paiement> paiements;
    
}
