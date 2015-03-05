package ch.motoloc.gestion.presentation.converter;

import ch.motoloc.gestion.business.Paiement;
import ch.motoloc.gestion.services.FactureService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Classe PaiementConverter
 * @author irina.fessemaz
 */
@FacesConverter(forClass = PaiementConverter.class, value="paiementConverteur")
public class PaiementConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null){
            return null;
        }
        else{
            //On recupère un modele via son string
            Paiement paiement = FactureService.getPaiementById(Long.parseLong(value));
            return paiement;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return "";
        }
        //on retourne un string via son Object
        else if(value instanceof Paiement){
            return String.valueOf(((Paiement)value).getId());
        }
        else{
            return "";
        }
    }
}
