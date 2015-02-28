/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.Forfait;
import ch.motoloc.gestion.persistence.AbstractDAO;

/**
 *
 * @author vincentrobatel
 */
public class ForfaitDAO extends AbstractDAO<Forfait>{

    public ForfaitDAO() {
        super(Forfait.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT forf FROM Forfait forf";
    }
    
}
