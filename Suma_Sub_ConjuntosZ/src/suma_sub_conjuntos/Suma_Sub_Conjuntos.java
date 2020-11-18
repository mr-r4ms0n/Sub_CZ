/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suma_sub_conjuntos;

import java.awt.HeadlessException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Benitez
 */
public class Suma_Sub_Conjuntos
{
    /**
     * Casos de uso
     * 
     * 12,-12,51,16,38,-16,69
     * 
     * 
     * 
     * 
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException
    {
        //Hecho por mr.r4ms0n
        Sonidos sn = new Sonidos();
        int[] arr = null;
        int suma = 0;
        int opc;
        boolean listcorrect = false, opccorrect = false, sumcorrect = false;
        long inicio, fin;
        double tiempo;
        String s = "";
        String s1 = "";
        String s2 = "";
        Metodos_conj obj = new Metodos_conj();
        do
        {
            inicio = System.currentTimeMillis();
            try
            {
                s = JOptionPane.showInputDialog(null, "                        Programa hecho por mr.r4ms0n"
                        + "\n\n               Problema de la Suma de Sub-Conjuntos\n"
                        + "\n\nIngrese la lista de numeros a considerar, separados por comas:");
                if (!s.equals(""))
                {
                    if (s.matches("((-?[\\d]+,)+-?[\\d]+)")) ////([0-9]+,)+([0-9])+ para numeros positivos
                    {
                        listcorrect = true;
                        arr = Metodos_conj.conversor(s);
                    } else
                    {
                        System.out.println("Incorrecto");
                        sn.incorrect();
                        JOptionPane.showMessageDialog(null, "Lista de numeros invalida, intentelo de nuevo",
                                "Error", JOptionPane.ERROR_MESSAGE);

                    }

                } else
                {
                    sn.incorrect();
                    JOptionPane.showMessageDialog(null, "Lista de numeros invalida, intentelo de nuevo",
                            "Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (HeadlessException | NullPointerException e)
            {
                if (s == null)
                {
                    System.exit(0);
                }
            }

        } while (listcorrect != true);

        do
        {
            try
            {
                s1 = JOptionPane.showInputDialog(null, "Ingrese la suma a encontrar entre los sbconjuntos de\n"
                        + "{" + s + "}");
                if (Metodos_conj.isNumeric(s1))
                {
                    suma = Integer.parseInt(s1);
                    sumcorrect = true;
                } else
                {
                    if (s1 == null)
                    {
                        System.exit(0);
                    } else
                    {
                        sn.incorrect();
                        JOptionPane.showMessageDialog(null, "Suma invalida, intentelo de nuevo",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            } catch (HeadlessException | NullPointerException e)
            {

            }
        } while (sumcorrect != true);

        do
        {
            try
            {
                s2 = JOptionPane.showInputDialog(null, "Conjunto de datos proporcionado " + Arrays.toString(arr) + "Suma a identificar = 0" + "\n"
                        + "1.- Identificar si existe uno o mas subconjuntos\n"
                        + "2.- Salir\n"
                        + "Escoja una opción (1-2):");

                if (Metodos_conj.isNumeric(s2))
                {
                    opc = Integer.parseInt(s2);
                    switch (opc)
                    {
                        case 1:

                            Metodos_conj op = new Metodos_conj();
                            
                            JOptionPane.showMessageDialog(null, "Arreglo proporcionado: " + Arrays.toString(arr) + ", suma requerida: " + suma
                                    + "\nSubconjuntos encontrados: \n" + op.encuentra_conj(arr, suma));
                            fin = System.currentTimeMillis();
                            tiempo = (double) ((fin - inicio) / 1000);
                            System.out.println("El programa tardo: " + tiempo + " segundos de ejecución");
                            opccorrect = true;
                            break;
                        case 2:

                            opccorrect = true;
                            break;
                        default:
                            sn.incorrect();
                            JOptionPane.showMessageDialog(null, "Opcion invalida, intentelo de nuevo",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else
                {
                    if (s2 == null)
                    {
                        System.exit(0);
                    } else
                    {
                        sn.incorrect();
                        JOptionPane.showMessageDialog(null, "Opcion invalida, intentelo de nuevo",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }

            } catch (HeadlessException | NullPointerException e)
            {

            }
        } while (opccorrect != true);
    }

}
