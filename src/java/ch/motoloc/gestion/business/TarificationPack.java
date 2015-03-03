package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author vincentrobatel
 */
@Entity
@Table(
        name = "GM_PACK_PRICE",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "UK_PACK_PRICE",
                    columnNames = {"FK_MOTORBIKE_MODEL","FK_PACK_DURATION"})})
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

    @ManyToOne
    @JoinColumn(name = "FK_MOTORBIKE_MODEL", nullable = false)
    private MotoModele motoMod;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_PACK_DURATION", nullable = false)
    private PackDuree packDuree;

    public TarificationPack() {
    }

    public TarificationPack(Long id, Double prix_base, Double prix_km, MotoModele motoMod, PackDuree packDuree) {
        this.id = id;
        this.prix_base = prix_base;
        this.prix_km = prix_km;
        this.motoMod = motoMod;
        this.packDuree = packDuree;
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

    public MotoModele getMotoMod() {
        return motoMod;
    }

    public void setMotoMod(MotoModele motoMod) {
        this.motoMod = motoMod;
    }

    public PackDuree getPackDuree() {
        return packDuree;
    }

    public void setPackDuree(PackDuree packDuree) {
        this.packDuree = packDuree;
    }
    
    @Override
    public String toString() {
        return "TarificationPack{" + "id=" + id + ", prix_base=" + prix_base + ", prix_km=" + prix_km + ", motoMod=" + motoMod + ", packDuree=" + packDuree + '}';
    }

}
