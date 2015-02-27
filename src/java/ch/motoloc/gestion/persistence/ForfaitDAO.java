/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.persistence;

import ch.motoloc.gestion.business.ForfaitPack;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bibien.limido
 */
public class ForfaitDAO {
/*
retourne la liste des Packs   
*/
    public static List<ForfaitPack> findAllPack() {
        return new ArrayList<>();
    }
/*
retourne un pack par son id    
*/
    public static ForfaitPack findPack(long id) {
        return null;
    }
    
}
