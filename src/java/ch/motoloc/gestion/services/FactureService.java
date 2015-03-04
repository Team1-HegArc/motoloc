
package ch.motoloc.gestion.services;

import ch.motoloc.gestion.business.ForfaitFlexible;
import ch.motoloc.gestion.business.ForfaitPack;

/**
 * 
 * @author irina.fessemaz
 */
public class FactureService {
    
    public static Double getTotalFactureForfait(ForfaitFlexible forfaitFlexible){
        int nbJours = forfaitFlexible.getNbJour();
        return nbJours * (forfaitFlexible.getTarificationFlexible().getPrix_jour() - nbJours * forfaitFlexible.getTarificationFlexible().getPrix_degression());
    }
    
    public static Double getTotalFactureForfait(ForfaitPack forfaitPack){
        return forfaitPack.getTarificationPack().getPrix_base();
    }

    public static void sauverFactureForfait(ForfaitFlexible forfaitFlexible) {
        
    }
}
