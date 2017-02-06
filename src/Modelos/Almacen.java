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
    String descripcion;

    public Almacen(String codalmacen, String descripcion) {
        this.codalmacen = codalmacen;
        this.descripcion = descripcion;
    }

    public Almacen() {
        super();
    }

    public String getCodalmacen() {
        return codalmacen;
    }

    public void setCodalmacen(String codalmacen) {
        this.codalmacen = codalmacen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
