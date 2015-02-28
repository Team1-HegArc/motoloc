/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.services.BeanService;
import ch.motoloc.gestion.services.ClientService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author vincentrobatel
 */
@ManagedBean(name = "filtreClient")
@SessionScoped
public class FiltreClientBean {
 
    
    private String nom;
    private String prenom;
    private String email;
    private ListeClientBean listeClientBean;
    

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ListeClientBean getListeClientBean() {
        listeClientBean = BeanService.findBean("ListeClientBean", ListeClientBean.class);
        return listeClientBean;
    }

    public void setListeClientBean(ListeClientBean listeClientBean) {
        this.listeClientBean = listeClientBean;
    }
    
    
}
