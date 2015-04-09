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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cmi", catalog = "tris_cmi", schema = "cmi")
@NamedQueries({
    @NamedQuery(name = "Cmi.findAll", query = "SELECT c FROM Cmi c"),
    @NamedQuery(name = "Cmi.findById", query = "SELECT c FROM Cmi c WHERE c.id = :id"),
    @NamedQuery(name = "Cmi.findByIndicador", query = "SELECT c FROM Cmi c WHERE c.indicador = :indicador"),
    @NamedQuery(name = "Cmi.findByIdNivelHijo", query = "SELECT c FROM Cmi c WHERE c.idNivelHijo = :idNivelHijo"),
    @NamedQuery(name = "Cmi.findByObjetivo", query = "SELECT c FROM Cmi c WHERE c.objetivo = :objetivo"),
    @NamedQuery(name = "Cmi.findByMeta", query = "SELECT c FROM Cmi c WHERE c.meta = :meta"),
    @NamedQuery(name = "Cmi.findByMinimo", query = "SELECT c FROM Cmi c WHERE c.minimo = :minimo"),
    @NamedQuery(name = "Cmi.findByEstrategiaValor", query = "SELECT c FROM Cmi c WHERE c.estrategiaValor = :estrategiaValor"),
    @NamedQuery(name = "Cmi.getByPerspectiva", query = "SELECT c FROM Cmi c WHERE c.perspectiva.id = :id"),    
    @NamedQuery(name = "Cmi.findByDefinicionOperacional", query = "SELECT c FROM Cmi c WHERE c.definicionOperacional = :definicionOperacional")})
public class Cmi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "indicador")
    private String indicador;
    @Column(name = "id_nivel_hijo")
    private Integer idNivelHijo;
    @Size(max = 255)
    @Column(name = "objetivo")
    private String objetivo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "meta")
    private Double meta;
    @Column(name = "minimo")
    private Double minimo;
    @Size(max = 100)
    @Column(name = "estrategia_valor")
    private String estrategiaValor;
    @Size(max = 200)
    @Column(name = "definicion_operacional")
    private String definicionOperacional;
    @JoinColumn(name = "id_perspectiva", referencedColumnName = "id")
    @ManyToOne
    private Perspectiva perspectiva;
    @JoinColumn(name = "id_nivel_padre", referencedColumnName = "id")
    @ManyToOne
    private NivelOperativo nivelOperativo;
    @JoinColumn(name = "id_frecuencia", referencedColumnName = "id")
    @ManyToOne
    private Frecuencia frecuencia;
    @JoinColumn(name = "id_responsable", referencedColumnName = "id")
    @ManyToOne
    private Empleado empleado;
    @OneToMany(mappedBy = "cmi")
    private List<Datos> datosList;

    public Cmi() {
    }

    public Cmi(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public Integer getIdNivelHijo() {
        return idNivelHijo;
    }

    public void setIdNivelHijo(Integer idNivelHijo) {
        this.idNivelHijo = idNivelHijo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Double getMeta() {
        return meta;
    }

    public void setMeta(Double meta) {
        this.meta = meta;
    }

    public Double getMinimo() {
        return minimo;
    }

    public void setMinimo(Double minimo) {
        this.minimo = minimo;
    }

    public String getEstrategiaValor() {
        return estrategiaValor;
    }

    public void setEstrategiaValor(String estrategiaValor) {
        this.estrategiaValor = estrategiaValor;
    }

    public String getDefinicionOperacional() {
        return definicionOperacional;
    }

    public void setDefinicionOperacional(String definicionOperacional) {
        this.definicionOperacional = definicionOperacional;
    }

    public Perspectiva getPerspectiva() {
        return perspectiva;
    }

    public void setPerspectiva(Perspectiva perspectiva) {
        this.perspectiva = perspectiva;
    }

    public NivelOperativo getNivelOperativo() {
        return nivelOperativo;
    }

    public void setNivelOperativo(NivelOperativo nivelOperativo) {
        this.nivelOperativo = nivelOperativo;
    }

    public Frecuencia getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Frecuencia frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Datos> getDatosList() {
        return datosList;
    }

    public void setDatosList(List<Datos> datosList) {
        this.datosList = datosList;
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
        if (!(object instanceof Cmi)) {
            return false;
        }
        Cmi other = (Cmi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.triskel.cmi.dal.model.Cmi[ id=" + id + " ]";
    }
    
}
