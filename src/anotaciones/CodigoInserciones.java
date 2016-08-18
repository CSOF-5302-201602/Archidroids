/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: CodigoInserciones.java,v 1.1 Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Taller 1 - anotaciones
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package anotaciones;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.io.File;
import java.util.logging.SimpleFormatter;

/**
 * Clase encargada de contener el código de las inserciones El nombre de cada
 * método debe corresponder con el de la clase que representa
 */
public class CodigoInserciones {

    /**
     * Método invocado en la insercion de código hecha a los métodos anotados
     * con @Init
     *
     * @param instance Instancia desde que se invoca este método
     * @param claseRepresentada Clase a la que representa el proxý que hizo la
     * invocación del método
     * @param annotacion Informacion de la anotación hecha sobre el método que
     * invoca a este
     * @param method Método que fua anotado con @Init
     */
    public static void Init(Object instance, Class claseRepresentada, Annotation annotacion, Method method) throws Exception {
        Init c = (Init) annotacion;
        for (Field f : claseRepresentada.getDeclaredFields()) {
            try {
                f.setAccessible(true);
                if (f.getType().equals(Integer.TYPE)) {
                    if (f.isAnnotationPresent(NoInit.class)) {
                        return;
                    } else {
                        f.set(instance, c.Integer());
                    }

                } else if (f.getType().equals(Double.TYPE)) {
                    if (f.isAnnotationPresent(NoInit.class)) {
                        return;
                    } else {
                        f.set(instance, c.Double());
                    }

                } else if (f.getType().equals(Character.TYPE)) {
                    if (f.isAnnotationPresent(NoInit.class)) {
                        return;
                    } else {
                        f.set(instance, c.Char());
                    }

                } else if (f.getType().equals(String.class)) {
                    if (f.isAnnotationPresent(NoInit.class)) {
                        return;
                    } else {
                        f.set(instance, c.String());
                    }

                } else if (f.getType().equals(Boolean.TYPE)) {
                    if (f.isAnnotationPresent(NoInit.class)) {
                        return;
                    } else {
                        f.set(instance, c.Boolean());
                    }

                } else if (f.getType().equals(Float.TYPE)) {
                    if (f.isAnnotationPresent(NoInit.class)) {
                        return;
                    } else {
                        f.set(instance, c.Float());
                    }

                } else if (f.getType().equals(Long.TYPE)) {
                    if (f.isAnnotationPresent(NoInit.class)) {
                        return;
                    } else {
                        f.set(instance, c.Long());
                    }
                }

            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
    }

    /**
     * Metodo de imprimir logs
     *
     * @param method
     * @throws IOException
     */
    public static void Logg(Object instance, Class claseRepresentada, Annotation annotacion, Method method) throws IOException {

        Logger logger = Logger.getLogger("myLogger");
        FileHandler fh = null;
        File file = new File("./src/mundo/method.log");
        if (!file.exists()) {
            fh = new FileHandler("./src/mundo/method.log");
            logger.addHandler(fh);
        }

        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        logger.info(method.getDeclaringClass().getName() + " " + method.getName());

    }

}
