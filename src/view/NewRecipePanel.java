/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.Controller;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author 604772006
 */
public class NewRecipePanel  extends JPanel{

    private JFrame pFrame;
    private JLabel cim;
    private JTextField receptNeve;
    private JTextField otevoMennyiseg;
    private JList otevoTipus;
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
        this.receptNeve= new JTextField(1);
        this.otevoMennyiseg= new JTextField(1);
        this.otevoTipus = new JList();
        this.otevoMegnevezes= new JTextField(1);
        JLabel otevLabel = new JLabel("Összetevők:");
        DefaultListModel plmodel = new DefaultListModel();
        plmodel.addElement(" ");
        otevoList= new JList(plmodel);
        JLabel leirLabel = new JLabel("Recept leírása:");
        this.receptLeiras=new JTextField("leírás...");
        this.btnHozzaad=new JButton("Összetevő hozzáadása");
        this.btnMentes=new JButton("Mentés");
        this.btnVissza=new JButton("Vissza");
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnMentes.addActionListener(controller.getMentesGombListener());
        btnHozzaad.addActionListener(controller.getOsszetevotHozzaadListener());   
        
        //adjust size and set layout
        setPreferredSize (new Dimension (395, 156));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        //add components
        add(cim);
        add(rnevLabel);
        add(receptNeve);
        add(otevLabel);
        add(otevoMennyiseg);
        add(otevoTipus);
        add(otevoMegnevezes);
        add(otevoList);
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

    public JButton getBtnHozzaad() {
        return btnHozzaad;
    }

    public JButton getBtnMentes() {
        return btnMentes;
    }

    public JButton getBtnVissza() {
        return btnVissza;
    }

    public JTextField getReceptNeve() {
        return receptNeve;
    }

    public void setReceptNeve(JTextField receptNeve) {
        this.receptNeve = receptNeve;
    }

    public JList getOtevoList() {
        return otevoList;
    }

    public void setOtevoList(JList otevoList) {
        this.otevoList = otevoList;
    }

    public JTextField getReceptLeiras() {
        return receptLeiras;
    }

    public void setReceptLeiras(JTextField receptLeiras) {
        this.receptLeiras = receptLeiras;
    }

    public JTable getOtevoTabla() {
        return otevoTabla;
    }
    
    
    
    
    
}
