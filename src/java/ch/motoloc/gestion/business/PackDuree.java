package ch.motoloc.gestion.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Classe PackDuree
 *
 * @author irina.fessemaz
 */
@Entity
@Table(
        name = "GM_PACK_DURATION",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "UK_PACK_DURATION",
                    columnNames = {"NB_DAYS", "NB_WEEKENDS"})})
public class PackDuree {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PADU")
    @SequenceGenerator(name = "SEQ_PADU", sequenceName = "SEQ_PACK_DURATION", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_PACK_DURATION")
    private Long id;

    @Column(name = "NB_DAYS", nullable = false)
    private int nbJours;

    @Column(name = "NB_WEEKENDS", nullable = false)
    private int nbWeekends;

    public PackDuree() {
    }

    public PackDuree(Long id, int nbJours, int nbWeekends) {
        this.id = id;
        this.nbJours = nbJours;
        this.nbWeekends = nbWeekends;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbJours() {
        return nbJours;
    }

    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    public int getNbWeekends() {
        return nbWeekends;
    }

    public void setNbWeekends(int nbWeekends) {
        this.nbWeekends = nbWeekends;
    }

    @Override
    public String toString() {
        return "PackDuree{" + "id=" + id + ", nbJours=" + nbJours + ", nbWeekends=" + nbWeekends + '}';
    }

}
