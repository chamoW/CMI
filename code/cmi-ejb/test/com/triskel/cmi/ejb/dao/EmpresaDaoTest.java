/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.ejb.dao;

import org.junit.Test;

/**
 *
 * @author wwlopez
 */
public class EmpresaDaoTest extends GenericoTest{
    
    @Test
    public void contarTest(){
        Integer numeroDatos = empresaDao.contarDatos();
        System.out.println("numeroDatos: " + numeroDatos);
        
    }
    
}
