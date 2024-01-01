package com.mycompany.wangzihaopruebatecnica1.services;

import com.mycompany.wangzihaopruebatecnica1.controllers.PersistenceController;
import com.mycompany.wangzihaopruebatecnica1.models.Empleados;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * Clase con todos los metodos necesarios con su correspondida verificacion para retornar los datos necesarios para la creacion y edicion de empleados
 * 
 * @author Zihao Wang Clase para obtener los datos necesarios para crear y editar
 */
public class EmpleadosGetData {

    /**
     * Constructor vacio
     */
    protected EmpleadosGetData() {

    }

    private int month;
    private int year;

    /**
     *
     * Metodo con parametros para obtener un dni y verificar que cumplan los requisitos necesarios.
     * Usamos el findEmployerDni creado antes para verificar que el dni es unico.
     *
     * @param sc Scanner
     * @param editar Parametro booleano para identificar una edicion a una creacion
     * @param controller PersistenceController
     * @return dni
     */
    protected String getDni(Scanner sc, boolean editar, PersistenceController controller) {
        String dni;
        String invalidCharacters = ".*[*+{}()=?'¿¡/& %$·\"\\|@#€%<>_:.;,`´].*";
        do {
            System.out.println(editar ? "Enter the new employee's dni" : "Enter the employee's dni");
            dni = sc.nextLine().toUpperCase();
            if (dni.isBlank()) {
                System.out.println("Error, the dni cannot be empty");
            } else if (dni.matches(invalidCharacters)) {
                System.out.println("Error, invalid character detected");
            } else if (dni.length() > 9) {
                System.out.println("Error, the size of the dni cannot be greater than nine");
            } else if (dni.length() < 9) {
                System.out.println("Error, the size of the dni cannot be lower than nine");
            } else if (controller.findEmployerDni(dni)) {
                System.out.println("Error, this employee already exist");
            }
        } while (dni.isBlank() || dni.matches(invalidCharacters) || dni.length() > 9 || dni.length() < 9 || controller.findEmployerDni(dni));
        return dni;
    }

    /**
     *
     * Metodo con parametros que deja libertad a la hora de eligir un nombre para el empleado .
     * Contiene un unico filtro el cual impide que metamos nombres vacios .
     * Se elimina espacios existentes delante y atras del nombre.
     * Evita entrada de caracteres invalidos.
     *
     * @param sc Scanner
     * @param editar Parametro booleano para identificar una edicion a una creacion
     * @return nombre 
     * 
     */
    protected String getNombre(Scanner sc, boolean editar) {
        String nombre;
        do {
            System.out.println(editar ? "Enter the new employee's name" : "Enter the employee name");
            nombre = sc.nextLine().trim();
        } while (nombre.isBlank());
        return nombre;
    }

    /**
     *
     * Metodo con parametros que deja cierta libertad a la hora de eligir un apellido para el empleado .
     * Contiene un unico filtro el cual impide que metamos apellidos vacios .
     * Se elimina espacios existentes delante y atras del apellido.
     * Evita entrada de caracteres invalidos.
     *
     * @param sc Scanner
     * @param editar Parametro booleano para identificar una edicion a una creacion
     * @return apellido 
     * 
     */
    protected String getApellido(Scanner sc, boolean editar) {
        String apellido;
        do {
            System.out.println(editar ? "Enter the employee's new last name" : "Enter the employee's last name");
            apellido = sc.nextLine().trim();
        } while (apellido.isBlank());
        return apellido;
    }

    /**
     *
     * Metodo con parametros que deja cierta libertad a la hora de eligir un cargo para el empleado.
     * Contiene un unico filtro el cual impide que metamos cargos vacios. 
     * Se elimina espacios existentes delante y atras del cargo.
     * Evita entrada de caracteres invalidos.
     *
     * @param sc Scanner
     * @param editar Parametro booleano para identificar una edicion a una creacion
     * @return cargo 
     * 
     */
    protected String getCargo(Scanner sc, boolean editar) {
        String cargo;
        do {
            System.out.println(editar ? "Enter the employee's new position" : "Enter the employee's position");
            cargo = sc.nextLine().toLowerCase().trim();
        } while (cargo.isBlank());
        return cargo;
    }

    /**
     *
     * Metodo con parametros que retorna un salario con unos filtros para que no sea cero o un numero
     * Evita entrada de caracteres invalidos.
     *
     * @param sc Scanner
     * @param editar Parametro booleano para identificar una edicion a una creacion
     * @return salario 
     * 
     */
    protected Double getSalario(Scanner sc, boolean editar) {
        Double salario;
        while (true) {
            System.out.println("Enter the employee's salary");
            try {
                String input = sc.nextLine();
                salario = Double.valueOf(input);

                if (salario <= 0.0) {
                    System.out.println("Error, salary cannot be zero");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, you must put a number");
            }
        }
        return salario;
    }

    /**
     *
     * Metododo con parametros que retorna un año con un filtrado para que el año no sea despues de hoy
     * Evita entrada de caracteres invalidos.
     *
     * @param sc Scanner
     * @return year 
     * 
     */
    protected int getYear(Scanner sc) {
        String input;
        while (true) {
            System.out.println("Enter the new year");
            try {
                input = sc.nextLine();
                year = Integer.parseInt(input);
                if (year <= 0) {
                    System.out.println("Error, the year cannot be lower or equal than zero");
                } else if (year > LocalDate.now().getYear()) {
                    System.out.println("Error, the year cannot be after this year");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, you must enter a number");
            }
        }

        return year;
    }

    /**
     *
     * Metodo con parametros que retorna un mes y controla que este no sea 0 o menor o mayor que 12
     * Evita entrada de caracteres invalidos.
     *
     * @param sc Scanner
     * @return month 
     * 
     */
    protected int getMonth(Scanner sc) {
        String input;
        while (true) {
            System.out.println("Enter the new month");
            try {
                input = sc.nextLine();
                month = Integer.parseInt(input);
                if (month <= 0) {
                    System.out.println("Error, the month cannot be lower or equal than zero");
                } else if (month > 12) {
                    System.out.println("Error, the month cannot be greater than twelve");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, you must enter a number");
            }
        }
        return month;
    }

    /**
     * 
     * Metodo con parametros que retorna un dia filtrando y validando que el dia exista.
     * Evita entrada de caracteres invalidos.
     * 
     * @param sc Scanner
     * @param empleado Empleado
     * @return day
     * 
     */
    protected int getDay(Scanner sc, Empleados empleado) {
        Validaciones validar = new Validaciones();
        String input;
        int day;
        while (true) {
            try {
                System.out.println("Enter the new day");
                input = sc.nextLine();
                day = Integer.parseInt(input);
                if (day <= 0) {
                    System.out.println("Error, the month cannot be lower or equal than zero");
                } else if (validar.validarDia(day, month, year)) {
                    System.out.println("Error, that day does not exist in that month");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, you must enter a number");
            }
        }
        return day;
    }
    
    /**
     * 
     * Metodo con parametros que ejecuta los otros metodos asegurando la existencia de la fecha y entrada correcta de datos.
     * Se valida que no sea anterior al dia actual.
     * 
     * @param sc Scanner
     * @param empleado Empleado
     * @return LocalDate
     * 
     */
    protected LocalDate getDate(Scanner sc, Empleados empleado){
        LocalDate date;
        while(true){
            date=LocalDate.of(getYear(sc),getMonth(sc),getDay(sc,empleado));
            if(date.isAfter(LocalDate.now())){
                System.out.println("Error, the date cannot be after now");
            }else {
                break;
            }
        }
        return date;
    }

}
