package ch.motoloc.gestion.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
   
    @Id
    @Column(name="PK_INVOICE_RENTRAL")
    private Long id;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Forfait forfait;
    @OneToOne
    @JoinColumn(name="FK_PAYMENT")
    private Paiement paiement;
    
}
