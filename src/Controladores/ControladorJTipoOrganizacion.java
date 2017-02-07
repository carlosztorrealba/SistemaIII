/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.TipoOrgDAO;
import Modelos.Mensajes;
import Modelos.Rutinas;
import Modelos.TipoOrganizacion;
import Vistas.JTipoOrganizacion;
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
 * @author Carlos Enrique
 */
public class ControladorJTipoOrganizacion implements ActionListener
{
    private JTipoOrganizacion formtipoorg; 
    private boolean Hallado;
  
     public  ControladorJTipoOrganizacion()throws SQLException
    {
       
      formtipoorg=new JTipoOrganizacion();
      formtipoorg.agregarListener(this);
      formtipoorg.setVisible(true);
      formtipoorg.setLocationRelativeTo(null);
      
      Enabled(false);
       //------------------------------------------------------------------------   
      //*************************
      // Zona de KeyListener
      //************************
      
      formtipoorg.getTxtCodTipoOrg().addKeyListener(new KeyAdapter()
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
                  Logger.getLogger(ControladorJTipoOrganizacion.class.getName()).log(Level.SEVERE, null, ex);
              }
               }   
       }
    );          
    
      
      formtipoorg.getTxtNombreTipoOrg().addKeyListener(new KeyAdapter()
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
  
   TipoOrgDAO daotima;
  
  ResultSet RegistroTipoOrg;
 TipoOrganizacion tima=new TipoOrganizacion();
  Cadena=formtipoorg.getTxtCodTipoOrg().getText().trim();
          
   
   if (e.getKeyChar()==10 && Cadena.length() > 0)
   {
        daotima = new TipoOrgDAO();
        RegistroTipoOrg=daotima.BuscarTipoOrganizacion(Cadena);
     
      if (! RegistroTipoOrg.next()) 
       {  
         Enabled(true);  
         
         formtipoorg.getTxtNombreTipoOrg().requestFocusInWindow();
        
        Hallado=false;
         return;
       }
      Hallado=true;
      Enabled(true); 
     formtipoorg.getTxtNombreTipoOrg().setText(RegistroTipoOrg.getString("nombreorg"));
      
      
       
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
  
  Cadena=formtipoorg.getTxtNombreTipoOrg().getText();
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
  
  Cadena=formtipoorg.getTxtCodTipoOrg().getText();
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
     formtipoorg.getTxtCodTipoOrg().setEnabled(!status);
     formtipoorg.getTxtNombreTipoOrg().setEnabled(status);
     
  }
//---------------------------------------------------
  
  //--------------------------------------------------
  //Rutina para Cancelar Boton
  //----------------------------------------------
   
      private void Cancelar()
    { Enabled(false); 
      formtipoorg.getTxtCodTipoOrg().setText(""); 
      formtipoorg.getTxtNombreTipoOrg().setText("");
      
     
      
      
     formtipoorg.getTxtCodTipoOrg().requestFocusInWindow();
    }  
   
   //------------------------------------   
    private void Grabar()throws SQLException
{
    Integer codigo;
    
    String Cadena;
    
      
      TipoOrganizacion tima;
      Cadena=formtipoorg.getTxtCodTipoOrg().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Codigo Vacio", "");  
     formtipoorg.getTxtCodTipoOrg().requestFocusInWindow();
     return;
   } 
  
  Cadena=formtipoorg.getTxtNombreTipoOrg().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Nombre Vacio", "");  
     formtipoorg.getTxtNombreTipoOrg().requestFocusInWindow();
     return;
   } 
  
  
  
 
 
 //Grabacion************************


tima=new TipoOrganizacion( formtipoorg.getTxtCodTipoOrg().getText(),
              formtipoorg.getTxtNombreTipoOrg().getText()
                       );
 

 Cadena=formtipoorg.getTxtCodTipoOrg().getText().trim();

 TipoOrgDAO daotima=new TipoOrgDAO();
 ResultSet RegistroTipoOrganizacion;
 if (!Hallado)

   daotima.InsertarTipoOrganizacion(tima);
 else
    daotima.ModificarTipoOrganizacion(tima);
  
     Rutinas.Aviso("Registro Satisfactorio", ""); 
  Cancelar();
  Enabled(false);
} 

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(formtipoorg.getBtnGuardar()))
       {
            try {
                Grabar();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJTipoInsumo.class.getName()).log(Level.SEVERE, null, ex);
            }
       }   
        //--------------------------------------------------------------   
       if(e.getSource().equals(formtipoorg.getBtnCancelar()))
       {
         Cancelar();  
        }       
        
        
        if(e.getSource().equals(formtipoorg.getBtnSalir()))
       {
       formtipoorg.dispose();  
       }  
        
        if(e.getSource().equals(formtipoorg.getBtnConsultar()))
       {
            try {
                new ControladorJConsultarTipoOrganizacion();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJTipoOrganizacion.class.getName()).log(Level.SEVERE, null, ex);
            }
       }  
    }

   

    }

