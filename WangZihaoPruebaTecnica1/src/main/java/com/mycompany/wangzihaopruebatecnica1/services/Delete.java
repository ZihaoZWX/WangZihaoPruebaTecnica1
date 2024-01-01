package com.mycompany.wangzihaopruebatecnica1.services;

import com.mycompany.wangzihaopruebatecnica1.controllers.PersistenceController;
import java.util.Scanner;

/**
 *
 * Clase para eliminar
 * 
 * @author Zihao Wang
 */
public final class Delete {

    /**
     * 
     * Constructor con parametros
     * @param sc Scanner
     * @param controller PersistenceController
     */
    protected Delete(Scanner sc, PersistenceController controller) {
        delete(sc,controller);
    }

    /**
     * 
     * Metodo con parametros.
     * Instanciamos la clase FindAll para mostrar antes todos los empleados existentes.
     * Ejecutamos en bucle si no se introduce bien los datos.
     * Si se introduce correctamente el bucle para y se elimina un empleado con esa id.
     * 
     * @param sc Scanner
     * @param controller PersistenceController
     */
    private void delete(Scanner sc, PersistenceController controller) {
        Long id;
        String input;
        new FindAll(controller);
        while (true) {
            try {
                System.out.println("Enter the ID of the employee you want to delete");
                input = sc.nextLine();
                id = Long.valueOf(input);
                if (id <= 0) {
                    System.out.println("Error, the id has to be greater than zero");
                } else {
                    controller.deleteEmployer(id);
                    System.out.println("deleted employee");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, you must enter a number");
            }
        }
    }

}
