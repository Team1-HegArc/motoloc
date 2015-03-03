package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

/**
 * Classe Facture
 *
 * @author irina.fessemaz
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Facture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INVO")
    @SequenceGenerator(name = "SEQ_INVO", sequenceName = "SEQ_INVOICE", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_INVOICE")
    private Long id;

    @Column(name = "REFERENCE", nullable = false, length = 50)
    private String reference;

    protected Facture() {
    }

    protected Facture(String reference) {
        this.reference = reference;
    }

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

    @Override
    public String toString() {
        return "Facture{" + "id=" + id + ", reference=" + reference + '}';
    }

    
}
