/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.dao;

import com.triskel.cmi.dal.model.Cmi;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author chamoW
 */
@Stateless
@LocalBean
public class CmiDao extends Generico<Cmi> {

    public CmiDao() {
        super(Cmi.class);
    }
    
    
    public List<Cmi> getCmiByPerspectiva(Integer id){
        
        Query query = this.getEntityManager().createNamedQuery("Cmi.getByPerspectiva", Cmi.class);
        query.setParameter("id", id);
        
        return query.getResultList();
                
    }

}
