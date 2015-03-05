/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.presentation.beans;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.persistence.dao.ForfaitFlexibleDAO;
import ch.motoloc.gestion.persistence.dao.ForfaitPackDAO;
import ch.motoloc.gestion.persistence.dao.ReservationDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author lucas.hornisbe
 */
@ManagedBean(name = "managerListBean")
@SessionScoped
public class ManagerListBean {

    
    
    public ManagerListBean() {
    }
    
    public  List<ForfaitFlexible> getForfaitFlex(Client client){
        return new ForfaitFlexibleDAO().getForfaitByClient(client);
    }
    
    public  List<ForfaitPack> getForfaitPack(Client client){
        return new ForfaitPackDAO().getForfaitByClient(client);
    }

public  List<Reservation> getReservation(Forfait forfait){
        return new ReservationDAO().getReservationByForfait(forfait);
    }
}
