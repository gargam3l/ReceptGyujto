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
import javax.swing.table.TableColumn;
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
    private JButton btnOtevotEltavolit;
            
    
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
        btnHozzaad=new JButton("Hozzáad");
        btnMentes=new JButton("Mentés");
        btnVissza=new JButton("Vissza");
        btnOtevotEltavolit = new JButton("Eltávolít");
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnMentes.addActionListener(controller.getMentesGombListener());
        btnHozzaad.addActionListener(controller.getUjReceptOsszetevotHozzaadListener());
        btnOtevotEltavolit.addActionListener(controller.getUjReceptOsszetevotEltavolitListener());
        otevoList.getSelectionModel().addListSelectionListener(controller.getUjReceptListaElemListener());
        otevoList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        otevoTabla= new JTable();
        
        
        ListSelectionModel rowSelectionModel=otevoTabla.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(controller.getUjReceptTablaSorListener());
        JScrollPane tableScrollPane=new JScrollPane();
        tableScrollPane.setViewportView(otevoTabla);
        
        //adjust size and set layout
        setPreferredSize (new Dimension (400, 500));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                
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
        
        btnOtevotEltavolit.setBackground(new java.awt.Color(255, 0, 51));
        btnOtevotEltavolit.setForeground(new java.awt.Color(51, 0, 255));
        btnOtevotEltavolit.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        otevoList.setBackground(new java.awt.Color(255, 255, 102));
        
        otevoTabla.setBackground(new java.awt.Color(255, 255, 102));
        
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
        add(btnOtevotEltavolit);
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
    
    public void otevoOszlopotBeallit(JTable table, ArrayList<String> otevoList) {
        
        TableColumn otevoOszlop = table.getColumnModel().getColumn(1);
        JComboBox comboBox = new JComboBox();
        
        for (int i=0; i<otevoList.size();i++)
        {
            comboBox.addItem(otevoList.get(i));
            
        }
        
        
        otevoOszlop.setCellEditor(new DefaultCellEditor(comboBox));
    
        
    }
    
    public void setGuiPanel(JPanel guiPanel) {
        this.guiPanel = guiPanel;
    }

    public void setpFrame(JFrame pFrame) {
        this.pFrame = pFrame;
    }

    

    public String getReceptNeve() {
        if (receptNeve.getText().equals("")) throw new RuntimeException("Recept neve üres. Kérem adjon meg egy recept nevet!");
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
    
    public void removeRowToOtevoTabla(int rowNum)
    {
        DefaultTableModel model = (DefaultTableModel)otevoTabla.getModel();
        model.removeRow(rowNum);
        
    }
    
    public int getOtevoTablaSorokSzama()
    {
        if (otevoTabla.getModel().getRowCount()==0) throw new RuntimeException("Nincs összetevő hozzáadva a recepthez. Kérem adjon meg legalább egy összetevőt a recepthez!");
        
        return otevoTabla.getModel().getRowCount();
    }
            
    public String getReceptLeiras() {
        if (receptLeiras.getText().equals("")) throw new RuntimeException("Recept leírása üres. Kérem adjon meg egy leírást a recepthez!");
        return receptLeiras.getText();
    }

    public void setReceptLeiras(String receptLeiras) {
        this.receptLeiras.setText(receptLeiras);
    }

    public TableModel getOtevoTablaAdat() {
        return otevoTabla.getModel();
    }
    
    public String getOtevoTablaAdatCella(int x, int y) {
        if (otevoTabla.getModel().getValueAt(x, y).toString().equals("")) throw new RuntimeException("Összetevő mennyiség vagy leírás üres. Kérem adjon meg mennyiség ill leírás értéket az összetevőhöz!");
        return otevoTabla.getModel().getValueAt(x, y).toString();
    }

    public void setOtevoTabla(TableModel otevoTabla) {
        this.otevoTabla.setModel(otevoTabla);
    }

    public String getOtevoMennyiseg() {
        if (otevoMennyiseg.getText().equals("")) throw new RuntimeException("Összetevő mennyiség üres. Kérem adjon meg egy mennyiséget az összetevőhöz!");
        return otevoMennyiseg.getText();
    }

    public String getOtevoMegnevezes() {
        if (otevoMegnevezes.getText().equals("")) throw new RuntimeException("Összetevő leírása üres. Kérem adjon meg egy leírást a összetevőhöz!");
        return otevoMegnevezes.getText();
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    public JTable getOtevoTabla() {
        return otevoTabla;
    }
    
    public int getOtevoTableAktualisSor()
    {
        //if (otevoTabla.getSelectedRow()== -1) throw new RuntimeException("Nincs összetevő kiválasztva. Eltávolításhoz válasszon ki összetevőt!");
        return otevoTabla.getSelectedRow();
    }
    
    
    
    
}
