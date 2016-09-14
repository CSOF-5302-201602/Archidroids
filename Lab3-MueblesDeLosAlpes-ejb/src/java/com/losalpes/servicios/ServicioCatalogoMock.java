/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioCatalogoMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Implementación de los servicios de catalogo
 * 
 */
@Stateless
public class ServicioCatalogoMock implements IServicioCatalogoMockRemote, IServicioCatalogoMockLocal {

     /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    private IServicioPersistenciaMockLocal persistencia;

    /**
     * Lista con los muebles del carrito
     */
    private ArrayList<Mueble> arrMuebles;

   
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioCatalogoMock()
    {
        arrMuebles = new ArrayList<Mueble>();
        persistencia=new ServicioPersistenciaMock();
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

     /**
     * Verifica y registra un mueble en el sistema
     * @param m Mueble a persistir
     * @throws com.losalpes.excepciones.OperacionInvalidaException
     */
    @Override
     public void agregarMueble(Mueble m)throws OperacionInvalidaException
    {
        try
        {
            if(m.getReferencia()!=0)
            {
            persistencia.create(m);
            }
            else
            {
                throw new OperacionInvalidaException("El número de documento no es válido");
            }
        }
        catch (OperacionInvalidaException ex)
        {
            throw new OperacionInvalidaException(ex.getMessage());
        }
    }
 
   /**
     * Elimina un mueble del sistema dado su id
     * @param id identificador del mueble
     * @throws OperacionInvalidaException Excepción que es lanzada en caso de ocurrir un error
     */
    @Override
    public void eliminarMueble(long id) throws OperacionInvalidaException
    {
        try
        {
        Mueble u=(Mueble) persistencia.findById(Mueble.class, id);
        persistencia.delete(u);
        }
        catch(OperacionInvalidaException e)
        {
            throw new OperacionInvalidaException("Ocurrió un error al momento de eliminar");
        }
    }

    /**
     * Devuelve los muebles del sistema
     * @return muebles Lista con todos los clientes del sistema
     */
    @Override
    public List<Mueble> darMuebles()
    {
        return(ArrayList<Mueble>) persistencia.findAll(Mueble.class);
    }

    /**
     * Remueve un mueble del carrito de compra
     * @param mueble Mueble a remover 
     */
    @Override
    public void removerEjemplarMueble(long id)
    {

        Mueble foundItem = null;
        Mueble item;
        for(int i= 0, max= arrMuebles.size(); i < max; i++)
        {
            item = (Mueble)arrMuebles.get(i);
            if (item.getReferencia() == id)
            {
                item.reducirCantidad();
                foundItem = item;
                break;
            }
        }       
    }
    
}
