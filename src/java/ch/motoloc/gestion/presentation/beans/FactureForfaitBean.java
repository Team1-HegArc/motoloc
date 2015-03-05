package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.FactureForfait;
import ch.motoloc.gestion.business.Forfait;
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
    private Forfait forfait;
    private Client client;

    public FactureForfaitBean() {
    }
    
    public String detailFactureForfait(Forfait forfait) {
        this.forfait = forfait;
        this.facture = forfait.getFacture();
        return "succes";
    }

    public FactureForfait getFacture() {
        return facture;
    }

    public void setFacture(FactureForfait facture) {
        this.facture = facture;
    }

    public Forfait getForfait() {
        return forfait;
    }

    public void setForfait(Forfait forfait) {
        this.forfait = forfait;
    }

    public Client getClient() {
        this.client = FactureService.getClientFactureForfait(facture);
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
