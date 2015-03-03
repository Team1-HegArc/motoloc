package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.Reservation;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean ReservationBean
 * @author irina.fessemaz
 */
@ManagedBean(name = "reservationBean")
@SessionScoped
public class ReservationBean {
    
    private Reservation reservation;
    

    public ReservationBean() {
    }
    
    public String ajouterReservation(Forfait forfait) {
        this.reservation = new Reservation();
        forfait.addReservation(reservation);
        return "succes";
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
}
