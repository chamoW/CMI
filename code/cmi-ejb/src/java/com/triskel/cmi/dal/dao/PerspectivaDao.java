/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.dao;

import com.triskel.cmi.dal.model.Cmi;
import com.triskel.cmi.dal.model.Perspectiva;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.Query;

/**
 *
 * @author chamoW
 */
@Stateless
@LocalBean
public class PerspectivaDao extends Generico<Perspectiva> {

    public PerspectivaDao() {
        super(Perspectiva.class);
    }
        
    public List<Perspectiva> getPerspectiva(Integer id){
        
        Query query = this.getEntityManager().createNamedQuery("Perspectiva.findById", Perspectiva.class);
        query.setParameter("id", id);
        
        return query.getResultList();                
    }

}
