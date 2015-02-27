/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.services;

import ch.motoloc.gestion.persistence.ForfaitDAO;
import ch.motoloc.gestion.business.ForfaitPack;
import java.util.List;

/**
 *
 * @author bibien.limido
 */
public class ForfaitService {

    public static List<ForfaitPack> getAllForfaitPack() {
        return ForfaitDAO.findAllPack();
    }

    public static ForfaitPack getForfaitPackById(long id) {
        return ForfaitDAO.findPack(id);
    }
    
}
