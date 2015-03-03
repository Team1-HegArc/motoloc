package ch.motoloc.gestion.business;

import ch.motoloc.gestion.services.ConvertisseurDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe Client
 * 
 * @author irina.fessemaz
 */
@Entity
@Table(name = "GM_CUSTOMER")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUST")
    @SequenceGenerator(name = "SEQ_CUST", sequenceName = "SEQ_CUSTOMER", initialValue = 1, allocationSize = 100)
    @Column(name = "PK_CUSTOMER")
    private Long id;
    
    @Column(name = "NAME", nullable = false, length = 100)
    private String nom;
    
    @Column(name = "FIRSTNAME", nullable = false, length = 100)
    private String prenom;
    
    @Column(name = "STREET", nullable = false, length = 300)
    private String rue;
    
    @Column(name = "ZIPCODE", nullable = false, length = 50)
    private String npa;
    
    @Column(name = "CITY", nullable = false, length = 100)
    private String ville;
    
    @Column(name = "BIRTHDATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;
    
    @Column(name = "EMAIL", nullable = false, length = 200)
    private String email;
    
    @Column(name = "PHONE", nullable = true, length = 50)
    private String telephone;
    
    @Column(name = "NOTE", nullable = true, length = 500)
    private String remarque;
    
    @Column(name = "NUM_LICENSE", nullable = true, length = 50)
    private String numeroPermis;
    
    @OneToMany(mappedBy = "client")
    private List<Forfait> forfaits;

    public Client() {
        forfaits = new ArrayList<>();
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
        forfaits = new ArrayList<>();
    }

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

    public String getDateDeNaissance() {
        return ConvertisseurDate.displayDate(this.dateDeNaissance);
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = ConvertisseurDate.formatterDate(dateDeNaissance) ;
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

    public String getNumeroPermis() {
        return numeroPermis;
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

    public List<Forfait> getForfaits() {
        return forfaits;
    }

    public void setForfaits(List<Forfait> forfaits) {
        this.forfaits = forfaits;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", rue=" + rue + ", npa=" + npa + ", ville=" + ville + ", dateDeNaissance=" + dateDeNaissance + ", email=" + email + ", telephone=" + telephone + ", remarque=" + remarque + ", numeroPermis=" + numeroPermis + ", forfaits=" + forfaits + '}';
    }

}
