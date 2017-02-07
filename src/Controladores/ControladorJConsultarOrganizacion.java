/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.OrganizacionDAO;
import Modelos.Organizacion;
import Vistas.JConsultarOrganizacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Enrique
 */
public class ControladorJConsultarOrganizacion implements ActionListener
{
    private JConsultarOrganizacion consulorg;

    public ControladorJConsultarOrganizacion() throws SQLException
    {
        consulorg = new JConsultarOrganizacion();
        consulorg.agregarListener(this);
        consulorg.setVisible(true);
        consulorg.setLocationRelativeTo(null);
        CargarOrganizacion();
    }

    
    
    private void CargarOrganizacion() throws SQLException
{
 
  int Fila=0;
  Organizacion car=new Organizacion();
  OrganizacionDAO daoorg=new OrganizacionDAO();
  ResultSet RegistroOrganizacion;
  RegistroOrganizacion=daoorg.ConsultarOrganizacion();
   if (RegistroOrganizacion.next()) {
        do      
        {
    
    consulorg.getTblOrganizacion().setValueAt(RegistroOrganizacion.getString("rif"), Fila, 0);
    consulorg.getTblOrganizacion().setValueAt(RegistroOrganizacion.getString("nombreorg"), Fila, 1);
    consulorg.getTblOrganizacion().setValueAt(RegistroOrganizacion.getString("ciresponsable"), Fila, 2);
    consulorg.getTblOrganizacion().setValueAt(RegistroOrganizacion.getString("nombreresponsable"), Fila, 3);
    consulorg.getTblOrganizacion().setValueAt(RegistroOrganizacion.getString("direccion"), Fila, 4);
    
    
    Fila++;
        }while (RegistroOrganizacion.next());
    
}
}
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource().equals(consulorg.getBtnSalir()))
       {
        consulorg.dispose();  
       }  
    }

   
 
}
