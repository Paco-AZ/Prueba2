/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1;

import java.io.Serializable;

/**
 *
 * @author Francisco
 */
public class Prioridad implements Serializable
{
    private int noPrioridad;
    private Cola c;

    public Prioridad()
    {
    }

    public Prioridad(int noPrioridad, Cola c)
    {
        this.noPrioridad = noPrioridad;
        this.c = c;
    }

    /**
     * @return the noPrioridad
     */
    public int getNoPrioridad()
    {
        return noPrioridad;
    }

    /**
     * @param noPrioridad the noPrioridad to set
     */
    public void setNoPrioridad(int noPrioridad)
    {
        this.noPrioridad = noPrioridad;
    }

    /**
     * @return the c
     */
    public Cola getC()
    {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Cola c)
    {
        this.c = c;
    }
    
}
