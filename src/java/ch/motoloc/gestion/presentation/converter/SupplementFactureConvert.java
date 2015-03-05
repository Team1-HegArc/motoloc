package ch.motoloc.gestion.presentation.converter;

import ch.motoloc.gestion.business.Paiement;
import ch.motoloc.gestion.business.Supplement;
import ch.motoloc.gestion.services.FactureService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Classe SupplementFactureConverter
 * @author irina.fessemaz
 */
@FacesConverter(forClass = SupplementFactureConvert.class, value="supplementFactureConverteur")
public class SupplementFactureConvert implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null){
            return null;
        }
        else{
            //On recupère un modele via son string
            Supplement supplement = FactureService.getSupplementById(Long.parseLong(value));
            return supplement;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return "";
        }
        //on retourne un string via son Object
        else if(value instanceof Supplement){
            return String.valueOf(((Supplement)value).getId());
        }
        else{
            return "";
        }
    }
}
