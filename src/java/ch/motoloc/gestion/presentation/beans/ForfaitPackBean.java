/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.business.PackDuree;
import ch.motoloc.gestion.services.ForfaitService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author bibien.limido
 */
@ManagedBean(name = "forfaitPackBean")
@RequestScoped
public class ForfaitPackBean {
    private ForfaitPack fPack ;
    private PackDuree duree;
    private MotoModele modele;
    
    /**
     * Creates a new instance of forfaitPack
     */
    public ForfaitPackBean() {
    }

    public String ajouterPack(){
        this.fPack = new ForfaitPack();
        return "succes";
    }
    
    public String sauverPack(){
        this.getfPack().setTarificationPack(ForfaitService.getForfaitPackByAjout(duree, modele));
        ForfaitService.sauverForfaitPack(fPack);
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
