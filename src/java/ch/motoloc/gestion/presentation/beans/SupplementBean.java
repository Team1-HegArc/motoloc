/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Supplement;
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

    public String rechercherSupplementDebut() {

        supplements = ReservationService.getAllSupplementsDebut();
        supplementSelect = new ArrayList<>();

        return "rechercherSuppDebut";
    }

    public String rechercherSupplementRetour() {

        supplements = ReservationService.getAllSupplementsRetour();
        supplementSelect = new ArrayList<>();

        return "rechercherSuppRetour";
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
