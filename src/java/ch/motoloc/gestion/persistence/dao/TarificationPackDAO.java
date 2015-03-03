/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.business.PackDuree;
import ch.motoloc.gestion.business.TarificationPack;
import ch.motoloc.gestion.persistence.AbstractDAO;
import ch.motoloc.gestion.persistence.JpaConnection;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author vincentrobatel
 */
public class TarificationPackDAO extends AbstractDAO<TarificationPack>{

    public TarificationPackDAO() {
        super(TarificationPack.class);
    }

    @Override
    protected String findAllStatement() {
        return "SELECT tarPack FROM TarificationPack tarPack";
    }

    public List<MotoModele> findAllMotoModel() {
        String request = "SELECT DISTINCT tarPack.motoMod FROM TarificationPack tarPack ORDER BY tarPack.motoMod.id";
        TypedQuery<MotoModele> query = JpaConnection.getEntityManager().createQuery(request, MotoModele.class);
        return new ArrayList(query.getResultList());
    }
    
    public List<TarificationPack> findByAjout(PackDuree packDuree, MotoModele motoModele){
        String request = "SELECT tarPack FROM TarificationPack tarPack WHERE tarPack.packDuree=?1 AND tarPack.motoMod=?2";
        return super.findByParameter(request, packDuree, motoModele);
    }
}
