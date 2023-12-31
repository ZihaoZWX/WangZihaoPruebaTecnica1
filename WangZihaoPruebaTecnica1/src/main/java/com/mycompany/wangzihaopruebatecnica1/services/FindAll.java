package com.mycompany.wangzihaopruebatecnica1.services;

import com.mycompany.wangzihaopruebatecnica1.controllers.PersistenceController;
import com.mycompany.wangzihaopruebatecnica1.models.Empleados;
import java.util.ArrayList;

/**
 *
 * Clase que usamos para ver todos los empleados
 * @author Zihao Wang
 */
public final class FindAll {

    /**
     * 
     * Constructor que ejecuta el metodo que nos muestra los empleados
     * @param controller PersistenceController
     */
    protected FindAll(PersistenceController controller) {
        findAll(controller);
    }
    
    /**
     * 
     * Metodo que busca por id y nos muestra todos los Empleados que hay en nuestra base de datos
     * @param controller PersistenceController
     */
    private void findAll(PersistenceController controller) {
        ArrayList<Empleados> empleado = controller.findAllEmployer();
        if(controller.findAllEmployer().isEmpty()){
            System.out.println("Error, no records created in the table");
        }else{
            for (Empleados data : empleado) {
            System.out.println(data);
        }
        }
        
    }
    
}
