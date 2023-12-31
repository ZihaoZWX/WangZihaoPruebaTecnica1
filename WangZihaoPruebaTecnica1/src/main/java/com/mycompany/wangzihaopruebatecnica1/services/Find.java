package com.mycompany.wangzihaopruebatecnica1.services;

import com.mycompany.wangzihaopruebatecnica1.controllers.PersistenceController;
import com.mycompany.wangzihaopruebatecnica1.models.Empleados;
import java.util.Scanner;

/**
 *
 * @author Zihao Wang
 * Clase para buscar por id
 */
public final class Find {
    
    /**
     * 
     * Constructor vacio
     */
    public Find(){
        
    }

    /**
     * 
     * Constructor con parametros
     * @param sc
     * @param controller 
     * Ejecuta un metodo que imprime por pantalla
     */
    protected Find(Scanner sc, PersistenceController controller) {
        verFind(sc,controller);
    }
    
    /**
     * 
     * Metodo con parametros
     * @param sc
     * @param controller 
     * Metodo para imprimir el usuario encontrado con el metodo find
     */
    private void verFind(Scanner sc, PersistenceController controller) {
        System.out.println(find(sc, controller,false).toString());
    }

    /**
     * 
     * Metodo con parametros
     * @param sc
     * @param controller
     * @param edit Variable booleana para imprimir mensaje personalizado si es editar o ver
     * @return Empleado
     * Metodo que retorna un empleado con una id concreta
     */
    protected Empleados find(Scanner sc, PersistenceController controller, boolean edit) {
        Long id;
        String input;
        new FindAll(controller);
        while (true) {
            try {
                System.out.println(edit ? "Enter the ID of the employee you want to edit" : "Enter the ID of the employee you want to view");
                input = sc.nextLine();
                id = Long.valueOf(input);
                if (id <= 0) {
                    System.out.println("Error, ID must be greater than zero");
                } else if (controller.findEmployer(id).toString().isEmpty()) {
                    System.out.println("Error, non-existent employee");
                } else {
                    return controller.findEmployer(id);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, you must enter an integer");
            }
        }
    }

}
