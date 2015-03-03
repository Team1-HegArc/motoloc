/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.persistence.AbstractDAO;

/**
 *
 * @author vincentrobatel
 */
public class MotoModeleDAO extends AbstractDAO<MotoModele>{

    public MotoModeleDAO() {
        super(MotoModele.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT motMod FROM MotoModele motMod";
    }
    
}
