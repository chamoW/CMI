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
 * @author wwlopez
 */
@Entity
@Table(name = "matriz_fa", catalog = "tris_cmi", schema = "cmi")
@NamedQueries({
    @NamedQuery(name = "MatrizFa.findAll", query = "SELECT m FROM MatrizFa m"),
    @NamedQuery(name = "MatrizFa.findByIdFortaleza", query = "SELECT m FROM MatrizFa m WHERE m.matrizFaPK.idFortaleza = :idFortaleza"),
    @NamedQuery(name = "MatrizFa.findByIdAmenaza", query = "SELECT m FROM MatrizFa m WHERE m.matrizFaPK.idAmenaza = :idAmenaza"),
    @NamedQuery(name = "MatrizFa.findByPuntaje", query = "SELECT m FROM MatrizFa m WHERE m.puntaje = :puntaje"),
    @NamedQuery(name = "MatrizFa.findByCodigo", query = "SELECT m FROM MatrizFa m WHERE m.codigo = :codigo")})
public class MatrizFa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatrizFaPK matrizFaPK;
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
    @JoinColumn(name = "id_amenaza", referencedColumnName = "id_detalle_foda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DetalleFoda detalleFoda1;

    public MatrizFa() {
    }

    public MatrizFa(MatrizFaPK matrizFaPK) {
        this.matrizFaPK = matrizFaPK;
    }

    public MatrizFa(MatrizFaPK matrizFaPK, int puntaje, String codigo) {
        this.matrizFaPK = matrizFaPK;
        this.puntaje = puntaje;
        this.codigo = codigo;
    }

    public MatrizFa(int idFortaleza, int idAmenaza) {
        this.matrizFaPK = new MatrizFaPK(idFortaleza, idAmenaza);
    }

    public MatrizFaPK getMatrizFaPK() {
        return matrizFaPK;
    }

    public void setMatrizFaPK(MatrizFaPK matrizFaPK) {
        this.matrizFaPK = matrizFaPK;
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
        hash += (matrizFaPK != null ? matrizFaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatrizFa)) {
            return false;
        }
        MatrizFa other = (MatrizFa) object;
        if ((this.matrizFaPK == null && other.matrizFaPK != null) || (this.matrizFaPK != null && !this.matrizFaPK.equals(other.matrizFaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.ejb.entities.MatrizFa[ matrizFaPK=" + matrizFaPK + " ]";
    }
    
}
