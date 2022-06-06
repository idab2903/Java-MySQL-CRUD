/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaodbc;

/**
 *
 * @author Ivan
 */
import pruebaodbc.metodos;
import pruebaodbc.Informe;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class tabla {
    metodos dao = null;


    public void visualizar_Informe(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("id");
        dt.addColumn("Descripcion");
        dt.addColumn("Foto");

        dao = new metodos();
        Informe vo = new Informe();
        ArrayList<Informe> list = dao.Listar_Informe();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[5];
                vo = list.get(i);
                fila[0] = vo.getId();
                fila[1] = vo.getDescripcion();
                try{
                    byte[] bi = vo.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[2] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[3] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
}
