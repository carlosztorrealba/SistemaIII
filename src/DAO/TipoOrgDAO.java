/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.ClassConexionDAO;
import Modelos.Rutinas;
import Modelos.TipoOrganizacion;
import PackageConeccion.ConeccionBD;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Enrique
 */
public class TipoOrgDAO extends ClassConexionDAO
{

    public void InsertarTipoOrganizacion(TipoOrganizacion tima)    
 {
   String Sql;
   
 
   Sql="INSERT INTO tipoorganizacion(codtipoorg,nombreorg)  VALUES (";
   Sql=Sql+Rutinas.Apost(tima.getCodtipoorg())+",";
   Sql=Sql+Rutinas.Apost(tima.getNombretipoorg())+")";
     ConeccionBD.ejecutar(Sql);
 }      
//-----------------------    
public void ModificarTipoOrganizacion(TipoOrganizacion tima)     
{
   String Sql;
  
   Sql="UPDATE tipoorganizacion SET ";
   
   Sql=Sql+"nombreorg="+Rutinas.Apost(tima.getNombretipoorg());
   Sql=Sql+ " WHERE codtipoorg="+Rutinas.Apost(tima.getCodtipoorg());     
   ConeccionBD.ejecutar(Sql);
}         
//---------------- 
public void Eliminar()    
 {
     
 }         
//-------------------------
public ResultSet BuscarTipoOrganizacion(String codi) throws SQLException    
 {
      String Sql;
     ResultSet RegistroTipoOrganizacion=null;  
      
      Sql="SELECT * FROM tipoorganizacion WHERE codtipoorg="+Rutinas.Apost(codi);
                                              
      RegistroTipoOrganizacion=ConeccionBD.consultar(Sql);
      
      return RegistroTipoOrganizacion;
 }         
//--------------------------------------
  public ResultSet ConsultarTipoOrganizacion() throws SQLException
    {
      String Sql;
      ResultSet RegistroTipoOrganizacion=null;  
      
      Sql="SELECT * FROM tipoorganizacion";
                                              
      RegistroTipoOrganizacion=ConeccionBD.consultar(Sql);
      
      return RegistroTipoOrganizacion;
        
   }
}