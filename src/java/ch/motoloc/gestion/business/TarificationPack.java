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
 *
 * @author vincentrobatel
 */
@Entity
@Table(name = "GM_PACK_PRICE")
public class TarificationPack implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAPR")
    @SequenceGenerator(name = "SEQ_PAPR", sequenceName = "SEQ_PACK_PRICE", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_PACK_PRICE")
    private Long id;

    @Column(name = "BASIC_PRICE", nullable = false)
    private Double prix_base;

    @Column(name = "KM_PRICE", nullable = false)
    private Double prix_km;

    @Column(name = "NB_DAYS", nullable = false)
    private int nbJours;

    @Column(name = "NB_WEEKENDS", nullable = false)
    private int nbWeekends;

    @ManyToOne
    @JoinColumn(name = "FK_MOTORBIKE_MODEL", nullable = false)
    private MotoModele motoMod;

    public TarificationPack() {
    }

    public TarificationPack(Double prix_base, Double prix_km, int nbJours, int nbWeekends, MotoModele motoMod) {
        this.prix_base = prix_base;
        this.prix_km = prix_km;
        this.nbJours = nbJours;
        this.nbWeekends = nbWeekends;
        this.motoMod = motoMod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrix_base() {
        return prix_base;
    }

    public void setPrix_base(Double prix_base) {
        this.prix_base = prix_base;
    }

    public Double getPrix_km() {
        return prix_km;
    }

    public void setPrix_km(Double prix_km) {
        this.prix_km = prix_km;
    }

    public int getNbJours() {
        return nbJours;
    }

    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    public int getNbWeekends() {
        return nbWeekends;
    }

    public void setNbWeekends(int nbWeekends) {
        this.nbWeekends = nbWeekends;
    }

    public MotoModele getMotoMod() {
        return motoMod;
    }

    public void setMotoMod(MotoModele motoMod) {
        this.motoMod = motoMod;
    }

    @Override
    public String toString() {
        return "TarificationPack{" + "id=" + id + ", prix_base=" + prix_base + ", prix_km=" + prix_km + ", nbJours=" + nbJours + ", nbWeekends=" + nbWeekends + ", motoMod=" + motoMod + '}';
    }

}
