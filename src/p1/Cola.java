/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1;

import cjb.ci.Mensajes;
import java.io.Serializable;

/**
 *
 * @author Francisco
 */
class Cola implements Serializable
{

    private Nodo atras;

    /**
     * @return the atras
     */
    public Nodo getAtras()
    {
        return atras;
    }

    /**
     * @param atras the atras to set
     */
    public void setAtras(Nodo atras)
    {
        this.atras = atras;
    }

    public void inserta(Nodo n)
    {
        if (atras == null)
        {
            atras = n;
            atras.setSig(atras);
        } else
        {
            n.setSig(atras.getSig());
            atras.setSig(n);
            atras = n;
        }
    }

    public Nodo elimina()
    {
        Nodo n = null;
        if (atras != null)
        {
            n = atras.getSig();
            if (n == atras)
            {
                atras = null;
                n.setSig(null);
            } else
            {
                atras.setSig(n.getSig());
                n.setSig(null);
            }
        } else
        {
            System.out.println("Cola vacia");
        }
        return n;
    }

    public Nodo eliminaE(String s)//3
    {
        Nodo n = null;
        Nodo m;
        Nodo a = elimina();
        if (!(((Proceso) a.getObj()).getNombre().equals(s)))
        {
            m = new Nodo(a.getEt(), new Proceso(((Proceso) a.getObj()).getNoProceso(), ((Proceso) a.getObj()).getNombre(), ((Proceso) a.getObj()).getQuantum()));
            inserta(a);
            do
            {
                a = elimina();
                if ((((Proceso) a.getObj()).getNombre().equals(s)))
                {
                    n = a;
                    a = elimina();
                }
                inserta(a);
            } while (!((Proceso) m.getObj()).getNombre().equals(((Proceso) atras.getSig().getObj()).getNombre()));

        } else
        {
            n = a;
        }
        return n;
    }

    public String desp()
    {
        Nodo a = null;
        Nodo b = atras;
        String s = "";
        int z = 0;
        while (!b.equals(a))
        {
            a = elimina();
            s += (++z) + " " + ((Proceso) a.getObj()).getNombre() + "\n";
            inserta(a);
        }
        return s;
    }

    public String despPP()
    {
        String c = "No hay ningun proceso siguiente";
        Nodo n = null;
        Nodo m;
        if (atras != null)
        {
            Nodo a = elimina();
            c = ((Proceso) a.getObj()).getNombre();
            m = new Nodo(a.getEt(), new Proceso(((Proceso)a.getObj()).getNoProceso(),((Proceso)a.getObj()).getNombre(),((Proceso)a.getObj()).getQuantum()));
            inserta(a);
            do
            {
                a = elimina();
                inserta(a);
            } while (!((Proceso) m.getObj()).getNombre().equals(((Proceso) atras.getSig().getObj()).getNombre()));
        }
        return c;
    }
}
