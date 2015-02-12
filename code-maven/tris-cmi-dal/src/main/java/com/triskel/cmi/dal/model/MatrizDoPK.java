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
public class MatrizDoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_debilidad")
    private int idDebilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_oportunidad")
    private int idOportunidad;

    public MatrizDoPK() {
    }

    public MatrizDoPK(int idDebilidad, int idOportunidad) {
        this.idDebilidad = idDebilidad;
        this.idOportunidad = idOportunidad;
    }

    public int getIdDebilidad() {
        return idDebilidad;
    }

    public void setIdDebilidad(int idDebilidad) {
        this.idDebilidad = idDebilidad;
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
        hash += (int) idDebilidad;
        hash += (int) idOportunidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatrizDoPK)) {
            return false;
        }
        MatrizDoPK other = (MatrizDoPK) object;
        if (this.idDebilidad != other.idDebilidad) {
            return false;
        }
        if (this.idOportunidad != other.idOportunidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.ejb.entities.MatrizDoPK[ idDebilidad=" + idDebilidad + ", idOportunidad=" + idOportunidad + " ]";
    }
    
}
