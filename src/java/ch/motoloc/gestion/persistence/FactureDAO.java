/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence;

import ch.motoloc.gestion.business.Facture;

/**
 *
 * @author vincentrobatel
 */
public class FactureDAO extends AbstractDAO<Facture>{

    public FactureDAO() {
        super(Facture.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT fact FROM Facture fact";
    }
    
}
