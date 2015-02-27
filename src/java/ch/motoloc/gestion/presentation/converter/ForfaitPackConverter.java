/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.presentation.converter;

import ch.motoloc.gestion.business.ForfaitPack;
import ch.motoloc.gestion.business.MotoModele;
import ch.motoloc.gestion.services.ForfaitService;
import ch.motoloc.gestion.services.MotoService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cyril.briguet
 */
@FacesConverter(forClass = ForfaitPackConverter.class, value="forfaitPackConverteur")
public class ForfaitPackConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null){
            return null;
        }
        else{
            //On recupère un modele via son string
            ForfaitPack fPack = ForfaitService.getForfaitPackById(Long.parseLong(value));
            return fPack;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return "";
        }
        //on retourne un string via son Object
        else if(value instanceof MotoModele){
            return String.valueOf(((MotoModele)value).getId());
        }
        else{
            return "";
        }
    }
}
