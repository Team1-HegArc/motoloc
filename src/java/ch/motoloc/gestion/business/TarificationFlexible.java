package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Vincent Robatel
 */
@Entity
@Table(
        name = "GM_FLEXIBLE_PRICE",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "UK_FLEXIBLE_PRICE",
                    columnNames = {"FK_MOTORBIKE_MODEL"})})
public class TarificationFlexible implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FLPR")
    @SequenceGenerator(name = "SEQ_FLPR", sequenceName = "SEQ_FLEXIBLE_PRICE", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_FLEXIBLE_PRICE")
    private Long id;
    
    @Column(name = "DAY_PRICE", nullable = false)
    private Double prix_jour;
    
    @Column(name = "KM_PRICE", nullable = false)
    private Double prix_km;
    
    @Column(name = "DEGRESSION_PRICE", nullable = false)
    private Double prix_degression;
    
    @OneToOne
    @JoinColumn(name = "FK_MOTORBIKE_MODEL", referencedColumnName = "PK_MOTORBIKE_MODEL", nullable = false)
    private MotoModele motoModl;

    public TarificationFlexible() {
    }

    public TarificationFlexible(Double prix_jour, Double prix_km, Double prix_degression, MotoModele motoModl) {
        this.prix_jour = prix_jour;
        this.prix_km = prix_km;
        this.prix_degression = prix_degression;
        this.motoModl = motoModl;
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

    public MotoModele getMotoModl() {
        return motoModl;
    }

    public void setMotoModl(MotoModele motoModl) {
        this.motoModl = motoModl;
    }

    @Override
    public String toString() {
        return "TarificationFlexible{" + "id=" + id + ", prix_jour=" + prix_jour + ", prix_km=" + prix_km + ", prix_degression=" + prix_degression + ", motoModl=" + motoModl + '}';
    }

}
