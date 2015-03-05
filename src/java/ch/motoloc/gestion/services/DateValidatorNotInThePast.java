/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.services;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
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
@FacesValidator("dateValidatorNotInThePast")
public class DateValidatorNotInThePast implements Validator {
  
  
      @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        UIInput sd = (UIInput)component.getAttributes().get("firstDate");
        Date firstDate = (Date)sd.getValue();
        Date secondDate = new Date();
        if(!firstDate.before(secondDate)){
            FacesMessage msg = new FacesMessage("La date est antérieur à la date du jour !");
            throw new ValidatorException(msg);
        }
    }
}
