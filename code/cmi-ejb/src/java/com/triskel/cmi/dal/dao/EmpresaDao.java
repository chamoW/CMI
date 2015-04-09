/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.triskel.cmi.dal.model.Empresa;



/**
 *
 * @author wwlopez
 */

@Stateless
@LocalBean
public class EmpresaDao extends Generico<Empresa> {

	public EmpresaDao() {
		super(Empresa.class);
	}

	public Integer contarDatos() {
		Query query = getEntityManager().createNamedQuery("Empresa.count");
		return ((Number) query.getSingleResult()).intValue();
	}

	public List<Empresa> searchAll() {
		Query query = getEntityManager().createNamedQuery("Empresa.findAll",
				Empresa.class);
		return query.getResultList();
	}

}
