
package DAO;
import Modelos.ClassConexionDAO;
import Modelos.Rutinas;
import PackageConeccion.ConeccionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelos.Personal1;
import java.text.SimpleDateFormat;

public class PersonalDAO extends ClassConexionDAO  
{
    public void InsertarPersonal(Personal1 perso)    
 {
   String Sql;
   
// SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
   
  // String Fecha=perso.getFechaingreso().toString();
   Sql="INSERT INTO personal(ci,nombreper,apellidoper,codcargo,tipoper,fechaingreso,estatusper)  VALUES (";
   Sql=Sql+Rutinas.Apost(perso.getCedula())+",";
   Sql=Sql+Rutinas.Apost(perso.getNombre())+",";
   Sql=Sql+Rutinas.Apost(perso.getApellido())+",";
   Sql=Sql+Rutinas.Apost(perso.getCodigocargo())+",";
   Sql=Sql+Rutinas.Apost(perso.getTipopersonal())+",";
   Sql=Sql+Rutinas.Apost(perso.getFechaingreso())+",";
   Sql=Sql+Rutinas.Apost(perso.getEstatus())+")";
     ConeccionBD.ejecutar(Sql);
 }         
//-----------------------    
public void ModificarPersonal(Personal1 perso)     
{
   String Sql;
   SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
   
   String Fecha=perso.getFechaingreso().toString();
   Sql="UPDATE personal SET ";
   
   Sql=Sql+"nombreper="+Rutinas.Apost(perso.getNombre())+",";
   Sql=Sql+"apellidoper="+Rutinas.Apost(perso.getApellido())+",";
   Sql=Sql+"codcargo="+Rutinas.Apost(perso.getCodigocargo())+",";
   Sql=Sql+"tipoper="+Rutinas.Apost(perso.getTipopersonal())+",";
   Sql=Sql+"fechaingreso="+Rutinas.Apost(Fecha)+",";
   Sql=Sql+"estatusper="+Rutinas.Apost(perso.getEstatus());
   Sql=Sql+ " WHERE ci="+Rutinas.Apost(perso.getCedula());     
   ConeccionBD.ejecutar(Sql);
}         
//---------------- 
public void Eliminar()    
 {
     
 }         
//-------------------------
public ResultSet BuscarPersonal(String ci) throws SQLException    
 {
     String Sql;
     ResultSet RegistroPersonal=null;  
      
      Sql="SELECT * FROM personal WHERE ci="+Rutinas.Apost(ci);
                                              
      RegistroPersonal=ConeccionBD.consultar(Sql);
      
      return RegistroPersonal;
 }         
//--------------------------------------
  public ResultSet ConsultarPersonal() throws SQLException
    {
      String Sql;
      ResultSet RegistroPersonal=null;  
      
      Sql="SELECT * FROM personal";
                                              
      RegistroPersonal=ConeccionBD.consultar(Sql);
      
      return RegistroPersonal;
        
   }
   
  
}
