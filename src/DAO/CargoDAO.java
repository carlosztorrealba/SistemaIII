/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Cargo;
import Modelos.ClassConexionDAO;
import Modelos.Rutinas;
import PackageConeccion.ConeccionBD;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Enrique
 */
public class CargoDAO  extends ClassConexionDAO  
{
    public void InsertarCargo(Cargo car)    
 {
   String Sql;
   
 
   Sql="INSERT INTO cargo(codcargo,nombrecargo)  VALUES (";
   Sql=Sql+Rutinas.Apost(car.getCodCargo())+",";
   Sql=Sql+Rutinas.Apost(car.getNombreCargo())+")";
     ConeccionBD.ejecutar(Sql);
 }         
//-----------------------    
public void ModificarCargo(Cargo car)     
{
   String Sql;
  
   Sql="UPDATE cargo SET ";
   
   Sql=Sql+"nombrecargo="+Rutinas.Apost(car.getNombreCargo());
   Sql=Sql+ " WHERE codcargo="+Rutinas.Apost(car.getCodCargo());     
   ConeccionBD.ejecutar(Sql);
}         
//---------------- 
public void Eliminar()    
 {
     
 }         
//-------------------------
public ResultSet BuscarCargo(String car) throws SQLException    
 {
     String Sql;
     ResultSet RegistroCargo=null;  
      
      Sql="SELECT * FROM cargo WHERE codcargo="+Rutinas.Apost(car);
                                              
      RegistroCargo=ConeccionBD.consultar(Sql);
      
      return RegistroCargo;
 }         
//--------------------------------------
  public ResultSet ConsultarCargo() throws SQLException
    {
      String Sql;
      ResultSet RegistroCargo=null;  
      
      Sql="SELECT * FROM cargo";
                                              
      RegistroCargo=ConeccionBD.consultar(Sql);
      
      return RegistroCargo;
        
   }
}
