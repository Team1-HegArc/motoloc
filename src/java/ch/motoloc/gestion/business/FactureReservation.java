package ch.motoloc.gestion.business;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe FactureReservation
 *
 * @author irina.fessemaz
 */
@Entity
@Table(name = "GM_INVOICE_BOOKING")
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

    @Override
    public String toString() {
        return "FactureReservation{" + "lignesSupplements=" + lignesSupplements + ", lignesPaiements=" + lignesPaiements + '}';
    }

    

}
