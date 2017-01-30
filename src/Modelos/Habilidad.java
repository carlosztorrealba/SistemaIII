/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Carlos Enrique
 */
class Habilidad 
{
    String codigohabil;
    String nombrehabil;

    public Habilidad(String codigohabil, String nombrehabil)
    {
        this.codigohabil = codigohabil;
        this.nombrehabil = nombrehabil;
    }

    public String getCodigohabil() 
    {
        return codigohabil;
    }

    public void setCodigohabil(String codigohabil)
    {
        this.codigohabil = codigohabil;
    }

    public String getNombrehabil() 
    {
        return nombrehabil;
    }

    public void setNombrehabil(String nombrehabil) 
    {
        this.nombrehabil = nombrehabil;
    }
    
    
}
