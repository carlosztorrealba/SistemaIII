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
public class TipoInsumo 
{
    String codtipoinsumo;
    String nombretipoinsumo;

    public TipoInsumo(String codtipoinsumo, String nombretipoinsumo) {
        this.codtipoinsumo = codtipoinsumo;
        this.nombretipoinsumo = nombretipoinsumo;
    }

    public TipoInsumo() 
    {
        super();
    }
    
    

    public String getCodtipoinsumo() {
        return codtipoinsumo;
    }

    public void setCodtipoinsumo(String codtipoinsumo) {
        this.codtipoinsumo = codtipoinsumo;
    }

    public String getNombretipoinsumo() {
        return nombretipoinsumo;
    }

    public void setNombretipoinsumo(String nombretipoinsumo) {
        this.nombretipoinsumo = nombretipoinsumo;
    }
    
    
}
