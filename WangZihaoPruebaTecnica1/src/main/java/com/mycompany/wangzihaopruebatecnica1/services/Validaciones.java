
package com.mycompany.wangzihaopruebatecnica1.services;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zihao Wang
 * Clase en la cual validamos la fecha
 */
public class Validaciones {
    
    /**
     * 
     * Metodo con parametros
     * @param day
     * @param month
     * @param year
     * @return Boolean
     * Metodo que retorna un false si en ese mes existe ese dia y true si no existe
     */
    protected boolean validarDia(int day, int month,int year){
        Map<Integer,Integer> diaMes =new HashMap<>();
        diaMes.put(1,31);
        if(year%4==0){
            diaMes.put(2,29);
        }else{
            diaMes.put(2,28);
        }
        diaMes.put(3,31);
        diaMes.put(4,30);
        diaMes.put(5,31);
        diaMes.put(6,30);
        diaMes.put(7,31);
        diaMes.put(8,31);
        diaMes.put(9,30);
        diaMes.put(10,31);
        diaMes.put(11,30);
        diaMes.put(12,31);
        int diaMax=diaMes.get(month);
        System.out.println(diaMax);
        if(day>diaMax){
            return true;
        }else{
            return false;
        }
    }
    
}
