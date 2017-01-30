/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author Carlos Enrique
 */
public class Solicitud extends Servicio
{
    String codigosoli;
    String rif;
    String descripcion;
    Date fechasoli;
    String estatussoli;

    public Solicitud(String codigosoli, String rif, String descripcion, Date fechasoli, String estatussoli, String codigoserv, String nombreserv, String estatusserv, String codigotiposerv, String nombretiposerv, String estatus)
    {
        super(codigoserv, nombreserv, estatusserv, codigotiposerv, nombretiposerv, estatus);
        this.codigosoli = codigosoli;
        this.rif = rif;
        this.descripcion = descripcion;
        this.fechasoli = fechasoli;
        this.estatussoli = estatussoli;
    }

    public String getCodigosoli()
    {
        return codigosoli;
    }

    public void setCodigosoli(String codigosoli) 
    {
        this.codigosoli = codigosoli;
    }

    public String getRif()
    {
        return rif;
    }

    public void setRif(String rif) 
    {
        this.rif = rif;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }

    public Date getFechasoli()
    {
        return fechasoli;
    }

    public void setFechasoli(Date fechasoli) 
    {
        this.fechasoli = fechasoli;
    }

    public String getEstatussoli() 
    {
        return estatussoli;
    }

    public void setEstatussoli(String estatussoli) 
    {
        this.estatussoli = estatussoli;
    }
    
    
}
