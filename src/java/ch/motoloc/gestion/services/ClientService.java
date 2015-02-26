/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.persistence.ClientDAO;
import ch.motoloc.gestion.persistence.JpaConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ClientService {

    private static List<Client> listClients = new ArrayList();

    public static boolean ajouterClient(String nom, String prenom, String rue, String npa,
            String ville, Date dateDeNaissance, String email, String telephone, String remarque, String numeroPermis) {
        try {
                Client client = new Client(nom, prenom, rue, npa, ville, dateDeNaissance, email, telephone, remarque, numeroPermis);
                listClients.add(client);
                JpaConnection.getEntityManager().getTransaction().begin();
                ClientDAO.create(client);
                JpaConnection.getEntityManager().getTransaction().commit();
                return true;
                
        } catch (Exception e) {
            return false;
        }

    }  
           
 
    public static void sauverClient(Long id, String nom, String prenom, String rue, String npa, 
            String ville, Date dateDeNaissance, String email, String telephone, String remarque, String numeroPermis){
        for (Client c : listClients) {
            if (c.getId().equals(id)) {
                c.setPrenom(prenom);
                c.setNom(nom);
                c.setRue(rue);
                c.setNpa(npa);
                c.setVille(ville);
                c.setDateDeNaissance(dateDeNaissance);
                c.setEmail(email);
                c.setTelephone(telephone);
                c.setRemarque(remarque);
                c.setNumeroPermis(numeroPermis);
            }
        }
    }



}
