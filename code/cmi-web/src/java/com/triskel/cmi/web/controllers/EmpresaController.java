/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.web.controllers;

import com.triskel.cmi.ejb.dao.EmpresaDao;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author wwlopez
 */
@ManagedBean
@ViewScoped
public class EmpresaController {
    
    @EJB
    private EmpresaDao empresaDao;
    
    
    
    
}
