/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.persistence.AbstractDAO;
import java.util.List;

/**
 *
 * @author vincentrobatel
 */
public class ReservationDAO extends AbstractDAO<Reservation>{

    public ReservationDAO() {
        super(Reservation.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT res FROM Reservation res";
    }
    
    public List<Moto> findAllMotoAvailable(Reservation reservation){
        
        String request =""
        
        return null;
        
        
        
    }
    
}
