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
        if(!firstDate.before(secondDate)){
            FacesMessage msg = new FacesMessage("Entered dates are invalid: first date must be before second date");
            throw new ValidatorException(msg);
        }
    }
    

}