
package com.mycompany.wangzihaopruebatecnica1.services;

import com.mycompany.wangzihaopruebatecnica1.controllers.PersistenceController;
import com.mycompany.wangzihaopruebatecnica1.models.Empleados;
import java.util.Scanner;

/**
 *
 * Clase para editar
 * 
 * @author Zihao Wang
 */
public final class Edit {
    
    /**
     * 
     * Constructor con parametros
     * @param sc Scanner
     * @param controller PersistenceController
     */
    protected Edit(Scanner sc, PersistenceController controller) {
        edit(sc,controller);
    }
    
    /**
     * 
     * Metodo con parametros.
     * Metodo con Menu para poder selecionar que editar.
     * Usaremos la clase Find para poder verificar la existencia del empleado que queremos modificar.
     * Usaremos la clase EmpleadosGetData con diferentes parametros para editar.
     * 
     * @param sc Scanner
     * @param controller PersistenceController
     * 
     */
    private void edit(Scanner sc, PersistenceController controller) {
        Find f=new Find();
        EmpleadosGetData egd=new EmpleadosGetData();
        Empleados empleado = f.find(sc, controller,2);
        int elecion = 6;
        while (elecion != 0) {
            System.out.println("""
                               ====================================
                               | * * * * * * | EDIT | * * * * * * |
                               ====================================
                               | 0 | EXIT                         |
                               ------------------------------------
                               | 1 | EDIT DNI                     |
                               ------------------------------------
                               | 2 | EDIT NAME                    |
                               ------------------------------------
                               | 3 | EDIT LAST NAME               |
                               ------------------------------------
                               | 4 | EDIT POSITION                |
                               ------------------------------------
                               | 5 | EDIT SALARY                  |
                               ------------------------------------
                               | 6 | EDIT DATE                    |
                               ====================================""");
            elecion = sc.nextInt();
            sc.nextLine();
            switch (elecion) {
                case 0:
                    break;
                case 1:
                    empleado.setDni(egd.getNombre(sc,true));
                    break;
                case 2:
                    empleado.setNombre(egd.getNombre(sc,true));
                    break;
                case 3:
                    empleado.setApellido(egd.getApellido(sc,true));
                    break;
                case 4:
                    empleado.setCargo(egd.getCargo(sc,true));
                    break;
                case 5:
                    empleado.setSalario(egd.getSalario(sc,true));
                    break;
                case 6:
                    empleado.setFecha(egd.getDate(sc,empleado));
                    break;
            }
        }
        controller.editEmployer(empleado);
        System.out.println("modified employee");
    }
    
    

}
