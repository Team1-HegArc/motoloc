/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.business.Supplement;
import ch.motoloc.gestion.persistence.dao.SupplementDAO;
import ch.motoloc.gestion.services.BeanService;
import ch.motoloc.gestion.services.ReservationService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

/**
 *
 * @author cyril.briguet
 */
@ManagedBean(name = "supplementBean")
@SessionScoped
public class SupplementBean {

    private List<Supplement> supplements;
    private List<String> supplementSelect;
    

    public SupplementBean() {
    }

    public String rechercherSupplementDebut(Moto moto) {

        BeanService.findBean("reservationBean", ReservationBean.class).getReservation().setMoto(moto);
        
        supplements = ReservationService.getAllSupplementsDebut();
        supplementSelect = new ArrayList<>();

        return "rechercherSuppDebut";
    }

    public String rechercherSupplementRetour() {

        supplements = ReservationService.getAllSupplementsRetour();
        supplementSelect = new ArrayList<>();

        return "rechercherSuppRetour";
    }
    
    public String lierSupplements(){
        List<Supplement> supp = new  ArrayList();
        SupplementDAO suppDAO = new SupplementDAO();
        for (String s : supplementSelect) {
            supp.add(suppDAO.findById(Long.valueOf(s)));
        }
        BeanService.findBean("reservationBean", ReservationBean.class).getReservation().setSupplements(supp);
        
        return "resumerReservation";
    }

    public List<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }

    public List<String> getSupplementSelect() {
        return supplementSelect;
    }

    public void setSupplementSelect(List<String> supplementSelect) {
        this.supplementSelect = supplementSelect;
    }

    

}
