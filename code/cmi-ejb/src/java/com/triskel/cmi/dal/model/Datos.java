/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.dal.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author chamoW
 */
@Entity
@Table(name = "datos", catalog = "tris_cmi", schema = "cmi")
@NamedQueries({
    @NamedQuery(name = "Datos.findAll", query = "SELECT d FROM Datos d"),
    @NamedQuery(name = "Datos.findByCmiId", query = "SELECT d FROM Datos d WHERE d.cmi.id =:id order by d.secuencia asc"),
    @NamedQuery(name = "Datos.countByCmiId", query = "SELECT count(d.secuencia) FROM Datos d WHERE d.cmi.id =:id"),
    @NamedQuery(name = "Datos.findById", query = "SELECT d FROM Datos d WHERE d.id = :id"),
    @NamedQuery(name = "Datos.findByDescripcion", query = "SELECT d FROM Datos d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Datos.findByValor", query = "SELECT d FROM Datos d WHERE d.valor = :valor"),
    @NamedQuery(name = "Datos.findBySecuencia", query = "SELECT d FROM Datos d WHERE d.secuencia = :secuencia")})
public class Datos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "secuencia")
    private Integer secuencia;
    @Column(name = "semaforo")
    private Integer semaforo;
    
    @Transient
    private Integer semaforoAux;

    @JoinColumn(name = "id_cmi", referencedColumnName = "id")
    @ManyToOne
    private Cmi cmi;

    public Datos() {
    }

    public Datos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public Cmi getCmi() {
        return cmi;
    }

    public void setCmi(Cmi cmi) {
        this.cmi = cmi;
    }

    public Integer getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(Integer semaforo) {
        this.semaforo = semaforo;
    }

    public Integer getSemaforoAux() {
        return semaforoAux;
    }

    public void setSemaforoAux(Integer semaforoAux) {
        this.semaforoAux = semaforoAux;
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
        if (!(object instanceof Datos)) {
            return false;
        }
        Datos other = (Datos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.dal.model.Datos[ id=" + id + " ]";
    }

}
