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
public class MatrizDaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_debilidad")
    private int idDebilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_amenaza")
    private int idAmenaza;

    public MatrizDaPK() {
    }

    public MatrizDaPK(int idDebilidad, int idAmenaza) {
        this.idDebilidad = idDebilidad;
        this.idAmenaza = idAmenaza;
    }

    public int getIdDebilidad() {
        return idDebilidad;
    }

    public void setIdDebilidad(int idDebilidad) {
        this.idDebilidad = idDebilidad;
    }

    public int getIdAmenaza() {
        return idAmenaza;
    }

    public void setIdAmenaza(int idAmenaza) {
        this.idAmenaza = idAmenaza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDebilidad;
        hash += (int) idAmenaza;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatrizDaPK)) {
            return false;
        }
        MatrizDaPK other = (MatrizDaPK) object;
        if (this.idDebilidad != other.idDebilidad) {
            return false;
        }
        if (this.idAmenaza != other.idAmenaza) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.ejb.entities.MatrizDaPK[ idDebilidad=" + idDebilidad + ", idAmenaza=" + idAmenaza + " ]";
    }
    
}
