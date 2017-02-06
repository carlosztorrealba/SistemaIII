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
public class Organizacion 
{
    String rif;
    String nombreorg;
    String ciresponsable;
    String nombreresponsable;
    String direccion;
    String codtipoorg;

    public Organizacion(String rif, String nombreorg, String ciresponsable, String nombreresponsable, String direccion, String codtipoorg) {
        this.rif = rif;
        this.nombreorg = nombreorg;
        this.ciresponsable = ciresponsable;
        this.nombreresponsable = nombreresponsable;
        this.direccion = direccion;
        this.codtipoorg = codtipoorg;
    }

    public Organizacion()
    {
        super();
    }
    
    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getNombreorg() {
        return nombreorg;
    }

    public void setNombreorg(String nombreorg) {
        this.nombreorg = nombreorg;
    }

    public String getCiresponsable() {
        return ciresponsable;
    }

    public void setCiresponsable(String ciresponsable) {
        this.ciresponsable = ciresponsable;
    }

    public String getNombreresponsable() {
        return nombreresponsable;
    }

    public void setNombreresponsable(String nombreresponsable) {
        this.nombreresponsable = nombreresponsable;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodtipoorg() {
        return codtipoorg;
    }

    public void setCodtipoorg(String codtipoorg) {
        this.codtipoorg = codtipoorg;
    }
    
    
    
}
