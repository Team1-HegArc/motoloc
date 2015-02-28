/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.ForfaitPack;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author bibien.limido
 */
@ManagedBean(name = "forfaitPackBean")
@RequestScoped
public class ForfaitPackBean {
    private ForfaitPack fPack ;
    /**
     * Creates a new instance of forfaitPack
     */
    public ForfaitPackBean() {
    }

    public ForfaitPack getfPack() {
        return fPack;
    }

    public void setfPack(ForfaitPack fPack) {
        this.fPack = fPack;
    }
    
}
