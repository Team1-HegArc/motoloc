package ch.motoloc.gestion.business;

import java.util.Date;

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

    public Client() {
    }

    public Client(String nom, String prenom, String rue, String npa, String ville, Date dateDeNaissance, String email, String telephone, String remarque) {
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.npa = npa;
        this.ville = ville;
        this.dateDeNaissance = dateDeNaissance;
        this.email = email;
        this.telephone = telephone;
        this.remarque = remarque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNpa() {
        return npa;
    }

    public void setNpa(String npa) {
        this.npa = npa;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }
    
    
    
}
