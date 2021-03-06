/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Vendedor.java,v 1.1 Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Taller 1 - anotaciones
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package mundo;

import anotaciones.Init;
import anotaciones.NoInit;
import anotaciones.PostConstructor;

/**
 * Entidad que representa a un vendedor de MLA
 */
@Init(String="-- Vacio --", Integer=-1)
public class Vendedor
{

    /**
     * Id del vendedor. Tiene que ser único.
     */ 
    @NoInit()
    private int id;

    /**
     * Nombres del vendedor.
     */
    private String nombres;

    /**
     * Apellidos del vendedor
     */
    private String apellidos;

    /**
     * Sexo del vendedor
     */
    private String sexo;

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }
    
    @PostConstructor
    public void postConstructorVendedor() {
        if(nombres == null || apellidos == null) {
            System.out.println("ERROR: El objeto Vendedor no fue inicializado correctamente");
        } else {
            System.out.println("El objeto Vendedor fue inicializado correctamente");
        }
    }
}
