/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.Supplement;
import ch.motoloc.gestion.persistence.AbstractDAO;

/**
 *
 * @author vincentrobatel
 */
public class SupplementDAO extends AbstractDAO<Supplement>{

    public SupplementDAO() {
        super(Supplement.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT sup FROM Supplement sup";
    }
    
}
