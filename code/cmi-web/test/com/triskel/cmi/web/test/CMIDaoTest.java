/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.web.test;


import com.triskel.cmi.dal.model.Cmi;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.triskel.cmi.dal.model.Empresa;
import com.triskel.cmi.dal.model.Perspectiva;
import com.triskel.cmi.dal.util.EnumPerspectiva;





/**
 *
 * @author wwlopez
 */
public class CMIDaoTest extends GenericoTest{
    
    @Test
    public void contarTest(){
        
        logger.error("EnumPerspectiva.Aprendizaje.getId()" + EnumPerspectiva.Financiera.getId());        
        
        List<Cmi> listCmi = cmiDao.getCmiByPerspectiva(EnumPerspectiva.Financiera.getId());
        for (Cmi tmpObj : listCmi) {
            logger.error("tmpObj.getObjetivo(): " + tmpObj.getId());        
        }
        
        Assert.assertNotNull(listCmi);                
    }
    
    
    
}
