
package com.mycompany.wangzihaopruebatecnica1.services;

import com.mycompany.wangzihaopruebatecnica1.controllers.PersistenceController;
import java.util.Scanner;

/**
 *
 * @author Zihao Wang
 * Clase principal que inicializa el menu principal
 */
public final class CRUD {
    
    /**
     * Constructor que inicializa un metodo
     */
    public CRUD(){
        start();
    }
    
    Scanner sc=new Scanner(System.in);
    PersistenceController controller=new PersistenceController();
    
    /**
     * Metodo Start que inicia el programa
     * Muestra un menu y dependiendo de que numero pongas instancia una clase pasandole ciertos parametros
     */
    private void start() {
        int elecion = 7;
        while (elecion != 0) {
            System.out.println("""
                               =====================================
                               | * * * * * * | ENTER | * * * * * * |
                               =====================================
                               | 0 | EXIT                          |
                               -------------------------------------
                               | 1 | CREATE                        |
                               -------------------------------------
                               | 2 | EDIT                          |
                               -------------------------------------
                               | 3 | DELETE                        |
                               -------------------------------------
                               | 4 | SEARCH BY POSITION            |
                               -------------------------------------
                               | 5 | SEARCH BY ID                  |
                               -------------------------------------
                               | 6 | SHOW ALL EMPLOYEES            |
                               =====================================""");
            if (sc.hasNextInt()) {
                elecion = sc.nextInt();
                sc.nextLine();
                if (elecion <= 6 && elecion >= 0) {
                    switch (elecion) {
                        case 0:
                            sc.close();
                            System.exit(0);
                            break;
                        case 1:
                            new Create(sc,controller);
                            break;
                        case 2:
                            new Edit(sc,controller);
                            break;
                        case 3:
                            new Delete(sc,controller);
                            break;
                        case 4:
                            new FindPosition(sc,controller);
                            break;
                        case 5:
                            new Find(sc,controller);
                            break;
                        case 6:
                            new FindAll(controller);
                            break;
                    }
                } else {
                    System.out.println("Error you must enter a number from 0 to 6");
                }
            } else {
                System.out.println("Error you must enter a number");
                sc.next();
            }
        }
    }
}
