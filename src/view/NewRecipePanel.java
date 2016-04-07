/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.Controller;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author 604772006
 */
public class NewRecipePanel  extends JPanel{

    private JFrame pFrame;
    private JLabel cim;
    private JTextField receptNeve;
    private JTextField otevoMennyiseg;
   private JTextField otevoMegnevezes;
    private JTable otevoTabla;
    private JList otevoList;
    private JTextField receptLeiras;
    private JButton btnHozzaad;
    private JButton btnMentes;
    private JButton btnVissza;
    private JPanel guiPanel;
            
    
    public NewRecipePanel(Controller controller) {
        //construct components
        cim = new JLabel("Új recept felvétel");
        JLabel rnevLabel = new JLabel("Recept neve");
        receptNeve= new JTextField(1);
        otevoMennyiseg= new JTextField(1);
        otevoMegnevezes= new JTextField(1);
        JLabel otevLabel = new JLabel("Összetevők:");
        JLabel otevoHozzaadLabel = new JLabel("Összetevő hozzáadás");
        JLabel otevoMennyisegLabel = new JLabel("Mennyiség");
        JLabel otevoMennyisegTipusLabel = new JLabel("Mennyiség Típus");
        JLabel ujOtevLabel = new JLabel("Összetevő");
        
        otevoList= new JList(new String[]{"listelem1","listaelem2"});
        JLabel leirLabel = new JLabel("Recept leírása:");
        receptLeiras=new JTextField("leírás...");
        btnHozzaad=new JButton("Összetevő hozzáadása");
        btnMentes=new JButton("Mentés");
        btnVissza=new JButton("Vissza");
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnMentes.addActionListener(controller.getMentesGombListener());
        btnHozzaad.addActionListener(controller.getUjReceptOsszetevotHozzaadListener());
        otevoList.getSelectionModel().addListSelectionListener(controller.getUjReceptListaElemListener());
        otevoList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        otevoTabla= new JTable();
        otevoTabla.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
                
            },
            new String [] {
                "Mennyiség", "Egység", "Összetevő"
            }
        ));
        
        ListSelectionModel rowSelectionModel=otevoTabla.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(controller.getTablaSorListener());
        JScrollPane tableScrollPane=new JScrollPane();
        tableScrollPane.setViewportView(otevoTabla);
        
        //adjust size and set layout
        setPreferredSize (new Dimension (395, 156));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(new java.awt.Color(0, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 102, 255)));
                
        cim.setFont(new java.awt.Font("Courier New", 1, 24));
        cim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        otevoHozzaadLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        otevoHozzaadLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        otevLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        otevLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        otevoMennyisegLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        otevoMennyisegLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        otevoMennyisegTipusLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        otevoMennyisegTipusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        ujOtevLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        ujOtevLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        leirLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        leirLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        receptNeve.setBackground(new java.awt.Color(255, 255, 102));
        
        otevoMennyiseg.setBackground(new java.awt.Color(255, 255, 102));
        
        otevoMegnevezes.setBackground(new java.awt.Color(255, 255, 102));
        
        receptLeiras.setBackground(new java.awt.Color(255, 255, 102));
        
        btnHozzaad.setBackground(new java.awt.Color(255, 0, 51));
        btnHozzaad.setForeground(new java.awt.Color(51, 0, 255));
        btnHozzaad.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        btnMentes.setBackground(new java.awt.Color(255, 0, 51));
        btnMentes.setForeground(new java.awt.Color(51, 0, 255));
        btnMentes.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        btnVissza.setBackground(new java.awt.Color(255, 0, 51));
        btnVissza.setForeground(new java.awt.Color(51, 0, 255));
        btnVissza.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        otevoList.setBackground(new java.awt.Color(255, 255, 102));
        
        otevoTabla.setBackground(new java.awt.Color(255, 255, 102));
        
        //add components
        add(cim);
        add(rnevLabel);
        add(receptNeve);
        add(otevLabel);
        add(tableScrollPane);
        add(otevoHozzaadLabel);
        add(otevoMennyisegLabel);
        add(otevoMennyiseg);
        add(otevoMennyisegTipusLabel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().setView(otevoList);
        add(scrollPane);
        add(ujOtevLabel);
        add(otevoMegnevezes);
        
        
        add(btnHozzaad);
        //add(otevoTabla);
        add(leirLabel);
        add(receptLeiras);
        add(btnMentes);
        add(btnVissza);
    }
  
    public void setGuiPanel(JPanel guiPanel) {
        this.guiPanel = guiPanel;
    }

    public void setpFrame(JFrame pFrame) {
        this.pFrame = pFrame;
    }

    

    public String getReceptNeve() {
        return receptNeve.getText();
    }

    public void setReceptNeve(String receptNeve) {
        this.receptNeve.setText(receptNeve);
    }

    public ListModel getOtevoList() {
        return otevoList.getModel();
    }
    
    public String getOtevoListCurrentSelection()
    {
        return otevoList.getSelectedValue().toString();
        
    }

    public void setOtevoList(ArrayList<String> otevoList) {
        DefaultListModel dlModel = new DefaultListModel();
        for (int i=0; i<otevoList.size();i++)
        {
            dlModel.addElement(otevoList.get(i));
        }
        
        this.otevoList.setModel(dlModel);
    }
    
    public void addRowToOtevoTabla(Object[] obj)
    {
        DefaultTableModel model = (DefaultTableModel)otevoTabla.getModel();
        model.addRow(obj);
    }

    public String getReceptLeiras() {
        return receptLeiras.getText();
    }

    public void setReceptLeiras(String receptLeiras) {
        this.receptLeiras.setText(receptLeiras);
    }

    public TableModel getOtevoTabla() {
        return otevoTabla.getModel();
    }

    public void setOtevoTabla(TableModel otevoTabla) {
        this.otevoTabla.setModel(otevoTabla);
    }

    public String getOtevoMennyiseg() {
        return otevoMennyiseg.getText();
    }

    public String getOtevoMegnevezes() {
        return otevoMegnevezes.getText();
    }
    
    
    
    
    
    
}
