/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.PersonalDAO;
import Modelos.Personal1;
import Vistas.JConsultarPersonal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Enrique
 */
public class ControladorJConsultarPersonal implements ActionListener
{
      private JConsultarPersonal consulperso;

    public ControladorJConsultarPersonal() throws SQLException
    {
        consulperso = new JConsultarPersonal();
        consulperso.agregarListener(this);
        consulperso.setVisible(true);
        consulperso.setLocationRelativeTo(null);
        CargarPersonal();
    }

    
    
    private void CargarPersonal() throws SQLException
{
 
  int Fila=0;
  Personal1 car=new Personal1();
  PersonalDAO daoper=new PersonalDAO();
  ResultSet RegistroPersonal;
  RegistroPersonal=daoper.ConsultarPersonal();
   
   if (RegistroPersonal.next()) {
        do      
        {
    
    consulperso.getTblPersonal().setValueAt(RegistroPersonal.getString("ci"), Fila, 0);
    consulperso.getTblPersonal().setValueAt(RegistroPersonal.getString("nombreper"), Fila, 1);
    consulperso.getTblPersonal().setValueAt(RegistroPersonal.getString("apellidoper"), Fila, 2);
    consulperso.getTblPersonal().setValueAt(RegistroPersonal.getString("tipoper"), Fila, 3);
    
    
    
    Fila++;
        }while (RegistroPersonal.next());
    
}
}
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource().equals(consulperso.getBtnSalir()))
       {
        consulperso.dispose();  
       }  
    }

 
    
    
}
