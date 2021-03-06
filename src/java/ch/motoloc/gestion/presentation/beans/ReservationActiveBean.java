package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;
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

    private Reservation reservation;
    

    /**
     *
     */
    public ReservationActiveBean() {
    }

    /**
     *
     * @return
     */
    public Reservation getReservation() {
        List<Reservation> listRes = ReservationService.getReservationActive(BeanService.findBean("clientBean", ClientBean.class).getClient());

        if(listRes.isEmpty()){
            reservation = null;
        }else{
            reservation = listRes.get(0);
        }
        return reservation;
    }

    /**
     *
     * @param reservation
     */
    public void setReservation(Reservation reservations) {
        this.reservation = reservation;
    }

}
