/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.business.PackDuree;
import ch.motoloc.gestion.services.ForfaitService;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bibien.limido
 */
@ManagedBean(name = "forfaitPackBean")
@SessionScoped
public class ForfaitPackBean {
    private ForfaitPack fPack ;
    private PackDuree duree;
    private MotoModele modele;
    
    /**
     * Creates a new instance of forfaitPack
     */
    public ForfaitPackBean() {
    }

    public String ajouterPack(Client client){
        this.fPack = new ForfaitPack();
        client.addForfait(fPack);
        fPack.setDateCommande(new Date());
        return "succes";
    }
    
    public String sauverPack(){
        this.getfPack().setTarificationPack(ForfaitService.getForfaitPackByAjout(duree, modele));
        ForfaitService.sauverForfait(fPack);
        return "succes";
    }
    
    public ForfaitPack getfPack() {
        return fPack;
    }

    public void setfPack(ForfaitPack fPack) {
        this.fPack = fPack;
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
    
}
