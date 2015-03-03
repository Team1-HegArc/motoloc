/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.services.MotoService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cyril.briguet
 */
@ManagedBean(name = "motoBean")
@SessionScoped
public class MotoBean implements Serializable {

    private Moto moto;
    private MotoModele modele;
    private boolean erreur = false;

    /**
     *
     */
    public MotoBean() {
    }

        public String ajouterMoto (){
        this.moto = new Moto();
        return "editMoto";
    }
    
    /**
     *
     * @param moto
     * @return
     */
    public String editerClient (Moto moto){
        this.moto = moto;
        return "editMoto";
    }
    
    /**
     *
     * @return
     */
    public String sauverMoto() {
        boolean checkAjout = MotoService.sauverMoto(moto);
        if (!checkAjout) {
            erreur = true;
            return "erreur";
        } else {
            erreur = false;
            return "succes";
        }
    }
    
        public String supprimerClient (Moto moto){
        boolean checkSuppression = MotoService.supprimerMoto(moto);
        if(!checkSuppression) {
            erreur = true;
            return "erreur"; 
        } else {
            erreur = false;
            return "succes";
        }
    }

    /**
     *
     * @return
     */
    public MotoModele getModele() {
        return modele;
    }

    /**
     *
     * @param modele
     */
    public void setModele(MotoModele modele) {
        this.modele = modele;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    /**
     *
     * @return
     */
    public boolean isErreur() {
        return erreur;
    }

    /**
     *
     * @param erreur
     */
    public void setErreurAjout(boolean erreur) {
        this.erreur = erreur;
    }

}
