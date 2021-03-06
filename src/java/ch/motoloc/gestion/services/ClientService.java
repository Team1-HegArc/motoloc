package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.persistence.JpaConnection;
import ch.motoloc.gestion.persistence.dao.ClientDAO;
import java.util.List;
import javax.persistence.EntityManager;

public class ClientService {

    public static boolean sauverClient(Client client) {
        boolean success = false;
        EntityManager em = JpaConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            if (client.getId() != null) {
                Client clientMAJ = new ClientDAO().findById(client.getId());
                clientMAJ.setNom(client.getNom());
                clientMAJ.setPrenom(client.getPrenom());
                clientMAJ.setEmail(client.getEmail());
                clientMAJ.setVille(client.getVille());
                clientMAJ.setTelephone(client.getTelephone());
                clientMAJ.setRemarque(client.getRemarque());
                clientMAJ.setDateDeNaissance(client.getDateDeNaissance());
                clientMAJ.setRue(client.getRue());
                clientMAJ.setNpa(client.getNpa());
                clientMAJ.setNumeroPermis(client.getNumeroPermis());
                clientMAJ.setForfaits(client.getForfaits());
           } else {
                em.persist(client);
            }
            em.getTransaction().commit();
            success = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return success;
    }

    public static List<Client> getAllClients() {     
        return new ClientDAO().findAll();
    }

    public static boolean supprimerClient(Client client) {
        boolean success = false;
        EntityManager em = JpaConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(client);
            em.getTransaction().commit();
            success = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return success;

    }

    public static Client getClientId(Long id) {
        return new ClientDAO().findById(id);
    }

    public static List<Client> rechercherClient(String nom, String prenom, String email) {
        return new ClientDAO().findByFiltre(nom, prenom, email);

    }

}
