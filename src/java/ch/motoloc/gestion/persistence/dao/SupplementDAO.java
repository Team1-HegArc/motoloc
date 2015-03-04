/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import static ch.motoloc.gestion.business.FactureLigneSupplement_.supplement;
import ch.motoloc.gestion.business.Supplement;
import ch.motoloc.gestion.persistence.AbstractDAO;
import java.util.List;

/**
 *
 * @author vincentrobatel
 */
public class SupplementDAO extends AbstractDAO<Supplement> {

    public SupplementDAO() {
        super(Supplement.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT sup FROM Supplement sup";
    }

    public List<Supplement> findDebut() {
        String request = "SELECT sup from Supplement sup WHERE sup.estExtra is true";
        return super.findByParameter(request);
    }

    public List<Supplement> findFin() {
        String request = "SELECT sup from Supplement sup WHERE sup.estExtra is false";
        return super.findByParameter(request);

    }

}
