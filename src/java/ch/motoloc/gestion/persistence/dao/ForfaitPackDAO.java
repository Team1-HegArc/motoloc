/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.persistence.AbstractDAO;
import ch.motoloc.gestion.persistence.JpaConnection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author vincentrobatel
 */
public class ForfaitPackDAO extends AbstractDAO<ForfaitPack>{

    

    public ForfaitPackDAO() {
        super(ForfaitPack.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT forPac FROM ForfaitPack forPac";
    }
    
    public List<ForfaitPack> getForfaitByClient(Client client) {
        String request = "SELECT forPac FROM ForfaitPack forPac WHERE forPac.client = ?1";
        return super.findByParameter(request, client);
    }
    
    public static void nettoyerBase() {
        EntityManager em = JpaConnection.getEntityManager();
       em.createQuery("DELETE FROM Forfait f WHERE f.facture IS NULL ").executeUpdate();
    }
    
}
