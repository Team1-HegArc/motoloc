/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.services.ClientService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;


/**
 *
 * @author cyril.briguet
 */
@ManagedBean(name = "clientBean")
@RequestScoped
public class ClientBean implements Serializable{

    private Client client;
    private boolean erreur = false;
    
    /*
    Constructeur par defaut
    */
    public ClientBean() {
    }
    /*
    Ajoute un client dans le referenciel 
    + redirection
    */
    public String ajouterClient (){
        this.client = new Client();
        return "editClient";
    }
    
    public String editerClient (Client client){
        this.client = client;
        return "editClient";
    }
    
    public String sauverClient(){
        boolean checkAjout = ClientService.sauverClient(client);
        if(!checkAjout) {
            erreur = true;
            return "erreur"; 
        } else {
            erreur = false;
            return "succes";
        }
    }
    /*
    Suppression du client dans le référenciel + redirection
    */
    public String supprimerClient (Long id){
        boolean checkSuppression = ClientService.supprimerClient(id);
        if(!checkSuppression) {
            erreur = true;
            return "erreur"; 
        } else {
            erreur = false;
            return "succes";
        }
    }
    
    public boolean isErreur() {
        return erreur;
    }

    public void setErreur(boolean erreur) {
        this.erreur = erreur;
    }
}
