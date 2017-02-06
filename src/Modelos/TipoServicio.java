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
public class TipoServicio 
{
    String codtiposervicio;
    String nombretiposervicio;

    public TipoServicio(String codtiposervicio, String nombretiposervicio) {
        this.codtiposervicio = codtiposervicio;
        this.nombretiposervicio = nombretiposervicio;
    }

    public TipoServicio() 
    {
        super();
    }

    public String getCodtiposervicio() {
        return codtiposervicio;
    }

    public void setCodtiposervicio(String codtiposervicio) {
        this.codtiposervicio = codtiposervicio;
    }

    public String getNombretiposervicio() {
        return nombretiposervicio;
    }

    public void setNombretiposervicio(String nombretiposervicio) {
        this.nombretiposervicio = nombretiposervicio;
    }
    
    
}
