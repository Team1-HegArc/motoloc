package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe FactureLigneSupplement
 *
 * @author irina.fessemaz
 */
@Entity
@Table(name = "GM_LINE_CHARGE")
public class FactureLigneSupplement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LICH")
    @SequenceGenerator(name = "SEQ_LICH", sequenceName = "SEQ_LINE_CHARGE", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_LINE_CHARGE")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_CHARGE")
    private Supplement supplement;

    @OneToOne
    @JoinColumn(name = "FK_INVOICE_BOOKING")
    private FactureReservation factureRes;

    @Column(name = "PRICE")
    private Double prix;

    public FactureLigneSupplement() {
    }

    public FactureLigneSupplement(Supplement supplement, FactureReservation factureRes, Double prix) {
        this.supplement = supplement;
        this.factureRes = factureRes;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "FactureLigneSupplement{" + "id=" + id + ", supplement=" + supplement + ", factureRes=" + factureRes + ", prix=" + prix + '}';
    }

   

}
