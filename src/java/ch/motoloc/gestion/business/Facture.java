package ch.motoloc.gestion.business;

/**
 * Classe Facture
 * @author irina.fessemaz
 */
public class Facture {
    
    private String numero;

    public Facture() {
    }

    public Facture(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
