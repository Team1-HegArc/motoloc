package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe Paiement
 *
 * @author irina.fessemaz
 */
@Entity
@Table(name = "GM_PAYMENT")
public class Paiement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAYM")
    @SequenceGenerator(name = "SEQ_PAYM", sequenceName = "SEQ_PAYMENT", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_PAYMENT")
    private Long id;
    
    @Column(name = "LABEL", nullable = false, length = 100)
    private String libelle;

    public Paiement() {
    }

    public Paiement(String libelle) {
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Paiement{" + "id=" + id + ", libelle=" + libelle + '}';
    }

}
