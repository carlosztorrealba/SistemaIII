/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.TipoOrgDAO;
import Modelos.TipoOrganizacion;
import Vistas.JConsultarTipoOrganizacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Enrique
 */
public class ControladorJConsultarTipoOrganizacion implements ActionListener
{
     private JConsultarTipoOrganizacion consultipoorg;

    public ControladorJConsultarTipoOrganizacion() throws SQLException
    {
        consultipoorg = new JConsultarTipoOrganizacion();
        consultipoorg.agregarListener(this);
        consultipoorg.setVisible(true);
        consultipoorg.setLocationRelativeTo(null);
        CargarTipoOrganizacion();
    }

    
    
    private void CargarTipoOrganizacion() throws SQLException
{
 
  int Fila=0;
  TipoOrganizacion car=new TipoOrganizacion();
  TipoOrgDAO daotipoorg=new TipoOrgDAO();
  ResultSet RegistroTipoOrganizacion;
  RegistroTipoOrganizacion=daotipoorg.ConsultarTipoOrganizacion();
   
   if (RegistroTipoOrganizacion.next()) {
        do      
        {
    
    consultipoorg.getTblTipoOrg().setValueAt(RegistroTipoOrganizacion.getString("codtipoorg"), Fila, 0);
    consultipoorg.getTblTipoOrg().setValueAt(RegistroTipoOrganizacion.getString("nombreorg"), Fila, 1);
    
    
    
    Fila++;
        }while (RegistroTipoOrganizacion.next());
    
}
}
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource().equals(consultipoorg.getBtnSalir()))
       {
        consultipoorg.dispose();  
       }  
    }
    
}
