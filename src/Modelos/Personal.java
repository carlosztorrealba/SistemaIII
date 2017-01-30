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
public class Personal extends Habilidad
{
    String cedula;
    String nombre;
    String apellido;
    String telefono;
    String direccion;
    Date fechaingreso;
    String estatus;
    String cargo;

    public Personal(String cedula, String nombre, String apellido, String telefono, String direccion, Date fechaingreso, String estatus, String cargo, String codigohabil, String nombrehabil) 
    {
        super(codigohabil, nombrehabil);
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaingreso = fechaingreso;
        this.estatus = estatus;
        this.cargo = cargo;
    }

    public String getCedula() 
    {
        return cedula;
    }

    public void setCedula(String cedula)
    {
        this.cedula = cedula;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido) 
    {
        this.apellido = apellido;
    }

    public String getTelefono() 
    {
        return telefono;
    }

    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }

    public String getDireccion() 
    {
        return direccion;
    }

    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }

    public Date getFechaingreso() 
    {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso)
    {
        this.fechaingreso = fechaingreso;
    }

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus(String estatus) 
    {
        this.estatus = estatus;
    }

    public String getCargo() 
    {
        return cargo;
    }

    public void setCargo(String cargo) 
    {
        this.cargo = cargo;
    }
    
    
}
