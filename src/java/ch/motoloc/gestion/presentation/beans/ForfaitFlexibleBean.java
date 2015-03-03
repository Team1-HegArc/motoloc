/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.services.BeanService;
import ch.motoloc.gestion.services.ForfaitService;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author vincentrobatel
 */
@ManagedBean(name = "forfaitFlexBean")
@SessionScoped
public class ForfaitFlexibleBean {

    private ForfaitFlexible forfaitFlexible;
    private FactureForfaitBean factureForfaitBean = BeanService.findBean("factureForfaitBean", FactureForfaitBean.class);

    public ForfaitFlexibleBean() {
    }

    public String ajouterFlexible(Client client) {
        forfaitFlexible = new ForfaitFlexible();
        client.addForfait(forfaitFlexible);
        forfaitFlexible.setDateCommande(new Date());
        return "succes";
    }

    public String sauverFlexible() {
        factureForfaitBean.ajoutFacture();
        return "succes";
    }

    public String detailReservation(ForfaitFlexible forfaitFlexible) {
        this.forfaitFlexible = forfaitFlexible;
        return "detailReservation";
    }

    public ForfaitFlexible getForfaitFlexible() {
        return forfaitFlexible;
    }

    public void setForfaitFlexible(ForfaitFlexible forfaitFlexible) {
        this.forfaitFlexible = forfaitFlexible;
    }

    public FactureForfaitBean getFactureForfaitBean() {
        return factureForfaitBean;
    }

    public void setFactureForfaitBean(FactureForfaitBean factureForfaitBean) {
        this.factureForfaitBean = factureForfaitBean;
    }
}
