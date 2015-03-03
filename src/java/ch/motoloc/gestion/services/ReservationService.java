package ch.motoloc.gestion.services;

import ch.motoloc.gestion.persistence.dao.ReservationDAO;
import ch.motoloc.gestion.business.Reservation;
import java.util.List;

/**
 *
 * @author irina.fessemaz
 */
public class ReservationService {

    public static List<Reservation> getAllReservations() {
        return new ReservationDAO().findAll();
    }
    
}
