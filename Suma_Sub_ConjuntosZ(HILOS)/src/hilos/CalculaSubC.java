/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.ArrayList;
import suma_sub_conjuntos.Metodos_conj;
import suma_sub_conjuntos.Resultado;

/**
 *
 * @author Kevin Benitez
 */
public class CalculaSubC implements Runnable
{

    private boolean paused = false;
    private boolean stopped = false;
    private int[] subc = null;
    private int suma = 0;
    private Resultado rs = null;
    Thread t;
    public ArrayList<Resultado> copia;
    
    /**
     * Constuctor que nos arranca el hilo encargado de calcular subconjuntos de un conjunto que sera ordenado de -20 a 101
     * @param arr conjunto al que se le extraeran subconjuntos
     * @param suma 
     * @param lista 
     */
    public CalculaSubC(int[] arr, int suma,ArrayList<Resultado> lista)
    {
        this.subc = arr;
        this.suma = suma;
        this.copia = lista;
        paused = false;
        stopped = false;
        t = new Thread(this, "SubC");
        t.start();
    }

    @Override
    public void run()
    {

        try
        {

            Metodos_conj obj = new Metodos_conj();
            String s = obj.encuentra_conj(subc, suma);
            System.out.println("SI ENTRE");
            if (!s.equals(""))
            {
                rs = new Resultado(subc, s);
                copia.add(rs);
                RandomG.lista = copia;
                System.out.println("SUBCONJUNTO ENCONTRADO");
            }
            Thread.sleep(100);

        } catch (InterruptedException e)
        {
            System.out.println("Interrupcion del hilo de subconjuntos");
        }
        System.out.println("Hilo de subconjuntos terminado");
    }
}

