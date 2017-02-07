/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.TipoServicioDAO;
import Modelos.TipoServicio;
import Vistas.JConsultarTipoServicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Enrique
 */


public class ControladorJConsultarTipoServicio implements ActionListener
{
    private JConsultarTipoServicio consultiposerv;

    public ControladorJConsultarTipoServicio() throws SQLException
    {
        consultiposerv = new JConsultarTipoServicio();
        consultiposerv.agregarListener(this);
        consultiposerv.setVisible(true);
        consultiposerv.setLocationRelativeTo(null);
        CargarTipoServicio();
    }

    
    
    private void CargarTipoServicio() throws SQLException
{
 
  int Fila=0;
  TipoServicio car=new TipoServicio();
  TipoServicioDAO daotiposerv=new TipoServicioDAO();
  ResultSet RegistroTipoServicio;
  RegistroTipoServicio=daotiposerv.ConsultarTipoServicio();
   
   if (RegistroTipoServicio.next()) {
        do      
        {
    
    consultiposerv.getTblTipoServicio().setValueAt(RegistroTipoServicio.getString("codtiposervicios"), Fila, 0);
    consultiposerv.getTblTipoServicio().setValueAt(RegistroTipoServicio.getString("nombretiposervicio"), Fila, 1);
    
    
    
    Fila++;
        }while (RegistroTipoServicio.next());
    
}
}
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource().equals(consultiposerv.getBtnSalir()))
       {
        consultiposerv.dispose();  
       }  
    }
    
}
