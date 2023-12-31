
package com.mycompany.wangzihaopruebatecnica1.controllers;

import com.mycompany.wangzihaopruebatecnica1.models.Empleados;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zihao Wang
 */
public class PersistenceController {
    /**
     * Creamos un objeto de EmpleadosJpaController
     */
    EmpleadosJpaController emplJPA=new EmpleadosJpaController();
    public void createEmployer(Empleados empleados){
        emplJPA.create(empleados);
    }
    
    /**
     * 
     * @param id Parametro id para indicar que empleado eliminar
     */
    public void deleteEmployer(Long id){
        try{
        emplJPA.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param empleados Parametro de la clase Empleados
     * Metodo para editar un empleado en concreto
     */
    public void editEmployer(Empleados empleados){
        try{
        emplJPA.edit(empleados);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param id Parametro por el cual buscamos un usuario
     * @return Retornamos un empleado
     */
    public Empleados findEmployer(Long id) {
        return emplJPA.findEmpleados(id);
    }
    
    /**
     * 
     * @param cargo Parametro que usaremos para filtrar por cargo
     * @return Retornamos una lista de empleados con el cargo que pasamos por parametro
     */
    public ArrayList<Empleados> findEmployerPosition(String cargo){
        List<Empleados> temp=emplJPA.findEmpleadosPosition(cargo);
        ArrayList empleado=new ArrayList<>(temp);
        return empleado;
    }
    
    /**
     * 
     * @param dni Parametro dni que usaremos para filtrar los empleados
     * @return Retornamos un true si existe y false si no existe ese empleado
     */
    public boolean findEmployerDni(String dni){
        return emplJPA.findEmpleadoDni(dni);
    }
    
    /**
     * 
     * @return Retornamos una lista de todos los empleados de la base de datos
     */
    public ArrayList<Empleados> findAllEmployer(){
        List<Empleados> temp=emplJPA.findEmpleadosEntities();
        ArrayList<Empleados> empleados=new ArrayList<>(temp);
        return empleados;
    }

}
