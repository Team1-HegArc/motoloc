package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.services.ConvertisseurDate;
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
    
    private String dateDebut;
    private String dateFin;
    

    public ReservationBean() {
    }
    
    public String ajouterReservation(Forfait forfait) {
        this.reservation = new Reservation();
        forfait.addReservation(reservation);
        return "choixDate";
    }
    
    public String rechercherDispoMoto() {
        this.reservation.setDateDebut(ConvertisseurDate.formatterDate(this.dateDebut));
        this.reservation.setDateFin(ConvertisseurDate.formatterDate(this.dateFin));
        return "rechercherDispoMoto";
    }
    
    public String sauverReservation() {
        ReservationService.sauverReservation(reservation);
        return "succes";
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
    
    
    
}
