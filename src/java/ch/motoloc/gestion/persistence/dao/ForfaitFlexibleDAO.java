/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.persistence.AbstractDAO;

/**
 *
 * @author vincentrobatel
 */
public class ForfaitFlexibleDAO extends AbstractDAO<ForfaitFlexible>{

    public ForfaitFlexibleDAO() {
        super(ForfaitFlexible.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT forFle FROM ForfaitFlexible forFle";
    }
    
}
