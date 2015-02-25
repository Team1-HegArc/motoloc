/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Vincent Robatel
 */
@Entity
@Table(name="FLEXIBLE")
public class TarificationFlexible implements Serializable {
    
    @Id
    @Column(name = "PK_FLEXIBLE")
    private Long id;
    
    @Column(name="DAY_PRICE")
    private Double prix_jour;
    
    @Column(name="KM_PRICE")
    private Double prix_km;
    
    @Column(name="DEGRESSION_PRICE")
    private Double prix_degression;
    
    @OneToOne
    @JoinColumn(name="FK_MOTORBIKE_MODEL", unique = true)
    private MotoModele motoModele;

    public TarificationFlexible() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrix_jour() {
        return prix_jour;
    }

    public void setPrix_jour(Double prix_jour) {
        this.prix_jour = prix_jour;
    }

    public Double getPrix_km() {
        return prix_km;
    }

    public void setPrix_km(Double prix_km) {
        this.prix_km = prix_km;
    }

    public Double getPrix_degression() {
        return prix_degression;
    }

    public void setPrix_degression(Double prix_degression) {
        this.prix_degression = prix_degression;
    }

    public MotoModele getMotoModele() {
        return motoModele;
    }

    public void setMotoModele(MotoModele motoModele) {
        this.motoModele = motoModele;
    }
    
    
}
