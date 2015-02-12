/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.dao;

import com.triskel.cmi.dal.model.Empresa;

import java.util.List;

import javax.persistence.Query;

/**
 *
 * @author wwlopez
 */

public class EmpresaDao extends Generico{
    
    public Integer contarDatos(){        
        Query query = this.entityManager.createNamedQuery("Empresa.count");
        return ((Number)query.getSingleResult()).intValue();
    }
    
    public List<Empresa> searchAll(){
        Query query = this.entityManager.createNamedQuery("Empresa.findAll", Empresa.class);
        return query.getResultList();
    }
    
}
