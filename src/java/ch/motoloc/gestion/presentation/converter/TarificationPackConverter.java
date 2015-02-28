/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.presentation.converter;


import ch.motoloc.gestion.business.TarificationPack;
import ch.motoloc.gestion.services.ForfaitService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author vincentrobatel
 */
@FacesConverter(forClass = ForfaitPackConverter.class, value="tarificationPackConverteur")
public class TarificationPackConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null){
            return null;
        }
        else{
            //On recupère un pack via son string
            TarificationPack tPack = ForfaitService.getTarificationPackById(Long.parseLong(value));
            return tPack;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return "";
        }
        //on retourne un string via son Object
        else if(value instanceof TarificationPack){
            return String.valueOf(((TarificationPack)value).getId());
        }
        else{
            return "";
        }
    }
}
