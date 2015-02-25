package ch.motoloc.gestion.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe Client
 * @author irina.fessemaz
 */

@Entity
@Table(name = "CUSTOMER")
public class Client implements Serializable {
    
    @Id
    @Column(name = "PK_CUSTOMER")
    private Long id;
    
    @Column(name = "NAME")
    private String nom;
    
    @Column(name = "FIRSTNAME")
    private String prenom;
    
    @Column(name = "STREET")
    private String rue;
    
    @Column(name = "ZIPCODE")
    private String npa;
    
    @Column(name = "CITY")
    private String ville;
    
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "PHONE")
    private String telephone;
    
    @Column(name = "NOTE")
    private String remarque;
    
    //A VERIFIER
    @OneToMany
    @JoinColumn(name="FK_CUSTOMER")
    private List<Forfait> forfaits;
    
    @Column(name = "NUM_LICENSE")
    private String numeroPermis;

    public Client() {
    }

    public Client(String nom, String prenom, String rue, String npa, String ville, Date dateDeNaissance, String email, String telephone, String remarque, String numeroPermis) {
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.npa = npa;
        this.ville = ville;
        this.dateDeNaissance = dateDeNaissance;
        this.email = email;
        this.telephone = telephone;
        this.remarque = remarque;
        this.numeroPermis = numeroPermis;
    }
s
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Forfait> getForfaits() {
        return forfaits;
    }

    public void setForfaits(List<Forfait> forfaits) {
        this.forfaits = forfaits;
    }

    public String getNumeroPermis() {
        return numeroPermis;
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }
    
    
    

}
