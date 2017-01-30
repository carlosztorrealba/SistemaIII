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
public class Insumo extends TipoInsumo
{
    String codigoins;
    String estatus;
    Integer cantidad;

    public Insumo(String codigoins, String estatus, Integer cantidad, String codtipoins, String descripcionins, Integer cantidadins, Integer stock)
    {
        super(codtipoins, descripcionins, cantidadins, stock);
        this.codigoins = codigoins;
        this.estatus = estatus;
        this.cantidad = cantidad;
    }

    public String getCodigoins()
    {
        return codigoins;
    }

    public void setCodigoins(String codigoins) 
    {
        this.codigoins = codigoins;
    }

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus(String estatus) 
    {
        this.estatus = estatus;
    }

    public Integer getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) 
    {
        this.cantidad = cantidad;
    }
    
    
    
}