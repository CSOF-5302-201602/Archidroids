/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.RegistroVenta;
import com.losalpes.servicios.IServicioCatalogoMockLocal;
import com.losalpes.servicios.IServicioReporteMockLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;


public class ReporteBean implements Serializable {
  
    /**
     * Relación con la interfaz que provee los servicios necesarios del
     * catálogo.
     */
    @EJB
    private IServicioReporteMockLocal reporte;
    
    
    /**
     * Devuelve una lista con todos los muebles del sistema
     *
     * @return muebles Muebles del sistema
     */
    public ArrayList<RegistroVenta> getReportes() {

        ArrayList<RegistroVenta> reportes= reporte.getReporte(new Date());
         return reportes;
    }
    
    
}
