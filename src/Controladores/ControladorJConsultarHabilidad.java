/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.HabilidadDAO;
import Modelos.Habilidad;
import Vistas.JConsultarHabilidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class ControladorJConsultarHabilidad implements ActionListener
{
        private JConsultarHabilidad consulhab;

    public ControladorJConsultarHabilidad() throws SQLException
    {
        consulhab = new JConsultarHabilidad();
        consulhab.agregarListener(this);
        consulhab.setVisible(true);
        consulhab.setLocationRelativeTo(null);
        CargarHabilidad();
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
