package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.services.BeanService;
import ch.motoloc.gestion.services.ConvertisseurDate;
import ch.motoloc.gestion.services.ReservationService;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

/**
 * Bean ReservationBean
 *
 * @author irina.fessemaz
 */
@ManagedBean(name = "reservationActiveBean")
@SessionScoped
public class ReservationActiveBean {

    private Reservation reservation;

    public ReservationActiveBean() {
    }

    public String reservationCourante(Client client){
        
       
        
        return "";
    }
    
    public Reservation getReservation() {
        
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }


   

}
