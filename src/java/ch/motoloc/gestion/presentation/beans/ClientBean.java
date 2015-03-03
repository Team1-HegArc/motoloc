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
import javax.faces.bean.SessionScoped;


/**
 *
 * @author cyril.briguet
 */
@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientBean implements Serializable{

    private Client client;
    private boolean erreur = false;
    
    /*
    Constructeur par defaut
    */

    /**
     *
     */
    
    public ClientBean() {
    }
    /*
    Ajoute un client dans le referentiel 
    + redirection
    */

    /**
     *
     * @return
     */
    
    public String ajouterClient (){
        this.client = new Client();
        return "editClient";
    }
    
    /**
     *
     * @param client
     * @return
     */
    public String editerClient (Client client){
        this.client = client;
        return "editClient";
    }
    
    /**
     *
     * @return
     */
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

    /**
     *
     * @param client
     * @return
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
    
    public String detailClient (Client client){
        this.client=client;
        return "detailClient";
    }
    
        public String detailForfaitPack(Client client){
        this.client=client;
        return "detailForfaitPack";
    }
    
    /**
     *
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
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
    public void setErreur(boolean erreur) {
        this.erreur = erreur;
    }
}
