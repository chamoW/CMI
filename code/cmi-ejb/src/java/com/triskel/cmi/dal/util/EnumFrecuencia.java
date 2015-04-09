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
public enum EnumFrecuencia {

    ANUAL(1),
    SEMESTRAL(2),
    TRIMESTRAL(3),
    BIMESTRAL(4),
    MENSUAL(5),
    QUINCENAL(6),
    SEMANAL(7),
    DIARIO(8);

    Integer id;

    private EnumFrecuencia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

}
