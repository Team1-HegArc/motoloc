/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author vincentrobatel
 */
public abstract class AbstractDAO<T> {
    

    private Class<T> clazz;
    
    protected abstract String findAllStatement();

    public AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    public T findById(final Long id){
        return (T) JpaConnection.getEntityManager().find(clazz, id);
    }
    
    protected List<T> findByParameter(String request, String... arguements){
        TypedQuery<T> query = JpaConnection.getEntityManager().createQuery(request, clazz);
        for (int i = 0; i < arguements.length; i++) {
            query.setParameter(i+1, '%' + arguements[i]+ '%');
        }
        return new ArrayList(query.getResultList());
    }
    
    protected List<T> findByParameter(String request, Object... arguements){
        TypedQuery<T> query = JpaConnection.getEntityManager().createQuery(request, clazz);
        for (int i = 0; i < arguements.length; i++) {
            query.setParameter(i+1, arguements[i]);
        }
        return new ArrayList(query.getResultList());
    }
    
    protected List<T> findByParameter(String request){
        TypedQuery<T> query = JpaConnection.getEntityManager().createQuery(request, clazz);
        return new ArrayList<>(query.getResultList());
    }
    
    public List<T> findAll(){
        TypedQuery<T> query = JpaConnection.getEntityManager().createQuery(findAllStatement(), clazz);
        return new ArrayList(query.getResultList());
    }
    
}
