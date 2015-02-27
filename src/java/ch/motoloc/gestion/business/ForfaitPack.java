package ch.motoloc.gestion.business;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Classe ForfaitPack
 *
 * @author irina.fessemaz
 */
@Entity
@Table(name = "GM_RENTAL_PACK")
@PrimaryKeyJoinColumn(name = "PK_RENTAL")
public class ForfaitPack extends Forfait {

    @ManyToOne
    @JoinColumn(name = "FK_RENTAL_PACK")
    private TarificationPack tarificationPack;

    public ForfaitPack() {
    }

    public ForfaitPack(TarificationPack tarificationPack, Date dateCommande, Client client, FactureForfait facture) {
        super(dateCommande, client, facture);
        this.tarificationPack = tarificationPack;
    }

    public TarificationPack getTarificationPack() {
        return tarificationPack;
    }

    public void setTarificationPack(TarificationPack tarificationPack) {
        this.tarificationPack = tarificationPack;
    }

    @Override
    public String toString() {
        return "ForfaitPack{" + "tarificationPack=" + tarificationPack + '}';
    }

}