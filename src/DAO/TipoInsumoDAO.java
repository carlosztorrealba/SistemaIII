
package DAO;
import Modelos.ClassConexionDAO;
import Modelos.Rutinas;
import Modelos.TipoInsumo;
import PackageConeccion.ConeccionBD;
import java.sql.ResultSet;
import java.sql.SQLException;



public class TipoInsumoDAO extends ClassConexionDAO
{
    public void InsertarTipoMaterial(TipoInsumo tima)    
 {
   String Sql;
   
 
   Sql="INSERT INTO tipoinsumo(codtipoinsumo,nombreinsumo)  VALUES (";
   Sql=Sql+Rutinas.Apost(tima.getCodtipoinsumo())+",";
   Sql=Sql+Rutinas.Apost(tima.getNombretipoinsumo())+")";
     ConeccionBD.ejecutar(Sql);
 }         
//-----------------------    
public void ModificarTipoMaterial(TipoInsumo tima)     
{
   String Sql;
  
   Sql="UPDATE tipoinsumo SET ";
   
   Sql=Sql+"nombreinsumo="+Rutinas.Apost(tima.getNombretipoinsumo());
   Sql=Sql+ " WHERE codtipoinsumo="+Rutinas.Apost(tima.getCodtipoinsumo());     
   ConeccionBD.ejecutar(Sql);
}         
//---------------- 
public void Eliminar()    
 {
     
 }         
//-------------------------
public ResultSet BuscarTipoMaterial(String codi) throws SQLException    
 {
      String Sql;
     ResultSet RegistroTipoMaterial=null;  
      
      Sql="SELECT * FROM tipoinsumo WHERE codtipoinsumo="+Rutinas.Apost(codi);
                                              
      RegistroTipoMaterial=ConeccionBD.consultar(Sql);
      
      return RegistroTipoMaterial;
 }         
//--------------------------------------
  public ResultSet ConsultarTipoMaterial() throws SQLException
    {
      String Sql;
      ResultSet RegistroTipoMaterial=null;  
      
      Sql="SELECT * FROM tipoinsumo";
                                              
      RegistroTipoMaterial=ConeccionBD.consultar(Sql);
      
      return RegistroTipoMaterial;
        
   }
}
