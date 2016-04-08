package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
    private JLabel space1;
    private JLabel space2;
    private JLabel space3;
    private JLabel space4;
    
    public SearchRecipePanel(Controller controller) {
        initialized = false;
        rkeres = new JLabel("Recept Keresése");
        JLabel rnevLabel = new JLabel("Recept neve");
        this.receptNeve= new JTextField(30);
        this.btnVissza=new JButton("Vissza");
        this.btnKereses=new JButton("Keresés");
        this.btnMegnyitas=new JButton("Megnyitás");
        this.talalatTabla=new JTable();
        this.tablaPanel=new JScrollPane();
        space1 = new JLabel("");
        space2 = new JLabel("");
        space3 = new JLabel("");
        space4 = new JLabel("");
                
        ListSelectionModel rowSelectionModel=talalatTabla.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(controller.getReceptTablaSorListener());
        tablaPanel.setViewportView(talalatTabla);
        
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnKereses.addActionListener(controller.getReceptKeresListener());
        btnMegnyitas.addActionListener(controller.getReceptMutatPanelListener());  
        
        //adjust size and set layout
        setPreferredSize (new Dimension (400, 650));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                
        rkeres.setFont(new Font("Courier New", 1, 24));
        rkeres.setBorder(new EmptyBorder(new Insets(1, 50, 50, 1)));
        
        rnevLabel.setFont(new Font("Courier New", 0, 14));
               
        receptNeve.setBackground(Color.decode("#62B4CF"));
        
        space1.setFont(new Font("Courier New", 1, 24));
        space1.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        btnKereses.setFont(new Font("Courier New", 1, 14));
        
        space2.setFont(new Font("Courier New", 1, 24));
        space2.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        talalatTabla.setBackground(Color.decode("#62B4CF"));
        
        tablaPanel.setBackground(Color.decode("#62B4CF"));
        
        space3.setFont(new Font("Courier New", 1, 24));
        space3.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        btnVissza.setFont(new Font("Courier New", 1, 14));
        
        space4.setFont(new Font("Courier New", 1, 24));
        space4.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        btnMegnyitas.setFont(new Font("Courier New", 1, 14));
        
        //add components
        add(rkeres);
        add(rnevLabel);
        add(receptNeve);
        add(space1);
        add(btnKereses);
        add(space2);
        add(tablaPanel);
        add(space3);
        add(btnVissza);
        add(space4);
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
