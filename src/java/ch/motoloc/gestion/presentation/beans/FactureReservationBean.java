package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.FactureForfait;
import ch.motoloc.gestion.business.FactureReservation;
import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.services.FactureService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean FactureReservationBean
 *
 * @author irina.fessemaz
 */
@ManagedBean(name = "factureReservationBean")
@SessionScoped
public class FactureReservationBean {

    private FactureReservation facture;
    private Reservation reservation;
    private Client client;

    public FactureReservationBean() {
    }
    
    public String detailFactureReservation(Reservation reservation) {
        this.reservation = reservation;
        this.facture = reservation.getFacture();
        return "succes";
    }

    public FactureReservation getFacture() {
        return facture;
    }

    public void setFacture(FactureReservation facture) {
        this.facture = facture;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }


    public Client getClient() {
        this.client = FactureService.getClientFactureReservation(facture);
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
