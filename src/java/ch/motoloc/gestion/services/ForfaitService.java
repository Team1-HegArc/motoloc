/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.business.PackDuree;
import ch.motoloc.gestion.business.TarificationFlexible;
import ch.motoloc.gestion.business.TarificationPack;
import ch.motoloc.gestion.persistence.dao.ForfaitFlexibleDAO;
import ch.motoloc.gestion.persistence.dao.ForfaitPackDAO;
import ch.motoloc.gestion.persistence.dao.PackDureeDAO;
import ch.motoloc.gestion.persistence.dao.TarificationFlexibleDAO;
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
    
    public static List<TarificationFlexible> getAllTarifiactionFlex() {
        return new TarificationFlexibleDAO().findAll();
    }

    public static TarificationFlexible getTarificationFlexById(long id) {
        return new TarificationFlexibleDAO().findById(id);
    }
    
    public static PackDuree getPackDureeById (long id){
        return new PackDureeDAO().findById(id);
    }
    
    public static List<PackDuree> getAllPackDuree(){
        return new PackDureeDAO().findAll();
    }

    public static List<MotoModele> getAllModelesPacks() {
        return new TarificationPackDAO().findAllMotoModel();
    }

    public static TarificationPack getForfaitPackByAjout(PackDuree duree, MotoModele modele) {
        List<TarificationPack> listeTarif = new TarificationPackDAO().findByAjout(duree, modele);
        TarificationPack tarif = null;
        if(listeTarif.size() == 1) {
            tarif = listeTarif.get(0);
        }
        return tarif;
    }

    public static void sauverForfaitPack(ForfaitPack fPack) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
