/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lucas.hornisbe
 */

public class JpaConnection {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static EntityManager getEntityManager(){
        if(emf == null){
                emf = Persistence.createEntityManagerFactory("motolocPU");
            }
        if(em == null){
            em = emf.createEntityManager();
        }
        return em;
    }
}
