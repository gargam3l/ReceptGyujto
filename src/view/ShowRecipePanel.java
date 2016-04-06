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
    
    public ShowRecipePanel(Controller controller) {
    
        
        JLabel cim = new JLabel("Receptek megjelenítése");
        JLabel receptek = new JLabel("Receptek");
        
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
        btnHozzaad.addActionListener(controller.getReceptMutatOsszetevotHozzaadListener());
        osszetevokList.getSelectionModel().addListSelectionListener(controller.getReceptMutatListaElemListener());
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
        return otevoMenny.getText();
    }

    public String getOtevoLeiras() {
        return otevoLeiras.getText();
    }

    public String getReceptNeve() {
        return receptNeve.getText();
    }

    public String getLeiras() {
        return leiras.getText();
    }
    
    
}
