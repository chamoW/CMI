/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.web.controllers;

import com.triskel.cmi.dal.dao.CargoDao;
import com.triskel.cmi.dal.dao.DepartamentoDao;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.triskel.cmi.dal.dao.EmpleadoDao;
import com.triskel.cmi.dal.model.Cargo;
import com.triskel.cmi.dal.model.Departamento;
import com.triskel.cmi.dal.model.Empleado;
import com.triskel.cmi.web.controllers.util.JsfUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

/**
 *
 * @author wwlopez
 */
@ManagedBean
@ViewScoped
public class EstrategiaController {

    //--------------------------------------------------------------------------
    //-- EJBS Y VARIABLES COMUNES
    //--------------------------------------------------------------------------
    @EJB
    private EmpleadoDao ejbFacade;
    @EJB
    private DepartamentoDao ejbFacadeDepartamento;
    @EJB
    private CargoDao ejbFacadeCargo;
    private Empleado current;
    private List<Empleado> items;
    private List<SelectItem> comboDepartamentos;
    private List<SelectItem> comboCargos;
    private SelectItem seleccione = new SelectItem(null, "Seleccione");
    private Integer idDepartamento;
    private Integer idCargo;

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    //--------------------------------------------------------------------------
    //-- GETTERS / SETTERSS
    //--------------------------------------------------------------------------
    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public Empleado getCurrent() {
        return current;
    }

    public void setCurrent(Empleado current) {
        this.current = current;
    }

    public List<Empleado> getItems() {
        return items;
    }

    public void setItems(List<Empleado> items) {
        this.items = items;
    }

    public List<SelectItem> getComboDepartamentos() {
        return comboDepartamentos;
    }

    public void setComboDepartamentos(List<SelectItem> comboDepartamentos) {
        this.comboDepartamentos = comboDepartamentos;
    }

    public List<SelectItem> getComboCargos() {
        return comboCargos;
    }

    public void setComboCargos(List<SelectItem> comboCargos) {
        this.comboCargos = comboCargos;
    }

    //--------------------------------------------------------------------------
    //-- METODOS
    //--------------------------------------------------------------------------    
    @PostConstruct
    public void inicializar() {
        this.current = new Empleado();
        this.items = ejbFacade.findAll();
        cargarCombos();

    }

    public void seleccionar(Empleado empresa) {
        this.current = empresa;
    }

    public void prepareCreate() {
        current = new Empleado();
        idCargo = null;
        idDepartamento = null;
        items = ejbFacade.findAll();
    }

    public void create() {
        try {
            
            current.setDepartamento(new Departamento(idDepartamento));
            current.setCargo(new Cargo(idCargo));

            if (current.getId() == null) {
                ejbFacade.create(current);
            } else {
                ejbFacade.edit(current);
            }

            prepareCreate();
            JsfUtil.addSuccessMessage("REGISTRO GUARDADO");
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "ERROR AL GUARDAR REGISTRO");
        }
    }

    public String destroy() {
        /*
         * current = (Objetivo) getItems().getRowData(); selectedItemIndex =
         * pagination.getPageFirstItem() + getItems().getRowIndex();
         * performDestroy(); recreatePagination(); recreateModel();
         */
        return "List";
    }

    private void performDestroy() {
        try {
            ejbFacade.remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
                    "com/triskel/cmi/web/controllers/util/Bundle").getString(
                            "ObjetivoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(
                    e,
                    ResourceBundle.getBundle(
                            "com/triskel/cmi/web/controllers/util/Bundle")
                    .getString("PersistenceErrorOccured"));
        }
    }

    private void cargarCombos() {

        //Combo departamentos      
        comboDepartamentos = new ArrayList();
        comboDepartamentos.add(seleccione);
        for (Departamento obj : ejbFacadeDepartamento.findAll()) {
            comboDepartamentos.add(new SelectItem(obj.getId(), obj.getNombre()));
        }

        /*
         //Combo cargos
         comboCargos = new ArrayList();
         comboCargos.add(seleccione);
         for (Cargo obj : ejbFacadeCargo.findAll()) {
         comboCargos.add(new SelectItem(obj.getId(), obj.getNombre()));
         }
         */
    }

    public void setComboCargo() {
        //Combo cargos
        comboCargos = new ArrayList();
        comboCargos.add(seleccione);
        for (Cargo obj : ejbFacadeCargo.getCargoByDepartamento(idDepartamento)) {
            comboCargos.add(new SelectItem(obj.getId(), obj.getNombre()));
        }
    }

}
