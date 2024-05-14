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
public class ListaDCL implements Serializable
{

    private Nodo r;

    /**
     * @return the r
     */
    public Nodo getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Nodo r)
    {
        this.r = r;
    }

    public void inserta(Nodo n)
    {
        if (n != null)
        {
            if (r == null)
            {
                r = n;
                r.setSig(r);
                r.setAnt(r);
            } else
            {
                if (r.getEt() - n.getEt() < 0)
                {
                    n.setSig(r.getSig());
                    n.setAnt(r);
                    r.getSig().setAnt(n);
                    r.setSig(n);
                    r = n;
                } else
                {
                    Nodo a = r;
                    while (a.getSig().getEt() - n.getEt() < 0 && a.getSig() != r)
                    {
                        a = a.getSig();
                    }
                    n.setSig(a.getSig());
                    n.setAnt(a);
                    a.getSig().setAnt(n);
                    a.setSig(n);
                }
            }
        }
    }

    public Nodo eliminaI()
    {
        Nodo b = null;
        if (r != null)
        {
            b = r.getSig();
            if (!r.getSig().equals(r))
            {
                r.setSig(r.getSig().getSig());
                b.getSig().setAnt(r);
                b.setSig(null);
                b.setAnt(null);
            } else
            {
                r.setSig(null);
                r.setAnt(null);
                r = null;
            }
        } else
        {
            b = null;
        }
        return b;
    }

    public Nodo eliminaF()
    {
        Nodo a;
        Nodo b;
        a = r;
        b = r;
        if (r != null)
        {
            if (!r.getSig().equals(r))
            {
                while (a.getSig() != r)
                {
                    a = a.getSig();
                }
                r.getSig().setAnt(r.getAnt());
                r = r.getSig();
                a.getSig().setSig(null);
                a.getSig().setAnt(null);
                a.setSig(r);

                r = a;
            } else
            {
                r.setSig(null);
                r = null;
            }
        } else
        {
            b = null;
        }
        return b;
    }

    public Nodo eliminaE(int s)
    {
        Nodo a;
        Nodo b;
        a = r;
        if (r != null)
        {
            while (a.getSig() != r && a.getSig().getEt() != s)
            {
                a = a.getSig();
            }
            if (a.getSig().equals(r) && r.getSig().getEt() == s)
            {
                b = eliminaF();
            } else
            {
                if (a.getSig().getEt() == s)
                {
                    b = a.getSig();
                    if (r.equals(b))
                    {
                        r = r.getAnt();
                    }
                    a.setSig(b.getSig());
                    b.getSig().setAnt(a);
                    b.setSig(null);
                    b.setAnt(null);
                } else
                {
                    b = null;
                }
            }

        } else
        {
            b = null;
        }
        return b;
    }

    public boolean busquedaE(int s)
    {
        Nodo a;
        boolean b = false;
        a = r;
        if (r != null)
        {
            while (a.getSig() != r && a.getSig().getEt() != s)
            {
                a = a.getSig();
            }
            if (a.getSig().equals(r) && r.getSig().getEt() == s)
            {
                b = true;
            } else
            {
                if (a.getSig().getEt() != s)
                {
                    b = false;
                } else
                {
                    b = true;
                }
            }

        } else
        {
            b = false;
        }
        return b;
    }

    public void desp()
    {
        Nodo a = r;
        if (r != null)
        {
            if (r.equals(r.getSig()))
            {
                System.out.println(r.getEt());
            } else
            {
                a = a.getSig();
                while (!a.equals(r))
                {
                    System.out.print(a.getEt() + "   ");
                    a = a.getSig();
                }
                System.out.println(a.getEt() + "   ");
            }
        } else
        {
            System.out.println("No hay nada en la cola");
        }
    }

    public void despI()
    {
        Nodo a = r;
        if (r != null)
        {
            do
            {
                System.out.print(a.getEt() + "   ");
                a = a.getAnt();
            } while (a != r);
            System.out.println("");
            System.out.println("Ya termino");
        } else
        {
            System.out.println("No hay nada en la cola");
        }
    }
}
