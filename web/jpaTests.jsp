<%-- 
    Document   : jpaTests
    Created on : 25 févr. 2015, 14:55:17
    Author     : Administrateur
--%>

<%@page import="java.util.Date"%>
<%@page import="ch.motoloc.gestion.business.Client"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("motolocPU");
            EntityManager em = emf.createEntityManager();

            EntityTransaction transaction = em.getTransaction();

            /**
             * Ajout d'un client
             */
            transaction.begin();
            Client client = new Client("Fessemaz", "Irina", "Primevères 2", "2400", "Le Locle", new Date(), "irina.fessemaz@gmail.com", "0764211766", "RAS", "012345");
            //Ajout du client
            em.persist(client);
            transaction.commit();
            //Mise à jour de l'ID du client généré dans la base
            Query query = em.createQuery("SELECT c FROM Client c WHERE c.nom = :nom");
            query.setParameter("nom", client.getNom());
            client = (Client) query.getSingleResult();
            //Affichage du client
            out.println(client);

            em.close();
            emf.close();;
        %>
    </body>
</html>
