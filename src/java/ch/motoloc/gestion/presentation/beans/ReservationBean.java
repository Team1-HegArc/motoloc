package ch.motoloc.gestion.presentation.beans;

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
@ManagedBean(name = "reservationBean")
@SessionScoped
public class ReservationBean {

    private Reservation reservation;
    private ListDataModel<Moto> motos;
    private Date dateDebut;
    private Date dateFin;
    private FactureReservationBean factureReservationBean;

    public ReservationBean() {
    }

    public String ajouterReservation(Forfait forfait) {
        this.reservation = new Reservation();
        forfait.addReservation(reservation);
        return "choixDate";
    }

    public String rechercherDispoMoto() {
        this.reservation.setDateDebut(this.dateDebut);
        this.reservation.setDateFin(this.dateFin);

        motos = new ListDataModel();
        motos.setWrappedData(ReservationService.rechercherDispoMoto(reservation));
        
        return "rechercherDispoMoto";
    }
    
    public String detailReservation(Reservation reservation) {
        this.reservation = reservation;
        return "detailReservation";
    }

    public String sauverReservation() {
        ReservationService.sauverReservation(reservation);
        return "succes";
    }
    
    public String annulerReservation() {
        throw new UnsupportedOperationException();
    }
    
    public String checkinReservation() {
        this.getFactureReservationBean();
        this.factureReservationBean.sauverFacture(this.reservation);
        return "checkin";
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

   

    public ListDataModel<Moto> getMotos() {
        return motos;
    }

    public void setMotos(ListDataModel<Moto> motos) {
        this.motos = motos;
    }

    public FactureReservationBean getFactureReservationBean() {
        this.factureReservationBean = BeanService.findBean("factureReservationBean", FactureReservationBean.class);
        return factureReservationBean;
    }

    public void setFactureReservationBean(FactureReservationBean factureReservationBean) {
        this.factureReservationBean = factureReservationBean;
    }
    
}
