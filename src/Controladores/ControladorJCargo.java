/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CargoDAO;
import Modelos.Cargo;
import Modelos.Mensajes;
import Modelos.Rutinas;
import Vistas.JCargo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Enrique
 */
public class ControladorJCargo implements  ActionListener,KeyListener 
{
  
    private JCargo formCargo; 
    private boolean Hallado;
    
    public ControladorJCargo() throws SQLException
    {
       
      formCargo=new JCargo();
      formCargo.agregarListener(this);
      formCargo.setVisible(true);
      formCargo.setLocationRelativeTo(null);
      
      Enabled(false);
      
      //------------------------------------------------------------------------   
      //*************************
      // Zona de KeyListener
      //************************
      
      
      
      formCargo.getTxtCodCargo().addKeyListener(new KeyAdapter()
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
                  Logger.getLogger(ControladorJCargo.class.getName()).log(Level.SEVERE, null, ex);
              }
               }   
       }
    );          
    
      
       formCargo.getTxtNombreCargo().addKeyListener(new KeyAdapter()
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
  
   CargoDAO daocar;
  
  ResultSet RegistroCargo;
 Cargo car=new Cargo();
  Cadena=formCargo.getTxtCodCargo().getText().trim();
          
   
   if (e.getKeyChar()==10 && Cadena.length() > 0)
   {
        daocar = new CargoDAO();
        RegistroCargo=daocar.BuscarCargo(Cadena);
     
      if (! RegistroCargo.next()) 
       {  
         Enabled(true);  
         
         formCargo.getTxtCodCargo().requestFocusInWindow();
        
        Hallado=false;
         return;
       }
      Hallado=true;
      Enabled(true); 
      formCargo.getTxtNombreCargo().setText(RegistroCargo.getString("nombrecargo"));
      
      
       
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
  
  Cadena=formCargo.getTxtCodCargo().getText();
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
  
  Cadena=formCargo.getTxtNombreCargo().getText();
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
      formCargo.getTxtCodCargo().setEnabled(!status);
      formCargo.getTxtNombreCargo().setEnabled(status);
 
  }
//---------------------------------------------------
  
  //--------------------------------------------------
  //Rutina para Cancelar Boton
  //----------------------------------------------
   
      private void Cancelar()
    { Enabled(false); 
      formCargo.getTxtCodCargo().setText(""); 
      formCargo.getTxtNombreCargo().setText("");
      
     
      
      
    
    }  
   
      //---------------------------------------------------------
      private void Grabar()throws SQLException
{
    Integer codigo;
    
    String Cadena;
    
      
      Cargo car;
      Cadena=formCargo.getTxtCodCargo().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Codigo Vacio", "");  
     formCargo.getTxtCodCargo().requestFocusInWindow();
     return;
   } 
  
  Cadena=formCargo.getTxtNombreCargo().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Nombre Vacio", "");  
     formCargo.getTxtNombreCargo().requestFocusInWindow();
     return;
   } 
  
 
  

 
 
 //Grabacion************************


car=new Cargo( formCargo.getTxtCodCargo().getText(),
               formCargo.getTxtNombreCargo().getText()
                       );
 

 Cadena=formCargo.getTxtCodCargo().getText().trim();

 CargoDAO daocar=new CargoDAO();
 ResultSet RegistroCargo;
 if (!Hallado)

   daocar.InsertarCargo(car);
 else
    daocar.ModificarCargo(car);
  
     Rutinas.Aviso("Registro Satisfactorio", ""); 
  Cancelar();
  Enabled(false);
} 
//-----------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(formCargo.getBtnGuardar()))
       {
            try {
                Grabar();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJCargo.class.getName()).log(Level.SEVERE, null, ex);
            }
       }   
        //--------------------------------------------------------------   
       if(e.getSource().equals(formCargo.getBtnCancelar()))
       {
         Cancelar();  
        }              
       //-----------------------------------------------------------------   
      
       if(e.getSource().equals(formCargo.getBtnSalir()))
       {
        formCargo.dispose();  
       }      
       //----------------------------------------------------------------
       
        //----------------------------------------------------------------
       if(e.getSource().equals(formCargo.getBtnConsultar()))
       {  
          
            try {
                new ControladorJConsultarCargo();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJCargo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       
       }   
       
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
      
}