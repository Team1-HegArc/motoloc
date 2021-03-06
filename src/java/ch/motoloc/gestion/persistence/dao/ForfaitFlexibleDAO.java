/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.persistence.AbstractDAO;
import ch.motoloc.gestion.persistence.JpaConnection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author vincentrobatel
 */
public class ForfaitFlexibleDAO extends AbstractDAO<ForfaitFlexible>{

    public ForfaitFlexibleDAO() {
        super(ForfaitFlexible.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT forFle FROM ForfaitFlexible forFle";
    }

    public List<ForfaitFlexible> getForfaitByClient(Client client) {
        String request = "SELECT forFle FROM ForfaitFlexible forFle WHERE forFle.client = ?1";
        return super.findByParameter(request, client);
    }
    
    public static void nettoyerBase() {
        EntityManager em = JpaConnection.getEntityManager();
       em.createQuery("DELETE FROM Forfait f WHERE f.facture IS NULL ").executeUpdate();
    }
    
}
