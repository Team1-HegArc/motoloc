package ch.motoloc.gestion.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Classe Reservation
 * @author irina.fessemaz
 */

@Entity
@Table(name = "BOOKING")
public class Reservation implements Serializable {
    
    @Id
    @Column(name = "PK_PAYMENT")
    private Long id;
    
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    
    @ManyToOne
    @JoinColumn(name="FK_MOTORBIKE")
    private Moto moto;
    
    //A vérifier, enum derrière...
    @ManyToOne
    @JoinColumn(name="FK_BOOKING_STATE")
    private ReservationStatut statut;
    
    // A vérifier
    @OneToOne
    @PrimaryKeyJoinColumn
    private FactureReservation facture;
    
    // WTF
    @Transient
    private Forfait forfait;
    
    @OneToMany
    private List<Supplement> supplements;  
}
