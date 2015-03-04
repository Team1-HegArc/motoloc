/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.Moto;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.persistence.AbstractDAO;
import java.util.List;

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

    
    public List<Moto> findByFiltre(MotoModele motoModele, String numeroChassis) {
        String request = "SELECT mot FROM Moto mot WHERE LOWER(mot.motoModele.libelle) LIKE LOWER (?1) AND LOWER(mot.reference) LIKE LOWER(?2)";
        return super.findByParameter(request, motoModele.getLibelle(), numeroChassis);
    }
    
      public List<Moto> findByFiltre(Long motoModeleID) {
        String request = "SELECT mot FROM Moto mot WHERE(mot.motoModele.id) LIKE (?1)";
        return super.findByParameter(request, motoModeleID);
    }
    
    
}
