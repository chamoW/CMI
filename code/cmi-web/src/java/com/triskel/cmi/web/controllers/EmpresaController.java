/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.web.controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.triskel.cmi.dal.dao.EmpresaDao;

import com.triskel.cmi.dal.model.Empresa;

import com.triskel.cmi.web.controllers.util.JsfUtil;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;

/**
 *
 * @author wwlopez
 */
@ManagedBean
@ViewScoped
public class EmpresaController {
    
    @EJB
    private EmpresaDao ejbFacade;    
    private Empresa current;
    private List<Empresa> items;
    

    @PostConstruct
    public void inicializar() {
        this.current = new Empresa();
        this.items = ejbFacade.findAll();

    }

    public Empresa getCurrent() {
        return current;
    }

    public void setCurrent(Empresa current) {
        this.current = current;
    }

    public List<Empresa> getItems() {
        return items;
    }

    public void setItems(List<Empresa> items) {
        this.items = items;
    }

    
    
    

    public void seleccionar(Empresa empresa) {
        this.current = empresa;

    }

    public void prepareList() {
        items = ejbFacade.findAll();

    }

    public void prepareCreate() {
        current = new Empresa();
        items = ejbFacade.findAll();

        //prepareList();
        // return "Create";
    }

    public void create() {
        try {

            ejbFacade.create(current);
            prepareCreate();

            JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
                    "com/triskel/cmi/web/controllers/util/Bundle")
                    .getString("ObjetivoCreated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(
                    e,
                    ResourceBundle.getBundle(
                            "com/triskel/cmi/web/controllers/util/Bundle")
                    .getString("PersistenceErrorOccured"));
        }
    }

    public void edit() {
        try {

            ejbFacade.edit(current);
            prepareCreate();

            JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
                    "com/triskel/cmi/web/controllers/util/Bundle")
                    .getString("ObjetivoCreated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(
                    e,
                    ResourceBundle.getBundle(
                            "com/triskel/cmi/web/controllers/util/Bundle")
                    .getString("PersistenceErrorOccured"));
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
    
    
    
    
}
