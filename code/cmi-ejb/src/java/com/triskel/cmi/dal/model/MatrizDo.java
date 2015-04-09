/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.model;

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
 * @author chamoW
 */
@Entity
@Table(name = "matriz_do", catalog = "tris_cmi", schema = "cmi")
@NamedQueries({
    @NamedQuery(name = "MatrizDo.findAll", query = "SELECT m FROM MatrizDo m"),
    @NamedQuery(name = "MatrizDo.findByIdDebilidad", query = "SELECT m FROM MatrizDo m WHERE m.matrizDoPK.idDebilidad = :idDebilidad"),
    @NamedQuery(name = "MatrizDo.findByIdOportunidad", query = "SELECT m FROM MatrizDo m WHERE m.matrizDoPK.idOportunidad = :idOportunidad"),
    @NamedQuery(name = "MatrizDo.findByPuntaje", query = "SELECT m FROM MatrizDo m WHERE m.puntaje = :puntaje"),
    @NamedQuery(name = "MatrizDo.findByCodigo", query = "SELECT m FROM MatrizDo m WHERE m.codigo = :codigo")})
public class MatrizDo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatrizDoPK matrizDoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje")
    private int puntaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    private String codigo;
    @JoinColumn(name = "id_oportunidad", referencedColumnName = "id_detalle_foda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DetalleFoda detalleFoda;
    @JoinColumn(name = "id_debilidad", referencedColumnName = "id_detalle_foda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DetalleFoda detalleFoda1;

    public MatrizDo() {
    }

    public MatrizDo(MatrizDoPK matrizDoPK) {
        this.matrizDoPK = matrizDoPK;
    }

    public MatrizDo(MatrizDoPK matrizDoPK, int puntaje, String codigo) {
        this.matrizDoPK = matrizDoPK;
        this.puntaje = puntaje;
        this.codigo = codigo;
    }

    public MatrizDo(int idDebilidad, int idOportunidad) {
        this.matrizDoPK = new MatrizDoPK(idDebilidad, idOportunidad);
    }

    public MatrizDoPK getMatrizDoPK() {
        return matrizDoPK;
    }

    public void setMatrizDoPK(MatrizDoPK matrizDoPK) {
        this.matrizDoPK = matrizDoPK;
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
        hash += (matrizDoPK != null ? matrizDoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatrizDo)) {
            return false;
        }
        MatrizDo other = (MatrizDo) object;
        if ((this.matrizDoPK == null && other.matrizDoPK != null) || (this.matrizDoPK != null && !this.matrizDoPK.equals(other.matrizDoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.dal.model.MatrizDo[ matrizDoPK=" + matrizDoPK + " ]";
    }
    
}
