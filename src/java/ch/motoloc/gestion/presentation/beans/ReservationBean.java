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
    private boolean erreur = false;

    /**
     *
     */
    public ReservationBean() {
    }

    /**
     *
     * @param forfait
     * @return
     */
    public String ajouterReservation(Forfait forfait) {
        this.reservation = new Reservation();
        forfait.addReservation(reservation);
        return "choixDate";
    }

    /**
     *
     * @return retourne la liste des motos disponibles pour une tranche de dates
     */
    public String rechercherDispoMoto() {
        this.reservation.setDateDebut(this.dateDebut);
        this.reservation.setDateFin(this.dateFin);
        int joursRestants = 0;
        /*
        Test le type de forfait afin de retourner l'élément du bon type
        */
        if (reservation.getForfait() instanceof ForfaitPack) {
            joursRestants = ForfaitService.nbJourRestant((ForfaitPack) reservation.getForfait());
        }

        if (reservation.getForfait() instanceof ForfaitFlexible) {
            joursRestants = ForfaitService.nbJourRestant((ForfaitFlexible) reservation.getForfait());
        }
        
        /*
        test si le nombre de jours disponible est suffisant
        */
        int joursReserves = (int) (reservation.getDateFin().getTime() - reservation.getDateDebut().getTime());
        joursReserves = joursReserves /(1000*60*60*24);
        if (joursReserves > joursRestants) {
            erreur = true;
            return "erreur";
        } else {
            motos = new ListDataModel();
            motos.setWrappedData(ReservationService.rechercherDispoMoto(reservation));
            erreur=false;
            return "rechercherDispoMoto";
        }
    }

    /**
     *
     * @param reservation
     * @return
     */
    public String detailReservation(Reservation reservation) {
        this.reservation = reservation;
        return "detailReservation";
    }

    /**
     *
     * @return
     */
    public String sauverReservation() {
        ReservationService.sauverReservation(reservation);
        return "succes";
    }

    /**
     *
     * @return
     */
    public String annulerReservation() {
        reservation.setEstAnnule(true);
        
        return "annuler";
    }

    /**
     *
     * @return
     */
    public String checkinReservation() {
        this.getFactureReservationBean();
        this.factureReservationBean.sauverFacture(this.reservation);
        return "checkin";
    }
    
    public String reservationCourante(Client client){
        
       reservation = BeanService.findBean("reservationActiveBean", ReservationActiveBean.class ).reservationCourante(client);
        
        return "detailReservation";
    }

    /**
     *
     * @return
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     *
     * @param reservation
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     *
     * @return
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     *
     * @param dateDebut
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     *
     * @return
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     *
     * @param dateFin
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     *
     * @return
     */
    public ListDataModel<Moto> getMotos() {
        return motos;
    }

    /**
     *
     * @param motos
     */
    public void setMotos(ListDataModel<Moto> motos) {
        this.motos = motos;
    }

    /**
     *
     * @return
     */
    public FactureReservationBean getFactureReservationBean() {
        this.factureReservationBean = BeanService.findBean("factureReservationBean", FactureReservationBean.class);
        return factureReservationBean;
    }

    /**
     *
     * @param factureReservationBean
     */
    public void setFactureReservationBean(FactureReservationBean factureReservationBean) {
        this.factureReservationBean = factureReservationBean;
    }

    public boolean isErreur() {
        return erreur;
    }

    public void setErreur(boolean erreur) {
        this.erreur = erreur;
    }
    
}
