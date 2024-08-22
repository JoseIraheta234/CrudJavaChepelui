package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Producto;
import vista.frmProductos;


public class ctrlProducto implements MouseListener{
    
    //1- Llamar a las otras capas(modelo, vista)
    private frmProductos vista;
    private Producto modelo;
    
    //2- Crear el constructor de la clase
    public ctrlProducto(frmProductos Vista, Producto Modelo){
        this.vista = Vista;
        this.modelo = Modelo;
        
        vista.btnGuardar.addMouseListener(this);  
        
        vista.jtbProductos.addMouseListener(this);
        modelo.Mostrar(vista.jtbProductos);
        
        vista.btnEliminar.addMouseListener(this);
        vista.jtbProductos.addMouseListener(this);
        
        vista.btnActualizar.addMouseListener(this);
        
        vista.btnLimpiar.addMouseListener(this);
        
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      if(e.getSource() == vista.btnGuardar){
          modelo.setNombre(vista.txtNombre.getText());
          modelo.setPrecio(Double.parseDouble( vista.txtPrecio.getText()));
          modelo.setCategoria(vista.txtCategoria.getText());
          
          modelo.Guardar();
          modelo.Mostrar(vista.jtbProductos);
         
      }
      
      
    if (e.getSource() == vista.btnEliminar) {
            
                modelo.Eliminar(vista.jtbProductos);
                modelo.Mostrar(vista.jtbProductos);
                
      
            
        }
    
    if (e.getSource() == vista.btnActualizar) {
            
            
                    //Asignar lo de la vista al modelo al momento de darle clic a actualizar
                    modelo.setNombre(vista.txtNombre.getText());
                    modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
                    modelo.setCategoria(vista.txtCategoria.getText());

                    //Ejecutar el método    
                    modelo.Actualizar(vista.jtbProductos);
                    modelo.Mostrar(vista.jtbProductos);
                    
              
            
        }
    
       if (e.getSource() == vista.btnLimpiar) {
            modelo.limpiar(vista);
        }

        if (e.getSource() == vista.jtbProductos) {
            modelo.cargarDatosTabla(vista);
        }
       
    }
   


    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    

}
