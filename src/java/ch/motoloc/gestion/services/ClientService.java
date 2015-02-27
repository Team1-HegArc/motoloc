package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.persistence.ClientDAO;
import ch.motoloc.gestion.persistence.JpaConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientService {

    private static List<Client> listClients = new ArrayList();

    public static boolean ajouterClient(Client client) {
        try {

            listClients.add(client);
//                JpaConnection.getEntityManager().getTransaction().begin();
//                ClientDAO.create(client);
//                JpaConnection.getEntityManager().getTransaction().commit();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean sauverClient(Client client) {
        boolean success = false;
        try {

            if (client.getId() != null) {

                for (Client c : listClients) {
                    if (c.getId().equals(client.getId())) {
                        c = client;
                        success = true;
                    }
                }
            } else {
                listClients.add(client);
                success = true;
            }

        } catch (Exception e) {
        }
        return success;
    }


    public static List<Client> getAllClients() {
        /*
         ajoute en dur pour test
         */

        listClients.add(new Client("bibien", "bibien", "bibien", "bibien", "bibien", null, "dsa@sd.com", "0798976767", null, null));
        listClients.add(new Client("bibien", "bibien", "bibien", "bibien", "bibien", null, "dsa@sd.com", "0798976767", null, null));

//return ClientDAO.findAll();     
        return listClients;
    }

    public static boolean supprimerClient(Client client) {
        boolean success = false;

        try {
            for (int i = 0; i < listClients.size(); i++) {
                if (listClients.get(i).getId().equals(client.getId())) {
                    listClients.remove(i);
                    success = true;
                }
            }
//                JpaConnection.getEntityManager().getTransaction().begin();
//                ClientDAO.create(client);
//                JpaConnection.getEntityManager().getTransaction().commit();
            return success;
        } catch (Exception e) {
            return success;
        }

    }

    public static Client getClientId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Client rechercherClient(String prenom, String nom, String email) {
        Client cli = new Client();
        cli.setPrenom(prenom);
        cli.setNom(nom);
        cli.setEmail(email);
        return cli;

    }

}

