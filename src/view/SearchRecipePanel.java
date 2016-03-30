/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

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
    private JFrame pFrame;
    private JPanel guiPanel;
    
    public SearchRecipePanel() {
        rkeres = new JLabel("Recept Keresése");
        JLabel rnevLabel = new JLabel("Recept neve");
        this.receptNeve= new JTextField(1);
        this.btnVissza=new JButton("Vissza");
            
        //adjust size and set layout
        setPreferredSize (new Dimension (395, 156));
        //setLayout (null);
        setLayout(new FlowLayout());
        
        
        //set component bounds (only needed by Absolute Positioning)
        this.receptNeve.setBounds (20, 45, 100, 25);
        //this.otevoMennyiseg.setBounds (135, 60, 100, 25);
        //this.otevoTipus.setBounds (260, 35, 100, 25);
        //this.otevoMegnevezes.setBounds (105, 115, 100, 25);
        
        this.rkeres.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.rkeres.setAlignmentY(Component.TOP_ALIGNMENT);
        rnevLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        rnevLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //add components
        add(rkeres);
        add(rnevLabel);
        add(receptNeve);
        add(btnVissza);
        //this.setLayout(new FlowLayout());
        
        
    }

    void setGuiPanel(JPanel guiPanel) {
        this.guiPanel=guiPanel;
    }

    void setpFrame(JFrame pFrame) {
        this.pFrame=pFrame;
    }
    
    public void addController(ActionListener  controller){
		//System.out.println("View      : adding controller");
		this.btnVissza.addActionListener(controller);	//need controller before adding it as a listener 
                //this.ujRecept.addActionListener(controller);
    }

    public JButton getBtnVissza() {
        return btnVissza;
    }
    
}
