/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.FactureForfait;
import ch.motoloc.gestion.persistence.JpaConnection;
import javax.persistence.EntityManager;

/**
 *
 * @author vincentrobatel
 */
public class FactureService {

    public static boolean sauverFacture(FactureForfait factureForfait) {
        boolean success = false;
        EntityManager em = JpaConnection.getEntityManager();
        try {
            System.out.println(factureForfait);
            /*em.getTransaction().begin();
            em.persist(factureForfait);
            em.getTransaction().commit();*/
            success = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return success;
    }
    
}
