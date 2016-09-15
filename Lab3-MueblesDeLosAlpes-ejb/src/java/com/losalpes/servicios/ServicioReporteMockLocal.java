/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;


@Stateless
public class ServicioReporteMockLocal implements IServicioReporteMockLocal,IServicioReporteMockRemote{

     /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
   
    private IServicioPersistenciaMockLocal persistencia;
    
    
    /**
     * Lista con registro de ventas de muebles del carrito
     */
    private ArrayList<RegistroVenta> registroVenta;

    public ServicioReporteMockLocal() {
        persistencia=ServicioPersistenciaMock.getInstance();
        this.registroVenta = new ArrayList<RegistroVenta>();
    }
    
    
    
    
    
    @Override
    public ArrayList<RegistroVenta> getReporte(Date date) {
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        
      ArrayList<RegistroVenta> registros=(ArrayList<RegistroVenta>) persistencia.findAll(RegistroVenta.class);
      System.out.println("size "+registros.size());
        for (int i = 0; i < registros.size(); i++) {
            cal.setTime(registros.get(i).getFechaVenta());
           if(month==cal.get(Calendar.MONTH)){
            registroVenta.add(registros.get(i));
            }
        }
        return registroVenta;
    }

    
}
