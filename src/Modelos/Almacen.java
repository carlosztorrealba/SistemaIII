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
public class Almacen 
{
    String codalmacen;
    Integer capacidad;

    public Almacen(String codalmacen, Integer capacidad) 
    {
        this.codalmacen = codalmacen;
        this.capacidad = capacidad;
    }

    public String getCodalmacen() 
    {
        return codalmacen;
    }

    public void setCodalmacen(String codalmacen)
    {
        this.codalmacen = codalmacen;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }


    
}
