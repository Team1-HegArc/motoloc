/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.FactureForfait;
import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.services.FactureService;
import ch.motoloc.gestion.services.ForfaitService;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Vincent Robatel
 */

@ManagedBean(name = "factureForfaitBean")
@RequestScoped
public class FactureForfaitBean {
    private FactureForfait factureForfait;

    public FactureForfaitBean() {
    }

    public String ajoutFacture(Forfait forfait){
        factureForfait = new FactureForfait();
        factureForfait.setReference(Long.toString(new Date().getTime()));
        forfait.setFacture(factureForfait);
        FactureService.sauverFacture(factureForfait);
        ForfaitService.sauverForfait(forfait);
        return "succes";
    }
    
    public String confirmer(){
        return null;
    }
    
    public FactureForfait getFactureForfait() {
        return factureForfait;
    }

    public void setFactureForfait(FactureForfait factureForfait) {
        this.factureForfait = factureForfait;
    }
    
}
