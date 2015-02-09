/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wwlopez
 */
@Entity
@Table(name = "matriz_da", catalog = "tris_cmi", schema = "cmi")
@NamedQueries({
    @NamedQuery(name = "MatrizDa.findAll", query = "SELECT m FROM MatrizDa m"),
    @NamedQuery(name = "MatrizDa.findByIdDebilidad", query = "SELECT m FROM MatrizDa m WHERE m.matrizDaPK.idDebilidad = :idDebilidad"),
    @NamedQuery(name = "MatrizDa.findByIdAmenaza", query = "SELECT m FROM MatrizDa m WHERE m.matrizDaPK.idAmenaza = :idAmenaza"),
    @NamedQuery(name = "MatrizDa.findByPuntaje", query = "SELECT m FROM MatrizDa m WHERE m.puntaje = :puntaje"),
    @NamedQuery(name = "MatrizDa.findByCodigo", query = "SELECT m FROM MatrizDa m WHERE m.codigo = :codigo")})
public class MatrizDa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatrizDaPK matrizDaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje")
    private int puntaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    private String codigo;
    @JoinColumn(name = "id_debilidad", referencedColumnName = "id_detalle_foda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DetalleFoda detalleFoda;
    @JoinColumn(name = "id_amenaza", referencedColumnName = "id_detalle_foda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DetalleFoda detalleFoda1;

    public MatrizDa() {
    }

    public MatrizDa(MatrizDaPK matrizDaPK) {
        this.matrizDaPK = matrizDaPK;
    }

    public MatrizDa(MatrizDaPK matrizDaPK, int puntaje, String codigo) {
        this.matrizDaPK = matrizDaPK;
        this.puntaje = puntaje;
        this.codigo = codigo;
    }

    public MatrizDa(int idDebilidad, int idAmenaza) {
        this.matrizDaPK = new MatrizDaPK(idDebilidad, idAmenaza);
    }

    public MatrizDaPK getMatrizDaPK() {
        return matrizDaPK;
    }

    public void setMatrizDaPK(MatrizDaPK matrizDaPK) {
        this.matrizDaPK = matrizDaPK;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public DetalleFoda getDetalleFoda() {
        return detalleFoda;
    }

    public void setDetalleFoda(DetalleFoda detalleFoda) {
        this.detalleFoda = detalleFoda;
    }

    public DetalleFoda getDetalleFoda1() {
        return detalleFoda1;
    }

    public void setDetalleFoda1(DetalleFoda detalleFoda1) {
        this.detalleFoda1 = detalleFoda1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matrizDaPK != null ? matrizDaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatrizDa)) {
            return false;
        }
        MatrizDa other = (MatrizDa) object;
        if ((this.matrizDaPK == null && other.matrizDaPK != null) || (this.matrizDaPK != null && !this.matrizDaPK.equals(other.matrizDaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.ejb.entities.MatrizDa[ matrizDaPK=" + matrizDaPK + " ]";
    }
    
}
