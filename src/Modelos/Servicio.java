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
public class Servicio extends TipoServicio
{
    String codigoserv;
    String nombreserv;
    String estatusserv;

    public Servicio(String codigoserv, String nombreserv, String estatusserv, String codigotiposerv, String nombretiposerv, String estatus) {
        super(codigotiposerv, nombretiposerv, estatus);
        this.codigoserv = codigoserv;
        this.nombreserv = nombreserv;
        this.estatusserv = estatusserv;
    }

    public String getCodigoserv()
    {
        return codigoserv;
    }

    public void setCodigoserv(String codigoserv)
    {
        this.codigoserv = codigoserv;
    }

    public String getNombreserv() 
    {
        return nombreserv;
    }

    public void setNombreserv(String nombreserv) 
    {
        this.nombreserv = nombreserv;
    }

    public String getEstatusserv() 
    {
        return estatusserv;
    }

    public void setEstatusserv(String estatusserv) 
    {
        this.estatusserv = estatusserv;
    }
    
    
    
}
