/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import DAO.AlmacenDAO;
import Modelos.Almacen;
import Vistas.JConsultarAlmacen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Enrique
 */
public class ControladorJConsultarAlmacen implements ActionListener
{
    private JConsultarAlmacen consulalma;

    public ControladorJConsultarAlmacen() throws SQLException
    {
        consulalma = new JConsultarAlmacen();
        consulalma.agregarListener(this);
        consulalma.setVisible(true);
        consulalma.setLocationRelativeTo(null);
        CargarAlmacen();
    }

    
    
    
    
     private void CargarAlmacen() throws SQLException
{
 
  int Fila=0;
  Almacen car=new Almacen();
  AlmacenDAO daoalma=new AlmacenDAO();
  ResultSet RegistroAlma;
  RegistroAlma=daoalma.ConsultarAlmacen();
   
   if (RegistroAlma.next()) {
        do      
        {
    
    consulalma.getTblAlmacen().setValueAt(RegistroAlma.getString("codalmacen"), Fila, 0);
    consulalma.getTblAlmacen().setValueAt(RegistroAlma.getString("nombrealmacen"), Fila, 1);
    
    
    
    Fila++;
        }while (RegistroAlma.next());
    
}
}
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource().equals(consulalma.getBtnSalir()))
       {
        consulalma.dispose();  
       }  
    }
    
  
    
}
