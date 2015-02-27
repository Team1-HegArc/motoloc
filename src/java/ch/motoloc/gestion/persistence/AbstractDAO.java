/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author vincentrobatel
 */
public abstract class AbstractDAO<T> {
    

    private Class<T> clazz;
    //private static AbstractDAO instance;
    
    protected abstract String findByParameterStatement();
    protected abstract String findAllStatement();

    public AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    
    /*
    public static AbstractDAO getInstance(){
        if(instance==null){
            instance = new AbstractDAO();
        }
        return instance;
    }*/
    
    public T findById(final Long id){
        return (T) JpaConnection.getEntityManager().find(clazz, id);
    }
    
    public List<T> findByParameter(String... arguements){
        TypedQuery<T> query = JpaConnection.getEntityManager().createQuery(findByParameterStatement(), clazz);
        for (int i = 1; i < arguements.length; i++) {
            query.setParameter(i, arguements[i-1]);
        }
        return new ArrayList<T>(query.getResultList());
    }
    
    public List<T> findAll(){
        TypedQuery<T> query = JpaConnection.getEntityManager().createQuery(findAllStatement(), clazz);
        return new ArrayList<T>(query.getResultList());
    }
    
}
