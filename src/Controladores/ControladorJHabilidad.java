/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.HabilidadDAO;
import Modelos.Habilidad;
import Modelos.Mensajes;
import Modelos.Rutinas;
import Vistas.JHabilidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class ControladorJHabilidad implements ActionListener
{
     private JHabilidad formhab; 
    private boolean Hallado;
    
    public ControladorJHabilidad() throws SQLException
    {
       
      formhab=new JHabilidad();
      formhab.agregarListener(this);
      formhab.setVisible(true);
      formhab.setLocationRelativeTo(null);
      
      Enabled(false);
      
      //------------------------------------------------------------------------   
      //*************************
      // Zona de KeyListener
      //************************
      
      
      
      formhab.getTxtCodHabilidad().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaCodigo(e); 
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {
              try {  
                  CodigoKeyPressed(e);
              } catch (SQLException ex) {
                  Logger.getLogger(ControladorJHabilidad.class.getName()).log(Level.SEVERE, null, ex);
              }
               }   
       }
    );          
    
      
       formhab.getTxtDescripcion().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaNombre(e); 
               }
                 
       }
    );  
      
    }   
 //------------------------------------------------------------      
  private void CodigoKeyPressed(KeyEvent e)throws SQLException
{
  String Cadena;
 
  int Opcion;
  
   HabilidadDAO daohab;
  
  ResultSet RegistroHabilidad;
 Habilidad hab=new Habilidad();
  Cadena=formhab.getTxtCodHabilidad().getText().trim();
          
   
   if (e.getKeyChar()==10 && Cadena.length() > 0)
   {
        daohab = new HabilidadDAO();
        RegistroHabilidad=daohab.BuscarHabilidad(Cadena);
     
      if (! RegistroHabilidad.next()) 
       {  
         Enabled(true);  
         
         formhab.getTxtCodHabilidad().requestFocusInWindow();
        
        Hallado=false;
         return;
       }
      Hallado=true;
      Enabled(true); 
      formhab.getTxtDescripcion().setText(RegistroHabilidad.getString("nombreHabilidad"));
      formhab.getCmbEstatus().setSelectedItem(RegistroHabilidad.getString("estatus"));
      
      
       
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
      
 //-------------------------------------------     
 private void ValidaCodigo (KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
  Cadena=formhab.getTxtCodHabilidad().getText();
  if (Cadena.length()==10)
    {  
      e.consume();  
      return;
    }
  
  Tecla=e.getKeyChar();
  if (Tecla<'0' || Tecla>'9')
    e.consume();  
}        
//---------------------------------------------------------  
 private void ValidaNombre(KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
  Cadena=formhab.getTxtDescripcion().getText();
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
   
   //---------------------------------------------------------------------
 
  //-------------------------
   //Colocar Cajitas Inactivas
   //----------------------------
  
  private void Enabled(boolean status)
  {
      formhab.getTxtCodHabilidad().setEnabled(!status);
      formhab.getTxtDescripcion().setEnabled(status);
      formhab.getCmbEstatus().setEnabled(status);
 
  }
//---------------------------------------------------
  
  //--------------------------------------------------
  //Rutina para Cancelar Boton
  //----------------------------------------------
   
      private void Cancelar()
    { Enabled(false); 
      formhab.getTxtCodHabilidad().setText(""); 
      formhab.getTxtDescripcion().setText("");
      formhab.getCmbEstatus().setSelectedIndex(0);
     
      formhab.getTxtCodHabilidad().requestFocusInWindow();
      
    
    }  
   
      //---------------------------------------------------------
      private void Grabar()throws SQLException
{
    Integer codigo;
    
    String Cadena;
    
      
      Habilidad hab;
      Cadena=formhab.getTxtCodHabilidad().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Codigo Vacio", "");  
     formhab.getTxtCodHabilidad().requestFocusInWindow();
     return;
   } 
  
  Cadena=formhab.getTxtDescripcion().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Descripcion Vacio", "");  
     formhab.getTxtDescripcion().requestFocusInWindow();
     return;
   } 
  
  if (formhab.getCmbEstatus().getSelectedIndex()==0)  
   {
     Rutinas.Aviso("Debe Seleccionar un Estatus", "");   
     formhab.getCmbEstatus().requestFocusInWindow();
     return;
   } 
  

 
 
 //Grabacion************************

String tipo=(String)formhab.getCmbEstatus().getSelectedItem();
   tipo=tipo.trim();
hab=new Habilidad( formhab.getTxtCodHabilidad().getText(),
               formhab.getTxtDescripcion().getText(),
               tipo);
 

 Cadena=formhab.getTxtCodHabilidad().getText().trim();

 HabilidadDAO daohab=new HabilidadDAO();
 ResultSet RegistroHabilidad;
 if (!Hallado)

   daohab.InsertarHabilidad(hab);
 else
    daohab.ModificarHabilidad(hab);
  
     Rutinas.Aviso("Registro Satisfactorio", ""); 
  Cancelar();
  Enabled(false);
} 
//-----------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(formhab.getBtnGuardar()))
       {
            try {
                Grabar();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJCargo.class.getName()).log(Level.SEVERE, null, ex);
            }
       }   
        //--------------------------------------------------------------   
       if(e.getSource().equals(formhab.getBtnCancelar()))
       {
         Cancelar();  
        }              
       //-----------------------------------------------------------------   
      
       if(e.getSource().equals(formhab.getBtnSalir()))
       {
        formhab.dispose();  
       }      
       //----------------------------------------------------------------
       
        //----------------------------------------------------------------
       if(e.getSource().equals(formhab.getBtnConsultar()))
       {  
          
            try {
                new ControladorJConsultarHabilidad();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJCargo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       
       }   
       
    }

      
}
