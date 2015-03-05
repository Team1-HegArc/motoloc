/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.services;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author lucas.hornisbe
 */
@FacesValidator(value="dateValidatorSmaller")
public class DateValidatorSmaller implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        UIInput sd = (UIInput)component.getAttributes().get("firstDate");
        Date firstDate = (Date)sd.getValue();
        
        Date secondDate = (Date)value;
        Date jourDate = new Date();
        if(!firstDate.before(secondDate)){
            FacesMessage msg = new FacesMessage("Dates non-valides : la date de début doit être inférieur à la date de fin");
            throw new ValidatorException(msg);
        }
        
        if(firstDate.before(jourDate)){
            FacesMessage msg = new FacesMessage("La date de début doit être supérieur à la date du jour");
            throw new ValidatorException(msg);
        }
    }
    

}