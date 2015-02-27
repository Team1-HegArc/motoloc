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

    @Override
    protected String findByParameterStatement(String... argument) {
        String s = "SELECT cli FROM Client cli WHERE cli.nom LIKE %:nom% AND cli.prenom LIKE %:prenom% AND cli.email LIKE %:email%";
        return s;}
                

    @Override
    protected String findAllStatement() {
        return "SELECT cli FROM Client cli";
    }

}
