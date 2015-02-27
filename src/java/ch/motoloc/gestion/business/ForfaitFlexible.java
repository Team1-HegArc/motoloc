package ch.motoloc.gestion.business;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import javax.persistence.Table;

/**
 * Classe ForfaitFlexible
 *
 * @author irina.fessemaz
 */
@Entity
@Table(name = "GM_RENTAL_FLEXIBLE")
@PrimaryKeyJoinColumn(name = "PK_RENTAL")
public class ForfaitFlexible extends Forfait {

    @Column(name = "NB_DAYS")
    private Integer nbJour;

    @ManyToOne
    @JoinColumn(name = "FK_FLEXIBLE_PRICE")
    private TarificationFlexible tarificationFlexible;

    public ForfaitFlexible() {
    }

    public ForfaitFlexible(Integer nbJour, TarificationFlexible tarificationFlexible, Date dateCommande, Client client, FactureForfait facture) {
        super(dateCommande, client, facture);
        this.nbJour = nbJour;
        this.tarificationFlexible = tarificationFlexible;
    }

    public Integer getNbJour() {
        return nbJour;
    }

    public void setNbJour(Integer nbJour) {
        this.nbJour = nbJour;
    }

    public TarificationFlexible getTarificationFlexible() {
        return tarificationFlexible;
    }

    public void setTarificationFlexible(TarificationFlexible tarificationFlexible) {
        this.tarificationFlexible = tarificationFlexible;
    }

    @Override
    public String toString() {
        return "ForfaitFlexible{" + "nbJour=" + nbJour + ", tarificationFlexible=" + tarificationFlexible + '}';
    }

    
}