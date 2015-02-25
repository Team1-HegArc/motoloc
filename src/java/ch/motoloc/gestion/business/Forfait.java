package ch.motoloc.gestion.business;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe Forfait
 * @author irina.fessemaz
 */

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Forfait implements Serializable {
    
    //Manque ID, mettre le même nom de PK pour Pack et Flexible ?!?!
    
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @ManyToOne
    @JoinColumn(name="FK_MOTORBIKE_MODEL")
    private MotoModele motoModele;
    
    @OneToMany
    @JoinColumn(name="FK_BOOKING")
    private Set<Reservation> reservations;
    
    @OneToMany
    private Set<FactureForfait> factures;
  
}
