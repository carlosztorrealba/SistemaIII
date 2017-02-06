/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.JPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Enrique
 */
public class ControladorPrincipal implements ActionListener
{
    private JPrincipal principal;

    public ControladorPrincipal (/*boolean usuario,
                                boolean personal,
                                boolean insumo,
                                boolean servicio,
                                boolean organizacion,
                                boolean planificacion*/)
    {
  
        principal = new JPrincipal();
        principal.agregarListener(this);
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        
      /*  principal.getBarInsumo().setEnabled(usuario);
        principal.getBarPersonal().setEnabled(personal);
        principal.getBarInsumo().setEnabled(insumo);
        principal.getBarServicio().setEnabled(servicio); 
        principal.getBarOrganizacion().setEnabled(organizacion);
        principal.getBarPlanificacion().setEnabled(planificacion);  */
        
    }

    
   
   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(principal.getBarUsuario())) 
        {
                 new ControladorJUsuario();
        
        }
                if (e.getSource().equals(principal.getItemControlPersonal())) 
                {
                 new ControladorJPersonal();
                }
                 if (e.getSource().equals(principal.getItemControlCargo())) 
                 {
            try {
                new ControladorJCargo();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
                 }
                 
                  if (e.getSource().equals(principal.getItemControlAlmacen())) 
                {
            try {
                new ControladorJAlmacen();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                  
                   if (e.getSource().equals(principal.getItemControlTipoInsumo())) 
                {
            try {
                new ControladorJTipoInsumo();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                   
                   
                  if (e.getSource().equals(principal.getItemControlTipoOrg())) 
                {
            try {
                new ControladorJTipoOrganizacion();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                  
                  
                if (e.getSource().equals(principal.getItemControlTipoServicio())) 
                {
            try {
                new ControladorJTipoServicio();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                
                
                
           if (e.getSource().equals(principal.getItemControlOrganizacion())) 
                {
         
                new ControladorJOrganizacion();
           
                
                }         
       } 
  
    
    
}
