package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.FactureForfait;
import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.services.FactureService;
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
    private FactureForfait factureForfait;
    private Double total;
     private boolean erreur = false;

    public ForfaitFlexibleBean() {
    }

    public String ajouterFlexible(Client client) {
        forfaitFlexible = new ForfaitFlexible();
        client.addForfait(forfaitFlexible);
        forfaitFlexible.setDateCommande(new Date());

        return "succes";
    }

    public String resumer() {

        total = new Double(FactureService.getTotalFactureForfait(forfaitFlexible));
        return "succes";
    }

    public String sauverFlexible() {
        factureForfait = new FactureForfait();
        factureForfait.setReference(Long.toString(new Date().getTime()));
        forfaitFlexible.setFacture(factureForfait);
        FactureService.sauverFactureForfait(factureForfait);
        Boolean check = ForfaitService.sauverForfait(forfaitFlexible);
        
        if(!check){
            erreur = true;
            return "erreur";
        }
        else{
            erreur = false;
            return"succes";
        }
    }
    
    public String annuler(){
        ForfaitService.annulerForfaitFlexible(forfaitFlexible);
        return "annuler";
    }

    public String detailForfaitFlexible(ForfaitFlexible forfaitFlexible) {
        this.forfaitFlexible = forfaitFlexible;
        return "detailForfaitFlexible";
    }

    public ForfaitFlexible getForfaitFlexible() {
        return forfaitFlexible;
    }

    public void setForfaitFlexible(ForfaitFlexible forfaitFlexible) {
        this.forfaitFlexible = forfaitFlexible;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public FactureForfait getFactureForfait() {
        return factureForfait;
    }

    public void setFactureForfait(FactureForfait factureForfait) {
        this.factureForfait = factureForfait;
    }
    public boolean isErreur() {
        return erreur;
    }

    public void setErreur(boolean erreur) {
        this.erreur = erreur;
    }
}
