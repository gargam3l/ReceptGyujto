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
 * @author Chlebovics Kornél
 */
public class MainPanel extends JPanel{
    
    private JFrame pFrame;
    private JLabel cim;
    private JButton ujRecept;
    private JPanel guiPanel;
    private JButton receptKeres;
    private JButton kilepes;

    

    
    public MainPanel(Controller controller) {

        //construct components
        this.cim = new JLabel("Recept Kezelő");
        this.ujRecept = new JButton("Új recept hozzáadása");
        this.receptKeres= new JButton("Recept Keresése");
        this.kilepes= new JButton("Kilépés");
        ujRecept.addActionListener(controller.getUjReceptPanelListener());
        receptKeres.addActionListener(controller.getReceptKeresPanelListener());
        kilepes.addActionListener(controller.getKilepes());

        
        //adjust size and set layout
        setPreferredSize (new Dimension (400, 500));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new java.awt.Color(0, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 102, 255)));
                
        cim.setFont(new java.awt.Font("Courier New", 1, 24));
        cim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        ujRecept.setBackground(new java.awt.Color(255, 0, 51));
        ujRecept.setForeground(new java.awt.Color(51, 0, 255));
        ujRecept.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        receptKeres.setBackground(new java.awt.Color(255, 0, 51));
        receptKeres.setForeground(new java.awt.Color(51, 0, 255));
        receptKeres.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
        
        kilepes.setBackground(new java.awt.Color(255, 0, 51));
        kilepes.setForeground(new java.awt.Color(51, 0, 255));
        kilepes.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14));
                
        //add components
        add (cim);
        add (ujRecept);
        add(receptKeres);
        add(kilepes);
        
    }
    
    public void addController(ActionListener  controller){
		System.out.println("View      : adding controller");
		this.ujRecept.addActionListener(controller);
                this.receptKeres.addActionListener(controller);
    } //addController()
    
    
    public void setGuiPanel(JPanel guiPanel) {
        this.guiPanel = guiPanel;
    }

    public void setpFrame(JFrame pFrame) {
        this.pFrame = pFrame;
    }

    public JButton getUjRecept() {
        return ujRecept;
    }

    public JButton getReceptKeres() {
        return receptKeres;
    }
    
    public JButton getKilepes() {
        return kilepes;
    }
    
    
}
