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
import javax.persistence.UniqueConstraint;

/**
 * Classe FactureLigneSupplement
 *
 * @author irina.fessemaz
 */
@Entity
@Table(
        name = "GM_LINE_CHARGE",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "UK_LINE_CHARGE",
                    columnNames = {"FK_INVOICE_BOOKING", "FK_CHARGE"})})
public class FactureLigneSupplement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LICH")
    @SequenceGenerator(name = "SEQ_LICH", sequenceName = "SEQ_LINE_CHARGE", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_LINE_CHARGE")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_CHARGE", nullable = false)
    private Supplement supplement;

    @OneToOne
    @JoinColumn(name = "FK_INVOICE_BOOKING", nullable = false)
    private FactureReservation factureRes;

    @Column(name = "PRICE", nullable = false)
    private Double prix;

    public FactureLigneSupplement() {
    }

    public FactureLigneSupplement(Supplement supplement, FactureReservation factureRes, Double prix) {
        this.supplement = supplement;
        this.factureRes = factureRes;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplement getSupplement() {
        return supplement;
    }

    public void setSupplement(Supplement supplement) {
        this.supplement = supplement;
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
        return "FactureLigneSupplement{" + "id=" + id + ", supplement=" + supplement + ", factureRes=" + factureRes + ", prix=" + prix + '}';
    }

   

}
