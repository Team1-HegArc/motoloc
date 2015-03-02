/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.Paiement;
import ch.motoloc.gestion.persistence.AbstractDAO;

/**
 *
 * @author vincentrobatel
 */
public class PaiementDAO extends AbstractDAO<Paiement>{

    public PaiementDAO() {
        super(Paiement.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT pai FROM Paiement pai";
    }
    
}
