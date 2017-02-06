/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CargoDAO;
import DAO.PersonalDAO;
import Modelos.Cargo;
import Modelos.Mensajes;
import Modelos.Personal1;
import Modelos.Rutinas;
import Vistas.JPersonal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Torrealba
 */
public class ControladorJPersonal implements ActionListener
{
    private JPersonal jperso;
    private boolean Hallado;

    public ControladorJPersonal()
    {
        jperso = new JPersonal();
        jperso.agregarListener(this);
        jperso.setVisible(true);
        jperso.setLocationRelativeTo(null);
        
        //=====================================================================
        
         jperso.getTxtCedula().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaCedula(e); 
               }
              
            @Override
            public void keyPressed(KeyEvent e) 
               {
              try {  
                  CedulaKeyPressed(e);
              } catch (SQLException ex) {
                  Logger.getLogger(ControladorJPersonal.class.getName()).log(Level.SEVERE, null, ex);
              }
               }   
       }
    );          
    
   //=====================================================================
           
       jperso.getTxtNombre().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaNombre(e); 
               }
                 
       }
    );               
       
   //===================================================================== 
       
             jperso.getTxtApellido().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaNombre(e); 
               }
                 
       }
    ); 
       
       
       
       
       
   //=====================================================================
       
        
       jperso.getTxtCodigoCargo().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 CodigoCargokeyTyped(e); 
               }
                 @Override
            public void keyPressed(KeyEvent e) 
               {
              try {  
                  CodigoCargokeyPressed(e);
              } catch (SQLException ex) {
                  Logger.getLogger(ControladorJPersonal.class.getName()).log(Level.SEVERE, null, ex);
              }
               }   
       }
    );       
       
    }
    
    
    //=======================================================================================
    
    private void CedulaKeyPressed(KeyEvent e)throws SQLException
{
  String Cadena;
 Date Fecha;
   SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
  int Opcion;
  
   PersonalDAO daoperso;
  ResultSet RegistroPersonal;
  Personal1 perso =new Personal1();
  Cadena=jperso.getTxtCedula().getText().trim();   
   
   if (e.getKeyChar()==10 && Cadena.length() > 0)
   {
        daoperso = new PersonalDAO();
        RegistroPersonal=daoperso.BuscarPersonal(Cadena);
     
      if (! RegistroPersonal.next()) 
       {  
          
         
         jperso.getTxtNombre().requestFocusInWindow();
       // Enabled(true);
        Hallado=false;
         return;
       }
      Hallado=true;
     // Enabled(true); 
      jperso.getTxtNombre().setText(RegistroPersonal.getString("nombrePer"));
      jperso.getTxtApellido().setText(RegistroPersonal.getString("apellidoper"));
      jperso.getTxtCodigoCargo().setText(RegistroPersonal.getString("codCargo"));
      jperso.getFrmtFechaIngreso().setText(RegistroPersonal.getString("fechaIngreso"));
      jperso.getCmbTipoPersonal().setSelectedItem(RegistroPersonal.getString("tipoper"));
      jperso.getCmbEstatus().setSelectedItem(RegistroPersonal.getString("estatusper"));
       
     Opcion=Mensajes.Opciones("Modificar", "Eliminar", "Salir");
     switch (Opcion)
     {
         case 0:
                Enabled(true);  
               
               break; 
         case 1:  Rutinas.Aviso("Comuniquese con el Admnistrador de la base de datos", "");  
             Cancelar();
                break;
         case 2:Cancelar();  
                 Enabled(false);
                 break;
     }   
     return;
   }  
  
}        
    
    
    //==========================================================================
    
    private void ValidaCedula(KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
  Cadena=jperso.getTxtCedula().getText();
  if (Cadena.length()==10)
    {  
      e.consume();  
      return;
    }
  
  Tecla=e.getKeyChar();
  if (Tecla<'0' || Tecla>'9')
    e.consume();  
}        

    
    //============================================================================
    
     private void ValidaNombre(KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
  Cadena=jperso.getTxtNombre().getText();
  if (Cadena.length()==30)
    {  
      e.consume();  
      return;
    }
  
  Tecla=e.getKeyChar();
   Cadena=Tecla+"";
   Cadena=Cadena.toUpperCase();
   Tecla=Cadena.charAt(0);
   
   if (Tecla==' ')
     return;  
   
   if (Tecla <'A' || Tecla > 'Z')
     e.consume();  
}    
     
 //==============================================================================    

     
    
     
  private void CodigoCargokeyPressed(KeyEvent e)throws SQLException
 {
   String Cadena;
   
   
   Cargo car=new Cargo();
   Cadena=jperso.getTxtCodigoCargo().getText();
   CargoDAO daocar =new CargoDAO();
  ResultSet RegistroCargo;
   
   if (e.getKeyChar()==10 && Cadena.length() > 0)
   { 
       daocar=new CargoDAO();
      RegistroCargo=daocar.BuscarCargo(Cadena);
     
      if (!RegistroCargo.next()) 
       {  
         Enabled(true);
         Mensajes.Aviso("No Existe el Cargo", "");  
           jperso.getTxtCodigoCargo().requestFocusInWindow();
          Hallado=false;
          return;
       }
       Hallado=true;
      jperso.getTxtNombreCargo().setText(RegistroCargo.getString("nombrecargo"));
   
   }
 }
     
     //====================================================================================
     
     
     
       private void Cancelar()
    { 
        Enabled(false); 
      jperso.getTxtCedula().setText(""); 
      jperso.getTxtNombre().setText("");
      jperso.getTxtApellido().setText("");
      jperso.getFrmtFechaIngreso().setText("");
      jperso.getTxtCodigoCargo().setText("");
      jperso.getTxtNombreCargo().setText("");
      jperso.getCmbTipoPersonal().setSelectedIndex(0);
      jperso.getCmbEstatus().setSelectedIndex(0);
     
      
      jperso.getTxtCedula().requestFocusInWindow();
    }  
       
       
 //====================================================================================
       
    private void CodigoCargokeyTyped(KeyEvent e)
 {
   String Cadena;
   char Caracter;
   
   Cadena=jperso.getTxtCodigoCargo().getText();
   if (Cadena.length()==8)     
   {
     e.consume();
     return;
   }  
   
   Caracter=e.getKeyChar();
   if (Caracter <'0' || Caracter > '9')
     e.consume();  
 }
       
      
  //==================================================================================== 
    
    private void Enabled(boolean status)
  {
      jperso.getTxtCedula().setEnabled(!status);
      jperso.getTxtNombre().setEnabled(status);
      jperso.getFrmtFechaIngreso().setEnabled(status);
      jperso.getTxtCodigoCargo().setEnabled(status);
      jperso.getTxtApellido().setEnabled(status);
      jperso.getTxtNombreCargo().setEnabled(status);
      jperso.getCmbTipoPersonal().setEnabled(status);
      jperso.getCmbEstatus().setEnabled(status);
  }

    
    //==================================================================================== 
    
    
    private void Grabar()throws SQLException
{
    Integer codigo;
    Integer ci;
    String Cadena;
     SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
      
      Personal1 perso;
      Cadena=jperso.getTxtCedula().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Cedula Vacia", "");  
     jperso.getTxtCedula().requestFocusInWindow();
     return;
   } 
  
  Cadena=jperso.getTxtNombre().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Nombre Vacio", "");  
     jperso.getTxtNombre().requestFocusInWindow();
     return;
   } 
  
    Cadena=jperso.getTxtApellido().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Apellido Vacio", "");  
     jperso.getTxtApellido().requestFocusInWindow();
     return;
   } 
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Codigo del cargo Vacio", "");  
     jperso.getTxtCodigoCargo().requestFocusInWindow();
     return;
   } 
   Cadena=jperso.getFrmtFechaIngreso().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Fecha Vacia", "");  
     jperso.getFrmtFechaIngreso().requestFocusInWindow();
     return;
   } 
  if (jperso.getCmbTipoPersonal().getSelectedIndex()==0)  
   {
     Rutinas.Aviso("Debe Seleccionar un Tipo de Personal", "");   
     jperso.getCmbTipoPersonal().requestFocusInWindow();
     return;
   }   
  
  if (jperso.getCmbEstatus().getSelectedIndex()==0 ) 
   {
     Rutinas.Aviso("Debe Seleccionar Estatus ", "");   
     jperso.getCmbEstatus().requestFocusInWindow();
     return;
   }   
  
  
  String tipo=(String)jperso.getCmbTipoPersonal().getSelectedItem();
   tipo=tipo.trim();
 String estatus= (String)jperso.getCmbEstatus().getSelectedItem();
 
 
  
 //Grabacion************************

Date Fecha= Rutinas.CnvStringFecha(jperso.getFrmtFechaIngreso().getText());

    perso=new Personal1(jperso.getTxtCedula().getText(),
                       jperso.getTxtNombre().getText(),
                       jperso.getTxtApellido().getText(),
                       jperso.getTxtCodigoCargo().getText(),
                       tipo,
                       Fecha,
                       estatus
                       );
 

 Cadena=jperso.getTxtCedula().getText().trim();

 PersonalDAO daoperso=new PersonalDAO();
 ResultSet RegistroPersonal;
 
 RegistroPersonal=daoperso.BuscarPersonal(Cadena.trim());
 
 if (RegistroPersonal.next())
   daoperso.ModificarPersonal(perso);
 else      
   daoperso.InsertarPersonal(perso);
  
  Rutinas.Aviso("Registro Satisfactorio", ""); 
  Cancelar();
  Enabled(false);
} 
    
  //=============================================================================  
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource().equals(jperso.getBtnGuardar()))
            {
                try 
                {
                    Grabar();
                }
                catch (SQLException ex) 
                {
                    Logger.getLogger(ControladorJPersonal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
    
        if(e.getSource().equals(jperso.getBtnCancelar()))
             {
                Cancelar();
             }
          
        if(e.getSource().equals(jperso.getBtnSalir()))
             {
                 jperso.dispose();  
             }
        
        
        
    }
 }//ultimo

