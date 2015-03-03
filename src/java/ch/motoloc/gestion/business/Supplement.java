package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Classe Supplement
 *
 * @author Administrateur
 */
@Entity
@Table(
        name = "GM_CHARGE",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "UK_CHARGE",
                    columnNames = {"LABEL"})})
public class Supplement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHAR")
    @SequenceGenerator(name = "SEQ_CHAR", sequenceName = "SEQ_CHARGE", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_CHARGE")
    private Long id;

    @Column(name = "LABEL", nullable = false, length = 100)
    private String libelle;

    @Column(name = "DEFAULT_PRICE", nullable = true)
    private Double prix;

    @Column(name = "IS_EXTRA", nullable = false)
    private boolean estExtra;

    public Supplement() {
    }

    public Supplement(String libelle, Double prix, boolean estExtra) {
        this.libelle = libelle;
        this.prix = prix;
        this.estExtra = estExtra;
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

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public boolean isEstExtra() {
        return estExtra;
    }

    public void setEstExtra(boolean estExtra) {
        this.estExtra = estExtra;
    }

    @Override
    public String toString() {
        return "Supplement{" + "id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", estExtra=" + estExtra + '}';
    }

}
