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
public class TipoOrganizacion 
{
    String codtipoorg;
    String nombretipoorg;

    public TipoOrganizacion(String codtipoorg, String nombretipoorg) {
        this.codtipoorg = codtipoorg;
        this.nombretipoorg = nombretipoorg;
    }

    public TipoOrganizacion() 
    {
        super();
    }
    
    

    public String getCodtipoorg() {
        return codtipoorg;
    }

    public void setCodtipoorg(String codtipoorg) {
        this.codtipoorg = codtipoorg;
    }

    public String getNombretipoorg() {
        return nombretipoorg;
    }

    public void setNombretipoorg(String nombretipoorg) {
        this.nombretipoorg = nombretipoorg;
    }
    
    
}
