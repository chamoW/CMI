/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author chamoW
 */
@Entity
@Table(name = "foda", catalog = "tris_cmi", schema = "cmi")
@NamedQueries({
    @NamedQuery(name = "Foda.findAll", query = "SELECT f FROM Foda f"),
    @NamedQuery(name = "Foda.findByIdFoda", query = "SELECT f FROM Foda f WHERE f.idFoda = :idFoda"),
    @NamedQuery(name = "Foda.findByDescripcion", query = "SELECT f FROM Foda f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "Foda.findByFechaCreacion", query = "SELECT f FROM Foda f WHERE f.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Foda.findByFechaDesde", query = "SELECT f FROM Foda f WHERE f.fechaDesde = :fechaDesde"),
    @NamedQuery(name = "Foda.findByFechaHasta", query = "SELECT f FROM Foda f WHERE f.fechaHasta = :fechaHasta")})
public class Foda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_foda")
    private Integer idFoda;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_desde")
    @Temporal(TemporalType.DATE)
    private Date fechaDesde;
    @Size(max = 2147483647)
    @Column(name = "fecha_hasta")
    private String fechaHasta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foda")
    private List<DetalleFoda> detalleFodaList;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Foda() {
    }

    public Foda(Integer idFoda) {
        this.idFoda = idFoda;
    }

    public Foda(Integer idFoda, Date fechaCreacion, Date fechaDesde) {
        this.idFoda = idFoda;
        this.fechaCreacion = fechaCreacion;
        this.fechaDesde = fechaDesde;
    }

    public Integer getIdFoda() {
        return idFoda;
    }

    public void setIdFoda(Integer idFoda) {
        this.idFoda = idFoda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public List<DetalleFoda> getDetalleFodaList() {
        return detalleFodaList;
    }

    public void setDetalleFodaList(List<DetalleFoda> detalleFodaList) {
        this.detalleFodaList = detalleFodaList;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFoda != null ? idFoda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foda)) {
            return false;
        }
        Foda other = (Foda) object;
        if ((this.idFoda == null && other.idFoda != null) || (this.idFoda != null && !this.idFoda.equals(other.idFoda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.dal.model.Foda[ idFoda=" + idFoda + " ]";
    }
    
}
