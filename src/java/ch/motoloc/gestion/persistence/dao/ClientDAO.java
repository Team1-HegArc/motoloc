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

    private static ClientDAO instance;
    
    private ClientDAO() {
        super(Client.class);
    }
    
    public static ClientDAO getInstance(){
        if(instance==null){
            instance = new ClientDAO();
        }
        return instance;
    }
    
    
    @Override
    protected String findByParameterStatement(String... argument) {
        String s = "SELECT cli FROM Client cli WHERE cli.nom LIKE %:nom% AND cli.prenom LIKE %:prenom% AND cli.email LIKE %:email%";
        return s;}
                

    @Override
    protected String findAllStatement() {
        return "SELECT cli FROM Client cli";
    }

}
