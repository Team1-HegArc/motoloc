package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Paiement
 * @author irina.fessemaz
 */

@Entity
@Table(name = "PAYMENT")
public class Paiement implements Serializable {
    
    @Id
    @Column(name = "PK_PAYMENT")
    private Long id;
    
    @Column(name = "LABEL")
    private String libelle;
    
    // WTF
    private double prix;
    
}
