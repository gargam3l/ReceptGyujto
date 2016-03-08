/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;


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
public class GUI extends JPanel implements Observer{
    private CardLayout cardLayout = new CardLayout();
    private JPanel cards= new JPanel(cardLayout);
    private JFrame frame = new JFrame();
    private MainPanel mPanel;
    private NewRecipePanel newRPanel;
    //private SearchRecipePanel srchRPanel;
    private ShowRecipePanel shRPanel;
    private ReceptKezelo model;

    public GUI()
    {
        mPanel = new MainPanel();
        newRPanel = new NewRecipePanel();
        shRPanel = new ShowRecipePanel();
        mPanel.setGuiPanel(cards);
        shRPanel.setGuiPanel(cards);
        newRPanel.setGuiPanel(cards);
        
        mPanel.setpFrame(frame);
        shRPanel.setpFrame(frame);
        newRPanel.setpFrame(frame);
        
        cards.add(mPanel, "card1");
        cards.add(newRPanel, "card2");
        cards.add(shRPanel, "card3");
        
        cardLayout.show(cards, "card1");
        /*
        mPanel.setBorder(BorderFactory.createTitledBorder("Main Panel"));
        newRPanel.setBorder(BorderFactory.createTitledBorder("Új Recept Panel"));
        shRPanel.setBorder(BorderFactory.createTitledBorder("Recept megjelenítés Panel"));
        */
        setLayout(new BorderLayout());
        add(cards, BorderLayout.CENTER);
        
        
    }
    public void displayGUI()
    {
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        JPanel cards = new JPanel();
        cards.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5));
        cards.setLayout(new CardLayout());
        mPanel = new MainPanel(cards);
        newRPanel = new NewRecipePanel();
        //srchRPanel = new SearchRecipePanel();
        shRPanel = new ShowRecipePanel();
        cards.add(mPanel, "Recept Kezelő"); 
        cards.add(newRPanel, "Új recept felvétele");
        //contentPane.add(srchRPanel, "Recept keres");
        cards.add(shRPanel, "Recept megjelenítése");
                */
        frame.getContentPane().add(this);
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println ("View      : Observable is " + o.getClass() + ", object passed is " + arg.getClass());
        
        Object src=arg;
        if (getCurrentCard()==newRPanel)
        {
            System.out.println("new panel upd");
        }else if (getCurrentCard()==shRPanel)
        {
             System.out.println("show panel upd");   
        }
        
        
        
    }
    
    public void addController(ActionListener controller)
    {
        mPanel.addController(controller);
        newRPanel.addController(controller);
        shRPanel.addController(controller);
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
    
    
    
}
