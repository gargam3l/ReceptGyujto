/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** TO DO
* Set title on parent frame - of window
* Resize window depending on which panel comes up
*/

package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Osszetevok;
import model.ReceptKezelo;


/**
 *
 * @author 604772006
 */
public class ShowRecipePanel  extends JPanel{
    private JPanel guiPanel;
    private JFrame pFrame;
    private JButton btnVissza;
    private JButton btnMentes;
    private JButton btnTorles;
    
    private  JList osszetevokList;
    private JTextField leiras;
    private JTextField receptNeve;
    private JTable osszetevokTable;
    private JTextField otevoMenny;
    private JTextField otevoLeiras;
    private JButton btnHozzaad;
    private boolean initialized;
    
    public ShowRecipePanel(Controller controller) {
    
        
        JLabel cim = new JLabel("Receptek megjelenítése");
        JLabel receptek = new JLabel("Receptek");
        
        receptNeve=new JTextField();
        
        JLabel osszetevok = new JLabel("Összetevők");
        osszetevokList = new JList();
        
        JLabel leirasLbl = new JLabel("Leírás");
        JLabel otevoHozzaadLabel = new JLabel("Összetevő hozzáadás");
        JLabel otevoMennyisegLabel = new JLabel("Mennyiség");
        JLabel otevoMennyisegTipusLabel = new JLabel("Mennyiség Típus");
        JLabel otevoMegnevezesLabel = new JLabel("Összetevő");
        otevoMenny= new JTextField();
        otevoLeiras= new JTextField();
        leiras = new JTextField();
        btnVissza = new JButton("Vissza");
        btnTorles = new JButton("Törlés");
        btnMentes = new JButton("Mentés");
        btnHozzaad= new JButton("Hozáad");
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnTorles.addActionListener(controller.getReceptTorlesListener());
        btnMentes.addActionListener(controller.getReceptSzerkesztListener());
        btnHozzaad.addActionListener(controller.getReceptMutatOsszetevotHozzaadListener());
        osszetevokList.getSelectionModel().addListSelectionListener(controller.getReceptMutatListaElemListener());
        osszetevokList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        osszetevokTable= new JTable();
        
        
        ListSelectionModel rowSelectionModel=osszetevokTable.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(controller.getTablaSorListener());
        JScrollPane tableScrollPane=new JScrollPane();
        tableScrollPane.setViewportView(osszetevokTable);
        
        
        setPreferredSize (new Dimension (400, 500));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                
        cim.setFont(new java.awt.Font("Courier New", 1, 24));
        cim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        receptek.setFont(new java.awt.Font("Courier New", 0, 14));
        receptek.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        osszetevok.setFont(new java.awt.Font("Courier New", 0, 14));
        osszetevok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        leirasLbl.setFont(new java.awt.Font("Courier New", 0, 14));
        leirasLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        otevoHozzaadLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        otevoHozzaadLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        otevoMennyisegLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        otevoMennyisegLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        otevoMennyisegTipusLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        otevoMennyisegTipusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        otevoMegnevezesLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        otevoMegnevezesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        receptNeve.setBackground(new java.awt.Color(255, 255, 102));
        
        osszetevokList.setBackground(new java.awt.Color(255, 255, 102));
        
        otevoMenny.setBackground(new java.awt.Color(255, 255, 102));
        
        otevoLeiras.setBackground(new java.awt.Color(255, 255, 102));
        
        leiras.setBackground(new java.awt.Color(255, 255, 102));
        
        osszetevokTable.setBackground(new java.awt.Color(255, 255, 102));
        
        btnVissza.setBackground(new java.awt.Color(255, 0, 51));
        btnVissza.setForeground(new java.awt.Color(51, 0, 255));
        btnVissza.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        btnMentes.setBackground(new java.awt.Color(255, 0, 51));
        btnMentes.setForeground(new java.awt.Color(51, 0, 255));
        btnMentes.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        btnTorles.setBackground(new java.awt.Color(255, 0, 51));
        btnTorles.setForeground(new java.awt.Color(51, 0, 255));
        btnTorles.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        btnHozzaad.setBackground(new java.awt.Color(255, 0, 51));
        btnHozzaad.setForeground(new java.awt.Color(51, 0, 255));
        btnHozzaad.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        
        add(cim);
        add(receptek);
        add(receptNeve);
        
        add(osszetevok);
        add(tableScrollPane);
        add(otevoHozzaadLabel);
        add(otevoMennyisegLabel);
        add(otevoMenny);
        add(otevoMennyisegTipusLabel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().setView(osszetevokList);
        add(scrollPane);
        add(otevoMegnevezesLabel);
        add(otevoLeiras);
        add(btnHozzaad);
        add(leirasLbl);
        add(leiras);
        add(btnVissza);
        add(btnMentes);
        add(btnTorles);
        
    }
    
    public void inicShowRecipePanelDefault()
    {
        
        receptNeve.setText("");
        otevoMenny.setText("");
        otevoLeiras.setText("");
        leiras.setText("");
        osszetevokTable.setModel(new DefaultTableModel(new String[]{"Mennyiség", "Egység", "Összetevő"},0));
        DefaultListModel listModel= new DefaultListModel();
        listModel.addElement("");
        osszetevokList.setModel(listModel);
        
        initialized = true;
        
    }
    
    public void setGuiPanel(JPanel guiPanel) {
        this.guiPanel = guiPanel;
    }

    public void setpFrame(JFrame pFrame) {
        this.pFrame = pFrame;
    }

    
   

   public void setOtevokList(ArrayList<String> otevoList) {
        DefaultListModel dlModel = new DefaultListModel();
        for (int i=0; i<otevoList.size();i++)
        {
            dlModel.addElement(otevoList.get(i));
        }
        
        this.osszetevokList.setModel(dlModel);
    }

    public void setLeiras(String leiras) {
        this.leiras.setText(leiras);
    }
    
    
    
    
    public ListModel getOsszetevokList() {
        return osszetevokList.getModel();
    }

    

    public String getOtevoListCurrentSelection()
    {
        return osszetevokList.getSelectedValue().toString();
        
    }

    public DefaultTableModel getOsszetevokTable() {
        return (DefaultTableModel)osszetevokTable.getModel();
    }

    public int getOtevoTablaSorokSzama()
    {
        if (osszetevokTable.getModel().getRowCount()==0) throw new RuntimeException("Nincs összetevő hozzáadva a recepthez. Kérem adjon meg legalább egy összetevőt a recepthez!");
        
        return osszetevokTable.getModel().getRowCount();
    }
    
    public void setOsszetevokTable(TableModel osszetevokTable) {
        this.osszetevokTable.setModel(osszetevokTable);
    }

    public void setReceptNeve(String receptNeve) {
        this.receptNeve.setText(receptNeve);
    }

    public void addRowToOtevoTabla(Object[] obj)
    {
        DefaultTableModel model = (DefaultTableModel)osszetevokTable.getModel();
        model.addRow(obj);
    }

    public String getOtevoMenny() {
        if (otevoMenny.getText().equals("")) throw new RuntimeException("Összetevő mennyiség üres. Kérem adjon meg egy mennyiséget az összetevőhöz!");
        return otevoMenny.getText();
    }

    public String getOtevoLeiras() {
        if (otevoLeiras.getText().equals("")) throw new RuntimeException("Összetevő leírása üres. Kérem adjon meg egy leírást a összetevőhöz!");
        return otevoLeiras.getText();
    }

    public String getReceptNeve() {
        if (receptNeve.getText().equals("")) throw new RuntimeException("Recept neve üres. Kérem adjon meg egy recept nevet!");
        return receptNeve.getText();
    }

    public String getLeiras() {
        if (leiras.getText().equals("")) throw new RuntimeException("Recept leírása üres. Kérem adjon meg egy leírást a recepthez!");
        return leiras.getText();
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }
    
    
}
