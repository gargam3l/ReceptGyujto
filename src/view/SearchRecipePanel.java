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
    private boolean initialized;
    
    public SearchRecipePanel(Controller controller) {
        initialized = false;
        rkeres = new JLabel("Recept Keresése");
        JLabel rnevLabel = new JLabel("Recept neve");
        this.receptNeve= new JTextField(30);
        this.btnVissza=new JButton("Vissza");
        this.btnKereses=new JButton("Keresés");
        this.btnMegnyitas=new JButton("Megnyitas");
        this.talalatTabla=new JTable();
        this.tablaPanel=new JScrollPane();
        
        
        ListSelectionModel rowSelectionModel=talalatTabla.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(controller.getReceptTablaSorListener());
        tablaPanel.setViewportView(talalatTabla);
        
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnKereses.addActionListener(controller.getReceptKeresListener());
        btnMegnyitas.addActionListener(controller.getReceptMutatPanelListener());    
        //adjust size and set layout
        setPreferredSize (new Dimension (400, 500));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                
        rkeres.setFont(new java.awt.Font("Courier New", 1, 24));
        rkeres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        rnevLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        rnevLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        receptNeve.setBackground(new java.awt.Color(255, 255, 102));
        
        talalatTabla.setBackground(new java.awt.Color(255, 255, 102));
        
        tablaPanel.setBackground(new java.awt.Color(255, 255, 102));
        
        btnVissza.setBackground(new java.awt.Color(255, 0, 51));
        btnVissza.setForeground(new java.awt.Color(51, 0, 255));
        btnVissza.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        btnKereses.setBackground(new java.awt.Color(255, 0, 51));
        btnKereses.setForeground(new java.awt.Color(51, 0, 255));
        btnKereses.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        btnMegnyitas.setBackground(new java.awt.Color(255, 0, 51));
        btnMegnyitas.setForeground(new java.awt.Color(51, 0, 255));
        btnMegnyitas.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        //set component bounds (only needed by Absolute Positioning)
        this.receptNeve.setBounds (20, 45, 100, 25);
        this.rkeres.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.rkeres.setAlignmentY(Component.TOP_ALIGNMENT);
        rnevLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        rnevLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        
        
        //add components
        add(rkeres);
        add(rnevLabel);
        add(receptNeve);
        add(btnKereses);
        add(tablaPanel);
        add(btnVissza);
        add(btnMegnyitas);
    
        
    }
    
    public void inicSearchRecipePanelDefault()
    {
        
        receptNeve.setText("");
        talalatTabla.setModel(new DefaultTableModel(new String [] {"Megnevezés", "Elkészítés"},0));
        initialized = true;
    }

    void setGuiPanel(JPanel guiPanel) {
        this.guiPanel=guiPanel;
    }

    void setpFrame(JFrame pFrame) {
        this.pFrame=pFrame;
    }

    public String getReceptNeve() {
        if (receptNeve.getText().equals("")) throw new RuntimeException("Recept neve üres. Kérem adjon meg egy recept nevet a kereséshez!");
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

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }
    
    
}
