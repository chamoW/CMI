/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.dao;

import com.triskel.cmi.dal.model.Cmi;
import com.triskel.cmi.dal.model.Datos;
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
public class DatosDao extends Generico<Datos> {

    public DatosDao() {
        super(Datos.class);
    }
        
    public Integer getUltimoByCmiId(Integer id){        
        Query query = this.getEntityManager().createNamedQuery("Datos.countByCmiId", Integer.class);
        query.setParameter("id", id);        
        Integer valor = (Integer)((Long) query.getSingleResult()).intValue();                
        return valor;                
    }
    
    public List<Datos> getByCmiId(Integer id){        
        Query query = this.getEntityManager().createNamedQuery("Datos.findByCmiId", Datos.class);
        query.setParameter("id", id);        
        
        return query.getResultList();
    }

}
