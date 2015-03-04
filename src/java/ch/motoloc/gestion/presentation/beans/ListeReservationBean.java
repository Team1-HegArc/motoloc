package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.services.ReservationService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

/**
 * Bean ListeReservationBean
 * @author irina.fessemaz
 */
@ManagedBean(name = "listeReservationBean")
@SessionScoped
public class ListeReservationBean {
    
    private ListDataModel<Reservation> reservations;
    private ListDataModel<Reservation> reservationsDuJour;
    
    
    public ListeReservationBean() {
    }
    
    public String rechercherReservations() {
        this.reservations = new ListDataModel<>();
        this.reservations.setWrappedData(ReservationService.getAllReservations());
        return "succes";
    }
    
     public String rechercherReservationsDuJour() {
        this.reservations = new ListDataModel<>();
        this.reservations.setWrappedData(ReservationService.getAllReservations());
        return "succes";
    }
    

    public ListDataModel<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ListDataModel<Reservation> reservations) {
        this.reservations = reservations;
    }

    public ListDataModel<Reservation> getReservationsDuJour() {
        return reservationsDuJour;
    }

    public void setReservationsDuJour(ListDataModel<Reservation> reservationsDuJour) {
        this.reservationsDuJour = reservationsDuJour;
    }
    
    
}
