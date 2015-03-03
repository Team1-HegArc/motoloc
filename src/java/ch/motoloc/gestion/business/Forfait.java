package ch.motoloc.gestion.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe Forfait
 *
 * @author irina.fessemaz
 */
@Entity
@Table(name = "GM_RENTAL")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Forfait implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RENT")
    @SequenceGenerator(name = "SEQ_RENT", sequenceName = "SEQ_RENTAL", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_RENTAL")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE", nullable = false)
    private Date dateCommande;

    @ManyToOne
    @JoinColumn(name = "FK_CUSTOMER", referencedColumnName = "PK_CUSTOMER", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "forfait", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_INVOICE_RENTAL", referencedColumnName = "PK_INVOICE", nullable = true)
    private FactureForfait facture;

    protected Forfait() {
        reservations = new ArrayList<>();
    }

    protected Forfait(Date dateCommande, Client client, FactureForfait facture) {
        this.dateCommande = dateCommande;
        this.client = client;
        this.facture = facture;
        reservations = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public FactureForfait getFacture() {
        return facture;
    }

    public void setFacture(FactureForfait facture) {
        this.facture = facture;
    }

    @Override
    public String toString() {
        return "Forfait{" + "id=" + id + ", dateCommande=" + dateCommande + ", client=" + client + ", reservations=" + reservations + ", facture=" + facture + '}';
    }
    
    

}
