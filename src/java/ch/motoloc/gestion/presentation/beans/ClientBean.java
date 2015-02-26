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
import java.util.Date;
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

    private Long id;
    private String nom;
    private String prenom;
    private String rue;
    private String npa;
    private String ville;
    private String dateDeNaissance;
    private String email;
    private String telephone;
    private String remarque;
    private List<Forfait> forfaits;
    private String numeroPermis;
    private boolean erreurAjout = false;
    /*
    Liste de clients
    */
    private ListDataModel<Client> clients;
    
    public ClientBean() {
    }
    
    public String ajouterClient (){
        boolean checkAjout = ClientService.ajouterClient(nom, prenom, rue, npa, ville, dateDeNaissance, email, telephone, remarque, numeroPermis);
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
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNpa() {
        return npa;
    }

    public void setNpa(String npa) {
        this.npa = npa;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public List<Forfait> getForfaits() {
        return forfaits;
    }

    public void setForfaits(List<Forfait> forfaits) {
        this.forfaits = forfaits;
    }

    public String getNumeroPermis() {
        return numeroPermis;
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

    public boolean isErreurAjout() {
        return erreurAjout;
    }

    public void setErreurAjout(boolean erreurAjout) {
        this.erreurAjout = erreurAjout;
    }

    public ListDataModel<Client> getClients() {
        clients = new ListDataModel();
        clients.setWrappedData(ClientService.getClients());
        return clients;
    }

    public void setClients(ListDataModel<Client> clients) {
        this.clients = clients;
    }
    
    
}
