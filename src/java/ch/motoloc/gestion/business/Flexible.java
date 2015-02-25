package ch.motoloc.gestion.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Flexible
 * @author irina.fessemaz
 */

@Entity
@Table(name="RENTAL_FLEXIBLE")
public class Flexible extends Forfait {
    
    @Id
    @Column(name="PK_RENTAL_FLEXIBLE")
    private Long id;
    
    @Column(name = "NB_DAYS")
    private int nbJours;
    
    // TABLE FLEXIBLE
    @Column(name="DAY_PRICE")
    private Double prix_jour;
    @Column(name="KM_PRICE")
    private Double prix_km;
    @Column(name="DEGRESSION_PRICE")
    private Double prix_degression;
    
    
    
}
