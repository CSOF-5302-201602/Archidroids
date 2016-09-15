/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Remote;

@Remote
public interface IServicioReporteMockRemote {
     /**
     * Devuelve el inventario de muebles que se encuentran en el carrito
     * @param date
     * @return inventario Lista con los muebles que se encuentran en el carrito
     */
    public ArrayList<RegistroVenta> getReporte(Date date);
}
