/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.persistence.AbstractDAO;

/**
 *
 * @author vincentrobatel
 */
public class MotoDAO extends AbstractDAO<Moto>{

    public MotoDAO() {
        super(Moto.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT mot FROM Moto mot";
    }
    
}
