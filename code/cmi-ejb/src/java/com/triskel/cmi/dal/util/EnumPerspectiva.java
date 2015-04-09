/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.util;

/**
 *
 * @author chamoW
 */
public enum EnumPerspectiva {
    
    Financiera(1),
    Cliente(2),
    Procesos(3),
    Aprendizaje(4);
    
    Integer id;
    
    private EnumPerspectiva(Integer id){
        this.id = id;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    
    
}
