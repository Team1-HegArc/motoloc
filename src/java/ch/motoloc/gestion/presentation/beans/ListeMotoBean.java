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

@ManagedBean(name = "ListeClientBean")
@SessionScoped
public class ListeMotoBean {
    
    
    private ListDataModel<Moto> motos;
    private MotoBean motoBean;
    private boolean erreur;

    public ListeMotoBean() {
    }
    
    public String rechercherClient(MotoModele motoModele, String numeroChassis){
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
}
