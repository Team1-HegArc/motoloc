/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.persistence.AbstractDAO;
import java.util.List;

/**
 *
 * @author vincentrobatel
 */
public class ClientDAO extends AbstractDAO<Client>{

    
    public ClientDAO() {
        super(Client.class);
    }
    
    public List<Client> findByFiltre(final String nom, final String prenom, final String email){
        String request = "SELECT cli FROM Client cli WHERE cli.nom LIKE ?1 AND cli.prenom LIKE ?2 AND cli.email LIKE ?3";
        return super.findByParameter(request, nom, prenom, email);
    }
                

    @Override
    protected String findAllStatement() {
        return "SELECT cli FROM Client cli";
    }

}
