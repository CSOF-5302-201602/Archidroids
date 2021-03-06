/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ManejadorVendedores.java,v 1.1 Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Taller 1 - anotaciones
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package mundo;

import anotaciones.Cargar;
import anotaciones.Driver;
import anotaciones.Logg;
import anotaciones.NoInit;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Clase encargada de de manejar la creación, eliminación y búsqueda de los vendedores de MLA
 */
public class ManejadorVendedores {

    /**
     * Lista de vendedores de MLA
     */
    @Cargar
    private ArrayList<Vendedor> vendedores;

    /**
     * Id generado para los nuevos muebles
     */
    private int idGenerator;

    public ManejadorVendedores() {
    }

    /**
     * Retorna la lista de vendedores
     * @return
     */
     @Logg
    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    /**
     * Crea un nuevo vendedor y lo retorna
     * @return
     */
     @Logg
    public Vendedor nuevoVendedor() {
        Vendedor nuevo = (Vendedor)Driver.instanciar(Vendedor.class);
        
        for (Field f : Vendedor.class.getDeclaredFields()) {       
           if (f.isAnnotationPresent(NoInit.class))      
            nuevo.setId(idGenerator++);        
        }
         
        vendedores.add(nuevo);
        return nuevo;
    }

    /**
     * Busca un vendedor dado su ID
     * @param id
     * @return
     */
     @Logg
    public Vendedor findVendedor(int id) {
        for(int e = 0;e<vendedores.size();e++){
            if(vendedores.get(e).getId()==id){
                return vendedores.get(e);
            }
        }
        return null;
    }

    /**
     * Elimina un vendedor dado su ID
     * @param id
     */
     @Logg
    public void eliminarVendedor(int id) {
        for(int e = 0;e<vendedores.size();e++){
            if(vendedores.get(e).getId()==id){
                vendedores.remove(e);
                return;
            }
        }

    }

}
