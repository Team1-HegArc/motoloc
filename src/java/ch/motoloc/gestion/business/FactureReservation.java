package ch.motoloc.gestion.business;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Classe FactureReservation
 *
 * @author irina.fessemaz
 */
@Entity
@Table(
        name = "GM_INVOICE_BOOKING",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "UK_INVOICE_BOOKING",
                    columnNames = {"REFERENCE"})})
public class FactureReservation extends Facture {

    @OneToMany(mappedBy = "factureRes", cascade = CascadeType.ALL)
    private List<FactureLigneSupplement> lignesSupplements;

    @OneToMany(mappedBy = "factureRes", cascade = CascadeType.ALL)
    private List<FactureLignePaiement> lignesPaiements;

    public FactureReservation() {
        this.lignesSupplements = new ArrayList<>();
        this.lignesPaiements = new ArrayList<>();
    }

    public FactureReservation(String reference) {
        super(reference);
        this.lignesSupplements = new ArrayList<>();
        this.lignesPaiements = new ArrayList<>();
    }

    public List<FactureLigneSupplement> getLignesSupplements() {
        return lignesSupplements;
    }

    public void setLignesSupplements(List<FactureLigneSupplement> lignesSupplements) {
        this.lignesSupplements = lignesSupplements;
    }

    public List<FactureLignePaiement> getLignesPaiements() {
        return lignesPaiements;
    }

    public void setLignesPaiements(List<FactureLignePaiement> lignesPaiements) {
        this.lignesPaiements = lignesPaiements;
    }
    
    public void addFactureLigneSupplement(FactureLigneSupplement ligneSupplement) {
        this.getLignesSupplements().add(ligneSupplement);
        ligneSupplement.setFactureRes(this);
    }
    
    public void addFactureLignePaiement(FactureLignePaiement lignePaiement) {
        this.getLignesPaiements().add(lignePaiement);
        lignePaiement.setFactureRes(this);
    }

    @Override
    public String toString() {
        return "FactureReservation{" + "lignesSupplements=" + lignesSupplements + ", lignesPaiements=" + lignesPaiements + '}';
    }

    

}
