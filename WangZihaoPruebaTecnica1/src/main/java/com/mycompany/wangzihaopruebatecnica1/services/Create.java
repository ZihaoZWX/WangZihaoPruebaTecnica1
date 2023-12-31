package com.mycompany.wangzihaopruebatecnica1.services;

import com.mycompany.wangzihaopruebatecnica1.controllers.PersistenceController;
import com.mycompany.wangzihaopruebatecnica1.models.Empleados;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Zihao Wang
 * Clase para crear
 */
public final class Create {

    /**
     * 
     * Constructor con los parametros 
     * @param sc 
     * @param controller
     */
    protected Create(Scanner sc, PersistenceController controller) {
        create(sc, controller);
    }

    /**
     * 
     * @param sc
     * @param controller
     * Metodo para crear un empleado.
     * Usamos la clase EmpleadosGetData para obtener los datos necesarios pasandoles unos parametros
     */
    private void create(Scanner sc, PersistenceController controller) {
        EmpleadosGetData egd = new EmpleadosGetData();
        LocalDate date = LocalDate.now();
        Empleados empleado = new Empleados(egd.getDni(sc, false,controller),egd.getNombre(sc, false), egd.getApellido(sc, false), egd.getCargo(sc, false), egd.getSalario(sc, false), date);
        controller.createEmployer(empleado);
        System.out.println("created employee");
    }

}
