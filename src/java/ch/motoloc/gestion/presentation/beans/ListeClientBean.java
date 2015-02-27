/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.presentation.beans;


import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.services.BeanService;
import ch.motoloc.gestion.services.ClientService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

/**
 *
 * @author bibien.limido
 */
@ManagedBean(name = "ListeClientBean")
@SessionScoped
public class ListeClientBean {

    private ListDataModel<Client> clients;
    private ClientBean clientBean;

    /**
     *
     */
    public ListeClientBean() {
    }

    /**
     *
     * @param nom
     * @param prenom
     * @param email
     */
    public String rechercherClient(String nom, String prenom, String email ){
        clients = new ListDataModel();
        clients.setWrappedData(ClientService.rechercherClient(nom, prenom, email));
        return "succes";
    }
    
    /**
     *
     * @return
     */
    public ListDataModel<Client> getClients() {
        return clients;
    }

    /**
     *
     * @param clients
     */
    public void setClients(ListDataModel<Client> clients) {
        this.clients = clients;
    }

    /**
     *
     * @return
     */
    public ClientBean getClientBean() {
        clientBean = BeanService.findBean("clientEDIBean", ClientBean.class);
        return clientBean;
    }

    /**
     *
     * @param clientBean
     */
    public void setClientBean(ClientBean clientBean) {
        this.clientBean = clientBean;
    }

}
