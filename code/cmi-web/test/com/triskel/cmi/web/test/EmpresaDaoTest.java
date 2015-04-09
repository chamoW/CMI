/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.web.test;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.triskel.cmi.dal.model.Empresa;





/**
 *
 * @author wwlopez
 */
public class EmpresaDaoTest extends GenericoTest{
    
    @Test
    public void contarTest(){
        Integer numeroDatos = empresaDao.contarDatos();
        logger.error("numeroDatos: " + numeroDatos);        
        
        Assert.assertNotSame(1, numeroDatos);                
    }
    
    
    @Test
    public void buscarTodoTest(){
        List<Empresa> lista = empresaDao.searchAll();
        
        for(Empresa tmp : lista){
            logger.error("tmp.getNombre(): " + tmp.getNombre());        
        }                
    }
    
}
