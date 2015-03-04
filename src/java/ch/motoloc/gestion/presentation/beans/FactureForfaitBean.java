/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.FactureForfait;
import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.services.FactureService;
import ch.motoloc.gestion.services.ForfaitService;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Vincent Robatel
 */

@ManagedBean(name = "factureForfaitBean")
@SessionScoped
public class FactureForfaitBean {
    private FactureForfait factureForfait;

    public FactureForfaitBean() {
        factureForfait = new FactureForfait();
        factureForfait.setReference(Long.toString(new Date().getTime()));
    }
    public void ajoutFacture(){
        factureForfait = new FactureForfait();
        factureForfait.setReference(Long.toString(new Date().getTime()));
    }
    
    public String sauveFacture(ForfaitPack forfait){
        FactureService.sauverFacture(factureForfait);
        forfait.setFacture(factureForfait);
        ForfaitService.sauverForfait(forfait);
        return "succes";
    }
    
    public String sauveFacture(ForfaitFlexible forfait){
        FactureService.sauverFacture(factureForfait);
        forfait.setFacture(factureForfait);
        ForfaitService.sauverForfait(forfait);
        return "succes";
    }

    public FactureForfait getFactureForfait() {
        return factureForfait;
    }

    public void setFactureForfait(FactureForfait factureForfait) {
        this.factureForfait = factureForfait;
    }

    
}
