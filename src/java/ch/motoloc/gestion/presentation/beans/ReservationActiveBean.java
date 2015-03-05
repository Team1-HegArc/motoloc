package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.business.ForfaitPack_;
import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.services.BeanService;
import ch.motoloc.gestion.services.ConvertisseurDate;
import ch.motoloc.gestion.services.ForfaitService;
import ch.motoloc.gestion.services.ReservationService;
import java.util.Date;
import java.util.List;
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

    private List<Reservation> reservations;

    /**
     *
     */
    public ReservationActiveBean() {
    }

    public List<Reservation> reservationCourante(Client client) {
   
         reservations = ReservationService.getReservationActive(client);

        return reservations;
    }

    /**
     *
     * @return
     */
    public List<Reservation> getReservation() {
        return reservations;
    }

    /**
     *
     * @param reservation
     */
    public void setReservation(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
