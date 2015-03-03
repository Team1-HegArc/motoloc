/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.ForfaitFlexible;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author vincentrobatel
 */

@ManagedBean(name = "forfaitFlexBean")
@RequestScoped
public class ForfaitFlexibleBean {
    
    private ForfaitFlexible forfaitFlexible;

    public ForfaitFlexibleBean() {
    }

    public ForfaitFlexible getForfaitFlexible() {
        return forfaitFlexible;
    }

    public void setForfaitFlexible(ForfaitFlexible forfaitFlexible) {
        this.forfaitFlexible = forfaitFlexible;
    }
    
   
}
