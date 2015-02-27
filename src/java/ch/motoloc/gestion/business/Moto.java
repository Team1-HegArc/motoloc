package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe Moto
 *
 * @author irina.fessemaz
 */
@Entity
@Table(name = "GM_MOTORBIKE")
public class Moto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MOTO")
    @SequenceGenerator(name = "SEQ_MOTO", sequenceName = "SEQ_MOTORBIKE", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_MOTORBIKE")
    private Long id;

    @Column(name = "REFERENCE")
    private String reference;

    @ManyToOne
    @JoinColumn(name = "FK_MOTORBIKE_MODEL", referencedColumnName = "PK_MOTORBIKE_MODEL")
    private MotoModele motoModele;

    @Column(name = "NOTE")
    private String remarque;

    public Moto() {
    }

    public Moto(String reference, MotoModele motoModele, String remarque) {
        this.reference = reference;
        this.motoModele = motoModele;
        this.remarque = remarque;
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

    public MotoModele getMotoModele() {
        return motoModele;
    }

    public void setMotoModele(MotoModele motoModele) {
        this.motoModele = motoModele;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    @Override
    public String toString() {
        return "Moto{" + "id=" + id + ", reference=" + reference + ", motoModele=" + motoModele + ", remarque=" + remarque + '}';
    }

    

}
