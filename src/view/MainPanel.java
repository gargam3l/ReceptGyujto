package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JPanel{
    
    private JFrame pFrame;
    private JLabel cim;
    private JLabel space1;
    private JLabel space2;
    private JButton ujRecept;
    private JPanel guiPanel;
    private JButton receptKeres;
    private JButton kilepes;
    
    public MainPanel(Controller controller) {

        //construct components
        cim = new JLabel("Recept Kezelő");
        ujRecept = new JButton("Új recept hozzáadása");
        space1 = new JLabel("");
        receptKeres= new JButton("Recept Keresése");
        space2 = new JLabel("");
        kilepes= new JButton("Kilépés");
        
        ujRecept.addActionListener(controller.getUjReceptPanelListener());
        receptKeres.addActionListener(controller.getReceptKeresPanelListener());
        kilepes.addActionListener(controller.getKilepes());
        
        //adjust size and set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize (new Dimension (400, 650));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                
        cim.setFont(new Font("Courier New", 1, 24));
        cim.setBorder(new EmptyBorder(new Insets(1, 50, 50, 1)));
        
        ujRecept.setFont(new Font("Courier New", 1, 14));
        
        space1.setFont(new Font("Courier New", 1, 24));
        space1.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));
        
        receptKeres.setFont(new Font("Courier New", 1, 14));
        
        space2.setFont(new Font("Courier New", 1, 24));
        space2.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));        
        
        kilepes.setFont(new Font("Courier New", 1, 14));
                
        //add components
        add (cim);
        add (ujRecept);
        add (space1);
        add(receptKeres);
        add (space2);
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
