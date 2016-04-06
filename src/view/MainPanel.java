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
    private JButton receptMutat;
    private JButton ujRecept;
    private JPanel guiPanel;
    private JButton receptKeres;
    //private JPanel contentPane;
    

    
    public MainPanel(Controller controller) {
        //contentPane = panel;
        //construct components
        this.cim = new JLabel("Recept Kezelő");
        this.receptMutat = new JButton("Recept megjelenítése");
        this.ujRecept = new JButton("Új recept hozzáadása");
        this.receptKeres= new JButton("Recept Keresése");
        receptMutat.addActionListener(controller.getReceptMutatPanelListener());
        ujRecept.addActionListener(controller.getUjReceptPanelListener());
        receptKeres.addActionListener(controller.getReceptKeresPanelListener());
        //panel.add(this.receptKeres);
        //panel.add(this.ujRecept);
        
        //adjust size and set layout
        setPreferredSize (new Dimension (400, 500));
        //((JFrame)SwingUtilities.getRoot(guiPanel)).setTitle("Recept Kezelő");
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        //cim.setHorizontalAlignment(JLabel.CENTER);
        //setLayout(new BorderLayout());
        /*
        //set component bounds
        receptKeres.setLocation(0, 0);
        receptKeres.setSize(150, 25);
        ujRecept.setLocation(100, 100);
        ujRecept.setSize(60, 25);
        */
        
        //cim.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        //pFrame.setTitle("Recept Kezelő");
        /*
        receptMutat.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                CardLayout cardLayout = (CardLayout) guiPanel.getLayout();
                cardLayout.show(guiPanel, "card3");
                pFrame.setTitle("Receptek megjelenítése");
            }
        });
        ujRecept.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) guiPanel.getLayout();
                cardLayout.show(guiPanel, "card2");
                pFrame.setTitle("Új recept");
            }
        });
        */
        
        //add components
        add (cim);
        add (receptMutat);
        add (ujRecept);
        add(receptKeres);
        
    }
    
    public void addController(ActionListener  controller){
		System.out.println("View      : adding controller");
		this.receptMutat.addActionListener(controller);	//need controller before adding it as a listener 
                this.ujRecept.addActionListener(controller);
                this.receptKeres.addActionListener(controller);
    } //addController()
    
    /*
    public static class CloseListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
    e.getWindow().setVisible(false);
    System.exit(0);
    } //windowClosing()
    } //CloseListener
     */
    public void setGuiPanel(JPanel guiPanel) {
        this.guiPanel = guiPanel;
    }

    public void setpFrame(JFrame pFrame) {
        this.pFrame = pFrame;
    }

    public JButton getReceptMutat() {
        return receptMutat;
    }

    public JButton getUjRecept() {
        return ujRecept;
    }

    public JButton getReceptKeres() {
        return receptKeres;
    }
    
    
}
