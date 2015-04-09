/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "perspectiva", catalog = "tris_cmi", schema = "cmi")
@NamedQueries({
    @NamedQuery(name = "Perspectiva.findAll", query = "SELECT p FROM Perspectiva p"),
    @NamedQuery(name = "Perspectiva.findById", query = "SELECT p FROM Perspectiva p WHERE p.id = :id"),
    @NamedQuery(name = "Perspectiva.findByNombre", query = "SELECT p FROM Perspectiva p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Perspectiva.findByOrden", query = "SELECT p FROM Perspectiva p WHERE p.orden = :orden")})
public class Perspectiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "orden")
    private Integer orden;
    @OneToMany(mappedBy = "perspectiva")
    private List<Cmi> cmiList;

    public Perspectiva() {
    }

    public Perspectiva(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public List<Cmi> getCmiList() {
        return cmiList;
    }

    public void setCmiList(List<Cmi> cmiList) {
        this.cmiList = cmiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perspectiva)) {
            return false;
        }
        Perspectiva other = (Perspectiva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.dal.model.Perspectiva[ id=" + id + " ]";
    }
    
}
