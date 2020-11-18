/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import RSMaterialComponent.RSTextFieldMaterial;
import interfaces.ChConj;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Kevin Benitez
 */
public class RandomG implements Runnable
{

    private boolean paused = false;
    private boolean stopped = false;
    public RSTextFieldMaterial txt;

    public RandomG(RSTextFieldMaterial txt)
    {
        this.txt = txt;
    }

    public void iniciar()
    {
        paused = false;
        stopped = false;
        new Thread(this, "RandomNumbers").start();
    }

    public synchronized void pausa()
    {
        paused = true;
    }

    public synchronized void resume()
    {
        paused = false;
        notify();
    }

    public synchronized void stop()
    {
        stopped = true;
        notify();
    }

    @Override
    public void run()
    {
        Random generador = new Random();
        while (!stopped)
        {
            try
            {
                synchronized (this)
                {
                    if (paused)
                    {
                        System.out.println("Paused");
                        wait();
                        System.out.println("Resumed");
                    } else
                    {
                        int tam = (int) (Math.random() * 9 + 2);
                        int arr[] = new int[tam];
                        //Llenamos el array de numeros con rango de -100  a 100
                        for (int i = 0; i < arr.length; i++)
                        {
                            arr[i] = generador.nextInt(101) - 20;
                        }
                        //Checamos que el array no tenga elementos repetidos (-8,-8)
                        for (int i1 = 0; i1 < tam; i1++)
                        { // creamos la primera variable para la comprobacion
                            for (int i2 = 0; i2 < tam; i2++)
                            {//creamos la segunda que hara la comprobacion
                                if (arr[i1] == arr[i2] && i1 != i2)
                                {
                                    int rnd = (int) Math.floor(Math.random() * (-20 - (100 + 1)) + (100));
                                    arr[i1] = rnd;
                                    i1 = 0;
                                }/* este if comprobara si hay coincidencias en el arreglo
                            y de conseguirlas, la cambia y vuelve a hacer la comprobacion */
                            }// fin del for de la segunda comprobacion
                        }// fin del for de la segunda comprobacion
                        ChConj.arr = arr;
                        txt.setText(Arrays.toString(arr));
                        System.out.println(Arrays.toString(arr));
                        Thread.sleep(200);
                    }
                }
            } catch (InterruptedException ex)
            {
                System.err.println(ex);
            }
        }
    }
}
