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
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author wwlopez
 */
@ManagedBean
@ViewScoped
public class DashBoardController {

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
    private Integer idPerspectiva;
    private Perspectiva selectedPerspectiva;
    private List<Perspectiva> listPerspectiva = new ArrayList<>();

    private Cmi selectedCmi;
    private List<Cmi> listCmi = new ArrayList<>();

    private List<Datos> items;

    //Graficos
    private BarChartModel barModel;
    private PieChartModel pieModel1;
    private BubbleChartModel bubbleModel2;
    private MeterGaugeChartModel meterGaugeModel1;

    //--------------------------------------------------------------------------
    //-- GETTERS / SETTERSS
    //--------------------------------------------------------------------------
    public MeterGaugeChartModel getMeterGaugeModel1() {
        return meterGaugeModel1;
    }

    public BubbleChartModel getBubbleModel2() {
        return bubbleModel2;
    }

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

    public BarChartModel getBarModel() {
        return barModel;
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    //--------------------------------------------------------------------------
    //-- METODOS
    //--------------------------------------------------------------------------    
    @PostConstruct
    public void inicializar() {

        this.listPerspectiva = daoPerspectiva.findAll();
        this.selectedCmi = null;
        this.items = null;
    }

    public void onRowSelect(SelectEvent event) {
        this.listCmi = daoCmi.getCmiByPerspectiva(selectedPerspectiva.getId());
        this.selectedCmi = null;
        this.items = null;

        System.out.println("selectedPerspectiva: " + selectedPerspectiva);
    }

    public void onRowSelectCmi(SelectEvent event) {
        System.out.println("selectedCmi: " + selectedCmi);

        prepareDatos();
    }

    public void seleccionarPersectiva(Integer idPerspectiva) {
        this.idPerspectiva = idPerspectiva;
    }

    public void prepareDatos() {
        List<Datos> listTmp = ejbFacade.getByCmiId(selectedCmi.getId());

        if (listTmp != null) {
            items = new ArrayList<>();
            for (Datos objTmp : listTmp) {
                Integer semaforo = generarSemaforo(objTmp.getValor(), objTmp.getCmi().getMeta(), objTmp.getCmi().getMinimo());
                objTmp.setSemaforoAux(semaforo);
                items.add(objTmp);
            }
        }

        createGraficos();

    }

    private void createGraficos() {
        createBarModel();
        createPieModel1();
        createBubbleModels();
        createMeterGaugeModels();

    }

    private void createBarModel() {
        int rojo = 0;
        int amarrillo = 0;
        int verde = 0;

        for (Datos objt : items) {
            if (objt.getSemaforoAux() == 1) {
                verde++;
            }
            if (objt.getSemaforoAux() == 0) {
                amarrillo++;
            }
            if (objt.getSemaforoAux() == -1) {
                rojo++;
            }
        }

        barModel = initBarModel(rojo, amarrillo, verde);
        barModel.setLegendPosition("ne");
       

        Axis xAxis = barModel.getAxis(AxisType.X.X);
        xAxis.setLabel("Semaforo");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }

    private void createPieModel1() {
        int rojo = 0;
        int amarrillo = 0;
        int verde = 0;

        for (Datos objt : items) {
            if (objt.getSemaforoAux() == 1) {
                verde++;
            }
            if (objt.getSemaforoAux() == 0) {
                amarrillo++;
            }
            if (objt.getSemaforoAux() == -1) {
                rojo++;
            }
        }

        pieModel1 = new PieChartModel();
        pieModel1.setLegendPosition("w");
        pieModel1.setShowDataLabels(true);
        pieModel1.setSeriesColors("cc6666,E7E658,66cc66");
        pieModel1.set("Rojo", rojo);
        pieModel1.set("Amarillo", amarrillo);
        pieModel1.set("Verde", verde);
    }

    private void createBubbleModels() {

        int rojo = 0;
        int amarrillo = 0;
        int verde = 0;

        for (Datos objt : items) {
            if (objt.getSemaforoAux() == 1) {
                verde++;
            }
            if (objt.getSemaforoAux() == 0) {
                amarrillo++;
            }
            if (objt.getSemaforoAux() == -1) {
                rojo++;
            }
        }

        bubbleModel2 = initBubbleModel(rojo, amarrillo, verde);
        bubbleModel2.setSeriesColors("cc6666,E7E658,66cc66");
        bubbleModel2.setShadow(false);
        bubbleModel2.setBubbleGradients(true);
        bubbleModel2.setBubbleAlpha(0.8);
        bubbleModel2.getAxis(AxisType.X).setTickAngle(-50);
        Axis yAxis = bubbleModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(100);
        yAxis.setTickAngle(50);
    }

    private void createMeterGaugeModels() {
        meterGaugeModel1 = initMeterGaugeModel();
        meterGaugeModel1.setSeriesColors("cc6666,93b75f,E7E658,66cc66");
        meterGaugeModel1.setShowTickLabels(true);
        meterGaugeModel1.setLabelHeightAdjust(110);
        meterGaugeModel1.setIntervalOuterRadius(100);
    }

    private MeterGaugeChartModel initMeterGaugeModel() {
        int rojo = 0;
        int amarrillo = 0;
        int verde = 0;

        for (Datos objt : items) {
            if (objt.getSemaforoAux() == 1) {
                verde++;
            }
            if (objt.getSemaforoAux() == 0) {
                amarrillo++;
            }
            if (objt.getSemaforoAux() == -1) {
                rojo++;
            }
        }

        Integer mayor;

        if (rojo > amarrillo) {
            if (rojo > verde) {
                mayor = rojo;
                mayor = 25;
            } else {
                mayor = verde;
                mayor = 100;
            }
        } else if (amarrillo > verde) {
           mayor = amarrillo;
           mayor = 75;
        } else {
            mayor = verde;
            mayor = 100;
        }

        List<Number> intervals = new ArrayList<Number>() {
            {
                add(25);
                add(50);
                add(75);
                add(100);
            }
        };

        return new MeterGaugeChartModel(mayor, intervals);
    }

    private BubbleChartModel initBubbleModel(Integer rojo, Integer amarillo, Integer verde) {
        BubbleChartModel model = new BubbleChartModel();

        model.add(new BubbleChartSeries("Rojo", 70, 70, rojo));
        model.add(new BubbleChartSeries("Amarillo", 45, 45, amarillo));
        model.add(new BubbleChartSeries("Verde", 24, 24, verde));

        return model;
    }

    private BarChartModel initBarModel(Integer rojo, Integer amarillo, Integer verde) {
        BarChartModel model = new BarChartModel();

        ChartSeries barRojo = new ChartSeries();
        barRojo.setLabel("Semaforo");
        barRojo.set("Rojo", rojo);
        barRojo.set("Amarrillo", amarillo);
        barRojo.set("Verde", verde);

        model.addSeries(barRojo);

        return model;
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
