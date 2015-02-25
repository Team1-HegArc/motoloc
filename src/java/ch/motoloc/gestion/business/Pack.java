package ch.motoloc.gestion.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * Classe Pack
 * @author irina.fessemaz
 */

@Entity
@Table(name="RENTAL_PACK")
public class Pack extends Forfait {
    
    @OneToOne
    @JoinColumn(name="FK_PACK", unique=true)
    private TarificationPack tarificationPack; 

}
