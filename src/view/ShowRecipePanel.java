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
    
    //JPanel shRecipe = new JPanel();
    /*
        private JLabel cim=new JLabel("Recept megjelenítése");
        private JLabel receptek = new JLabel("Receptek");
       private  JTable receptNevList = new JTable();
        private JLabel osszetevok = new JLabel("Összetevők");
        
        private JLabel leirasLbl = new JLabel("Leírás");
        private JTextField leiras = new JTextField();
        private JButton btnVissza = new JButton("Vissza");
    */
    public ShowRecipePanel(Controller controller) {
    
        
        //JPanel shRecipe = new JPanel();
        JLabel cim = new JLabel("Receptek megjelenítése");
        JLabel receptek = new JLabel("Receptek");
        //receptNevTabla = new JTable(2, 1);
        /**tesztelő adat Listhez
        *DefaultListModel plmodel = new DefaultListModel();
        *plmodel.addElement("pl1");
        *plmodel.addElement("pl2");
        * */
        
        receptNeve=new JTextField("");
        
        JLabel osszetevok = new JLabel("Összetevők");
        osszetevokList = new JList(new String[]{"listelem1","listaelem2"});
        
        JLabel leirasLbl = new JLabel("Leírás");
        JLabel otevoHozzaadLabel = new JLabel("Összetevő hozzáadás");
        JLabel otevoMennyisegLabel = new JLabel("Mennyiség");
        JLabel otevoMennyisegTipusLabel = new JLabel("Mennyiség Típus");
        JLabel otevoMegnevezesLabel = new JLabel("Összetevő");
        otevoMenny= new JTextField("");
        otevoLeiras= new JTextField("");
        leiras = new JTextField();
        btnVissza = new JButton("Vissza");
        btnTorles = new JButton("Törlés");
        btnMentes = new JButton("Mentes");
        btnHozzaad= new JButton("Hozáad");
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnTorles.addActionListener(controller.getReceptTorlesListener());
        btnMentes.addActionListener(controller.getReceptSzerkesztListener());
        btnHozzaad.addActionListener(controller.getOsszetevotHozzaadListener());
        osszetevokList.getSelectionModel().addListSelectionListener(controller.getListaElemListener());
        osszetevokList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        osszetevokTable= new JTable();
        osszetevokTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
                
            },
            new String [] {
                "Mennyiség", "Egység", "Összetevő"
            }
        ));
        
        ListSelectionModel rowSelectionModel=osszetevokTable.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(controller.getTablaSorListener());
        JScrollPane tableScrollPane=new JScrollPane();
        tableScrollPane.setViewportView(osszetevokTable);
        
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setPreferredSize (new Dimension (395, 156));
        
        
        
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
    
    public void setGuiPanel(JPanel guiPanel) {
        this.guiPanel = guiPanel;
    }

    public void setpFrame(JFrame pFrame) {
        this.pFrame = pFrame;
    }

    
   

    public void setOsszetevokList(ListModel osszetevokList) {
        this.osszetevokList.setModel(osszetevokList);
    }

    public void setLeiras(String leiras) {
        this.leiras.setText(leiras);
    }
    
    public void loadRecipeNamesToView(ReceptKezelo kezelo)
    {
        System.out.println("load recipe names to panel");
        DefaultListModel model = new DefaultListModel();
        //model.setColumnIdentifiers(new String[]{"recept nevek"});
        for (String name:kezelo.getNames())
        {
            model.addElement(name);
        }
        //receptNevList.setModel(model);
    }
    
    public void loadRecipeOsszetevokToView(String receptNeve, ReceptKezelo kezelo)
    {
        System.out.println("load recipe osszetevok to panel");
        DefaultListModel model = new DefaultListModel();
        //model.setColumnIdentifiers(new String[]{"recept osszetevok"});
        for (Osszetevok osszetevok:(kezelo.keres(receptNeve).getOsszetevok()))
        {
            model.addElement(osszetevok);
        }
        osszetevokList.setModel(model);
    }
    
    public void loadRecipeLeirasToView(String receptNeve, ReceptKezelo kezelo)
    {
        System.out.println("load recipe leiras to panel");
        leiras.setText(kezelo.keres(receptNeve).getLeiras());
    }

    public ListModel getOsszetevokList() {
        return osszetevokList.getModel();
    }

    

    

    public TableModel getOsszetevokTable() {
        return osszetevokTable.getModel();
    }

    public void setOsszetevokTable(TableModel osszetevokTable) {
        this.osszetevokTable.setModel(osszetevokTable);
    }

    
    
    
}
