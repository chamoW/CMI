/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.web.controllers;

import com.triskel.cmi.dal.dao.CmiDao;
import com.triskel.cmi.dal.dao.EmpleadoDao;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.triskel.cmi.dal.dao.FrecuenciaDao;
import com.triskel.cmi.dal.dao.NivelOperativoDao;
import com.triskel.cmi.dal.model.Cmi;
import com.triskel.cmi.dal.model.Empleado;
import com.triskel.cmi.dal.model.Frecuencia;
import com.triskel.cmi.dal.model.NivelOperativo;
import com.triskel.cmi.dal.model.Perspectiva;
import com.triskel.cmi.dal.util.EnumPerspectiva;
import com.triskel.cmi.web.controllers.util.JsfUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

/**
 *
 * @author wwlopez
 */
@ManagedBean
@ViewScoped
public class CmiController {

    //--------------------------------------------------------------------------
    //-- EJBS
    //--------------------------------------------------------------------------
    @EJB
    private CmiDao daoCmi;

    @EJB
    private FrecuenciaDao daoFrecuencia;
    @EJB
    private NivelOperativoDao daoNivelOperativo;
    @EJB
    private EmpleadoDao daoEmpleado;

    //--------------------------------------------------------------------------
    //-- VARIABLES COMUNES
    //--------------------------------------------------------------------------
    private SelectItem seleccione = new SelectItem(null, "Seleccione");

    private Cmi current;
    //Perspecrtivas
    private Integer idPerspectiva;
    private List<Cmi> listFinanciera = new ArrayList<>();
    private List<Cmi> listCliente = new ArrayList<>();
    private List<Cmi> listProceso = new ArrayList<>();
    private List<Cmi> listAprendizaje = new ArrayList<>();

    //Frecuecia
    private Integer idFrecuencia;
    private List<SelectItem> comboFrecuencia;

    //Nivel Jerarquico Padre
    private Integer idNivelPadre;
    private List<SelectItem> comboNivelPadre;

    //Nivel Jerarquico Padre
    private Integer idNivelHijo;
    private List<SelectItem> comboNivelHijo;

    //Reponsable
    private Integer idResponsable;
    private List<SelectItem> comboResponsable;

    //--------------------------------------------------------------------------
    //-- GETTERS / SETTERSS
    //--------------------------------------------------------------------------
    public Integer getIdPerspectiva() {
        return idPerspectiva;
    }

    public void setIdPerspectiva(Integer idPerspectiva) {
        this.idPerspectiva = idPerspectiva;
    }

    public Integer getIdNivelPadre() {
        return idNivelPadre;
    }

    public void setIdNivelPadre(Integer idNivelPadre) {
        this.idNivelPadre = idNivelPadre;
    }

    public List<SelectItem> getComboNivelPadre() {
        return comboNivelPadre;
    }

    public void setComboNivelPadre(List<SelectItem> comboNivelPadre) {
        this.comboNivelPadre = comboNivelPadre;
    }

    public Integer getIdNivelHijo() {
        return idNivelHijo;
    }

    public void setIdNivelHijo(Integer idNivelHijo) {
        this.idNivelHijo = idNivelHijo;
    }

    public List<SelectItem> getComboNivelHijo() {
        return comboNivelHijo;
    }

    public void setComboNivelHijo(List<SelectItem> comboNivelHijo) {
        this.comboNivelHijo = comboNivelHijo;
    }

    public SelectItem getSeleccione() {
        return seleccione;
    }

    public void setSeleccione(SelectItem seleccione) {
        this.seleccione = seleccione;
    }

    public Integer getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

    public List<SelectItem> getComboResponsable() {
        return comboResponsable;
    }

    public void setComboResponsable(List<SelectItem> comboResponsable) {
        this.comboResponsable = comboResponsable;
    }

    public Integer getIdFrecuencia() {
        return idFrecuencia;
    }

    public void setIdFrecuencia(Integer idFrecuencia) {
        this.idFrecuencia = idFrecuencia;
    }

    public List<SelectItem> getComboFrecuencia() {
        return comboFrecuencia;
    }

    public void setComboFrecuencia(List<SelectItem> comboFrecuencia) {
        this.comboFrecuencia = comboFrecuencia;
    }

    public Cmi getCurrent() {
        return current;
        
    }

    public void setCurrent(Cmi current) {
        
        this.current = current;
        cargarDatosEditar();
    }

    public List<Cmi> getListFinanciera() {
        return listFinanciera;
    }

    public void setListFinanciera(List<Cmi> listFinanciera) {
        this.listFinanciera = listFinanciera;
    }

    public List<Cmi> getListCliente() {
        return listCliente;
    }

    public void setListCliente(List<Cmi> listCliente) {
        this.listCliente = listCliente;
    }

    public List<Cmi> getListProceso() {
        return listProceso;
    }

    public void setListProceso(List<Cmi> listProceso) {
        this.listProceso = listProceso;
    }

    public List<Cmi> getListAprendizaje() {
        return listAprendizaje;
    }

    public void setListAprendizaje(List<Cmi> listAprendizaje) {
        this.listAprendizaje = listAprendizaje;
    }

    //--------------------------------------------------------------------------
    //-- METODOS
    //--------------------------------------------------------------------------    
    @PostConstruct
    public void inicializar() {
        this.current = new Cmi();
        cargarDatosFinanciera();
        cargarDatosCliente();
        cargarDatosProceso();
        cargarDatosAprendizaje();
        cargarCombos();
    }

    private void cargarDatosFinanciera() {
        this.listFinanciera = daoCmi.getCmiByPerspectiva(EnumPerspectiva.Financiera.getId());
    }

    private void cargarDatosCliente() {
        this.listCliente = daoCmi.getCmiByPerspectiva(EnumPerspectiva.Cliente.getId());
    }

    private void cargarDatosProceso() {
        this.listProceso = daoCmi.getCmiByPerspectiva(EnumPerspectiva.Procesos.getId());
    }
    
    private void cargarDatosAprendizaje() {
        this.listAprendizaje = daoCmi.getCmiByPerspectiva(EnumPerspectiva.Aprendizaje.getId());
    }

    public void seleccionar(Cmi empresa) {
        this.current = empresa;
    }

    public void seleccionarPersectiva(Integer idPerspectiva) {
        this.idPerspectiva = idPerspectiva;
        
        
        
        
    }

    public void prepareCreate() {

        current = new Cmi();
        idFrecuencia = null;
        idNivelPadre = null;
        idNivelHijo = null;
        idResponsable = null;

        if (idPerspectiva == EnumPerspectiva.Financiera.getId()) {
            cargarDatosFinanciera();
        }
        if (idPerspectiva == EnumPerspectiva.Cliente.getId()) {
            cargarDatosCliente();
        }
        if (idPerspectiva == EnumPerspectiva.Procesos.getId()) {
            cargarDatosProceso();
        }
        if (idPerspectiva == EnumPerspectiva.Aprendizaje.getId()) {
            cargarDatosAprendizaje();
        }

    }

    public void create() {
        try {

            current.setFrecuencia(new Frecuencia(idFrecuencia));
            current.setNivelOperativo(new NivelOperativo(idNivelPadre));
            current.setIdNivelHijo(idNivelHijo);
            current.setEmpleado(new Empleado(idResponsable));

            if (idPerspectiva == EnumPerspectiva.Financiera.getId()) {
                current.setPerspectiva(new Perspectiva(EnumPerspectiva.Financiera.getId()));
            }
            if (idPerspectiva == EnumPerspectiva.Cliente.getId()) {
                current.setPerspectiva(new Perspectiva(EnumPerspectiva.Cliente.getId()));
            }
            if (idPerspectiva == EnumPerspectiva.Procesos.getId()) {
                current.setPerspectiva(new Perspectiva(EnumPerspectiva.Procesos.getId()));
            }
            if (idPerspectiva == EnumPerspectiva.Aprendizaje.getId()) {
                current.setPerspectiva(new Perspectiva(EnumPerspectiva.Aprendizaje.getId()));
            }

            if (current.getId() == null) {
                daoCmi.create(current);
            } else {
                daoCmi.edit(current);
            }

            prepareCreate();
            JsfUtil.addSuccessMessage("REGISTRO GUARDADO");
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "ERROR AL GUARDAR REGISTRO");
        }
    }

    public void delete(Integer idPerspectiva, Cmi cmiDelete) {
        
        daoCmi.remove(cmiDelete);
        
        seleccionarPersectiva(idPerspectiva);
        prepareCreate();
        
         JsfUtil.addSuccessMessage("REGISTRO ELIMINADO");
        
        
        
    }

    private void cargarCombos() {
        //Combo frecuencia      
        comboFrecuencia = new ArrayList();
        comboFrecuencia.add(seleccione);
        for (Frecuencia obj : daoFrecuencia.getAll()) {
            comboFrecuencia.add(new SelectItem(obj.getId(), obj.getNombre()));

        }

        //Combo Nivel Jeraquico Padre      
        comboNivelPadre = new ArrayList();
        comboNivelPadre.add(seleccione);
        for (NivelOperativo obj : daoNivelOperativo.getAll()) {
            comboNivelPadre.add(new SelectItem(obj.getId(), obj.getNombre()));

        }
    }

    public void loadCombosByNivel() {
        //Combo cargos subnivel
        comboNivelHijo = new ArrayList();
        for (SelectItem obj : comboNivelPadre) {
            if (obj.getValue() != idNivelPadre) {
                comboNivelHijo.add(new SelectItem(obj.getValue(), obj.getLabel()));
            }
        }

        //Combo Responsable
        comboResponsable = new ArrayList();
        comboResponsable.add(seleccione);
        for (Empleado obj : daoEmpleado.getByNivelJerarquico(idNivelPadre)) {
            comboResponsable.add(new SelectItem(obj.getId(), obj.getNombres() + obj.getApellidos()));

        }
    }

    public void cargarDatosEditar() {
        
        this.idFrecuencia = current.getFrecuencia().getId();
        this.idNivelPadre = current.getNivelOperativo().getId();
        this.idNivelHijo = current.getIdNivelHijo();
        this.idResponsable = current.getEmpleado().getId();
    }

}
