package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.FactureLignePaiement;
import ch.motoloc.gestion.business.FactureLigneSupplement;
import ch.motoloc.gestion.business.FactureReservation;
import ch.motoloc.gestion.business.Paiement;
import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.business.Supplement;
import ch.motoloc.gestion.services.FactureService;
import ch.motoloc.gestion.services.ReservationService;
import java.util.Date;
import java.util.List;
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
    private FactureLigneSupplement ligneSupplement;
    private FactureLignePaiement lignePaiement;
    private List<Supplement> supplement;

    public FactureReservationBean() {
    }

    public String sauverFacture(Reservation reservation) {
        facture = new FactureReservation();
        facture.setReference(Long.toString(new Date().getTime()));
        for (Supplement supp : reservation.getSupplements()) {
            FactureLigneSupplement ligneSupp = new FactureLigneSupplement();
            ligneSupp.setSupplement(supp);
            ligneSupp.setPrix(supp.getPrix());
            facture.addFactureLigneSupplement(ligneSupp);
        }
        reservation.setFacture(facture);
        FactureService.sauverFactureReservation(facture);
        supplement = ReservationService.getAllSupplementsRetour();
        return "succes";
    }
    
    public String ajoutSupplement() {
        this.ligneSupplement = new FactureLigneSupplement();
        return "ajoutSupplement";
    }
    
        public String ajoutPaiement() {
        this.lignePaiement = new FactureLignePaiement();
        return "ajoutPaiement";
    }
    
    public String sauverSupplement(FactureLigneSupplement ligneSupplement) {
        facture.addFactureLigneSupplement(ligneSupplement);
        FactureService.sauverFactureLigneSupplement(ligneSupplement);
        return "succesAjoutSupplement";
        
    }
    
    public String sauverPaiement(FactureLignePaiement lignePaiement) {
        facture.addFactureLignePaiement(lignePaiement);
        FactureService.sauverFactureLignePaiement(lignePaiement);
        return "succesAjoutPaiement";
        
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

    public FactureLigneSupplement getLigneSupplement() {
        return ligneSupplement;
    }

    public void setLigneSupplement(FactureLigneSupplement ligneSupplement) {
        this.ligneSupplement = ligneSupplement;
    }

    public FactureLignePaiement getLignePaiement() {
        return lignePaiement;
    }

    public void setLignePaiement(FactureLignePaiement lignePaiement) {
        this.lignePaiement = lignePaiement;
    }

    public List<Supplement> getSupplement() {
        return supplement;
    }

    public void setSupplement(List<Supplement> supplement) {
        this.supplement = supplement;
    }

    
    
    
    

}
