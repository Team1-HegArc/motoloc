package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.FactureForfait;
import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.services.FactureService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean FactureForfaitBean
 *
 * @author irina.fessemaz
 */
@ManagedBean(name = "factureForfaitBean")
@SessionScoped
public class FactureForfaitBean {

    private FactureForfait facture;
    private ForfaitFlexible forfaitFlexible;
    private ForfaitPack forfaitPack;
    private Client client;

    public FactureForfaitBean() {
    }
    
    public String detailFactureForfait(ForfaitFlexible forfait) {
        this.forfaitFlexible=forfait;
        this.facture = forfait.getFacture();
        return "succes";
    }
    
    public String detailFactureForfait(ForfaitPack forfait) {
        this.forfaitPack=forfait;
        this.facture = forfait.getFacture();
        return "succes";
    }

    public FactureForfait getFacture() {
        return facture;
    }

    public void setFacture(FactureForfait facture) {
        this.facture = facture;
    }

    public ForfaitFlexible getForfaitFlexible() {
        return forfaitFlexible;
    }

    public void setForfaitFlexible(ForfaitFlexible forfaitFlexible) {
        this.forfaitFlexible = forfaitFlexible;
    }

    public ForfaitPack getForfaitPack() {
        return forfaitPack;
    }

    public void setForfaitPack(ForfaitPack forfaitPack) {
        this.forfaitPack = forfaitPack;
    }

    public Client getClient() {
        this.client = FactureService.getClientFactureForfait(facture);
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
