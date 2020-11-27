/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suma_sub_conjuntos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Kevin Benitez
 */
public class Metodos_conj
{

    /**
     * Método encargado de convertir una cadena de enteros en formato #,#,#,# a
     * un arreglo de enteros
     *
     * @param cad Cadena de numeros a convertir
     * @return Arreglo de enteros convertido
     */
    public static int[] conversor(String cad)
    {
        String[] cadnumbers = cad.split(",");
        int arr[] = new int[cadnumbers.length];
        for (int i = 0; i < cadnumbers.length; i++)
        {
            arr[i] = Integer.parseInt(cadnumbers[i]);
        }
        return arr;
    }

    /**
     * Método encargado de verificar si una cadena proporcionada es un numero
     * entero
     *
     * @param cad Cadena a verificar
     * @return true = numero | false = !numero
     */
    public static boolean isNumeric(String cad)
    {
        try
        {
            Integer.parseInt(cad);
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }

    String s = "";
    long fin, tiempo;
    int subc_en = 1;
    long inicio;
    
    /**
     * Método encargado de encontrar 1 o mas subconjuntos cuya suma de elementos
     * sea la proporcionada
     *
     * @param arr Arreglo de numeros enteros
     * @param suma Suma deseada
     * @return Cadena concatenada con cada elemento que se encontro
     */
    public String encuentra_conj(int[] arr, int suma)
    {
        Arrays.sort(arr);
        List<Integer> lista_comb = new ArrayList<>();
        combinaciones(arr, 0, 0, lista_comb, suma);
        return s;
    }

    public void combinaciones(int arr[], int sumActual, int inicio, List<Integer> lista_comb, int suma)
    {
        if (sumActual == suma && lista_comb.size() > 0)
        {
            s += "\tSub-Conjunto " + subc_en + ": " + lista_comb + "\n";
            subc_en++;
            return;
        }

        for (int i = inicio; i < arr.length; i++)
        {
            if (sumActual + arr[i] > suma)
            {
                break;
            }
            lista_comb.add(arr[i]);
            combinaciones(arr, sumActual + arr[i], i + 1, lista_comb, suma);
            lista_comb.remove(lista_comb.size() - 1);
        }
    }
}
