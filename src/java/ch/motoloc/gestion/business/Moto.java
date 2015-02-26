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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public MotoModele getModele() {
        return modele;
    }

    public void setModele(MotoModele modele) {
        this.modele = modele;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    
    
   
}
