/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Dao.UsuarioDAO;
import Vistas.JUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Modelos.Mensajes;
import Modelos.Rutinas;
import Modelos.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Enrique
 */
public class ControladorJUsuario implements ActionListener, KeyListener
{
    private JUsuario jusu;
    private boolean Hallado;

    public ControladorJUsuario()
    {
        jusu = new JUsuario();
        jusu.agregarListener(this);
        jusu.setVisible(true);
        jusu.setLocationRelativeTo(null);
                
       jusu.getTxtUsuario().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 Validacedula(e); 
               }
                 
       }
    ); 
       
            jusu.getTxtContraseña().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 Validapassword(e); 
               }
                 
       }
    ); 
     
    }
    
 //==================================================================================
  private void Validacedula(KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
   Cadena=jusu.getTxtUsuario().getText();
  if (Cadena.length()==8)
    {  
      e.consume();  
      return;
    }
  }
//==================================================================================
  private void Validapassword(KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
   Cadena=jusu.getTxtContraseña().getText();
  if (Cadena.length()==10)
    {  
      e.consume();  
      return;
    }
  }
  
  
 //==================================================================================
  private void Cancelar()
    {  
     jusu.getTxtUsuario().setText(""); 
     jusu.getTxtContraseña().setText("");
      
      
   jusu.getTxtUsuario().requestFocusInWindow();
    }  
  
  private void Grabar()throws SQLException
  {
    
    String Cadena;
     
    Usuario usa;
    Cadena=jusu.getTxtUsuario().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Usuario Vacio", "");  
    jusu.getTxtUsuario().requestFocusInWindow();
     return;
   } 
  
  Cadena=jusu.getTxtContraseña().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Contraseña Vacia", "");  
     jusu.getTxtContraseña().requestFocusInWindow();
     return;
   } 
  
  
   usa= new Usuario( jusu.getTxtUsuario().getText().trim(),
           jusu.getTxtContraseña().getText().trim());
    
 UsuarioDAO daousa=new UsuarioDAO();
 daousa.InsertarUsuario(usa);
 Rutinas.Aviso("Registro Satisfactorio", ""); 
 Cancelar();
  }  

 /*==================================================================================
  
  private void ValidarUsuario() throws SQLException
{
   String Cadena ;
  String ced ;  
  String pass ;
  UsuarioDAO daoUsua=new UsuarioDAO();
  ResultSet regisUsua;
  
  Cadena=jusu.getTxtUsuario().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Usuario Vacio", "");  
    jusu.getTxtUsuario().requestFocusInWindow();
     return;
   } 
  
  Cadena=jusu.getTxtContraseña().getText().trim();
  
  if (Cadena.length()==0)
   {  
     Mensajes.Aviso("Contraseña Vacia", "");  
     jusu.getTxtContraseña().requestFocusInWindow();
     return;
   } 
  
  ced=jusu.getTxtUsuario().getText().trim();
  pass=jusu.getTxtContraseña().getText();
  regisUsua=daoUsua.buscarUsuarioCargo(ced, pass);
  
  if (regisUsua.next())
    {  
        

        if (null != regisUsua.getString("nombrecargo").trim())
          switch (regisUsua.getString("nombrecargo").trim()) {
           case "Supervisor":
               new ControladorPrincipal(true,true,false,false,true,true);
               break;
           case "Administrador":
               new ControladorPrincipal(true,true,true,true,true,true);
               break;
           case "Gerente":
               new ControladorPrincipal(false,false,false,false,false,false);
               break;
       }
        
    } 
  else
     Rutinas.Aviso("Usuario no existe Y/O contraseña incorrecta", ""); 
   //Enabled(false);
  
}  
  
  
  
  
//==================================================================================*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jusu.getBtnRegistro()))
       {
            try {
                Grabar();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
       }   
        
        
             if(e.getSource().equals(jusu.getBtnEntrar()))
       {
           if (!"12345".equals(jusu.getTxtContraseña().getText()))
              {
                  Mensajes.Aviso("USUARIO Y/O CONTRASEÑA INVALIDOS", "");
              }
           else
               new ControladorPrincipal();
                
            
           /* try {  
                ValidarUsuario();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorJUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }*/
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
    
    

