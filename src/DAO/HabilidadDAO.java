/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.ClassConexionDAO;
import Modelos.Habilidad;
import Modelos.Rutinas;
import PackageConeccion.ConeccionBD;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class HabilidadDAO extends ClassConexionDAO
{
    
 public void InsertarHabilidad(Habilidad hab)    
 {
   String Sql;
   
 
   Sql="INSERT INTO habilidad(codhabilidad,nombrehabilidad, estatus)  VALUES (";
   Sql=Sql+Rutinas.Apost(hab.getCodigo())+",";
   Sql=Sql+Rutinas.Apost(hab.getDescripcion())+",";
   Sql=Sql+Rutinas.Apost(hab.getEstatus())+")";
     ConeccionBD.ejecutar(Sql);
 }         
//-----------------------    
public void ModificarHabilidad(Habilidad hab)     
{
   String Sql;
  
   Sql="UPDATE habilidad SET ";
   
   Sql=Sql+"nombrehabilidad="+Rutinas.Apost(hab.getDescripcion());
   Sql=Sql+"estatus="+Rutinas.Apost(hab.getEstatus());
   Sql=Sql+ " WHERE codhabilidad="+Rutinas.Apost(hab.getCodigo());     
   ConeccionBD.ejecutar(Sql);
}         
//---------------- 
public void Eliminar()    
 {
     
 }         
//-------------------------
public ResultSet BuscarHabilidad(String hab) throws SQLException    
 {
     String Sql;
     ResultSet RegistroHabilidad=null;  
      
      Sql="SELECT * FROM habilidad WHERE codhabilidad="+Rutinas.Apost(hab);
                                              
      RegistroHabilidad=ConeccionBD.consultar(Sql);
      
      return RegistroHabilidad;
 }         
//--------------------------------------
  public ResultSet ConsultarHabilidad() throws SQLException
    {
      String Sql;
      ResultSet RegistroHabilidad=null;  
      
      Sql="SELECT * FROM habilidad";
                                              
      RegistroHabilidad=ConeccionBD.consultar(Sql);
      
      return RegistroHabilidad;
        
   }
}

