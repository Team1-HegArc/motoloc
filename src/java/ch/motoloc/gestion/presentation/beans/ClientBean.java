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
    private boolean erreur = false;
    /*
    pour tester pour afficher le client dans la modification A supprimer quand la persistance de merde marchera ! 
    */
    private Client cli = new Client("bibien", "bibien", "bibien", "bibien", "bibien", null, "dsa@sd.com","0798976767", null, null);
    
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
        boolean checkAjout = ClientService.ajouterClient(nom, prenom, rue, npa, ville, dateDeNaissance, email, telephone, remarque, numeroPermis);
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
    /*
    récupération du client dans la liste + redirection
    */
    public String editionBouton(long id)
    {
        
        return "edition";
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

    public boolean isErreur() {
        return erreur;
    }

    public void setErreur(boolean erreur) {
        this.erreur = erreur;
    }
/*
    pour test
*/
    public Client getCli() {
        return cli;
    }

    public void setCli(Client cli) {
        this.cli = cli;
    }
    
    
}
