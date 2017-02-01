
package Dao;

import Modelos.ClassConexionDAO;
import Modelos.Rutinas;
import Modelos.Usuario;
import PackageConeccion.ConeccionBD;
import java.sql.ResultSet;

public class UsuarioDAO extends ClassConexionDAO
{
  
   public ResultSet buscarUsuario(String cedula, String password) 
   {
      ResultSet regisUsua;
      String Sql;
      
      cedula=cedula.trim();
      Sql="SELECT * FROM usuario WHERE cedula="+Rutinas.Apost(cedula);
      Sql=Sql+" AND password="+Rutinas.Apost(password);
      regisUsua=PackageConeccion.ConeccionBD.consultar(Sql);
      
      return regisUsua;
      
   }   
   
   public void InsertarUsuario(Usuario usa)    
 {
   String Sql;
   
 
   Sql="INSERT INTO usuario(cedula,password)  VALUES (";
   Sql=Sql+Rutinas.Apost(usa.getUsuario())+",";
   Sql=Sql+Rutinas.Apost(usa.getContraseña())+")";
     ConeccionBD.ejecutar(Sql);
 }         
//-----------------------    
public void Modificarpassword(Usuario usa)     
{
   String Sql;
  
   Sql="UPDATE usuario SET ";
   
   
   Sql=Sql+"password="+Rutinas.Apost(usa.getContraseña());
   
   Sql=Sql+ " WHERE cedula="+Rutinas.Apost(usa.getUsuario());     
   ConeccionBD.ejecutar(Sql);
}         
 //------------------------------------------------
   public ResultSet buscarUsuarioCargo(String cedula, String password) 
   {
      ResultSet regisUsua;
      String Sql;
      
      cedula=cedula.trim();
      Sql="SELECT * FROM vistausuariocargos WHERE cedula="+Rutinas.Apost(cedula);
      Sql=Sql+" AND password="+Rutinas.Apost(password);
      regisUsua=PackageConeccion.ConeccionBD.consultar(Sql);
      
      return regisUsua;
      
   }   

   
   public ResultSet BuscarUsuario(String cedula) 
   {
      ResultSet regisUsua;
      String Sql;
      
      cedula=cedula.trim();
      Sql="SELECT * FROM usuario WHERE cedula="+Rutinas.Apost(cedula);
      regisUsua=PackageConeccion.ConeccionBD.consultar(Sql);
      
      return regisUsua;
      
   } 
}
