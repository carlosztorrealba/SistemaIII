
package Modelos;

import javax.swing.JOptionPane;
//------------------------------------------------------------------------------
public class Mensajes {
    
    public static void Aviso(String Mensaje,String CaptionWin) {

      JOptionPane.showMessageDialog(null,
      Mensaje,
      CaptionWin,
      JOptionPane.WARNING_MESSAGE);
    }
    
//---------------------------------------------------------------------------    
    public static int DialogConfirm(String Pregunta,String Titulo) 
    {      
        
      int respuesta = JOptionPane.showConfirmDialog(null,
                      Pregunta,
                      Titulo,            //Titulo
                      JOptionPane.YES_NO_OPTION,     //Botones que apareceran                       
                      JOptionPane.QUESTION_MESSAGE);    //Icono que se desea que aparezca
      
      return respuesta;
    }
 //--------------------------------------------------------------------------
public static int Opciones(String Op1,String Op2,String Op3)
{        
  int optionType = JOptionPane.DEFAULT_OPTION;
int messageType = JOptionPane.PLAIN_MESSAGE; // no standard icon

Object[] selValues = { Op1, Op2, Op3 };

// Shows message, choices appear as buttons
int res = JOptionPane.showOptionDialog(null, "Selecciona una Opcion", "Accion",
                                       optionType, messageType,null ,
                                       selValues, selValues[0]);

return res;
}
}
