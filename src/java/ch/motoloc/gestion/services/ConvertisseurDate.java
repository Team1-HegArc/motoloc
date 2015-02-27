/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.motoloc.gestion.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lucas.hornisbe
 */
public class ConvertisseurDate {
    
        public static Date formatterDate(String dateString){
                  
    	SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
	try {
		Date date = formatter.parse(dateString);
                return date;
 
	} catch (ParseException e) {
		e.printStackTrace();
                return null;
	}
      
       }
        
        public static String displayDate(Date date){
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
             String dateString =null;
            
            try {
            dateString = formatter.format(date);
            
            } catch (Exception e) {
            }
            return dateString;
        }
}
