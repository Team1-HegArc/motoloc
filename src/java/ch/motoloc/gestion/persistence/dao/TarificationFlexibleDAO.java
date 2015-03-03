/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.TarificationFlexible;
import ch.motoloc.gestion.persistence.AbstractDAO;

/**
 *
 * @author vincentrobatel
 */
public class TarificationFlexibleDAO extends AbstractDAO<TarificationFlexible>{

    public TarificationFlexibleDAO() {
        super(TarificationFlexible.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT tarifFlex FROM TarificationFlexible tarifFlex";
    }
    
}
