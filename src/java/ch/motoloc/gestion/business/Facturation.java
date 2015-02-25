package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Facturation
 * @author irina.fessemaz
 */

public class Facturation implements Serializable {
    
    private Long id;
    private Supplement supplement;
    private Double prix;

}
