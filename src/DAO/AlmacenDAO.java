
package DAO;


import Modelos.Almacen;
import Modelos.ClassConexionDAO;
import Modelos.Rutinas;
import PackageConeccion.ConeccionBD;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AlmacenDAO extends ClassConexionDAO   {
    
    public void InsertarAlmacen(Almacen alma)    
 {
   String Sql;
   
 
   Sql="INSERT INTO almacen(codalmacen,nombrealmacen)  VALUES (";
   Sql=Sql+Rutinas.Apost(alma.getCodalmacen())+",";
   Sql=Sql+Rutinas.Apost(alma.getDescripcion())+")";
   
     ConeccionBD.ejecutar(Sql);
 }         
//-----------------------    
public void ModificarAlmacen(Almacen alma)     
{
   String Sql;
  
   Sql="UPDATE almacen SET ";
   
   Sql=Sql+"nombrealmacen="+Rutinas.Apost(alma.getDescripcion())+"";
   
   Sql=Sql+ " WHERE codalmacen="+Rutinas.Apost(alma.getCodalmacen());     
   ConeccionBD.ejecutar(Sql);
}         
//---------------- 
public void Eliminar()    
 {
     
 }         
//-------------------------
public ResultSet BuscarAlmacen(String cod) throws SQLException    
 {
     String Sql;
     ResultSet RegistroAlmacen=null;  
      
      Sql="SELECT * FROM almacen WHERE codalmacen="+Rutinas.Apost(cod);
                                              
      RegistroAlmacen=ConeccionBD.consultar(Sql);
      
      return RegistroAlmacen;
 }         
//--------------------------------------
  public ResultSet ConsultarAlmacen() throws SQLException
    {
      String Sql;
      ResultSet RegistroAlmacen=null;  
      
      Sql="SELECT * FROM almacen";
                                              
      RegistroAlmacen=ConeccionBD.consultar(Sql);
      
      return RegistroAlmacen;
        
   }
}
