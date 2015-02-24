package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Supplement
 * @author irina.fessemaz
 */

@Entity
@Table(name="CHARGE")
public class Supplement implements Serializable {
    
    @Id
    @Column(name="PK_CHARGE")
    private String libelle;
    
    @Column(name="DEFAULT_PRICE")
    private double prix;
    
    // CONVERTER
    @Column(name="IS_EXTRA")
    private boolean estExtra;

}
