/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.dao;

import com.triskel.cmi.dal.model.Frecuencia;
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
public class FrecuenciaDao extends Generico<Frecuencia> {

    public FrecuenciaDao() {
        super(Frecuencia.class);
    }

    public List<Frecuencia> getAll() {

        Query query = this.getEntityManager().createNamedQuery("Frecuencia.findAll", Frecuencia.class);        
        return query.getResultList();

    }

}
