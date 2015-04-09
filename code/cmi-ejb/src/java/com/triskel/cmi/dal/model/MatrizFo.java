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
@Table(name = "matriz_fo", catalog = "tris_cmi", schema = "cmi")
@NamedQueries({
    @NamedQuery(name = "MatrizFo.findAll", query = "SELECT m FROM MatrizFo m"),
    @NamedQuery(name = "MatrizFo.findByIdFortaleza", query = "SELECT m FROM MatrizFo m WHERE m.matrizFoPK.idFortaleza = :idFortaleza"),
    @NamedQuery(name = "MatrizFo.findByIdOportunidad", query = "SELECT m FROM MatrizFo m WHERE m.matrizFoPK.idOportunidad = :idOportunidad"),
    @NamedQuery(name = "MatrizFo.findByPuntaje", query = "SELECT m FROM MatrizFo m WHERE m.puntaje = :puntaje"),
    @NamedQuery(name = "MatrizFo.findByCodigo", query = "SELECT m FROM MatrizFo m WHERE m.codigo = :codigo")})
public class MatrizFo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatrizFoPK matrizFoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje")
    private int puntaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    private String codigo;
    @JoinColumn(name = "id_fortaleza", referencedColumnName = "id_detalle_foda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DetalleFoda detalleFoda;
    @JoinColumn(name = "id_oportunidad", referencedColumnName = "id_detalle_foda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DetalleFoda detalleFoda1;

    public MatrizFo() {
    }

    public MatrizFo(MatrizFoPK matrizFoPK) {
        this.matrizFoPK = matrizFoPK;
    }

    public MatrizFo(MatrizFoPK matrizFoPK, int puntaje, String codigo) {
        this.matrizFoPK = matrizFoPK;
        this.puntaje = puntaje;
        this.codigo = codigo;
    }

    public MatrizFo(int idFortaleza, int idOportunidad) {
        this.matrizFoPK = new MatrizFoPK(idFortaleza, idOportunidad);
    }

    public MatrizFoPK getMatrizFoPK() {
        return matrizFoPK;
    }

    public void setMatrizFoPK(MatrizFoPK matrizFoPK) {
        this.matrizFoPK = matrizFoPK;
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
        hash += (matrizFoPK != null ? matrizFoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatrizFo)) {
            return false;
        }
        MatrizFo other = (MatrizFo) object;
        if ((this.matrizFoPK == null && other.matrizFoPK != null) || (this.matrizFoPK != null && !this.matrizFoPK.equals(other.matrizFoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.dal.model.MatrizFo[ matrizFoPK=" + matrizFoPK + " ]";
    }
    
}
