package ch.motoloc.gestion.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Classe Reservation
 *
 * @author irina.fessemaz
 */
@Entity
@Table(
        name = "GM_BOOKING",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "UK_BOOKING",
                    columnNames = {"START_DATE", "END_DATE", "FK_MOTORBIKE"})})
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOOK")
    @SequenceGenerator(name = "SEQ_BOOK", sequenceName = "SEQ_BOOKING", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_BOOKING")
    private Long id;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(name = "END_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_MOTORBIKE", nullable = false)
    private Moto moto;

    @Column(name = "IS_CANCELLED", nullable = true)
    private Boolean estAnnule;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_INVOICE_BOOKING", referencedColumnName = "PK_INVOICE", nullable = true)
    private FactureReservation facture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_RENTAL", nullable = false)
    private Forfait forfait;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "GM_BOOKING_CHARGE",
            joinColumns = {
                @JoinColumn(name = "FK_BOOKING", referencedColumnName = "PK_BOOKING", nullable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "FK_CHARGE", referencedColumnName = "PK_CHARGE", nullable = false)})
    private List<Supplement> supplements;

    
    public Reservation() {
        supplements = new ArrayList<>();
    }

    public Reservation(Date dateDebut, Date dateFin, Moto moto, Boolean estAnnule, FactureReservation facture, Forfait forfait) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.moto = moto;
        this.estAnnule = estAnnule;
        this.facture = facture;
        this.forfait = forfait;
        supplements = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Boolean getEstAnnule() {
        return estAnnule;
    }

    public void setEstAnnule(Boolean estAnnule) {
        this.estAnnule = estAnnule;
    }

    public FactureReservation getFacture() {
        return facture;
    }

    public void setFacture(FactureReservation facture) {
        this.facture = facture;
    }

    public Forfait getForfait() {
        return forfait;
    }

    public void setForfait(Forfait forfait) {
        this.forfait = forfait;
    }

    public List<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", moto=" + moto + ", estAnnule=" + estAnnule + ", facture=" + facture + ", forfait=" + forfait + ", supplements=" + supplements + '}';
    }
    
}
