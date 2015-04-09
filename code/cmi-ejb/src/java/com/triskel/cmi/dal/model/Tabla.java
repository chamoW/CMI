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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author chamoW
 */
@Entity
@Table(name = "tabla", catalog = "tris_cmi", schema = "cmi")
@NamedQueries({
    @NamedQuery(name = "Tabla.findAll", query = "SELECT t FROM Tabla t"),
    @NamedQuery(name = "Tabla.findByIdTabla", query = "SELECT t FROM Tabla t WHERE t.idTabla = :idTabla"),
    @NamedQuery(name = "Tabla.findByNombre", query = "SELECT t FROM Tabla t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tabla.findByEstado", query = "SELECT t FROM Tabla t WHERE t.estado = :estado")})
public class Tabla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tabla")
    private Integer idTabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tabla")
    private List<Catalogo> catalogoList;

    public Tabla() {
    }

    public Tabla(Integer idTabla) {
        this.idTabla = idTabla;
    }

    public Tabla(Integer idTabla, String nombre, String estado) {
        this.idTabla = idTabla;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdTabla() {
        return idTabla;
    }

    public void setIdTabla(Integer idTabla) {
        this.idTabla = idTabla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Catalogo> getCatalogoList() {
        return catalogoList;
    }

    public void setCatalogoList(List<Catalogo> catalogoList) {
        this.catalogoList = catalogoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTabla != null ? idTabla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabla)) {
            return false;
        }
        Tabla other = (Tabla) object;
        if ((this.idTabla == null && other.idTabla != null) || (this.idTabla != null && !this.idTabla.equals(other.idTabla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.dal.model.Tabla[ idTabla=" + idTabla + " ]";
    }
    
}
