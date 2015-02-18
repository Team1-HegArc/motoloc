package ch.motoloc.gestion.business;

/**
 * Classe Moto
 * @author irina.fessemaz
 */
public class Moto {
    
    private String numero;
    private MotoModele modele;
    private String remarque;

    public Moto() {
    }

    public Moto(String numero, MotoModele modele, String remarque) {
        this.numero = numero;
        this.modele = modele;
        this.remarque = remarque;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public MotoModele getModele() {
        return modele;
    }

    public void setModele(MotoModele modele) {
        this.modele = modele;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }
    
    
}
