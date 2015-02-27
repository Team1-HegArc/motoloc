/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.services.MotoService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cyril.briguet
 */
@ManagedBean(name = "motoBean")
@SessionScoped
public class MotoBean implements Serializable{

    private Long id;
    private String reference;
    private MotoModele modele;
    private String remarque;
    private boolean erreurAjout = false;
    
    
    public MotoBean() {
    }
    
    public String ajouterMoto(){
        boolean checkAjout = MotoService.ajouterMoto(reference, modele, remarque);
        if(!checkAjout) {
            erreurAjout = true;
            return "erreur"; 
        } else {
            erreurAjout = false;
            return "succes";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public MotoModele getModele() {
        return modele;
    }

    public void setModele(MotoModele modele) {
        this.modele = modele;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public boolean isErreurAjout() {
        return erreurAjout;
    }

    public void setErreurAjout(boolean erreurAjout) {
        this.erreurAjout = erreurAjout;
    }
    
    
    
    
}
