/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.ejb.dao;

import javax.persistence.Query;

/**
 *
 * @author wwlopez
 */

public class EmpresaDao extends Generico{
    
    public Integer contarDatos(){
        Query query = getEntityManager().createNamedQuery("Empresa.count");
        return query.getFirstResult();
    }
    
}
