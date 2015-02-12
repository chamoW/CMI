/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author wwlopez
 */
@Embeddable
public class MatrizFoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fortaleza")
    private int idFortaleza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_oportunidad")
    private int idOportunidad;

    public MatrizFoPK() {
    }

    public MatrizFoPK(int idFortaleza, int idOportunidad) {
        this.idFortaleza = idFortaleza;
        this.idOportunidad = idOportunidad;
    }

    public int getIdFortaleza() {
        return idFortaleza;
    }

    public void setIdFortaleza(int idFortaleza) {
        this.idFortaleza = idFortaleza;
    }

    public int getIdOportunidad() {
        return idOportunidad;
    }

    public void setIdOportunidad(int idOportunidad) {
        this.idOportunidad = idOportunidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFortaleza;
        hash += (int) idOportunidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatrizFoPK)) {
            return false;
        }
        MatrizFoPK other = (MatrizFoPK) object;
        if (this.idFortaleza != other.idFortaleza) {
            return false;
        }
        if (this.idOportunidad != other.idOportunidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.ejb.entities.MatrizFoPK[ idFortaleza=" + idFortaleza + ", idOportunidad=" + idOportunidad + " ]";
    }
    
}
