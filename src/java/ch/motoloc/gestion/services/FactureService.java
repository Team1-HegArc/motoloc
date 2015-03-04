
package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.FactureForfait;
import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.persistence.JpaConnection;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * 
 * @author irina.fessemaz
 */
public class FactureService {
    
    public static Double getTotalFactureForfait(ForfaitFlexible forfaitFlexible){
        int nbJours = forfaitFlexible.getNbJour();
        return nbJours * (forfaitFlexible.getTarificationFlexible().getPrix_jour() - nbJours * forfaitFlexible.getTarificationFlexible().getPrix_degression());
    }
    
    public static Double getTotalFactureForfait(ForfaitPack forfaitPack){
        return forfaitPack.getTarificationPack().getPrix_base();
    }
    

    public static boolean sauverFactureForfait(FactureForfait factureForfait) {
        boolean success = false;
        EntityManager em = JpaConnection.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
             et.begin();
             em.persist(factureForfait);
             et.commit();
             success = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return success;     
    }
}
