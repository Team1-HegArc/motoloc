/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.persistence;

import ch.motoloc.gestion.business.Client;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas.hornisbe
 */
public class ClientDAO {
        
        public static void create(Client client) {
        JpaConnection.getEntityManager().persist(client);
    }
        
       public static List<Client> findAll(){ 
        return new ArrayList<Client>();
    
} 
    
}
