/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.TipoServicioDAO;
import Modelos.Mensajes;
import Modelos.Rutinas;
import Modelos.TipoServicio;
import Vistas.JTipoServicio;
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
public class ControladorJTipoServicio implements ActionListener, KeyListener
{
     private JTipoServicio formTipoServicio; 
    private boolean Hallado;
  
     public  ControladorJTipoServicio ()throws SQLException
    {
       
      formTipoServicio=new JTipoServicio();
      formTipoServicio.agregarListener(this);
      formTipoServicio.setVisible(true);
      formTipoServicio.setLocationRelativeTo(null);
      
      Enabled(false);
      
      
      //------------------------------------------------------------------------   
      //*************************
      // Zona de KeyListener
      //************************
      
      formTipoServicio.getTxtCodTipoServicio().addKeyListener(new KeyAdapter()
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
                  Logger.getLogger(ControladorJTipoServicio.class.getName()).log(Level.SEVERE, null, ex);
              }
               }   
       }
    );          
    
      
      formTipoServicio.getTxtNombreServicio().addKeyListener(new KeyAdapter()
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
  
   TipoServicioDAO daotiser;
  
  ResultSet RegistroTipoServicio;
 TipoServicio tiser=new TipoServicio();
       Cadena= formTipoServicio.getTxtCodTipoServicio().getText().trim();
          
   
   if (e.getKeyChar()==10 && Cadena.length() > 0)
   {
        daotiser = new TipoServicioDAO();
        RegistroTipoServicio=daotiser.BuscarTipoServicio(Cadena);
     
      if (! RegistroTipoServicio.next()) 
       {  
         Enabled(true);  
         
         formTipoServicio.getTxtNombreServicio().requestFocusInWindow();
        
        Hallado=false;
         return;
       }
      Hallado=true;
      Enabled(true); 
     formTipoServicio.getTxtNombreServicio().setText(RegistroTipoServicio.getString("nombretiposervicio"));
      
      
       
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
 
//---------------------------------------------------------  
 private void ValidaNombre(KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
  Cadena=formTipoServicio.getTxtNombreServicio().getText();
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
   
     //--------------------------------
      private void ValidaCodigo (KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
  Cadena=formTipoServicio.getTxtCodTipoServicio().getText();
  if (Cadena.length()==10)
    {  
      e.consume();  
      return;
    }
  
  Tecla=e.getKeyChar();
  if (Tecla<'0' || Tecla>'9')
    e.consume();  
}         
       //---------------------------------------------------------------------
 
  //-------------------------
   //Colocar Cajitas Inactivas
   //----------------------------
  
  private void Enabled(boolean status)
  {
     formTipoServicio.getTxtCodTipoServicio().setEnabled(!status);
     formTipoServicio.getTxtNombreServicio().setEnabled(status);
     
  }
//---------------------------------------------------
  
  //--------------------------------------------------
  //Rutina para Cancelar Boton
  //----------------------------------------------
   
      private void Cancelar()
    { Enabled(false); 
      formTipoServicio.getTxtCodTipoServicio().setText(""); 
      formTipoServicio.getTxtNombreServicio().setText("");
      
     
      
      
     formTipoServicio.getTxtCodTipoServicio().requestFocusInWindow();
    }  
   
      
    private void Grabar()throws SQLException
{
    Integer codigo;
    
    String Cadena;
    
      
      TipoServicio tiser;
      Cadena=formTipoServicio.getTxtCodTipoServicio().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Codigo Vacio", "");  
     formTipoServicio.getTxtCodTipoServicio().requestFocusInWindow();
     return;
   } 
  
  Cadena=formTipoServicio.getTxtNombreServicio().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Nombre Vacio", "");  
     formTipoServicio.getTxtNombreServicio().requestFocusInWindow();
     return;
   } 
  
  
  
  
 
  String codi=formTipoServicio.getTxtCodTipoServicio().getText();
 codigo=Integer.parseInt(codi);
 //Grabacion************************


tiser=new TipoServicio(formTipoServicio.getTxtCodTipoServicio().getText(),
              formTipoServicio.getTxtNombreServicio().getText()
              
                       );
 

 Cadena=formTipoServicio.getTxtCodTipoServicio().getText().trim();

 TipoServicioDAO daotiser=new TipoServicioDAO();
 ResultSet RegistroTipoServicio;
 if (!Hallado)

   daotiser.InsertarTipoServicio(tiser);
 else
    daotiser.ModificarTipoServicio(tiser);
  
     Rutinas.Aviso("Registro Satisfactorio", ""); 
  Cancelar();
  Enabled(false);
} 

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(formTipoServicio.getBtnGuardar()))
       {
            try {
                Grabar();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJTipoServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
       }   
        //--------------------------------------------------------------   
       if(e.getSource().equals(formTipoServicio.getBtnCancelar()))
       {
         Cancelar();  
        }       
        
        if(e.getSource().equals(formTipoServicio.getBtnSalir()))
       {
       formTipoServicio.dispose();  
    
       }  
      
      if(e.getSource().equals(formTipoServicio.getBtnConsultar()))
       {
           try {
                new ControladorJConsultarTipoServicio();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJTipoServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
       }  
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
