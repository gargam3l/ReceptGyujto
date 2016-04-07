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
    private boolean initialized;
            
    
    public NewRecipePanel(Controller controller) {
        //construct components
        initialized = false;
        cim = new JLabel("Új recept felvétel");
        JLabel rnevLabel = new JLabel("Recept neve");
        receptNeve= new JTextField(30);
        otevoMennyiseg= new JTextField(30);
        otevoMegnevezes= new JTextField(30);
        JLabel otevLabel = new JLabel("Összetevők:");
        JLabel otevoHozzaadLabel = new JLabel("Összetevő hozzáadás");
        JLabel otevoMennyisegLabel = new JLabel("Mennyiség");
        JLabel otevoMennyisegTipusLabel = new JLabel("Mennyiség Típus");
        JLabel ujOtevLabel = new JLabel("Összetevő");
        
        otevoList= new JList();
        JLabel leirLabel = new JLabel("Recept leírása:");
        receptLeiras=new JTextField(100);
        btnHozzaad=new JButton("Összetevő hozzáadása");
        btnMentes=new JButton("Mentés");
        btnVissza=new JButton("Vissza");
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnMentes.addActionListener(controller.getMentesGombListener());
        btnHozzaad.addActionListener(controller.getUjReceptOsszetevotHozzaadListener());
        otevoList.getSelectionModel().addListSelectionListener(controller.getUjReceptListaElemListener());
        otevoList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        otevoTabla= new JTable();
        
        
        ListSelectionModel rowSelectionModel=otevoTabla.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(controller.getTablaSorListener());
        JScrollPane tableScrollPane=new JScrollPane();
        tableScrollPane.setViewportView(otevoTabla);
        
        //adjust size and set layout
        setPreferredSize (new Dimension (395, 156));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        inicNewRecipePanelDefault();
        
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
  
    public void inicNewRecipePanelDefault()
    {
        
        receptNeve.setText("");
        otevoMennyiseg.setText("");
        otevoMegnevezes.setText("");
        receptLeiras.setText("");
        otevoTabla.setModel(new DefaultTableModel(new String[]{"Mennyiség", "Egység", "Összetevő"},0));
        DefaultListModel listModel= new DefaultListModel();
        listModel.addElement("");
        otevoList.setModel(listModel);
        
        initialized = true;
        
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

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }
    
    
    
    
    
    
}
