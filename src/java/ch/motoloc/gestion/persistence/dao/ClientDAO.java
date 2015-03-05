/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence.dao;

import ch.motoloc.gestion.business.Client;
import ch.motoloc.gestion.business.Facture;
import ch.motoloc.gestion.persistence.AbstractDAO;
import java.util.List;

/**
 *
 * @author vincentrobatel
 */
public class ClientDAO extends AbstractDAO<Client>{

    
    public ClientDAO() {
        super(Client.class);
    }
    
    public List<Client> findByFiltre(final String nom, final String prenom, final String email){
        String request = "SELECT cli FROM Client cli WHERE LOWER(cli.nom) LIKE LOWER(?1) AND LOWER(cli.prenom) LIKE LOWER(?2) AND LOWER(cli.email) LIKE LOWER(?3) ORDER BY cli.nom";
        return super.findByParameter(request, nom, prenom, email);
    }
    
    public List<Client> findByFactureForfait(Facture facture) {
        String request = "SELECT cli FROM Client cli INNER JOIN cli.forfaits forf WHERE LOWER(forf.facture.reference) LIKE LOWER(?1)";
        return super.findByParameter(request, facture.getReference().toString());
    }
    
    public List<Client> findByFactureReservation(Facture facture) {
        String request = "SELECT cli FROM Client cli INNER JOIN cli.forfaits forf INNER JOIN forf.reservations res WHERE LOWER(res.facture.reference) LIKE LOWER(?1)";
        return super.findByParameter(request, facture.getReference().toString());
    }
                

    @Override
    protected String findAllStatement() {
        return "SELECT cli FROM Client cli";
    }

}
