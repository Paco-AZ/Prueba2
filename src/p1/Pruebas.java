/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p1;

import poo.ManArch;

/**
 *
 * @author Francisco
 */
public class Pruebas
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        Ejecucion x = new Ejecucion();
        ManArch.carga(null, "Procesos.dat");
        Proceso a = new Proceso(1, "Brillo", 5);
        Proceso b = new Proceso(1, "Saturno", 3);
        Proceso c = new Proceso(2, "Rojo", 4);
        Proceso d = new Proceso(2, "Amarillo", 4);
        Proceso e = new Proceso(2, "Toronja", 2);
        x.subirProc(a, null);
        x.subirProc(b, null);
        x.subirProc(c, null);
        x.subirProc(d, null);
        x.subirProc(e, null);
        x.subirProc(e, null);
        x.procesar(null);

        System.out.println(x.dispPP(1));
        System.out.println(x.dispPP(2));
        x.quitaProc("Amarill o", null);
        System.out.println(x.dispPP(1));
        System.out.println(x.dispPP(2));
        System.out.println(x.ObtenerSP());
        x.moverProc("Brillo");
        System.out.println(x.dispPP(5));
        x.eliminaPrio(5);
        System.out.println(x.dispPP(5));
    } 

}
