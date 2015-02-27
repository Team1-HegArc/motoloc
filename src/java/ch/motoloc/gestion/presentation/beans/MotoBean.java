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

    /**
     *
     */
    public MotoBean() {
    }
    
    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getReference() {
        return reference;
    }

    /**
     *
     * @param reference
     */
    public void setReference(String reference) {
        this.reference = reference;
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

    /**
     *
     * @return
     */
    public String getRemarque() {
        return remarque;
    }

    /**
     *
     * @param remarque
     */
    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    /**
     *
     * @return
     */
    public boolean isErreurAjout() {
        return erreurAjout;
    }

    /**
     *
     * @param erreurAjout
     */
    public void setErreurAjout(boolean erreurAjout) {
        this.erreurAjout = erreurAjout;
    }
    
    
    
    
}
