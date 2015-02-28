/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.FactureForfait;
import ch.motoloc.gestion.persistence.AbstractDAO;
import java.util.List;

/**
 *
 * @author vincentrobatel
 */
public class FactureForfaitDAO extends AbstractDAO<FactureForfait>{

    public FactureForfaitDAO() {
        super(FactureForfait.class);
    }
    
    @Override
    protected String findAllStatement() {
        return "SELECT factF FROM FactureForfait factF";
    }
    
}
