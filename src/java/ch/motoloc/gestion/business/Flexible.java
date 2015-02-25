package ch.motoloc.gestion.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Table;

/**
 * Classe Flexible
 * @author irina.fessemaz
 */

@Entity
@Table(name="RENTAL_FLEXIBLE")
public class Flexible extends Forfait{
    
    @Column(name = "NB_DAYS")
    private Integer nbJour;
    
    @OneToOne
    @JoinColumn(name="FK_FLEXIBLE", unique=true)
    private TarificationFlexible tarificationFlexible;
}
