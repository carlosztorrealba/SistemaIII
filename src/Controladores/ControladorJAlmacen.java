/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.AlmacenDAO;
import Modelos.Almacen;
import Modelos.Mensajes;
import Modelos.Rutinas;
import Vistas.JAlmacen;
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
public class ControladorJAlmacen implements  ActionListener,KeyListener 
{
 private JAlmacen formAlmacen; 
    private boolean Hallado;
  
     public  ControladorJAlmacen ()throws SQLException
    {
       
      formAlmacen=new JAlmacen();
      formAlmacen.agregarListener(this);
      formAlmacen.setVisible(true);
      formAlmacen.setLocationRelativeTo(null);
      
      Enabled(false);
      
       //------------------------------------------------------------------------   
      //*************************
      // Zona de KeyListener
      //************************
      
      
      
     formAlmacen.getTxtCodAlmacen().addKeyListener(new KeyAdapter()
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
                  Logger.getLogger(ControladorJAlmacen.class.getName()).log(Level.SEVERE, null, ex);
              }
               }   
       }
    );          
    
      
       formAlmacen.getTxtDescripcion().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaNombre(e); 
               }
                 
       }
    );  
      
  
    }   
       
    private void CodigoKeyPressed(KeyEvent e)throws SQLException
{
  String Cadena;
 
  int Opcion;
  
   AlmacenDAO daoalma;
  
  ResultSet RegistroAlmacen ;
 Almacen  alma=new Almacen ();
  Cadena=formAlmacen.getTxtCodAlmacen().getText().trim();
          
   
   if (e.getKeyChar()==10 && Cadena.length() > 0)
   {
        daoalma = new AlmacenDAO ();
        RegistroAlmacen =daoalma.BuscarAlmacen (Cadena);
     
      if (! RegistroAlmacen .next()) 
       {  
         Enabled(true);  
         
         formAlmacen.getTxtCodAlmacen().requestFocusInWindow();
        
        Hallado=false;
         return;
       }
      Hallado=true;
      Enabled(true); 
      formAlmacen.getTxtDescripcion().setText(RegistroAlmacen.getString("nombrealmacen"));
      
       
     Opcion=Mensajes.Opciones("Modificar", "Eliminar", "Salir");
     switch (Opcion)
     {
         case 0:
                Enabled(true);  
               
               break; 
         case 1:    Rutinas.Aviso("Comuniquese con el Admnistrador de la base de datos", "");  
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
  
  Cadena=formAlmacen.getTxtCodAlmacen().getText();
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
  
  Cadena=formAlmacen.getTxtDescripcion().getText();
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
      formAlmacen.getTxtCodAlmacen().setEnabled(!status);
      formAlmacen.getTxtDescripcion().setEnabled(status);
      
     
  }
//---------------------------------------------------
  
  //--------------------------------------------------
  //Rutina para Cancelar Boton
  //----------------------------------------------
   
      private void Cancelar()
    { 
        Enabled(false); 
      formAlmacen.getTxtCodAlmacen().setText(""); 
      formAlmacen.getTxtDescripcion().setText("");
   
       formAlmacen.getTxtCodAlmacen().requestFocusInWindow();
    }  
      
      
      
      
private void Grabar()throws SQLException
{
    Integer codigo;
    
    String Cadena;
    
      
      Almacen alma;
      Cadena=formAlmacen.getTxtCodAlmacen().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Codigo Vacio", "");  
     formAlmacen.getTxtCodAlmacen().requestFocusInWindow();
     return;
   } 
  
  Cadena=formAlmacen.getTxtDescripcion().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Nombre Vacio", "");  
     formAlmacen.getTxtDescripcion().requestFocusInWindow();
     return;
   } 

 
 //Grabacion************************


alma=new Almacen(formAlmacen.getTxtCodAlmacen().getText(),
               formAlmacen.getTxtDescripcion().getText()
                         );
 

 Cadena=formAlmacen.getTxtCodAlmacen().getText().trim();

 AlmacenDAO daoalma=new AlmacenDAO();
 ResultSet RegistroAlmacen;
 if (!Hallado)

   daoalma.InsertarAlmacen(alma);
 else
    daoalma.ModificarAlmacen(alma);
  
     Rutinas.Aviso("Registro Satisfactorio", ""); 
  Cancelar();
  Enabled(false);
} 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(formAlmacen.getBtnGuardar()))
       {
            try {
                Grabar();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            }
       }   
        //--------------------------------------------------------------   
       if(e.getSource().equals(formAlmacen.getBtnCancelar()))
       {
         Cancelar();  
        }       
        
        if(e.getSource().equals(formAlmacen.getBtnSalir()))
       {
       formAlmacen.dispose();  
       }
        
        if(e.getSource().equals(formAlmacen.getBtnConsultar()))
       {  
        
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
