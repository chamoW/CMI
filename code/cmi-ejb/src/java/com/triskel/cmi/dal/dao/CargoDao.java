/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.dao;

import com.triskel.cmi.dal.model.Cargo;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author wwlopez
 */
@Stateless
@LocalBean
public class CargoDao extends Generico<Cargo> {

    public CargoDao() {
        super(Cargo.class);
    }
    
    public List<Cargo> getCargoById(Integer id){
        
        Query query = this.getEntityManager().createNamedQuery("Cargo.findById", Cargo.class);
        query.setParameter("id", id);
        
        return query.getResultList();
                
    }
    
     public List<Cargo> getCargoByDepartamento(Integer id){
        
        Query query = this.getEntityManager().createNamedQuery("Cargo.findByDepartamento", Cargo.class);
        query.setParameter("id", id);
        
        return query.getResultList();
                
    }

}
