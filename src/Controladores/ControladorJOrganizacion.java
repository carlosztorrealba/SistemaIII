/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.OrganizacionDAO;
import DAO.TipoOrgDAO;
import Modelos.Mensajes;
import Modelos.Organizacion;
import Modelos.Rutinas;
import Modelos.TipoOrganizacion;
import Vistas.JOrganizacion;
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
public class ControladorJOrganizacion implements ActionListener, KeyListener
{
    private JOrganizacion jorg;
    private boolean Hallado;

    public ControladorJOrganizacion()
    {
        jorg = new JOrganizacion();
        jorg.agregarListener(this);
        jorg.setVisible(true);
        jorg.setLocationRelativeTo(null);
        
        
   //=========================================================================     
        
        jorg.getTxtRifOrg().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaRif(e); 
               }
              
            @Override
            public void keyPressed(KeyEvent e) 
               {
              try {  
                  RifKeyPressed(e);
              } catch (SQLException ex) {
                  Logger.getLogger(ControladorJPersonal.class.getName()).log(Level.SEVERE, null, ex);
              }
               }   
       }
    ); 
        
   //=========================================================================     
        
       jorg.getTxtNombreOrg().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaNombre(e); 
               }
                 
       }
    );               
       
    //========================================================================= 
               
               
      jorg.getTxtNombreResp().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaNombreResponsable(e); 
               }
                 
       }
    );                
               
    //=========================================================================           
       jorg.getTxtCedResp().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaCedula(e); 
               }
      }
       );
     //=========================================================================          
               
      jorg.getTxtDireccion().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaDireccion(e); 
               }
                 
       }
    );  
               
               
 //=========================================================================              
               
               
        jorg.getTxtCodTipoOrg().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 CodigoOrganizacionkeyTyped(e); 
               }
                 @Override
            public void keyPressed(KeyEvent e) 
               {
              try {  
                  CodigoOrganizacionkeyPressed(e);
              } catch (SQLException ex) {
                  Logger.getLogger(ControladorJPersonal.class.getName()).log(Level.SEVERE, null, ex);
              }
               }   
       }
    );       
       
    }
    
//=========================================================================
    
      private void ValidaRif(KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
  Cadena=jorg.getTxtRifOrg().getText();
  if (Cadena.length()==10)
    {  
      e.consume();  
      return;
    }
  
  Tecla=e.getKeyChar();
  if (Tecla<'0' || Tecla>'9')
    e.consume();  
}        
 
//=========================================================================   
    
          private void ValidaCedula(KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
  Cadena=jorg.getTxtCedResp().getText();
  if (Cadena.length()==10)
    {  
      e.consume();  
      return;
    }
  
  Tecla=e.getKeyChar();
  if (Tecla<'0' || Tecla>'9')
    e.consume();  
}  
//========================================================================= 
          
       private void ValidaNombre(KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
  Cadena=jorg.getTxtNombreOrg().getText();
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
          
//========================================================================= 
       
    private void CodigoOrganizacionkeyTyped(KeyEvent e)
 {
   String Cadena;
   char Caracter;
   
   Cadena=jorg.getTxtCodTipoOrg().getText();
   if (Cadena.length()==8)     
   {
     e.consume();
     return;
   }  
   
   Caracter=e.getKeyChar();
   if (Caracter <'0' || Caracter > '9')
     e.consume();  
 }       
        
//=========================================================================          
          
  private void ValidaDireccion(KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
  Cadena=jorg.getTxtDireccion().getText();
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
 //=========================================================================         
          
  private void ValidaNombreResponsable(KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
  Cadena=jorg.getTxtNombreResp().getText();
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
//=========================================================================
  
    private void CodigoOrganizacionkeyPressed(KeyEvent e)throws SQLException
 {
   String Cadena;
   
   
   TipoOrganizacion tipoorg=new TipoOrganizacion();
   Cadena=jorg.getTxtCodTipoOrg().getText();
   TipoOrgDAO daorg =new TipoOrgDAO();
  ResultSet RegistroOrg;
   
   if (e.getKeyChar()==10 && Cadena.length() > 0)
   { 
       daorg=new TipoOrgDAO();
      RegistroOrg=daorg.BuscarTipoOrganizacion(Cadena);
     
      if (!RegistroOrg.next()) 
       {  
         Enabled(true);
         Mensajes.Aviso("No Existe el Tipo de Organizacion", "");  
           jorg.getTxtCodTipoOrg().requestFocusInWindow();
          Hallado=false;
          return;
       }
       Hallado=true;
      jorg.getTxtNombreTipoOrg().setText(RegistroOrg.getString("nombreorg"));
   
   }
 }
          
          
//=========================================================================          
          
          
  private void RifKeyPressed(KeyEvent e)throws SQLException
{
  String Cadena;

   
  int Opcion;
  
   OrganizacionDAO daoorg;
  ResultSet RegistroOrganizacion;
  Organizacion perso =new Organizacion();
  Cadena=jorg.getTxtRifOrg().getText().trim();   
   
   if (e.getKeyChar()==10 && Cadena.length() > 0)
   {
        daoorg = new OrganizacionDAO();
        RegistroOrganizacion=daoorg.BuscarOrganizacion(Cadena);
     
      if (! RegistroOrganizacion.next()) 
       {  
          
         
         jorg.getTxtNombreOrg().requestFocusInWindow();
        //Enabled(true)
        Hallado=false;
         return;
       }
      Hallado=true;
     // Enabled(true); 
      jorg.getTxtNombreOrg().setText(RegistroOrganizacion.getString("nombreorg"));
      jorg.getTxtCedResp().setText(RegistroOrganizacion.getString("ciresponsable"));
      jorg.getTxtNombreResp().setText(RegistroOrganizacion.getString("nombreresponsable"));
      jorg.getTxtDireccion().setText(RegistroOrganizacion.getString("direccion"));
      jorg.getTxtCodTipoOrg().setText(RegistroOrganizacion.getString("codtipoorg"));
     
       
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
          
          
 //=========================================================================   
  
      
    private void Enabled(boolean status)
  {
      jorg.getTxtRifOrg().setEnabled(!status);
      jorg.getTxtNombreOrg().setEnabled(status);
      jorg.getTxtCedResp().setEnabled(status);
      jorg.getTxtNombreResp().setEnabled(status);
      jorg.getTxtDireccion().setEnabled(status);
      jorg.getTxtCodTipoOrg().setEnabled(status);
      jorg.getTxtNombreTipoOrg().setEnabled(status);
  }
 //=========================================================================
          
   private void Cancelar()
    { 
        Enabled(false); 
      jorg.getTxtRifOrg().setText("");
      jorg.getTxtNombreOrg().setText("");
      jorg.getTxtCedResp().setText("");
      jorg.getTxtNombreResp().setText("");
      jorg.getTxtDireccion().setText("");
      jorg.getTxtCodTipoOrg().setText("");
      jorg.getTxtNombreTipoOrg().setText("");
      
      jorg.getTxtRifOrg().requestFocusInWindow();
    }          
    //========================================================================= 
       private void Grabar()throws SQLException
{
    Integer codigo;
    Integer ci;
    String Cadena;
   
      
      Organizacion orga;
      Cadena=jorg.getTxtRifOrg().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Rif Vacio", "");  
     jorg.getTxtRifOrg().requestFocusInWindow();
     return;
   }
  
        Cadena=jorg.getTxtCedResp().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Cedula del Responsable Vacio", "");  
     jorg.getTxtCedResp().requestFocusInWindow();
     return;
   } 
  
  Cadena=jorg.getTxtNombreOrg().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Nombre de la Organizacion Vacio", "");  
     jorg.getTxtNombreOrg().requestFocusInWindow();
     return;
   } 
  
    Cadena=jorg.getTxtNombreResp().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Nombre del Responsable Vacio", "");  
     jorg.getTxtNombreResp().requestFocusInWindow();
     return;
   } 
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Codigo del Tipo de Organizacion Vacio", "");  
     jorg.getTxtCodTipoOrg().requestFocusInWindow();
     return;
   } 
     Cadena=jorg.getTxtDireccion().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Direccion Vacio", "");  
     jorg.getTxtDireccion().requestFocusInWindow();
     return;
   }  
  
  
  
 
  
 //Grabacion************************



    orga=new Organizacion(jorg.getTxtRifOrg().getText(),
                       jorg.getTxtNombreOrg().getText(),
                       jorg.getTxtCedResp().getText(),
                       jorg.getTxtNombreResp().getText(),
                       jorg.getTxtDireccion().getText(),
                       jorg.getTxtCodTipoOrg().getText()
                       );
 

 Cadena=jorg.getTxtRifOrg().getText().trim();

 OrganizacionDAO daorg=new OrganizacionDAO();
 ResultSet RegistroOrganizacion;
 
 RegistroOrganizacion=daorg.BuscarOrganizacion(Cadena.trim());
 
 if (RegistroOrganizacion.next())
   daorg.ModificarOrganizacion(orga);
 else      
   daorg.InsertarOrganizacion(orga);
  
  Rutinas.Aviso("Registro Satisfactorio", ""); 
  Cancelar();
  Enabled(false);
}
   

  //=========================================================================         
          
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(jorg.getBtnGuardar()))
            {
                try 
                {
                    Grabar();
                }
                catch (SQLException ex) 
                {
                    Logger.getLogger(ControladorJOrganizacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
    
        if(e.getSource().equals(jorg.getBtnCancelar()))
             {
                Cancelar();
             }
          
        if(e.getSource().equals(jorg.getBtnSalir()))
             {
                 jorg.dispose();  
             }
        
         if(e.getSource().equals(jorg.getBtnTipoOrg()))
             {
            try {  
                new ControladorJConsultarTipoOrganizacion();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJOrganizacion.class.getName()).log(Level.SEVERE, null, ex);
            }
             }
         
          if(e.getSource().equals(jorg.getBtnConsultar()))
             {
            try {  
                new ControladorJConsultarOrganizacion();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJOrganizacion.class.getName()).log(Level.SEVERE, null, ex);
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
 