/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;


import controller.Controller;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import model.ReceptKezelo;

/**
 *
 * @author 604772006
 */
public class GUI extends JPanel{
    private CardLayout cardLayout = new CardLayout();
    private JPanel cards= new JPanel(cardLayout);
    private JFrame frame = new JFrame();
    private MainPanel mPanel;
    private NewRecipePanel newRPanel;
    private SearchRecipePanel srchRPanel;
    private ShowRecipePanel shRPanel;
    private ReceptKezelo model;
    public final String[] RECEPT_OSZLOP_NEVEK = {"Mennyiség", "Egység", "Összetevő"};

    public GUI(Controller controller)
    {
        mPanel = new MainPanel(controller);
        newRPanel = new NewRecipePanel(controller);
        shRPanel = new ShowRecipePanel(controller);
        srchRPanel = new SearchRecipePanel(controller);
        mPanel.setGuiPanel(cards);
        shRPanel.setGuiPanel(cards);
        newRPanel.setGuiPanel(cards);
        srchRPanel.setGuiPanel(cards);
        mPanel.setpFrame(frame);
        shRPanel.setpFrame(frame);
        newRPanel.setpFrame(frame);
        srchRPanel.setpFrame(frame);
        
        cards.add(mPanel, "card1");
        cards.add(newRPanel, "card2");
        cards.add(shRPanel, "card3");
        cards.add(srchRPanel, "card4");
        cardLayout.show(cards, "card1");
        
        this.frame.setLayout(cardLayout);
        setLayout(new BorderLayout());
        add(cards, BorderLayout.CENTER);
        frame.setTitle("Chlebovics Kornél(VYSQGW) & Papp Zoltán(N3GM04)");
        
        
    }
    public void displayGUI()
    {
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(this, BorderLayout.CENTER);
        //frame.getContentPane().add(this);
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    
    public MainPanel getmPanel() {
        return mPanel;
    }

    public NewRecipePanel getNewRPanel() {
        return newRPanel;
    }

    public ShowRecipePanel getShRPanel() {
        return shRPanel;
    }

    public JPanel getCards() {
        return cards;
    }

    public SearchRecipePanel getSrchRPanel() {
        return srchRPanel;
    }
    
    
    
    public JPanel getCurrentCard()
{
    JPanel card = null;

    for (Component comp : cards.getComponents() ) {
        if (comp.isVisible() == true) {
            card = (JPanel)comp;
            System.out.println(card.getName() );
        }
    }
    //System.out.println();

    return card;
    
    
}

    public JFrame getFrame() {
        return frame;
    }
    
    
    
}
