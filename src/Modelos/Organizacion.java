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
public class Organizacion extends TipoOrganizacion
{
     String rif;
     String nombre;
     String direccion;
     String estado;
     String ciudad;
     String telefono;
     String responsable;
     String cedula;
     String estatus;

    public Organizacion(String rif, String nombre, String direccion, String estado, String ciudad, String telefono, String responsable, String cedula, String estatus, String codigo, String descripcion) 
    {
        super(codigo, descripcion);
        this.rif = rif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.estado = estado;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.responsable = responsable;
        this.cedula = cedula;
        this.estatus = estatus;
    }

    public String getRif() 
    {
        return rif;
    }

    public void setRif(String rif) 
    {
        this.rif = rif;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public String getCiudad()
    {
        return ciudad;
    }

    public void setCiudad(String ciudad) 
    {
        this.ciudad = ciudad;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }

    public String getResponsable() 
    {
        return responsable;
    }

    public void setResponsable(String responsable)
    {
        this.responsable = responsable;
    }

    public String getCedula() 
    {
        return cedula;
    }

    public void setCedula(String cedula) 
    {
        this.cedula = cedula;
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
