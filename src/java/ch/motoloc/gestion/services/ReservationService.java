package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.persistence.dao.ReservationDAO;
import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.business.Supplement;
import ch.motoloc.gestion.persistence.JpaConnection;
import ch.motoloc.gestion.persistence.dao.MotoDAO;
import ch.motoloc.gestion.persistence.dao.SupplementDAO;
import java.util.ArrayList;
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

    public static Long rechercheMotoModele(Reservation reservation) {

        MotoModele modele = null;

        if (reservation.getForfait() instanceof ForfaitPack) {
            modele = ((ForfaitPack) reservation.getForfait()).getTarificationPack().getMotoMod();
        }
        if (reservation.getForfait() instanceof ForfaitFlexible) {
            modele = ((ForfaitFlexible) reservation.getForfait()).getTarificationFlexible().getMotoModl();
        }
        return modele.getId();

    }

    public static List<Moto> rechercherDispoMoto(Reservation reservation) {
        List<Moto> listMotosTest = new ArrayList();
        List<Moto> listMotosDispo = new ArrayList();

        listMotosTest = new MotoDAO().findByFiltre(rechercheMotoModele(reservation));

        for (Moto moto : listMotosTest) {
            if (new ReservationDAO().findAllMotoDispo(reservation, moto).isEmpty()) {
                listMotosDispo.add(moto);

            }

        }
        return listMotosDispo;
    }

    public static boolean sauverReservation(Reservation reservation) {
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
    
        public static List<Supplement> getAllSupplementsDebut() {
        return new SupplementDAO().findDebut();
    }
        
                public static List<Supplement> getAllSupplementsFin() {
        return new SupplementDAO().findFin();
    }

}
