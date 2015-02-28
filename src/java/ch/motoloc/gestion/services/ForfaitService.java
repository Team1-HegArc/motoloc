/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.business.TarificationPack;
import ch.motoloc.gestion.persistence.dao.ForfaitFlexibleDAO;
import ch.motoloc.gestion.persistence.dao.ForfaitPackDAO;
import ch.motoloc.gestion.persistence.dao.TarificationPackDAO;
import java.util.List;

/**
 *
 * @author bibien.limido
 */
public class ForfaitService {

    public static List<ForfaitPack> getAllForfaitPack() {
        return new ForfaitPackDAO().findAll();
    }

    public static ForfaitPack getForfaitPackById(long id) {
        return new ForfaitPackDAO().findById(id);
    }
    
    public static List<ForfaitFlexible> getAllForfaitFlexible() {
        return new ForfaitFlexibleDAO().findAll();
    }

    public static ForfaitFlexible getForfaitFLexibleById(long id) {
        return new ForfaitFlexibleDAO().findById(id);
    }
    
    public static List<TarificationPack> getAllTarifiactionPack() {
        return new TarificationPackDAO().findAll();
    }

    public static TarificationPack getTarificationPackById(long id) {
        return new TarificationPackDAO().findById(id);
    }
}
