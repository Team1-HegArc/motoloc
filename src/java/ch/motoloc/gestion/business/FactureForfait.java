package ch.motoloc.gestion.business;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Classe FactureForfait
 * @author irina.fessemaz
 */

@Entity
@Table(name="INVOICE_RENTAL")
public class FactureForfait extends Facture {
    
    // A vérifier
    @OneToOne
    @PrimaryKeyJoinColumn
    private Forfait forfait;
    
    @OneToOne
    @JoinColumn(name="FK_PAYMENT")
    private Paiement paiement;
    
}
