package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe Facture
 * @author irina.fessemaz
 */

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Facture implements Serializable {
    
    //Manque ID, mettre le même nom de PK pour FactureForfait et FactureReservation ?!?!
    
    @Column(name="REFERENCE")
    private String reference;

}
