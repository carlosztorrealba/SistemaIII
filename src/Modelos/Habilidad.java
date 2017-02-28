/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Carlos
 */
public class Habilidad 
{
     String codigo;
     String descripcion;
     String estatus;

    public Habilidad(String codigo, String descripcion, String estatus) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estatus = estatus;
        
        
        
    }

    public Habilidad() {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
     
    
}
