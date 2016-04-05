/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.*;
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
            
    
    public NewRecipePanel() {
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
            
        //adjust size and set layout
        setPreferredSize (new Dimension (395, 156));
        //setLayout (null);
        //setLayout(new FlowLayout());
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        /*
        //set component bounds (only needed by Absolute Positioning)
        this.receptNeve.setBounds (20, 45, 100, 25);
        this.otevoMennyiseg.setBounds (135, 60, 100, 25);
        this.otevoTipus.setBounds (260, 35, 100, 25);
        this.otevoMegnevezes.setBounds (105, 115, 100, 25);
        */
        
        
        
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
                
        btnHozzaad.addActionListener( new ActionListener());
        btnMentes.addActionListener( new ActionListener());
        */
        
        
    }
    
    
    public void addController(ActionListener controller)
    {
        //btnVissza.addActionListener(controller);
        btnVissza.addActionListener(((Controller)controller).getVisszaGombListener());
        btnHozzaad.addActionListener( controller);
        btnMentes.addActionListener( controller);
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
