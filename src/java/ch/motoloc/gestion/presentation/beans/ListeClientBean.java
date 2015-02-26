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

    private ListDataModel<Client> customers;
    private ClientBean customerBean;

    public ListeClientBean() {
    }

    public ListDataModel<Client> getCustomers() {
        customers = new ListDataModel();
        customers.setWrappedData(ClientService.getAllClients());
        return customers;
    }

    public void setCustomers(ListDataModel<Client> customers) {
        this.customers = customers;
    }

    public ClientBean getCustomerBean() {
        customerBean = BeanService.findBean("customerEDIBean", ClientBean.class);
        return customerBean;
    }

    public void setCustomerBean(ClientBean customerBean) {
        this.customerBean = customerBean;
    }

}
