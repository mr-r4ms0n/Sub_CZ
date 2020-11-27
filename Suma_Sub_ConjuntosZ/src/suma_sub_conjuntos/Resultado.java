/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suma_sub_conjuntos;

/**
 *
 * @author Kevin Benitez
 */
public class Resultado
{
    private String subConjunto = null;
    private int [] subC = null;

    public Resultado(int [] subC, String result)
    {
        this.subC = subC;
        this.subConjunto = result;
    }

    /**
     * @return the subConjunto
     */
    public String getSubConjunto()
    {
        return subConjunto;
    }

    /**
     * @param subConjunto the subConjunto to set
     */
    public void setSubConjunto(String subConjunto)
    {
        this.subConjunto = subConjunto;
    }

    /**
     * @return the subC
     */
    public int[] getSubC()
    {
        return subC;
    }

    /**
     * @param subC the subC to set
     */
    public void setSubC(int[] subC)
    {
        this.subC = subC;
    }
    
    
    
    
}
