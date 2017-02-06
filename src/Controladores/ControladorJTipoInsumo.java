/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.TipoInsumoDAO;
import Modelos.Mensajes;
import Modelos.Rutinas;
import Modelos.TipoInsumo;
import Vistas.JTipoInsumo;
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
public class ControladorJTipoInsumo implements  ActionListener, KeyListener  {

    private JTipoInsumo formTipoMaterial; 
    private boolean Hallado;
  
     public  ControladorJTipoInsumo ()throws SQLException
    {
       
      formTipoMaterial=new JTipoInsumo();
      formTipoMaterial.agregarListener(this);
      formTipoMaterial.setVisible(true);
      formTipoMaterial.setLocationRelativeTo(null);
      
      Enabled(false);
       //------------------------------------------------------------------------   
      //*************************
      // Zona de KeyListener
      //************************
      
      formTipoMaterial.getTxtCodInsumo().addKeyListener(new KeyAdapter()
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
                  Logger.getLogger(ControladorJTipoInsumo.class.getName()).log(Level.SEVERE, null, ex);
              }
               }   
       }
    );          
    
      
      formTipoMaterial.getTxtNombreInsumo().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaNombre(e); 
               }
                 
       }
    );  
      
    }     
  //-----------------------------------------------------------------    
  private void CodigoKeyPressed(KeyEvent e)throws SQLException
{
  String Cadena;
 
  int Opcion;
  
   TipoInsumoDAO daotima;
  
  ResultSet RegistroTipoMaterial;
 TipoInsumo tima=new TipoInsumo();
  Cadena=formTipoMaterial.getTxtCodInsumo().getText().trim();
          
   
   if (e.getKeyChar()==10 && Cadena.length() > 0)
   {
        daotima = new TipoInsumoDAO();
        RegistroTipoMaterial=daotima.BuscarTipoMaterial(Cadena);
     
      if (! RegistroTipoMaterial.next()) 
       {  
         Enabled(true);  
         
         formTipoMaterial.getTxtNombreInsumo().requestFocusInWindow();
        
        Hallado=false;
         return;
       }
      Hallado=true;
      Enabled(true); 
     formTipoMaterial.getTxtNombreInsumo().setText(RegistroTipoMaterial.getString("nombreinsumo"));
      
      
       
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
  
  Cadena=formTipoMaterial.getTxtNombreInsumo().getText();
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
  
  Cadena=formTipoMaterial.getTxtCodInsumo().getText();
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
     formTipoMaterial.getTxtCodInsumo().setEnabled(!status);
     formTipoMaterial.getTxtNombreInsumo().setEnabled(status);
     
  }
//---------------------------------------------------
  
  //--------------------------------------------------
  //Rutina para Cancelar Boton
  //----------------------------------------------
   
      private void Cancelar()
    { Enabled(false); 
      formTipoMaterial.getTxtCodInsumo().setText(""); 
      formTipoMaterial.getTxtNombreInsumo().setText("");
      
     
      
      
     formTipoMaterial.getTxtCodInsumo().requestFocusInWindow();
    }  
   
   //------------------------------------   
    private void Grabar()throws SQLException
{
    Integer codigo;
    
    String Cadena;
    
      
      TipoInsumo tima;
      Cadena=formTipoMaterial.getTxtCodInsumo().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Codigo Vacio", "");  
     formTipoMaterial.getTxtCodInsumo().requestFocusInWindow();
     return;
   } 
  
  Cadena=formTipoMaterial.getTxtNombreInsumo().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Nombre Vacio", "");  
     formTipoMaterial.getTxtNombreInsumo().requestFocusInWindow();
     return;
   } 
  
  
  
 
 
 //Grabacion************************


tima=new TipoInsumo( formTipoMaterial.getTxtCodInsumo().getText(),
              formTipoMaterial.getTxtNombreInsumo().getText()
                       );
 

 Cadena=formTipoMaterial.getTxtCodInsumo().getText().trim();

 TipoInsumoDAO daotima=new TipoInsumoDAO();
 ResultSet RegistroTipoMaterial;
 if (!Hallado)

   daotima.InsertarTipoMaterial(tima);
 else
    daotima.ModificarTipoMaterial(tima);
  
     Rutinas.Aviso("Registro Satisfactorio", ""); 
  Cancelar();
  Enabled(false);
} 

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(formTipoMaterial.getBtnGuardar()))
       {
            try {
                Grabar();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJTipoInsumo.class.getName()).log(Level.SEVERE, null, ex);
            }
       }   
        //--------------------------------------------------------------   
       if(e.getSource().equals(formTipoMaterial.getBtnCancelar()))
       {
         Cancelar();  
        }       
        
        
        if(e.getSource().equals(formTipoMaterial.getBtnSalir()))
       {
       formTipoMaterial.dispose();  
       }  
        
        if(e.getSource().equals(formTipoMaterial.getBtnConsultar()))
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
