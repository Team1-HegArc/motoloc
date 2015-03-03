/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.PackDuree;
import ch.motoloc.gestion.persistence.AbstractDAO;

/**
 *
 * @author vincentrobatel
 */
public class PackDureeDAO extends AbstractDAO<PackDuree>{

    public PackDureeDAO() {
        super(PackDuree.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT packD FROM PackDuree packD";
    }
    
}
