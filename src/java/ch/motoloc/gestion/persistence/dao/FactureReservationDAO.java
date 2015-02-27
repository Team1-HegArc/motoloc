/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.FactureReservation;
import ch.motoloc.gestion.persistence.AbstractDAO;

/**
 *
 * @author vincentrobatel
 */
public class FactureReservationDAO extends AbstractDAO<FactureReservation>{

    public FactureReservationDAO() {
        super(FactureReservation.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT factR FROM FactureReservation factR";
    }
    
}
