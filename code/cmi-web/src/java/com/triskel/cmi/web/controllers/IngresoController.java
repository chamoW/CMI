/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.web.controllers;

import com.triskel.cmi.dal.dao.CmiDao;
import com.triskel.cmi.dal.dao.DatosDao;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.triskel.cmi.dal.dao.PerspectivaDao;
import com.triskel.cmi.dal.model.Cmi;
import com.triskel.cmi.dal.model.Datos;
import com.triskel.cmi.dal.model.Frecuencia;
import com.triskel.cmi.dal.model.Perspectiva;
import com.triskel.cmi.dal.util.EnumFrecuencia;
import com.triskel.cmi.web.controllers.util.JsfUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author wwlopez
 */
@ManagedBean
@ViewScoped
public class IngresoController {

    //--------------------------------------------------------------------------
    //-- EJBS
    //--------------------------------------------------------------------------
    @EJB
    private DatosDao ejbFacade;

    @EJB
    private CmiDao daoCmi;
    @EJB
    private PerspectivaDao daoPerspectiva;

    //--------------------------------------------------------------------------
    //-- VARIABLES COMUNES
    //--------------------------------------------------------------------------
    private SelectItem seleccione = new SelectItem(null, "Seleccione");
    private Integer idPerspectiva;
    private Perspectiva selectedPerspectiva;
    private List<Perspectiva> listPerspectiva = new ArrayList<>();

    private Cmi selectedCmi;
    private List<Cmi> listCmi = new ArrayList<>();

    private Datos current;
    private List<Datos> items;

    //--------------------------------------------------------------------------
    //-- GETTERS / SETTERSS
    //--------------------------------------------------------------------------
    public List<Datos> getItems() {
        return items;
    }

    public void setItems(List<Datos> items) {
        this.items = items;
    }

    public Perspectiva getSelectedPerspectiva() {
        return selectedPerspectiva;
    }

    public void setSelectedPerspectiva(Perspectiva selectedPerspectiva) {
        this.selectedPerspectiva = selectedPerspectiva;
    }

    public Cmi getSelectedCmi() {
        return selectedCmi;
    }

    public void setSelectedCmi(Cmi selectedCmi) {
        this.selectedCmi = selectedCmi;
    }

    public Datos getCurrent() {
        return current;
    }

    public void setCurrent(Datos current) {
        this.current = current;
    }

    public SelectItem getSeleccione() {
        return seleccione;
    }

    public void setSeleccione(SelectItem seleccione) {
        this.seleccione = seleccione;
    }

    public Integer getIdPerspectiva() {
        return idPerspectiva;
    }

    public void setIdPerspectiva(Integer idPerspectiva) {
        this.idPerspectiva = idPerspectiva;
    }

    public List<Perspectiva> getListPerspectiva() {
        return listPerspectiva;
    }

    public void setListPerspectiva(List<Perspectiva> listPerspectiva) {
        this.listPerspectiva = listPerspectiva;
    }

    public List<Cmi> getListCmi() {
        return listCmi;
    }

    public void setListCmi(List<Cmi> listCmi) {
        this.listCmi = listCmi;
    }

    //--------------------------------------------------------------------------
    //-- METODOS
    //--------------------------------------------------------------------------    
    @PostConstruct
    public void inicializar() {
        this.current = new Datos();
        this.listPerspectiva = daoPerspectiva.findAll();
        this.selectedCmi = null;
        this.items = null;

        cargarCombos();
    }

    public void onRowSelect(SelectEvent event) {
        this.listCmi = daoCmi.getCmiByPerspectiva(selectedPerspectiva.getId());
        this.selectedCmi = null;
        this.items = null;
        this.current = new Datos();

        System.out.println("selectedPerspectiva: " + selectedPerspectiva);
    }

    public void onRowSelectCmi(SelectEvent event) {
        System.out.println("selectedCmi: " + selectedCmi);

        prepareDatos();

        asignarDatos(selectedCmi.getFrecuencia());

    }

    public void seleccionarPersectiva(Integer idPerspectiva) {
        this.idPerspectiva = idPerspectiva;
    }

    public void create() {
        try {
            if (current.getId() == null) {
                ejbFacade.create(current);
            } else {
                ejbFacade.edit(current);
            }

            prepareDatos();
            asignarDatos(selectedCmi.getFrecuencia());

            JsfUtil.addSuccessMessage("REGISTRO GUARDADO");
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "ERROR AL GUARDAR REGISTRO");
        }
    }

    private void cargarCombos() {

    }

    public void prepareDatos() {
        current = new Datos();
        List<Datos> listTmp = ejbFacade.getByCmiId(selectedCmi.getId());

        if (listTmp != null) {
            items = new ArrayList<>();
            for (Datos objTmp : listTmp) {
                Integer semaforo = generarSemaforo(objTmp.getValor(), objTmp.getCmi().getMeta(), objTmp.getCmi().getMinimo());
                objTmp.setSemaforoAux(semaforo);
                items.add(objTmp);
            }
        }
    }

    private void asignarDatos(Frecuencia frecuencia) {
        Integer ultimo = retornarUltimaSecuencia();
        String descripcion = asignarDescripcion(frecuencia.getId(), ultimo);

        this.current.setSecuencia(ultimo);
        this.current.setDescripcion(descripcion);
        this.current.setCmi(new Cmi(selectedCmi.getId()));
    }

    public void delete(Datos datoDelete) {

        ejbFacade.remove(datoDelete);
        prepareDatos();

        JsfUtil.addSuccessMessage("REGISTRO ELIMINADO");

    }

    private String asignarDescripcion(Integer frecuenciaId, Integer ultimo) {

        String descripcion = null;
        if (frecuenciaId == EnumFrecuencia.ANUAL.getId()) {
            descripcion = "AÑO " + ultimo;
        }

        if (frecuenciaId == EnumFrecuencia.SEMESTRAL.getId()) {
            descripcion = "SEMESTRE " + ultimo;
        }

        if (frecuenciaId == EnumFrecuencia.TRIMESTRAL.getId()) {
            descripcion = "TRIMESTRE " + ultimo;
        }
        if (frecuenciaId == EnumFrecuencia.BIMESTRAL.getId()) {
            descripcion = "BIMESTRE " + ultimo;
        }
        if (frecuenciaId == EnumFrecuencia.MENSUAL.getId()) {
            descripcion = "MES " + ultimo;
        }

        if (frecuenciaId == EnumFrecuencia.QUINCENAL.getId()) {
            descripcion = "QUINCENA " + ultimo;
        }
        if (frecuenciaId == EnumFrecuencia.SEMANAL.getId()) {
            descripcion = "SEMANA " + ultimo;
        }

        if (frecuenciaId == EnumFrecuencia.DIARIO.getId()) {
            descripcion = "DIA " + ultimo;
        }

        return descripcion;
    }

    private Integer retornarUltimaSecuencia() {
        Integer ultimo = ejbFacade.getUltimoByCmiId(selectedCmi.getId());
        if (ultimo == null || ultimo == 0) {
            ultimo = 1;
        } else {
            ultimo++;
        }

        return ultimo;
    }

    private Integer generarSemaforo(Double valor, Double meta, Double minimo) {
        Integer semaforo = null;

        // Para semaforizacion ascendente
        if (meta > minimo) {
            if (valor >= meta) {
                semaforo = 1;
            } else if (valor < meta && valor > minimo) {
                semaforo = 0;
            } else if (valor <= minimo) {
                semaforo = -1;
            }
        } else {
            // Para semaforizacion descendente
            if (valor <= meta) {
                semaforo = 1;
            } else if (valor > meta && valor < minimo) {
                semaforo = 0;
            } else if (valor >= minimo) {
                semaforo = -1;
            }
        }

        return semaforo;
    }
}
