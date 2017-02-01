/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author Carlos Torrealba
 */
public class Personal1 
{
    String cedula;
    String nombre;
    String apellido;
    String codigocargo;
    String tipopersonal;
    Date fechaingreso;
    String estatus;

    public Personal1(String cedula, String nombre, String apellido, String codigocargo, String tipopersonal, Date fechaingreso, String estatus) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigocargo = codigocargo;
        this.tipopersonal = tipopersonal;
        this.fechaingreso = fechaingreso;
        this.estatus = estatus;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigocargo() {
        return codigocargo;
    }

    public void setCodigocargo(String codigocargo) {
        this.codigocargo = codigocargo;
    }

    public String getTipopersonal() {
        return tipopersonal;
    }

    public void setTipopersonal(String tipopersonal) {
        this.tipopersonal = tipopersonal;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
