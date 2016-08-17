/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anotaciones;

import java.lang.annotation.*;
/**
 * @author jc.caceres
 * Punto C
 * Declare una anotación NoInit y realice los cambios necesarios para su funcionamiento. 
 * Todo atributo anotado con esta anotación no puede ser alterado por la “ejecucion” de una anotación Init. 
 * Anote los atributos ID de las clases Mueble y Vendedor, pues ningun objeto puede cambiar su ID por las restricciones de negocio.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
public @interface NoInit {
    
} 
