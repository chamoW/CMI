/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wwlopez
 */
@Entity
@Table(name = "detalle_foda", catalog = "tris_cmi", schema = "cmi")
@NamedQueries({
    @NamedQuery(name = "DetalleFoda.findAll", query = "SELECT d FROM DetalleFoda d"),
    @NamedQuery(name = "DetalleFoda.findByIdDetalleFoda", query = "SELECT d FROM DetalleFoda d WHERE d.idDetalleFoda = :idDetalleFoda"),
    @NamedQuery(name = "DetalleFoda.findByDescripcion", query = "SELECT d FROM DetalleFoda d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DetalleFoda.findByTipo", query = "SELECT d FROM DetalleFoda d WHERE d.tipo = :tipo"),
    @NamedQuery(name = "DetalleFoda.findByOrden", query = "SELECT d FROM DetalleFoda d WHERE d.orden = :orden")})
public class DetalleFoda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_foda")
    private Integer idDetalleFoda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private Character tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private int orden;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleFoda")
    private List<MatrizFo> matrizFoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleFoda1")
    private List<MatrizFo> matrizFoList1;
    @JoinColumn(name = "id_foda", referencedColumnName = "id_foda")
    @ManyToOne(optional = false)
    private Foda idFoda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleFoda")
    private List<MatrizDo> matrizDoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleFoda1")
    private List<MatrizDo> matrizDoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleFoda")
    private List<MatrizFa> matrizFaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleFoda1")
    private List<MatrizFa> matrizFaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleFoda")
    private List<MatrizDa> matrizDaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleFoda1")
    private List<MatrizDa> matrizDaList1;

    public DetalleFoda() {
    }

    public DetalleFoda(Integer idDetalleFoda) {
        this.idDetalleFoda = idDetalleFoda;
    }

    public DetalleFoda(Integer idDetalleFoda, String descripcion, Character tipo, int orden) {
        this.idDetalleFoda = idDetalleFoda;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.orden = orden;
    }

    public Integer getIdDetalleFoda() {
        return idDetalleFoda;
    }

    public void setIdDetalleFoda(Integer idDetalleFoda) {
        this.idDetalleFoda = idDetalleFoda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public List<MatrizFo> getMatrizFoList() {
        return matrizFoList;
    }

    public void setMatrizFoList(List<MatrizFo> matrizFoList) {
        this.matrizFoList = matrizFoList;
    }

    public List<MatrizFo> getMatrizFoList1() {
        return matrizFoList1;
    }

    public void setMatrizFoList1(List<MatrizFo> matrizFoList1) {
        this.matrizFoList1 = matrizFoList1;
    }

    public Foda getIdFoda() {
        return idFoda;
    }

    public void setIdFoda(Foda idFoda) {
        this.idFoda = idFoda;
    }

    public List<MatrizDo> getMatrizDoList() {
        return matrizDoList;
    }

    public void setMatrizDoList(List<MatrizDo> matrizDoList) {
        this.matrizDoList = matrizDoList;
    }

    public List<MatrizDo> getMatrizDoList1() {
        return matrizDoList1;
    }

    public void setMatrizDoList1(List<MatrizDo> matrizDoList1) {
        this.matrizDoList1 = matrizDoList1;
    }

    public List<MatrizFa> getMatrizFaList() {
        return matrizFaList;
    }

    public void setMatrizFaList(List<MatrizFa> matrizFaList) {
        this.matrizFaList = matrizFaList;
    }

    public List<MatrizFa> getMatrizFaList1() {
        return matrizFaList1;
    }

    public void setMatrizFaList1(List<MatrizFa> matrizFaList1) {
        this.matrizFaList1 = matrizFaList1;
    }

    public List<MatrizDa> getMatrizDaList() {
        return matrizDaList;
    }

    public void setMatrizDaList(List<MatrizDa> matrizDaList) {
        this.matrizDaList = matrizDaList;
    }

    public List<MatrizDa> getMatrizDaList1() {
        return matrizDaList1;
    }

    public void setMatrizDaList1(List<MatrizDa> matrizDaList1) {
        this.matrizDaList1 = matrizDaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleFoda != null ? idDetalleFoda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFoda)) {
            return false;
        }
        DetalleFoda other = (DetalleFoda) object;
        if ((this.idDetalleFoda == null && other.idDetalleFoda != null) || (this.idDetalleFoda != null && !this.idDetalleFoda.equals(other.idDetalleFoda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.ejb.entities.DetalleFoda[ idDetalleFoda=" + idDetalleFoda + " ]";
    }
    
}
