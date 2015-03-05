package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.persistence.AbstractDAO;
import ch.motoloc.gestion.persistence.JpaConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

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
    
    public List<Reservation> findAllMotoDispo(Reservation reservation, Moto moto ){
        StringBuilder sb = new StringBuilder();
        
                  sb.append("SELECT res FROM Reservation res WHERE ?3 = res.moto.id ")
           .append("AND (?1 = res.dateDebut ")
           .append("OR ?2 = res.dateFin ")
           .append("OR ?1 BETWEEN res.dateDebut AND res.dateFin ")
           .append("OR ?2 BETWEEN res.dateDebut AND res.dateFin ")
           .append("OR (?1 < res.dateDebut AND ?2 > res.dateFin))")
           .append("AND (?1) >= CURRENT_DATE");
        
         EntityManager em = JpaConnection.getEntityManager();
         
        Query tp = em.createQuery(sb.toString())
                .setParameter(1,reservation.getDateDebut(), TemporalType.DATE)
                .setParameter(2,reservation.getDateFin(), TemporalType.DATE)
                .setParameter(3,moto.getId());
        
//          sb.append("SELECT res FROM Reservation res WHERE moto.id = reservation.moto.id ")
//           .append("AND TO_CHAR(reservation.dateDebut, 'DD.MM.YYYY') = TO_CHAR(res.dateDebut, 'DD.MM.YYYY')")
//           .append("AND TO_CHAR(reservation.dateFin, 'DD.MM.YYYY') = TO_CHAR(res.dateFin, 'DD.MM.YYYY')")
//           .append("AND TO_CHAR(reservation.dateDebut, 'DD.MM.YYYY') BETWEEN TO_CHAR(res.dateDebut, 'DD.MM.YYYY') AND TO_CHAR(res.dateFin, 'DD.MM.YYYY')")
//           .append("AND TO_CHAR(reservation.dateFin, 'DD.MM.YYYY') BETWEEN TO_CHAR(res.dateDebut, 'DD.MM.YYYY') AND TO_CHAR(res.dateFin, 'DD.MM.YYYY') ")
//           .append("AND TO_CHAR(reservation.dateDebut, 'DD.MM.YYYY') >= CURRENT_DATE").toString();
                 
        return new ArrayList(tp.getResultList());
        //return super.findByParameter(sb.toString(), reservation.getDateDebut(), reservation.getDateFin(), moto.getId());
  
    }
    
    public List<Reservation> findActive(Client client){
        String request = "SELECT res FROM Reservation res WHERE res.forfait.client = ?1 AND res.estAnnule = FALSE AND res.dateFin > CURRENT_DATE ORDER BY res.dateFin DESC ";
        TypedQuery<Reservation> query = JpaConnection.getEntityManager().createQuery(request, Reservation.class);
        query.setParameter(1, client);
        

        return query.getResultList();
    }
    
     public List<Reservation> getReservationByForfait(Forfait forfait) {
        String request = "SELECT res FROM Reservation res WHERE res.forfait = ?1";
        return super.findByParameter(request, forfait);
    }
    
    public static void nettoyerBase() {
        EntityManager em = JpaConnection.getEntityManager();
       em.createQuery("DELETE FROM Reservation r WHERE r.forfait IS NULL ").executeUpdate();
    }
}
