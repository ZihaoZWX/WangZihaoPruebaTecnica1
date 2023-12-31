package com.mycompany.wangzihaopruebatecnica1.services;

import com.mycompany.wangzihaopruebatecnica1.controllers.PersistenceController;
import com.mycompany.wangzihaopruebatecnica1.models.Empleados;
import java.util.Scanner;

/**
 *
 * @author Zihao Wang
 * Clase para buscar un empleado por posicion
 */
public final class FindPosition {

    /**
     * 
     * Constructor con parametros
     * @param sc
     * @param controller 
     * Constructor que ejecuta la funcion que nos muestra todos los empleados con un cargo concreto
     */
    protected FindPosition(Scanner sc, PersistenceController controller) {
        findPosition(sc,controller);
    }

    /**
     * 
     * Metodo con parametros
     * @param sc
     * @param controller 
     * Metodo que busca por un cargo en concreto y imprime todos los empleados con este cargo por pantalla
     * Instanciamos la clase FindAll para poder saber que empleados tenemos con que cargos hay
     */
    private void findPosition(Scanner sc, PersistenceController controller) {
        String cargo;
        new FindAll(controller);
        do {
            System.out.println("Enter the employee's position");
            cargo = sc.nextLine().toLowerCase().trim();
            if(cargo.isBlank()){
                System.out.println("Error, you must enter some character");
            }else if(controller.findEmployerPosition(cargo).isEmpty()){
                System.out.println("Error, non-existent position");
            }else{
                break;
            }
        } while (true);
        for(Empleados data:controller.findEmployerPosition(cargo)){
            System.out.println(data.toString());
        }
    }

}
