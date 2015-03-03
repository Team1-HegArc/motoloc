/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.persistence.JpaConnection;
import ch.motoloc.gestion.persistence.MotoModeleDAO;
import ch.motoloc.gestion.persistence.dao.MotoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author lucas.hornisbe
 */
public class MotoService {

    private static List<Moto> listeMotos = new ArrayList();
    private static List<MotoModele> listeModeles = new ArrayList();

    public static List<MotoModele> getAllMotoModele() {
        return MotoModeleDAO.findAll();
    }

    public static MotoModele getMotoModeleById(Long id) {
        return MotoModeleDAO.find(id);
    }

    public static boolean sauverMoto(Moto moto) {
        boolean success = false;
        EntityManager em = JpaConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            if (moto.getId() != null) {
                Moto motoMAJ = new MotoDAO().findById(moto.getId());
                motoMAJ.setReference(moto.getReference());
                motoMAJ.setRemarque(moto.getRemarque());
                motoMAJ.setMotoModele(moto.getMotoModele());
            } else {
                em.persist(moto);
            }
            em.getTransaction().commit();
            success = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return success;
    }
}
