package ch.motoloc.gestion.business;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe MotoModele
 * @author irina.fessemaz
 */

@Entity
@Table(name="MOTORBIKE_MODEL")
public class MotoModele implements Serializable {
    
    @Id
    @Column(name="PK_MOTORBIKE_MODEL")
    private Long id;
    
    @Column(name="LABEL")
    private String libelle;
    
    @Column(name="POWER_KW")
    private int puissance;
    
    // CONVERTER
    @Column(name="HAS_ABS")
    private Boolean abs;
    
    @Column(name="NB_CASES")
    private int nbCoffres;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @OneToMany
    private Set<Moto> motos;

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

    public Set<Moto> getMotos() {
        return motos;
    }

    public void setMotos(Set<Moto> motos) {
        this.motos = motos;
    }

    
    
}
