/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.FactureLigneSupplement;
import ch.motoloc.gestion.persistence.AbstractDAO;

/**
 *
 * @author vincentrobatel
 */
public class FactureLigneSupplementDAO extends AbstractDAO<FactureLigneSupplement>{

    public FactureLigneSupplementDAO() {
        super(FactureLigneSupplement.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT facLigS FROM FactureLigneSupplement facLigS";
    }
    
}
