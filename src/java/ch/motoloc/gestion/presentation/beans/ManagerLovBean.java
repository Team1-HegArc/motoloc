/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.MotoModele;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author cyril.briguet
 */
@ManagedBean(name="ManagerLovBean")
@RequestScoped
public class ManagerLovBean implements Serializable{

   public List<MotoModele> getModeles() {
        return MotoService.getAllModeles();
    }
}
