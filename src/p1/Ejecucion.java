/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1;

import cjb.ci.Lecturas;
import cjb.ci.Mensajes;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Francisco
 */
public class Ejecucion implements Serializable
{

    private ListaDCL x = new ListaDCL();
    private ArrayList<ArrayList<String>> nombres;

    public Ejecucion()
    {
        this.nombres = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            nombres.add(new ArrayList<>());
        }
    }

    /**
     * @return the nombres
     */
    public ArrayList<ArrayList<String>> getNombres()
    {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(ArrayList<ArrayList<String>> nombres)
    {
        this.nombres = nombres;
    }

    public ListaDCL getX()
    {
        return x;
    }

    public void setX(ListaDCL x)
    {
        this.x = x;
    }

    public void crearPLista(int prio, Prioridad p)
    {
        Nodo n = new Nodo(prio, p);
        x.inserta(n);
    }

    public void subirProc(Proceso n, JFrame jf)
    {
        if (n.getQuantum() > 0)
        {
            Nodo a = new Nodo(n.getNoProceso(), n);
            if (x == null)
            {
                Prioridad p = new Prioridad(n.getNoProceso(), new Cola());
                p.getC().inserta(a);
                crearPLista(n.getNoProceso(), p);
                nombres.get(n.getNoProceso() - 1).add(n.getNombre());
//            System.out.println(((Proceso)p.getC().getAtras().getObj()).getNombre());
            } else
            {
                Object obj[] = busquedaEN(n.getNombre());
                if ((x.busquedaE(n.getNoProceso())))
                {
                    if (((boolean) obj[1]))
                    {
                        Nodo z = x.eliminaE(n.getNoProceso());
                        ((Prioridad) z.getObj()).getC().inserta(a);
                        x.inserta(z);
                        nombres.get(n.getNoProceso() - 1).add(n.getNombre());
                    } else
                    {
                        Mensajes.error(jf, "Ya se repitio");
                    }
                } else
                {
                    if (((boolean) obj[1]))
                    {
                        Prioridad p = new Prioridad(n.getNoProceso(), new Cola());
                        p.getC().inserta(a);
                        crearPLista(n.getNoProceso(), p);
                        nombres.get(n.getNoProceso() - 1).add(n.getNombre());
//            System.out.println(dispPP(1));
                    } else
                    {
                        Mensajes.error(jf, "Ya se repitio");
                    }
                }
            }
        }
    }

    public Object[] busquedaEN(String s)
    {
        Object[] z = new Object[2];
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < nombres.get(i).size(); j++)
            {
                if (s.equals(nombres.get(i).get(j)))
                {
                    z[0] = i + 1;
                    z[1] = false;
                    return z;
                }
            }
        }
        z[0] = null;
        z[1] = true;
        return z;
    }

    public boolean quitarN(String s)
    {
        boolean z = false;
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < nombres.get(i).size(); j++)
            {
                if (s.equals(nombres.get(i).get(j)))
                {
                    nombres.get(i).remove(j);
                    z = true;
                    return z;
                }
            }
        }

        return z;
    }

    public void a(Proceso s)
    {
        nombres.get(s.getNoProceso()).add(s.getNombre());
    }

    public void quitaProc(String s, JFrame jf)
    {
        Object obj[] = busquedaEN(s);
        if (!((boolean) obj[1]))
        {
            quitarN(s);
            Nodo n = x.eliminaE(((int) obj[0]));
            Nodo m = ((Prioridad) n.getObj()).getC().eliminaE(s);
            if (((Prioridad) n.getObj()).getC().getAtras() != null)
            {
                x.inserta(n);
            }
            Mensajes.exito(jf, "Se ha eliminado con exito " + ((Proceso) m.getObj()).getNombre());
        } else
        {
            Mensajes.error(jf, "Error El nombre no coincide con ninguno");
        }
    }

    public Nodo quitaProcD(String s, JFrame jf)
    {
        Object obj[] = busquedaEN(s);
        if (!((boolean) obj[1]))
        {
            quitarN(s);
            Nodo n = x.eliminaE(((int) obj[0]));
            Nodo m = ((Prioridad) n.getObj()).getC().eliminaE(s);
            if (((Prioridad) n.getObj()).getC().getAtras() != null)
            {
                x.inserta(n);
            }
            return m;
        }
        return null;
    }

    public void procesar(JFrame jf)
    {
        Nodo n = x.eliminaI();
        Nodo m = ((Prioridad) n.getObj()).getC().elimina();
        quitarN(((Proceso) m.getObj()).getNombre());
        if (((Prioridad) n.getObj()).getC().getAtras() != null)
        {
            x.inserta(n);
        }
        if (((Proceso) m.getObj()).getNoProceso() > 0 && ((Proceso) m.getObj()).getNoProceso() <= 10)
        {
            ((Proceso) m.getObj()).setQuantum(((Proceso) m.getObj()).getQuantum() - 1);
            if (((Proceso) m.getObj()).getQuantum() != 0)
            {
                if (((Proceso) m.getObj()).getNoProceso() < 10)
                {
                    ((Proceso) m.getObj()).setNoProceso(((Proceso) m.getObj()).getNoProceso() + 1);
                }
                subirProc(((Proceso) m.getObj()), jf);
            }
        }
    }

    public String dispPP(int i)
    {
        String s;
        if (x.busquedaE(i))
        {
            Nodo a = x.eliminaE(i);
            s = ((Prioridad) a.getObj()).getC().desp();
            x.inserta(a);
        } else
        {
            s = "No tiene datos";
        }
        return s;
    }

    public String ObtenerSP()
    {
        Nodo a = x.eliminaI();
        String s = "No hay mas procesos";
        if (a != null)
        {
            s = ((Prioridad) a.getObj()).getC().despPP();
            if (((Prioridad) a.getObj()).getC() == null)
            {
                s = "No hay mas procesos";
            } else
            {
                x.inserta(a);
            }
        }
        return s;
    }

    public void eliminaPrio(int borrar)
    {
        if (x != null)
        {
            int m = 0;
            if (x.busquedaE(borrar))
            {
                Nodo a = x.eliminaE(borrar);
                if (((Prioridad) a.getObj()).getC().getAtras() != null)
                {
                    ((Prioridad) a.getObj()).getC();
                    Nodo c = null;
                    Nodo b = ((Prioridad) a.getObj()).getC().getAtras();
                    int s = 0;
                    int z = 0;
                    while (!b.equals(c))
                    {
                        c = ((Prioridad) a.getObj()).getC().elimina();
                        s++;
                        ((Prioridad) a.getObj()).getC().inserta(c);
                    }
                    if (s > 0)
                    {
                        do
                        {
                            System.out.println("La prioridad a eliminar contiene " + s + " ¿Desea eliminarlos?");
                            System.out.println("1.- si\t 2.- no");
                            m = Lecturas.entero(null);
                            if (m < 0 || m > 3)
                            {
                                System.out.println("Error seleccione una opcion correcta");
                            }
                        } while (m < 0 && m > 3);
                    }
                }
                if (m == 2)
                {
                    x.inserta(a);
                }
            }
            if (m != 2)
            {
                System.out.println("La prioridad " + borrar + " Se ha eliminado");
            }
        }
    }

    public void moverProc(String s)
    {
        Object obj[] = busquedaEN(s);// Revisa que exita el nombre donde el segundo valor del objeto es un booleano
        Nodo a= null;
        if (!((boolean) obj[1]))
        {
            quitarN(s);
            Nodo n = x.eliminaE(((int) obj[0]));
            a = ((Prioridad) n.getObj()).getC().eliminaE(s);
            if (((Prioridad) n.getObj()).getC().getAtras() != null)
            {
                x.inserta(n);
            }
             
        }
        int m;
        if (a == null)
        {
            System.out.println("No existe");
        } else
        {
            do
            {
                System.out.println("La prioridad actual es " + ((Proceso) a.getObj()).getNoProceso() + "\n¿A que prioridad lo desea mover?");
                m = Lecturas.entero(null);
                if (m == ((Proceso) a.getObj()).getNoProceso())
                {
                    System.out.println("Error. No puedes mover el proceso a la misma prioridad");
                }
                if (m < 0)
                {
                    System.out.println("Error. El valor no puede ser negativo");
                }
            } while (m == ((Proceso) a.getObj()).getNoProceso() || m<0);
            Proceso p = new Proceso(m, ((Proceso) a.getObj()).getNombre(), ((Proceso) a.getObj()).getQuantum());
            subirProc(p, null);
        }
    }
}
