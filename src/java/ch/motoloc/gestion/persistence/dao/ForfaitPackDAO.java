/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.persistence.AbstractDAO;

/**
 *
 * @author vincentrobatel
 */
public class ForfaitPackDAO extends AbstractDAO<ForfaitPack>{

    public ForfaitPackDAO() {
        super(ForfaitPack.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT forPac FROM ForfaitPack forPac";
    }
    
}
