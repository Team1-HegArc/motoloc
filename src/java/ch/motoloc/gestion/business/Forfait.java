package ch.motoloc.gestion.business;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe Forfait
 * @author irina.fessemaz
 */

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Forfait implements Serializable {
    
    @Id
    @Column(name = "PK_RENTAL")
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE")
    private Date dateCommande;
   
    @OneToMany
    @JoinColumn(name="FK_BOOKING")
    private Set<Reservation> reservations;
    
    @OneToMany
    private Set<FactureForfait> factures;
  
}
