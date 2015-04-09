/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.dao;

import com.triskel.cmi.dal.model.Empleado;
import com.triskel.cmi.dal.model.Frecuencia;
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
public class EmpleadoDao extends Generico<Empleado> {

    public EmpleadoDao() {
        super(Empleado.class);
    }

    public List<Empleado> getAll() {

        Query query = this.getEntityManager().createNamedQuery("Empleado.findAll", Empleado.class);
        return query.getResultList();

    }
    
    
     public List<Empleado> getByNivelJerarquico(Integer nivel) {

        Query query = this.getEntityManager().createNamedQuery("Empleado.findByNivel", Empleado.class);
        query.setParameter("idNivel", nivel);
        return query.getResultList();

    }

}
