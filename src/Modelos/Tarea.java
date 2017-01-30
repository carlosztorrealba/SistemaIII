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
public class Tarea extends TipoOrganizacion
{
    String codigot;
    String nombret;

    public Tarea(String codigot, String nombret, String codigo, String descripcion)
    {
        super(codigo, descripcion);
        this.codigot = codigot;
        this.nombret = nombret;
    }

    public String getCodigot()
    {
        return codigot;
    }

    public void setCodigot(String codigot)
    {
        this.codigot = codigot;
    }

    public String getNombret() 
    {
        return nombret;
    }

    public void setNombret(String nombret) 
    {
        this.nombret = nombret;
    }
    
    

}
