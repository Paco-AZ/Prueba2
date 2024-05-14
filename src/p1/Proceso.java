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
public class Proceso implements Serializable
{
    private int noProceso;
    private String nombre;
    private int quantum;

    /**
     *
     * @param noProceso
     * @param nombre
     */
    public Proceso(int noProceso, String nombre, int quantum)
    {
        this.noProceso = noProceso;
        this.nombre = nombre;
        this.quantum = quantum;
    }

    public Proceso()
    {
    }

    /**
     * @return the noProceso
     */
    public int getNoProceso()
    {
        return noProceso;
    }

    /**
     * @param noProceso the noProceso to set
     */
    public void setNoProceso(int noProceso)
    {
        this.noProceso = noProceso;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the quantum
     */
    public int getQuantum()
    {
        return quantum;
    }

    /**
     * @param quantum the quantum to set
     */
    public void setQuantum(int quantum)
    {
        this.quantum = quantum;
    }
}
