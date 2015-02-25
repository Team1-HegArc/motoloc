package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe Facture
 * @author irina.fessemaz
 */

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Facture implements Serializable {
    
    @Id
    @Column(name="PK_INVOICE")
    private Long id;
    
    @Column(name="REFERENCE")
    private String reference;

}
