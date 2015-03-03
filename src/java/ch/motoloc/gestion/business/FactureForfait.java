package ch.motoloc.gestion.business;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Classe FactureForfait
 *
 * @author irina.fessemaz
 */
@Entity
@Table(
        name = "GM_INVOICE_RENTAL",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "UK_INVOICE_RENTAL",
                    columnNames = {"REFERENCE"})})
public class FactureForfait extends Facture {

    @ManyToOne
    @JoinColumn(name = "FK_PAYMENT", referencedColumnName = "PK_PAYMENT", nullable = true)
    private Paiement paiement;

    public FactureForfait() {
    }

    public FactureForfait(Paiement paiement, String reference) {
        super(reference);
        this.paiement = paiement;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    @Override
    public String toString() {
        return "FactureForfait{" + "paiement=" + paiement + '}';
    }
    
    

    
}
