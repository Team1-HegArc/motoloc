package ch.motoloc.gestion.business;

import java.util.Date;
import java.util.List;

/**
 * Classe Client
 * @author irina.fessemaz
 */
public class Client {
    
    private String nom;
    private String prenom;
    private String rue;
    private String npa;
    private String ville;
    private Date dateDeNaissance;
    private String email;
    private String telephone;
    private String remarque;
    private List<Forfait> forfaits;
    private String numeroPermis;

    public Client() {
    }
    
    

}
