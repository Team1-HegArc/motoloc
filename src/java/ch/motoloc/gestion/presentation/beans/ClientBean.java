/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.services.ClientService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


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
    Suppression du client
    */
    public String supprimerClient (Client client){
        boolean checkSuppression = ClientService.supprimerClient(client);
        if(!checkSuppression) {
            erreur = true;
            return "erreur"; 
        } else {
            erreur = false;
            return "succes";
        }
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public boolean isErreur() {
        return erreur;
    }

    public void setErreur(boolean erreur) {
        this.erreur = erreur;
    }
}
