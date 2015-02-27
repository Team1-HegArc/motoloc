/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.presentation.beans;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author bibien.limido
 */
@ManagedBean(name = "menuBean")
@RequestScoped
public class MenuBean {
    /**
     * équivalement a un request.parametre
     * 
     */
    @ManagedProperty("#{param.pageId}")
    String pageId;

    /**
     *
     * @return
     */
    public String getPageId() {
        return pageId;
    }

    /**
     *
     * @param pageId
     */
    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    /**
     * Creates a new instance of MenuBean
     */
    public MenuBean() {
    }

    /**
     *
     * @throws IOException
     * 
     */
    public void affichePage() throws IOException {

        switch (pageId) {

            case "accueil":
                FacesContext.getCurrentInstance().getExternalContext().redirect("accueil.xhtml");
                break;
            case "ajoutClient":
                FacesContext.getCurrentInstance().getExternalContext().redirect("editClient.xhtml");
                break;
            case "ajoutMoto":
                FacesContext.getCurrentInstance().getExternalContext().redirect("ajoutMoto.xhtml");
                break;
            case "listeClients":
                FacesContext.getCurrentInstance().getExternalContext().redirect("listeClients.xhtml");
                break;
            case "listeMotos":
                FacesContext.getCurrentInstance().getExternalContext().redirect("listeMotos.xhtml");
                break;
            default:
                FacesContext.getCurrentInstance().getExternalContext().redirect("accueil.xhtml");
        }
    }

}
