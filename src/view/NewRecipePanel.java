package view;

import controller.Controller;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

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
    private JLabel space1;
    private JLabel space2;
    private JLabel space3;
    private JLabel space4;
    private JLabel space5;
    private JLabel space6;
    private JLabel space7;
    private JLabel space8;
    
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
        space1 = new JLabel("");
        space2 = new JLabel("");
        space3 = new JLabel("");
        space4 = new JLabel("");
        space5 = new JLabel("");
        space6 = new JLabel("");
        space7 = new JLabel("");
        space8 = new JLabel("");
                
        otevoList= new JList();
        JLabel leirLabel = new JLabel("Recept leírása:");
        receptLeiras=new JTextField(100);
        btnHozzaad=new JButton("Hozzáad");
        btnMentes=new JButton("Mentés");
        btnVissza=new JButton("Vissza");
        btnOtevotEltavolit = new JButton("Eltávolít");
        otevoTabla= new JTable();
        
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnMentes.addActionListener(controller.getMentesGombListener());
        btnHozzaad.addActionListener(controller.getUjReceptOsszetevotHozzaadListener());
        btnOtevotEltavolit.addActionListener(controller.getUjReceptOsszetevotEltavolitListener());
        otevoList.getSelectionModel().addListSelectionListener(controller.getUjReceptListaElemListener());
        otevoList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        
        ListSelectionModel rowSelectionModel=otevoTabla.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(controller.getUjReceptTablaSorListener());
        JScrollPane tableScrollPane=new JScrollPane();
        tableScrollPane.setViewportView(otevoTabla);
        
        //adjust size and set layout
        setPreferredSize (new Dimension (400, 650));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                
        cim.setFont(new Font("Courier New", 1, 24));
        cim.setBorder(new EmptyBorder(new Insets(1, 50, 50, 1)));
        
        rnevLabel.setFont(new Font("Courier New", 0, 14));
        
        receptNeve.setBackground(Color.decode("#62B4CF"));
        
        space1.setFont(new Font("Courier New", 1, 24));
        space1.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        otevLabel.setFont(new java.awt.Font("Courier New", 0, 14));
                
        otevoHozzaadLabel.setFont(new java.awt.Font("Courier New", 1, 16));
        otevoHozzaadLabel.setBorder(new EmptyBorder(new Insets(10, 1, 10, 1)));
                
        otevoMennyisegLabel.setFont(new java.awt.Font("Courier New", 0, 14));
                
        otevoMennyiseg.setBackground(Color.decode("#62B4CF"));
        
        space2.setFont(new Font("Courier New", 1, 24));
        space2.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        otevoMennyisegTipusLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        
        space3.setFont(new Font("Courier New", 1, 24));
        space3.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
                
        ujOtevLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        
        otevoMegnevezes.setBackground(Color.decode("#62B4CF"));
        
        space4.setFont(new Font("Courier New", 1, 24));
        space4.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        btnHozzaad.setFont(new Font("Courier New", 1, 14));
        
        space5.setFont(new Font("Courier New", 1, 24));
        space5.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        btnOtevotEltavolit.setFont(new Font("Courier New", 1, 14));
        
        space6.setFont(new Font("Courier New", 1, 24));
        space6.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        leirLabel.setFont(new java.awt.Font("Courier New", 0, 14));
        
        receptLeiras.setBackground(Color.decode("#62B4CF"));
        
        space7.setFont(new Font("Courier New", 1, 24));
        space7.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        btnMentes.setFont(new Font("Courier New", 1, 14));
        
        space8.setFont(new Font("Courier New", 1, 24));
        space8.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        btnVissza.setFont(new Font("Courier New", 1, 14));
        
        otevoList.setBackground(Color.decode("#62B4CF"));
        
        otevoTabla.setBackground(Color.decode("#62B4CF"));
        
        inicNewRecipePanelDefault();
        
        //add components
        add(cim);
        add(rnevLabel);
        add(receptNeve);
        add(space1);
        add(otevLabel);
        add(tableScrollPane);
        add(otevoHozzaadLabel);
        add(otevoMennyisegLabel);
        add(otevoMennyiseg);
        add(space2);
        add(otevoMennyisegTipusLabel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().setView(otevoList);
        add(scrollPane);
        add(space3);
        add(ujOtevLabel);
        add(otevoMegnevezes);
        add(space4);
        add(btnHozzaad);
        add(space5);
        add(btnOtevotEltavolit);
        add(space6);
        add(leirLabel);
        add(receptLeiras);
        add(space7);
        add(btnMentes);
        add(space8);
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
