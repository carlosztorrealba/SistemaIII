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
class TipoServicio 
{
    String codigotiposerv;
    String nombretiposerv;
    String estatus;

    public TipoServicio(String codigotiposerv, String nombretiposerv, String estatus) 
    {
        this.codigotiposerv = codigotiposerv;
        this.nombretiposerv = nombretiposerv;
        this.estatus = estatus;
    }

    public String getCodigotiposerv()
    {
        return codigotiposerv;
    }

    public void setCodigotiposerv(String codigotiposerv) 
    {
        this.codigotiposerv = codigotiposerv;
    }

    public String getNombretiposerv()
    {
        return nombretiposerv;
    }

    public void setNombretiposerv(String nombretiposerv)
    {
        this.nombretiposerv = nombretiposerv;
    }

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus(String estatus)
    {
        this.estatus = estatus;
    }
    
    
}
