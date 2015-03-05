/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.business.PackDuree;
import ch.motoloc.gestion.business.Reservation;
import ch.motoloc.gestion.business.TarificationFlexible;
import ch.motoloc.gestion.business.TarificationPack;
import ch.motoloc.gestion.persistence.JpaConnection;
import ch.motoloc.gestion.persistence.dao.ForfaitFlexibleDAO;
import ch.motoloc.gestion.persistence.dao.ForfaitPackDAO;
import ch.motoloc.gestion.persistence.dao.PackDureeDAO;
import ch.motoloc.gestion.persistence.dao.TarificationFlexibleDAO;
import ch.motoloc.gestion.persistence.dao.TarificationPackDAO;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author bibien.limido
 */
public class ForfaitService {

    public static List<ForfaitPack> getAllForfaitPack() {
        return new ForfaitPackDAO().findAll();
    }

    public static ForfaitPack getForfaitPackById(long id) {
        return new ForfaitPackDAO().findById(id);
    }
    
    public static List<ForfaitFlexible> getAllForfaitFlexible() {
        return new ForfaitFlexibleDAO().findAll();
    }

    public static ForfaitFlexible getForfaitFLexibleById(long id) {
        return new ForfaitFlexibleDAO().findById(id);
    }
    
    public static List<TarificationPack> getAllTarifiactionPack() {
        return new TarificationPackDAO().findAll();
    }

    public static TarificationPack getTarificationPackById(long id) {
        return new TarificationPackDAO().findById(id);
    }
    
    public static List<TarificationFlexible> getAllTarifiactionFlex() {
        return new TarificationFlexibleDAO().findAll();
    }

    public static TarificationFlexible getTarificationFlexById(long id) {
        return new TarificationFlexibleDAO().findById(id);
    }
    
    public static PackDuree getPackDureeById (long id){
        return new PackDureeDAO().findById(id);
    }
    
    public static List<PackDuree> getAllPackDuree(){
        return new PackDureeDAO().findAll();
    }

    public static List<MotoModele> getAllModelesPacks() {
        return new TarificationPackDAO().findAllMotoModel();
    }

    public static TarificationPack getForfaitPackByAjout(PackDuree duree, MotoModele modele) {
        List<TarificationPack> listeTarif = new TarificationPackDAO().findByAjout(duree, modele);
        TarificationPack tarif = null;
        if(listeTarif.size() == 1) {
            tarif = listeTarif.get(0);
        }
        return tarif;
    }
    public static boolean sauverForfait(Forfait forfait) {
        boolean success = false;
        EntityManager em = JpaConnection.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
             et.begin();
             em.persist(forfait);
             et.commit();
             success = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return success;     
    }
    
    public static int nbJourRestant(ForfaitFlexible forfait){
        int nbJour=forfait.getNbJour();
        for (Reservation res : forfait.getReservations()) {
            if(res.getId()!=null){
            nbJour = nbJour - (int) ((res.getDateFin().getTime()-res.getDateDebut().getTime())/ (1000*60*60*24));
            }
        }
        return nbJour;
    }
    
    public static int nbJourRestant(ForfaitPack forfait){
        int nbJour=forfait.getTarificationPack().getPackDuree().getNbJours();
        for (Reservation res : forfait.getReservations()) {
            if(res.getId()!=null){
                nbJour = nbJour - (int) ((res.getDateFin().getTime()-res.getDateDebut().getTime())/ (1000*60*60*24));
            }
        }
        return nbJour;
    }

    public static void annulerForfaitPack(ForfaitPack forfaitPack) {
       EntityManager em = JpaConnection.getEntityManager();
        
            em.getTransaction().begin();
            em.remove(forfaitPack);
            ForfaitPackDAO.nettoyerBase();
            em.getTransaction().commit();
        
    }
    public static void annulerForfaitFlexible(ForfaitFlexible forfaitFlexible) {
       EntityManager em = JpaConnection.getEntityManager();
        
            em.getTransaction().begin();
            em.remove(forfaitFlexible);
            ForfaitPackDAO.nettoyerBase();
            em.getTransaction().commit();
        
    }
}
