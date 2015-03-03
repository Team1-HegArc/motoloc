/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.presentation.beans;


import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.business.PackDuree;
import ch.motoloc.gestion.business.TarificationFlexible;
import ch.motoloc.gestion.business.TarificationPack;
import ch.motoloc.gestion.services.MotoService;
import ch.motoloc.gestion.services.ForfaitService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cyril.briguet
 */
@ManagedBean(name="ManagerLovBean")
@SessionScoped
public class ManagerLovBean implements Serializable{

    /**
     *
     * @return
     */
    public List<MotoModele> getModeles() {
        return MotoService.getAllMotoModele();
    }

    /**
     *
     * @return
     */
    public List<TarificationPack> getTarifiactionPacks() {
        return ForfaitService.getAllTarifiactionPack();
    }
    
    public List<TarificationFlexible> getTarificationFlexibles(){
        return ForfaitService.getAllTarifiactionFlex();
    }
    
    public List<PackDuree> getPackDuree(){
        return ForfaitService.getAllPackDuree();
    }
    
    public List<MotoModele> getModelesPacks(){
        return ForfaitService.getAllModelesPacks();
    }
}
