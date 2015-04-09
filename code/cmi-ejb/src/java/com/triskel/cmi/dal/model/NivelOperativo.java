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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author chamoW
 */
@Entity
@Table(name = "nivel_operativo", catalog = "tris_cmi", schema = "cmi")
@NamedQueries({
    @NamedQuery(name = "NivelOperativo.findAll", query = "SELECT n FROM NivelOperativo n"),
    @NamedQuery(name = "NivelOperativo.findById", query = "SELECT n FROM NivelOperativo n WHERE n.id = :id"),
    @NamedQuery(name = "NivelOperativo.findByNombre", query = "SELECT n FROM NivelOperativo n WHERE n.nombre = :nombre"),
    @NamedQuery(name = "NivelOperativo.findByOrden", query = "SELECT n FROM NivelOperativo n WHERE n.orden = :orden")})
public class NivelOperativo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 25)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "orden")
    private Integer orden;
    @OneToMany(mappedBy = "nivelOperativo")
    private List<Cargo> cargoList;
    @OneToMany(mappedBy = "nivelOperativo")
    private List<Cmi> cmiList;

    public NivelOperativo() {
    }

    public NivelOperativo(Integer id) {
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

    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
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
        if (!(object instanceof NivelOperativo)) {
            return false;
        }
        NivelOperativo other = (NivelOperativo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.dal.model.NivelOperativo[ id=" + id + " ]";
    }

}
