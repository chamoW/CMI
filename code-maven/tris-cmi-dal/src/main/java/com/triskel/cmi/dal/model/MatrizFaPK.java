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
public class MatrizFaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fortaleza")
    private int idFortaleza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_amenaza")
    private int idAmenaza;

    public MatrizFaPK() {
    }

    public MatrizFaPK(int idFortaleza, int idAmenaza) {
        this.idFortaleza = idFortaleza;
        this.idAmenaza = idAmenaza;
    }

    public int getIdFortaleza() {
        return idFortaleza;
    }

    public void setIdFortaleza(int idFortaleza) {
        this.idFortaleza = idFortaleza;
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
        hash += (int) idFortaleza;
        hash += (int) idAmenaza;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatrizFaPK)) {
            return false;
        }
        MatrizFaPK other = (MatrizFaPK) object;
        if (this.idFortaleza != other.idFortaleza) {
            return false;
        }
        if (this.idAmenaza != other.idAmenaza) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.ejb.entities.MatrizFaPK[ idFortaleza=" + idFortaleza + ", idAmenaza=" + idAmenaza + " ]";
    }
    
}
