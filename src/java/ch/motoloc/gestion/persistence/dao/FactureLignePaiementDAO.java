/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.FactureLignePaiement;
import ch.motoloc.gestion.persistence.AbstractDAO;

/**
 *
 * @author vincentrobatel
 */
public class FactureLignePaiementDAO extends AbstractDAO<FactureLignePaiement>{

    public FactureLignePaiementDAO() {
        super(FactureLignePaiement.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT facLigP FROM FactureLignePaiement facLigP";
    }
    
}
