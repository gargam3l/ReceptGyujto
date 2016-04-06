/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author 604772006
 */
public class SearchRecipePanel  extends JPanel{
    private  JLabel rkeres;
    private JTextField receptNeve;
    private JTable talalatTabla;
    private JButton btnVissza;
    private JButton btnKereses;
    private JFrame pFrame;
    private JPanel guiPanel;
    private JButton btnMegnyitas;
    private JScrollPane tablaPanel;
    
    public SearchRecipePanel(Controller controller) {
        rkeres = new JLabel("Recept Keresése");
        JLabel rnevLabel = new JLabel("Recept neve");
        this.receptNeve= new JTextField(1);
        this.btnVissza=new JButton("Vissza");
        this.btnKereses=new JButton("Keresés");
        this.btnMegnyitas=new JButton("Megnyitas");
        this.talalatTabla=new JTable();
        this.tablaPanel=new JScrollPane();
        
        talalatTabla.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
                
            },
            new String [] {
                "Megnevezés", "Elkészítés"
            }
        ));
        
        ListSelectionModel rowSelectionModel=talalatTabla.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(controller.getReceptTablaSorListener());
        tablaPanel.setViewportView(talalatTabla);
        
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnKereses.addActionListener(controller.getReceptKeresListener());
        btnMegnyitas.addActionListener(controller.getReceptMutatPanelListener());    
        //adjust size and set layout
        setPreferredSize (new Dimension (395, 156));
        
        //set component bounds (only needed by Absolute Positioning)
        this.receptNeve.setBounds (20, 45, 100, 25);
        this.rkeres.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.rkeres.setAlignmentY(Component.TOP_ALIGNMENT);
        rnevLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        rnevLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //add components
        add(rkeres);
        add(rnevLabel);
        add(receptNeve);
        add(btnKereses);
        add(tablaPanel);
        add(btnVissza);
        add(btnMegnyitas);
    
        
    }

    void setGuiPanel(JPanel guiPanel) {
        this.guiPanel=guiPanel;
    }

    void setpFrame(JFrame pFrame) {
        this.pFrame=pFrame;
    }

    public String getReceptNeve() {
        return receptNeve.getText();
    }

    public TableModel getTalalatTabla() {
        return talalatTabla.getModel();
    }

    public void setTalalatTabla(TableModel talalatTabla) {
        this.talalatTabla.setModel(talalatTabla);
    }
    
    public ArrayList<String> getTalalatTableAktualisSor()
    {
        ArrayList<String> eredmeny=new ArrayList<>();
        for (int i=0; i<talalatTabla.getColumnCount();i++)
            {   
            eredmeny.add(talalatTabla.getModel().getValueAt(talalatTabla.getSelectedRow(), i).toString());
                
                }
        return eredmeny;
    }
    
    
}
