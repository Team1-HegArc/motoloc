package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.Facture;
import ch.motoloc.gestion.business.FactureForfait;
import ch.motoloc.gestion.business.FactureLignePaiement;
import ch.motoloc.gestion.business.FactureLigneSupplement;
import ch.motoloc.gestion.business.FactureReservation;
import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.business.Paiement;
import ch.motoloc.gestion.business.Supplement;
import ch.motoloc.gestion.persistence.JpaConnection;
import ch.motoloc.gestion.persistence.dao.ClientDAO;
import ch.motoloc.gestion.persistence.dao.PaiementDAO;
import ch.motoloc.gestion.persistence.dao.SupplementDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Classe FactureService
 *
 * @author irina.fessemaz
 */
public class FactureService {

    public static Double getTotalFactureForfait(ForfaitFlexible forfaitFlexible) {
        int nbJours = forfaitFlexible.getNbJour();
        return nbJours * (forfaitFlexible.getTarificationFlexible().getPrix_jour() - nbJours * forfaitFlexible.getTarificationFlexible().getPrix_degression());
    }

    public static Double getTotalFactureForfait(ForfaitPack forfaitPack) {
        return forfaitPack.getTarificationPack().getPrix_base();
    }

    public static Client getClientFactureForfait(Facture facture) {
        Client client = (new ClientDAO().findByFactureForfait(facture)).iterator().next();
        return client;
    }

    public static Client getClientFactureReservation(Facture facture) {
        Client client = (new ClientDAO().findByFactureReservation(facture)).iterator().next();
        return client;
    }

    public static Paiement getPaiementById(Long id) {
        Paiement paiement = new PaiementDAO().findById(id);
        return paiement;
    }

    public static List<Paiement> getAllPaiements() {
        return new PaiementDAO().findAll();
    }

    public static Supplement getSupplementById(Long id) {
        Supplement supplement = new SupplementDAO().findById(id);
        return supplement;
    }

    public static List<Supplement> getAllSupplements() {
        return new SupplementDAO().findAll();
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

    public static boolean sauverFactureReservation(FactureReservation factureReservation) {
        boolean success = false;
        EntityManager em = JpaConnection.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(factureReservation);
            et.commit();
            success = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return success;
    }

    public static boolean sauverFactureLigneSupplement(FactureLigneSupplement factureLigneSupplement) {
        boolean success = false;
        EntityManager em = JpaConnection.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(factureLigneSupplement);
            et.commit();
            success = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return success;
    }
    
        public static boolean sauverFactureLignePaiement(FactureLignePaiement factureLignePaiement) {
        boolean success = false;
        EntityManager em = JpaConnection.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(factureLignePaiement);
            et.commit();
            success = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return success;
    }
}
