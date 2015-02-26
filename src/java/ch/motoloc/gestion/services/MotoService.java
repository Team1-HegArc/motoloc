/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.persistence.MotoModeleDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas.hornisbe
 */
public class MotoService {
    

    
    private static List<Moto> listMotos = new ArrayList();
    private static List<MotoModele> listmodeles = new ArrayList();

    public static boolean ajouterMoto(String reference, MotoModele motomodele, String remarque) {
        try {
                Moto moto = new Moto(reference, motomodele, remarque);
                listMotos.add(moto);
                //JpaConnection.getEntityManager().getTransaction().begin();
                //ClientDAO.create(client);
                //JpaConnection.getEntityManager().getTransaction().commit();
                return true;
                
        } catch (Exception e) {
            return false;
        }

    }  
    
    public List<MotoModele> getAllMotoModele(){     
        return MotoModeleDAO.findAll();     
    }
    
        public MotoModele getAllMotoModelebyID(Long id){          
        return MotoModeleDAO.find(id);     
    }
    
    
    
 
    
//    public static void sauverClient(Long id, String nom, String prenom, String rue, String npa, 
//            String ville, Date dateDeNaissance, String email, String telephone, String remarque, String numeroPermis){
//        for (Client c : listClients) {
//            if (c.getId().equals(id)) {
//                c.setPrenom(prenom);
//                c.setNom(nom);
//                c.setRue(rue);
//                c.setNpa(npa);
//                c.setVille(ville);
//                c.setDateDeNaissance(dateDeNaissance);
//                c.setEmail(email);
//                c.setTelephone(telephone);
//                c.setRemarque(remarque);
//                c.setNumeroPermis(numeroPermis);
//            }
//        }
//    }
    


    
}
