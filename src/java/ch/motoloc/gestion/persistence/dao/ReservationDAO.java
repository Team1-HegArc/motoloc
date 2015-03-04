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
    
    public List<Reservation> findAllMotoAvailable(Reservation reservation, Moto moto ){
        StringBuilder sb = new StringBuilder();
        
                  sb.append("SELECT res FROM Reservation res WHERE (?3) = res.moto.id ")
           .append("AND TO_CHAR((?1), 'DD.MM.YYYY') = TO_CHAR(res.dateDebut, 'DD.MM.YYYY')")
           .append("AND TO_CHAR((?2), 'DD.MM.YYYY') = TO_CHAR(res.dateFin, 'DD.MM.YYYY')")
           .append("AND TO_CHAR((?1), 'DD.MM.YYYY') BETWEEN TO_CHAR(res.dateDebut, 'DD.MM.YYYY') AND TO_CHAR(res.dateFin, 'DD.MM.YYYY')")
           .append("AND TO_CHAR((?2), 'DD.MM.YYYY') BETWEEN TO_CHAR(res.dateDebut, 'DD.MM.YYYY') AND TO_CHAR(res.dateFin, 'DD.MM.YYYY') ")
           .append("AND TO_CHAR((?1), 'DD.MM.YYYY') >= CURRENT_DATE").toString();
        
        
        
//          sb.append("SELECT res FROM Reservation res WHERE moto.id = reservation.moto.id ")
//           .append("AND TO_CHAR(reservation.dateDebut, 'DD.MM.YYYY') = TO_CHAR(res.dateDebut, 'DD.MM.YYYY')")
//           .append("AND TO_CHAR(reservation.dateFin, 'DD.MM.YYYY') = TO_CHAR(res.dateFin, 'DD.MM.YYYY')")
//           .append("AND TO_CHAR(reservation.dateDebut, 'DD.MM.YYYY') BETWEEN TO_CHAR(res.dateDebut, 'DD.MM.YYYY') AND TO_CHAR(res.dateFin, 'DD.MM.YYYY')")
//           .append("AND TO_CHAR(reservation.dateFin, 'DD.MM.YYYY') BETWEEN TO_CHAR(res.dateDebut, 'DD.MM.YYYY') AND TO_CHAR(res.dateFin, 'DD.MM.YYYY') ")
//           .append("AND TO_CHAR(reservation.dateDebut, 'DD.MM.YYYY') >= CURRENT_DATE").toString();
                 
        
        return super.findByParameter(sb.toString(), reservation.getDateDebut(), reservation.getDateFin(), moto.getId());
        
        
        
    }
    
}
