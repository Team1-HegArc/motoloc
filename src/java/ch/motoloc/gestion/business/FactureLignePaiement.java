package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Classe FactureLignePaiement
 *
 * @author irina.fessemaz
 */
@Entity
@Table(
        name = "GM_LINE_PAYMENT",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "UK_LINE_PAYMENT",
                    columnNames = {"FK_INVOICE_BOOKING", "FK_PAYMENT"})})
public class FactureLignePaiement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIPA")
    @SequenceGenerator(name = "SEQ_LIPA", sequenceName = "SEQ_LINE_PAYMENT", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_LINE_PAYMENT")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PAYMENT", nullable = false)
    private Paiement paiement;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_INVOICE_BOOKING", nullable = false)
    private FactureReservation factureRes;

    @Column(name = "PRICE", nullable = false)
    private Double prix;

    public FactureLignePaiement() {
    }

    public FactureLignePaiement(Paiement paiement, FactureReservation factureRes, Double prix) {
        this.paiement = paiement;
        this.factureRes = factureRes;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public FactureReservation getFactureRes() {
        return factureRes;
    }

    public void setFactureRes(FactureReservation factureRes) {
        this.factureRes = factureRes;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "FactureLignePaiement{" + "id=" + id + ", paiement=" + paiement + ", factureRes=" + factureRes + ", prix=" + prix + '}';
    }

    

}
