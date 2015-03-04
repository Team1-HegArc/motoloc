package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.FactureForfait;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.business.PackDuree;
import ch.motoloc.gestion.services.FactureService;
import ch.motoloc.gestion.services.ForfaitService;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bibien.limido
 */
@ManagedBean(name = "forfaitPackBean")
@SessionScoped
public class ForfaitPackBean {
    
    private ForfaitPack forfaitPack ;
    private PackDuree duree;
    private MotoModele modele;
    private FactureForfait factureForfait;
    

    public ForfaitPackBean() {
    }

    public String ajouterPack(Client client){
        this.forfaitPack = new ForfaitPack();
        this.forfaitPack.setClient(client);
        client.addForfait(forfaitPack);
        forfaitPack.setDateCommande(new Date());
        return "succes";
    }
    
    public String sauverPack(){
        factureForfait = new FactureForfait();
        factureForfait.setReference(Long.toString(new Date().getTime()));
        forfaitPack.setFacture(factureForfait);
        FactureService.sauverFactureForfait(factureForfait);
        ForfaitService.sauverForfait(forfaitPack);
        return "succes";
    }
    
    public String resumer() {
        this.getForfaitPack().setTarificationPack(ForfaitService.getForfaitPackByAjout(duree, modele));
        return "succes";
    }
    
    
    public String detailForfaitPack(ForfaitPack forfaitPack) {
        this.forfaitPack = forfaitPack;
        return "detailForfaitPack";
    }
    
    public String detailReservation(ForfaitPack forfaitPack){
        this.forfaitPack = forfaitPack;
        return "detailReservation";
    }
    
    public ForfaitPack getForfaitPack() {
        return forfaitPack;
    }

    public void setForfaitPack(ForfaitPack forfaitPack) {
        this.forfaitPack = forfaitPack;
    }

    public PackDuree getDuree() {
        return duree;
    }

    public void setDuree(PackDuree duree) {
        this.duree = duree;
    }

    public MotoModele getModele() {
        return modele;
    }

    public void setModele(MotoModele modele) {
        this.modele = modele;
    }

    public FactureForfait getFactureForfait() {
        return factureForfait;
    }

    public void setFactureForfait(FactureForfait factureForfait) {
        this.factureForfait = factureForfait;
    }
    
    
    
    
}
