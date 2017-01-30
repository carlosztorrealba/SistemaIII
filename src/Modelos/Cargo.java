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
public class Cargo
{
    String codcargo;
    String nombrecargo;

    public Cargo(String codcargo, String nombrecargo)
    {
        this.codcargo = codcargo;
        this.nombrecargo = nombrecargo;
    }
        
    public String getCodcargo()
    {
        return codcargo;
    }

    public void setCodcargo(String codcargo) 
    {
        this.codcargo = codcargo;
    }

    public String getNombrecargo() 
    {
        return nombrecargo;
    }

    public void setNombrecargo(String nombrecargo)
    {
        this.nombrecargo = nombrecargo;
    }
    
    
}
