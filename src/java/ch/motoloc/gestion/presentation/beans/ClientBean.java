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
public class ClientBean implements Serializable {

    private Client client;
    private boolean erreur = false;

    public ClientBean() {
    }

    public String ajouterClient() {
        this.client = new Client();
        return "editClient";
    }

    public String editerClient(Client client) {
        this.client = client;
        return "editClient";
    }

    public String sauverClient() {
        boolean checkAjout = ClientService.sauverClient(client);
        if (!checkAjout) {
            erreur = true;
            return "erreur";
        } else {
            erreur = false;
            return "succes";
        }
    }

    public String supprimerClient(Client client) {
        boolean checkSuppression = ClientService.supprimerClient(client);
        if (!checkSuppression) {
            erreur = true;
            return "erreur";
        } else {
            erreur = false;
            return "succes";
        }
    }

    public String detailClient(Client client) {
        this.client = client;
        return "detailClient";
    }

    public String detailForfaitPack(Client client) {
        this.client = client;
        return "detailForfaitPack";
    }
    
    public String detailForfaitFlexible(Client client) {
        this.client = client;
        return "detailForfaitFlexible";
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
