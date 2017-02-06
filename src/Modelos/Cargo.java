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
public class Cargo 
{
        private String codCargo;
	private String nombreCargo;
	
	
	public Cargo( String codCargo, String nombreCargo) {
		
		super();
		this.codCargo = codCargo;
		this.nombreCargo = nombreCargo;
	}

	public Cargo() {
		super();
	}


	public String getCodCargo() {
		return codCargo;
	}

	public String getNombreCargo() {
		return nombreCargo;
	}
	
	
	
	public void setCodCargo(String codCargo) {
		this.codCargo = codCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

}
