package ch.motoloc.gestion.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Classe Pack
 * @author irina.fessemaz
 */

@Entity
@Table(name="RENTAL_PACK")
public class Pack extends Forfait {
    
    @Id
    @Column(name="PK_RENTAL_PACK")
    private Long id;
    
    // TABLE PACK_TYPE
    @Column(name = "NB_DAYS")
    private int nbJours;
    @Column(name="NB_WEEKENDS")
    private int nbWeekends;
    
    // TABLE PACK
    @Column(name="BASIC_PRICE")
    private Double prix_base;
    @Column(name="KM_PRICE")
    private Double prix_km;

}
