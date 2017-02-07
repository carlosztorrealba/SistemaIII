/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;




import DAO.TipoInsumoDAO;
import Modelos.TipoInsumo;
import Vistas.JConsultarTipoInsumo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Enrique
 */
public class ControladorJConsultarTipoInsumo implements ActionListener
{
    private JConsultarTipoInsumo consultipoinsu;

    public ControladorJConsultarTipoInsumo() throws SQLException
    {
        consultipoinsu = new JConsultarTipoInsumo();
        consultipoinsu.agregarListener(this);
        consultipoinsu.setVisible(true);
        consultipoinsu.setLocationRelativeTo(null);
        CargarTipoInsumo();
    }

    
    
    private void CargarTipoInsumo() throws SQLException
{
 
  int Fila=0;
  TipoInsumo car=new TipoInsumo();
  TipoInsumoDAO daotipoinsu=new TipoInsumoDAO();
  ResultSet RegistroTipoInsumo;
  RegistroTipoInsumo=daotipoinsu.ConsultarTipoMaterial();
   
   if (RegistroTipoInsumo.next()) {
        do      
        {
    
    consultipoinsu.getTblTipoInsumo().setValueAt(RegistroTipoInsumo.getString("codtipoinsumo"), Fila, 0);
    consultipoinsu.getTblTipoInsumo().setValueAt(RegistroTipoInsumo.getString("nombreinsumo"), Fila, 1);
    
    
    
    Fila++;
        }while (RegistroTipoInsumo.next());
    
}
}
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource().equals(consultipoinsu.getBtnSalir()))
       {
        consultipoinsu.dispose();  
       }  
    }
    
}
