package ch.motoloc.gestion.services;

import ch.motoloc.gestion.persistence.dao.ReservationDAO;
import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.persistence.JpaConnection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author irina.fessemaz
 */
public class ReservationService {

    public static List<Reservation> getAllReservations() {
        return new ReservationDAO().findAll();
    }
    
    public static boolean sauverReservation (Reservation reservation){
        boolean success = false;
        EntityManager em = JpaConnection.getEntityManager();
                try {
             em.getTransaction().begin();
             em.persist(reservation);
             em.getTransaction().commit();
             
             success = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return success;     
    }
        
        
        
    
    
}
