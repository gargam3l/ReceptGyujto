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
    private JList receptNevList;
    private  JList osszetevokList;
    private JTextField leiras;
    
    //JPanel shRecipe = new JPanel();
    /*
        private JLabel cim=new JLabel("Recept megjelenítése");
        private JLabel receptek = new JLabel("Receptek");
       private  JTable receptNevList = new JTable();
        private JLabel osszetevok = new JLabel("Összetevők");
        private JTable osszetevokList = new JTable();
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
        receptNevList = new JList();
        JLabel osszetevok = new JLabel("Összetevők");
        osszetevokList = new JList();
        JLabel leirasLbl = new JLabel("Leírás");
        leiras = new JTextField();
        btnVissza = new JButton("Vissza");
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnTorles.addActionListener(controller.getReceptTorlesListener());
        btnMentes.addActionListener(controller.getMentesGombListener());
        
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //setLayout(new FlowLayout());
        setPreferredSize (new Dimension (395, 156));
        receptNevList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        
        add(cim);
        add(receptek);
        add(receptNevList);
        add(osszetevok);
        add(osszetevokList);
        add(leirasLbl);
        add(leiras);
        add(btnVissza);
        add(btnMentes);
        add(btnTorles);
        /*
        btnVissza.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) guiPanel.getLayout();
                cardLayout.show(guiPanel, "card1");
            }
        });
        
        */
    }
    
    public void addController(ActionListener controller)
    {
        btnVissza.addActionListener(controller);
        receptNevList.getSelectionModel().addListSelectionListener((ListSelectionListener)controller);
        //receptNevTabla.addMouseListener((MouseListener)controller);
        
    }

    public void setGuiPanel(JPanel guiPanel) {
        this.guiPanel = guiPanel;
    }

    public void setpFrame(JFrame pFrame) {
        this.pFrame = pFrame;
    }

    public JButton getBtnVissza() {
        return btnVissza;
    }
    
    public JButton getBtnMentes() {
        return btnMentes;
    }
    
    public JButton getBtnTorles() {
        return btnTorles;
    }

    public void setReceptNevList(JList receptNevList) {
        this.receptNevList = receptNevList;
    }

    public void setOsszetevokList(JList osszetevokList) {
        this.osszetevokList = osszetevokList;
    }

    public void setLeiras(JTextField leiras) {
        this.leiras = leiras;
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
        receptNevList.setModel(model);
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

    public JList getOsszetevokList() {
        return osszetevokList;
    }

    public JList getReceptNevList() {
        return receptNevList;
    }
    
    
}
