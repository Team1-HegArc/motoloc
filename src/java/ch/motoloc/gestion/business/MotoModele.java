package ch.motoloc.gestion.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe MotoModele
 *
 * @author irina.fessemaz
 */
@Entity
@Table(name = "GM_MOTORBIKE_MODEL")
public class MotoModele implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MOMO")
    @SequenceGenerator(name = "SEQ_MOMO", sequenceName = "SEQ_MOTORBIKE_MODEL", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_MOTORBIKE_MODEL")
    private Long id;

    @Column(name = "LABEL", nullable = false, length = 100)
    private String libelle;

    @Column(name = "POWER_KW", nullable = true)
    private int puissance;

    @Column(name = "HAS_ABS", nullable = true)
    private Boolean abs;

    @Column(name = "NB_CASES", nullable = true)
    private int nbCoffres;

    @Column(name = "DESCRIPTION", nullable = true, length = 500)
    private String description;

    @OneToMany(mappedBy = "motoModele")
    private List<Moto> motos;

    public MotoModele() {
        motos = new ArrayList<>();
    }

    public MotoModele(String libelle, int puissance, Boolean abs, int nbCoffres, String description) {
        this.libelle = libelle;
        this.puissance = puissance;
        this.abs = abs;
        this.nbCoffres = nbCoffres;
        this.description = description;
        motos = new ArrayList<>();
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

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public Boolean isAbs() {
        return abs;
    }

    public void setAbs(Boolean abs) {
        this.abs = abs;
    }

    public int getNbCoffres() {
        return nbCoffres;
    }

    public void setNbCoffres(int nbCoffres) {
        this.nbCoffres = nbCoffres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }

    @Override
    public String toString() {
        return "MotoModele{" + "id=" + id + ", libelle=" + libelle + ", puissance=" + puissance + ", abs=" + abs + ", nbCoffres=" + nbCoffres + ", description=" + description + ", motos=" + motos + '}';
    }
    

}
