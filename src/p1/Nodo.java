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
class Nodo<T> implements Serializable
{
    private int et;
    private T obj;
    private Nodo sig;
    private Nodo ant;

    public Nodo(int et, T obj)
    {
        this.et = et;
        this.obj = obj;
    }

    /**
     * @return the et
     */
    public int getEt()
    {
        return et;
    }

    /**
     * @param et the et to set
     */
    public void setEt(int et)
    {
        this.et = et;
    }

    /**
     * @return the obj
     */
    public T getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(T obj)
    {
        this.obj = obj;
    }

    /**
     * @return the sig
     */
    public Nodo getSig()
    {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Nodo sig)
    {
        this.sig = sig;
    }

    /**
     * @return the ant
     */
    public Nodo getAnt()
    {
        return ant;
    }

    /**
     * @param ant the ant to set
     */
    public void setAnt(Nodo ant)
    {
        this.ant = ant;
    }
}
