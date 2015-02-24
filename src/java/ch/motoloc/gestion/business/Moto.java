package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe Moto
 * @author irina.fessemaz
 */

@Entity
@Table(name="MOTORBIKE")
public class Moto implements Serializable {
    
    @Id
    @Column(name="PK_MOTORBIKE")
    private Long id;
    
    @Column(name="REFERENCE")
    private String reference;
    
    @ManyToOne
    @JoinColumn(name="FK_MOTORBIKE_MODEL")
    private MotoModele modele;
    
    @Column(name="NOTE")
    private String remarque;

   
}
