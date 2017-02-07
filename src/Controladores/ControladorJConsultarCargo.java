/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CargoDAO;
import Modelos.Cargo;
import Vistas.JConsultarCargo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Enrique
 */
public class ControladorJConsultarCargo implements ActionListener
{
    private JConsultarCargo consulcargo;

    public ControladorJConsultarCargo() throws SQLException
    {
        consulcargo = new JConsultarCargo();
        consulcargo.agregarListener(this);
        consulcargo.setVisible(true);
        consulcargo.setLocationRelativeTo(null);
        CargarCargo();
    }

    
    
    private void CargarCargo() throws SQLException
{
 
  int Fila=0;
  Cargo car=new Cargo();
  CargoDAO daocar=new CargoDAO();
  ResultSet RegistroCargo;
  RegistroCargo=daocar.ConsultarCargo();
   
   if (RegistroCargo.next()) {
        do      
        {
    
    consulcargo.getTblCargos().setValueAt(RegistroCargo.getString("codcargo"), Fila, 0);
    consulcargo.getTblCargos().setValueAt(RegistroCargo.getString("nombrecargo"), Fila, 1);
    
    
    
    Fila++;
        }while (RegistroCargo.next());
    
}
}
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource().equals(consulcargo.getBtnSalir()))
       {
        consulcargo.dispose();  
       }  
    }
    
    
    
}
