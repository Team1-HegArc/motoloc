/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.persistence.dao.ForfaitFlexibleDAO;
import ch.motoloc.gestion.persistence.dao.ForfaitPackDAO;
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
    
}
