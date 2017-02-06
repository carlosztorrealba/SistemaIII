/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.ClassConexionDAO;
import Modelos.Organizacion;

import Modelos.Rutinas;
import PackageConeccion.ConeccionBD;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Carlos Enrique
 */
public class OrganizacionDAO extends ClassConexionDAO
{
    public void InsertarOrganizacion(Organizacion org)    
 {
   String Sql;
  
   Sql="INSERT INTO organizacion(rif,nombreorg,ciresponsable,nombreresponsable,direccion,codtipoorg)  VALUES (";
   Sql=Sql+Rutinas.Apost(org.getRif())+",";
   Sql=Sql+Rutinas.Apost(org.getNombreorg())+",";
   Sql=Sql+Rutinas.Apost(org.getCiresponsable())+",";
   Sql=Sql+Rutinas.Apost(org.getNombreresponsable())+",";
   Sql=Sql+Rutinas.Apost(org.getDireccion())+",";
   Sql=Sql+Rutinas.Apost(org.getCodtipoorg())+")";
     ConeccionBD.ejecutar(Sql);
 }         
//-----------------------    
public void ModificarOrganizacion(Organizacion org)     
{
   String Sql;

   Sql="UPDATE organizacion SET ";
   
   Sql=Sql+"nombreorg="+Rutinas.Apost(org.getNombreorg())+",";
   Sql=Sql+"ciresponsable="+Rutinas.Apost(org.getCiresponsable())+",";
   Sql=Sql+"nombreresponsable="+Rutinas.Apost(org.getNombreresponsable())+",";
   Sql=Sql+"direccion="+Rutinas.Apost(org.getDireccion())+",";
   Sql=Sql+"codtipoorg="+Rutinas.Apost(org.getCodtipoorg());
   Sql=Sql+ " WHERE rif="+Rutinas.Apost(org.getRif());     
   ConeccionBD.ejecutar(Sql);
}         
//---------------- 
public void Eliminar()    
 {
     
 }         
//-------------------------
public ResultSet BuscarOrganizacion(String ci) throws SQLException    
 {
     String Sql;
     ResultSet RegistroOrganizacion=null;  
      
      Sql="SELECT * FROM organizacion WHERE rif="+Rutinas.Apost(ci);
                                              
      RegistroOrganizacion=ConeccionBD.consultar(Sql);
      
      return RegistroOrganizacion;
 }         
//--------------------------------------
  public ResultSet ConsultarOrganizacion() throws SQLException
    {
      String Sql;
      ResultSet RegistroOrganizacion=null;  
      
      Sql="SELECT * FROM organizacion";
                                              
      RegistroOrganizacion=ConeccionBD.consultar(Sql);
      
      return RegistroOrganizacion;
        
   }
   
  
}
