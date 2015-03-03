/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.services.MotoService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

/**
 *
 * @author vincentrobatel
 */

@ManagedBean(name = "ListeMotoBean")
@SessionScoped
public class ListeMotoBean {
    
    
    private ListDataModel<Moto> motos;
    private MotoBean motoBean;
    private boolean erreur;

    public ListeMotoBean() {
    }
    
    public String rechercherMoto(MotoModele motoModele, String numeroChassis){
        String retour;
        motos = new ListDataModel();
        motos.setWrappedData(MotoService.rechercherMoto(motoModele, numeroChassis));
        if(motos.isRowAvailable()){
            retour = "succes";
            erreur = false;
        }
        else{
            retour = "erreur";
            erreur = true;
        }
        return retour;
    }

    public ListDataModel<Moto> getMotos() {
        return motos;
    }

    public void setMotos(ListDataModel<Moto> motos) {
        this.motos = motos;
    }

    public MotoBean getMotoBean() {
        return motoBean;
    }

    public void setMotoBean(MotoBean motoBean) {
        this.motoBean = motoBean;
    }

    public boolean isErreur() {
        return erreur;
    }

    public void setErreur(boolean erreur) {
        this.erreur = erreur;
    }
    
    
    
}
