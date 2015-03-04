package ch.motoloc.gestion.business;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_RENTAL_PACK", nullable = false)
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

}
