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
public class SearchRecipePanel  extends JPanel{
    private  JLabel rkeres;
    private JTextField receptNeve;
    private JTable talalatTabla;
    private JButton btnVissza;
    private JButton btnKereses;
    private JFrame pFrame;
    private JPanel guiPanel;
    
    public SearchRecipePanel(Controller controller) {
        rkeres = new JLabel("Recept Keresése");
        JLabel rnevLabel = new JLabel("Recept neve");
        this.receptNeve= new JTextField(1);
        this.btnVissza=new JButton("Vissza");
        this.btnKereses=new JButton("Keresés");
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnKereses.addActionListener(controller.getReceptKeresListener());
            
        //adjust size and set layout
        setPreferredSize (new Dimension (395, 156));
        
        //set component bounds (only needed by Absolute Positioning)
        this.receptNeve.setBounds (20, 45, 100, 25);
        this.rkeres.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.rkeres.setAlignmentY(Component.TOP_ALIGNMENT);
        rnevLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        rnevLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //add components
        add(rkeres);
        add(rnevLabel);
        add(receptNeve);
        add(btnVissza);
        add(btnKereses);
    
        
    }

    void setGuiPanel(JPanel guiPanel) {
        this.guiPanel=guiPanel;
    }

    void setpFrame(JFrame pFrame) {
        this.pFrame=pFrame;
    }
    
    public JButton getBtnVissza() {
        return btnVissza;
    }
    
    public JButton getBtnKereses() {
        return btnKereses;
    }
    
}
