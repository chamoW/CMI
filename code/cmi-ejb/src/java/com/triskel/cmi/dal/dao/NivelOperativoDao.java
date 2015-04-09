/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.dao;

import com.triskel.cmi.dal.model.Empleado;
import com.triskel.cmi.dal.model.Frecuencia;
import com.triskel.cmi.dal.model.NivelOperativo;
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
public class NivelOperativoDao extends Generico<NivelOperativo> {

    public NivelOperativoDao() {
        super(NivelOperativo.class);
    }

    public List<NivelOperativo> getAll() {

        Query query = this.getEntityManager().createNamedQuery("NivelOperativo.findAll", NivelOperativo.class);
        return query.getResultList();

    }

}
