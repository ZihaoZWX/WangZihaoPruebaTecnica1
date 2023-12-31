
package com.mycompany.wangzihaopruebatecnica1.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Zihao Wang
 * Clase Empleados que implementa Serializable
 * Anotacion de Entity para indicar que es una entidad
 * Anotacion Table para indicar que es una Tabla con nombre empleados
 */
@Entity
@Table(name="empleados")
public class Empleados implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dni",nullable=false)
    private String dni;
    @Column(name = "nombre",nullable=false)
    private String nombre;
    @Column(name = "apellido",nullable=false)
    private String apellido;
    @Column(name = "cargo",nullable=false)
    private String cargo;
    @Column(name = "salario",nullable=false)
    private Double salario;
    @Column(name = "fecha",nullable=false)
    private LocalDate fecha;

    /**
     * Constructor vacio
     */
    public Empleados() {
    }

    /**
     * Constructor con los siguientes parametros
     * @param dni
     * @param nombre
     * @param apellido
     * @param cargo
     * @param salario
     * @param fecha 
     */
    public Empleados(String dni,String nombre, String apellido, String cargo, Double salario, LocalDate fecha) {
        this.dni=dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fecha = fecha;
    }

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return 
     */
    public String getDni() {
        return dni;
    }

    /**
     * 
     * @param dni 
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /**
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * 
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * 
     * @return cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * 
     * @param cargo 
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * 
     * @return salario
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * 
     * @param salario 
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * 
     * @return fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * 
     * @param fecha 
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * 
     * @return Todos los datos de los empleados
     */
    @Override
    public String toString() {
        return "{(id = " + id + ") (dni = "+ dni + ") (nombre = " + nombre + ") (apellido = " + apellido + ") (cargo = " + cargo + ") (salario = " + salario + ") (fecha = " + fecha + ")}";
    }
    
    

}
