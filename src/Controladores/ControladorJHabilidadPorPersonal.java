/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.HabilidadDAO;
import Modelos.Habilidad;
import Vistas.JHabilidadesPorPersonal;
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
public class ControladorJHabilidadPorPersonal implements ActionListener
{
    
        private JHabilidadesPorPersonal consulhab;

    public ControladorJHabilidadPorPersonal() throws SQLException
    {
        consulhab = new JHabilidadesPorPersonal();
        consulhab.agregarListener(this);
        consulhab.setVisible(true);
        consulhab.setLocationRelativeTo(null);
        CargarHabilidad();
        
        
        
        
        consulhab.getTxtCedula().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaCedula(e); 
               }
        
       }
    );          
    
   //=====================================================================
 
  
       consulhab.getTxtNombre().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaNombre(e); 
               }
                 
       }
    );               
       
   //===================================================================== 
       
             consulhab.getTxtApellido().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidaNombre(e); 
               }
                 
       }
    ); 
       
    }

    //=========================================================
    
    private void ValidaCedula(KeyEvent e)    
{
  String Cadena;
  char Tecla;
  
  Cadena=consulhab.getTxtCedula().getText();
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
  
  Cadena=consulhab.getTxtNombre().getText();
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
          private void Cancelar()
    { 
      Enabled(false); 
      consulhab.getTxtCedula().setText(""); 
      consulhab.getTxtNombre().setText("");
      consulhab.getTxtApellido().setText("");
      
      consulhab.getTxtCedula().requestFocusInWindow();
      
      
    }

 
   private void Enabled(boolean status)
  {
      consulhab.getTxtCedula().setEnabled(!status);
      consulhab.getTxtNombre().setEnabled(status);
      consulhab.getTxtApellido().setEnabled(status);
      
  }
    private void CargarHabilidad() throws SQLException
{
 
  int Fila=0;
  Habilidad hab=new Habilidad();
  HabilidadDAO daohab=new HabilidadDAO();
  ResultSet RegistroHabilidad;
  RegistroHabilidad=daohab.ConsultarHabilidad();
   
   if (RegistroHabilidad.next()) {
        do      
        {
    
    consulhab.getTblHabilidades().setValueAt(RegistroHabilidad.getString("codhabilidad"), Fila, 0);
    consulhab.getTblHabilidades().setValueAt(RegistroHabilidad.getString("nombrehabilidad"), Fila, 1);
    
    
    
    Fila++;
        }while (RegistroHabilidad.next());
    
}
}
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource().equals(consulhab.getBtnSalir()))
       {
        consulhab.dispose();  
       }  
    }

  
}
