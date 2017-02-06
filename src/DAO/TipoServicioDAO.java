/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.ClassConexionDAO;
import Modelos.Rutinas;
import Modelos.TipoServicio;
import PackageConeccion.ConeccionBD;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Enrique
 */
public class TipoServicioDAO extends ClassConexionDAO
{
     public void InsertarTipoServicio (TipoServicio tiser)    
 {
   String Sql;
   
 
   Sql="INSERT INTO tiposervicios(codtiposervicios,nombretiposervicio)  VALUES (";
   Sql=Sql+Rutinas.Apost(tiser.getCodtiposervicio())+",";
   Sql=Sql+Rutinas.Apost(tiser.getNombretiposervicio())+")";
     ConeccionBD.ejecutar(Sql);
 }         
//-----------------------    
public void ModificarTipoServicio(TipoServicio tiser)     
{
   String Sql;
  
   Sql="UPDATE tiposervicios SET ";
   
   Sql=Sql+"nombretiposervicio="+Rutinas.Apost(tiser.getNombretiposervicio());
   Sql=Sql+ " WHERE codtiposervicios="+Rutinas.Apost(tiser.getCodtiposervicio());     
   ConeccionBD.ejecutar(Sql);
}         
//---------------- 
public void Eliminar()    
 {
     
 }         
//-------------------------
public ResultSet BuscarTipoServicio(String cod) throws SQLException    
 {
      String Sql;
     ResultSet RegistroTipoServicio=null;  
      
      Sql="SELECT * FROM tiposervicios WHERE codtiposervicios="+Rutinas.Apost(cod);
                                              
      RegistroTipoServicio=ConeccionBD.consultar(Sql);
      
      return RegistroTipoServicio;
 }         
//--------------------------------------
  public ResultSet ConsultarTipoServicio() throws SQLException
    {
      String Sql;
      ResultSet RegistroTipoServicio=null;  
      
      Sql="SELECT * FROM tiposervicios";
                                              
      RegistroTipoServicio=ConeccionBD.consultar(Sql);
      
      return RegistroTipoServicio;
        
   }
}
