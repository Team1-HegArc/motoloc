package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.FactureForfait;
import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.services.ConvertisseurDate;
import ch.motoloc.gestion.services.ReservationService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

/**
 * Bean FactureForfaitBean
 *
 * @author irina.fessemaz
 */
@ManagedBean(name = "factureForfaitBean")
@SessionScoped
public class FactureForfaitBean {

    private FactureForfait facture;

    public FactureForfaitBean() {
    }
    
    public String detailFactureForfait(Forfait forfait) {
        this.facture = forfait.getFacture();
        return "succes";
    }

    public FactureForfait getFacture() {
        return facture;
    }

    public void setFacture(FactureForfait facture) {
        this.facture = facture;
    }

}
