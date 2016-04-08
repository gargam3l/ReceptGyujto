package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import model.Osszetevok;
import model.ReceptKezelo;

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
    private JButton btnOtevotEltavolit;
    private JLabel space1;
    private JLabel space2;
    private JLabel space3;
    private JLabel space4;
    private JLabel space5;
    private JLabel space6;
    private JLabel space7;
    private JLabel space8;
    private JLabel space9;
     
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
        btnHozzaad= new JButton("Hozzáad");
        btnOtevotEltavolit = new JButton("Eltávolít");
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnTorles.addActionListener(controller.getReceptTorlesListener());
        btnMentes.addActionListener(controller.getReceptSzerkesztListener());
        btnHozzaad.addActionListener(controller.getReceptMutatOsszetevotHozzaadListener());
        btnOtevotEltavolit.addActionListener(controller.getReceptMutatOsszetevotEltavolitListener());
        osszetevokList.getSelectionModel().addListSelectionListener(controller.getReceptMutatListaElemListener());
        osszetevokList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        osszetevokTable= new JTable();
        space1 = new JLabel("");
        space2 = new JLabel("");
        space3 = new JLabel("");
        space4 = new JLabel("");
        space5 = new JLabel("");
        space6 = new JLabel("");
        space7 = new JLabel("");
        space8 = new JLabel("");
        space9 = new JLabel("");
               
        ListSelectionModel rowSelectionModel=osszetevokTable.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(controller.getReceptMutatTablaSorListener());
        JScrollPane tableScrollPane=new JScrollPane();
        tableScrollPane.setViewportView(osszetevokTable);
        
        //adjust size and set layout
        setPreferredSize (new Dimension (400, 650));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                
        cim.setFont(new Font("Courier New", 1, 24));
        cim.setBorder(new EmptyBorder(new Insets(1, 50, 50, 1)));
        
        receptek.setFont(new java.awt.Font("Courier New", 0, 14));
        
        receptNeve.setBackground(Color.decode("#62B4CF"));
        
        space1.setFont(new Font("Courier New", 1, 24));
        space1.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
                
        osszetevok.setFont(new java.awt.Font("Courier New", 0, 14));
        
        osszetevokTable.setBackground(Color.decode("#62B4CF"));
        
        otevoHozzaadLabel.setFont(new java.awt.Font("Courier New", 1, 16));
        otevoHozzaadLabel.setBorder(new EmptyBorder(new Insets(10, 1, 10, 1)));
        
        otevoMennyisegLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        
        otevoMenny.setBackground(Color.decode("#62B4CF"));
        
        space2.setFont(new Font("Courier New", 1, 24));
        space2.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        otevoMennyisegTipusLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        
        osszetevokList.setBackground(Color.decode("#62B4CF"));
        
        space3.setFont(new Font("Courier New", 1, 24));
        space3.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        otevoMegnevezesLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        
        otevoLeiras.setBackground(Color.decode("#62B4CF"));
        
        space4.setFont(new Font("Courier New", 1, 24));
        space4.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        btnHozzaad.setFont(new java.awt.Font("Courier New", 1, 14));
        
        space5.setFont(new Font("Courier New", 1, 24));
        space5.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
                
        btnOtevotEltavolit.setFont(new java.awt.Font("Courier New", 1, 14));
        
        space6.setFont(new Font("Courier New", 1, 24));
        space6.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
                
        leirasLbl.setFont(new java.awt.Font("Courier New", 0, 14));
                
        leiras.setBackground(Color.decode("#62B4CF"));
        
        space7.setFont(new Font("Courier New", 1, 24));
        space7.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        btnVissza.setFont(new java.awt.Font("Courier New", 1, 14));
        
        space8.setFont(new Font("Courier New", 1, 24));
        space8.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        btnMentes.setFont(new java.awt.Font("Courier New", 1, 14));
        
        space9.setFont(new Font("Courier New", 1, 24));
        space9.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        btnTorles.setFont(new java.awt.Font("Courier New", 1, 14));
        
        //add components        
        add(cim);
        add(receptek);
        add(receptNeve);
        add(space1);
        add(osszetevok);
        add(tableScrollPane);
        add(otevoHozzaadLabel);
        add(otevoMennyisegLabel);
        add(otevoMenny);
        add(space2);
        add(otevoMennyisegTipusLabel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().setView(osszetevokList);
        add(scrollPane);
        add(space3);
        add(otevoMegnevezesLabel);
        add(otevoLeiras);
        add(space4);
        add(btnHozzaad);
        add(space5);
        add(btnOtevotEltavolit);
        add(space6);
        add(leirasLbl);
        add(leiras);
        add(space7);
        add(btnVissza);
        add(space8);
        add(btnMentes);
        add(space9);
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

    public DefaultTableModel getOsszetevokTableAdat() {
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
    
    public void removeRowToOtevoTabla(int rowNum)
    {
        DefaultTableModel model = (DefaultTableModel)osszetevokTable.getModel();
        model.removeRow(rowNum);
        
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

    public JTable getOsszetevokTable() {
        return osszetevokTable;
    }
    
    public int getOtevoTableAktualisSor()
    {
        //if (osszetevokTable.getSelectedRow()== -1) throw new RuntimeException("Nincs összetevő kiválasztva. Eltávolításhoz válasszon ki összetevőt!");
        return osszetevokTable.getSelectedRow();
    }
    
    public String getOtevoTablaAdatCella(int x, int y) {
        if (osszetevokTable.getModel().getValueAt(x, y).toString().equals("")) throw new RuntimeException("Összetevő mennyiség vagy leírás üres. Kérem adjon meg mennyiség ill leírás értéket az összetevőhöz!");
        return osszetevokTable.getModel().getValueAt(x, y).toString();
    }
    
}
