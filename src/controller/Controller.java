/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.*;
import model.ReceptKezelo;
import view.GUI;

/**
 *
 * @author 604772006
 */
public class Controller implements ActionListener, ListSelectionListener {
    private ReceptKezelo rKezelo;
    private GUI gui;
    
    
    public Controller() {
        gui = new GUI();
        rKezelo = new ReceptKezelo();
        
        
        
        
                    
        
    }
    
    public void Run()
    {
        rKezelo.addObserver(gui);
        gui.addController(this);
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                gui.displayGUI();
            }
        });
        // Teszt adat
        ArrayList<Osszetevok> tesztrosszetevok=new ArrayList<Osszetevok>();
        Osszetevok tesztossz=  new Osszetevok(1, "kg", "hús");
        tesztrosszetevok.add(tesztossz);
        rKezelo.ujRecept(new Recept("Gulyás", "Keverj össze mindent és főzd meg", tesztrosszetevok));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("controller -action performed");
        Object src = e.getSource();
        
        if (src!=null)
        {
            if (e.getSource()==gui.getmPanel().getUjRecept())
            {
                CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                cardLayout.show(gui.getCards(), "card2");
                //pFrame.setTitle("Új recept");
                //rKezelo.notifyObservers();
            }
            else if (e.getSource()==gui.getmPanel().getReceptMutat())
                {
                    CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                    cardLayout.show(gui.getCards(), "card3");
                    gui.getShRPanel().loadRecipeNamesToView(rKezelo);
                }
            else if((e.getSource()==gui.getNewRPanel().getBtnVissza()) || (e.getSource()==gui.getShRPanel().getBtnVissza()))
                {
                    CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                    cardLayout.show(gui.getCards(), "card1");
                }
            else if(e.getSource()==gui.getNewRPanel().getBtnHozzaad())
            {
                System.out.println("hozzad");
            }
            else if(e.getSource()==gui.getNewRPanel().getBtnMentes())
            {
                System.out.println("ment");
            }
                
            
        }
        else
        {
            throw new NullPointerException("null pointer in actionperf");
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        //ArrayList<String> Stringtemp = new ArrayList<String>(e.getSource());
        
        
        DefaultListSelectionModel listModel=(DefaultListSelectionModel)e.getSource();
        //System.out.println(gui.getShRPanel().getOsszetevokTabla().getValueAt(e.getFirstIndex(), 0));
        if (listModel == gui.getShRPanel().getReceptNevList().getSelectionModel() && e.getValueIsAdjusting()==false) {
            
            if (listModel.getLeadSelectionIndex() != -1) {
                System.out.println("List selection event yay!! for "+e.getSource()+ " source, which is a "+ e.getClass());
                //System.out.println(gui.getShRPanel().getOsszetevokTabla().getValueAt(e.getFirstIndex(), 1));
                String receptNeve = gui.getShRPanel().getReceptNevList().getSelectedValue().toString();
               System.out.println(receptNeve+ " is a "+ gui.getShRPanel().getReceptNevList().getSelectedValue().getClass());
               gui.getShRPanel().loadRecipeOsszetevokToView(receptNeve, rKezelo);
               gui.getShRPanel().loadRecipeLeirasToView(receptNeve, rKezelo);
            //controller.setRoomID((Integer)NewMeetingWindow.meetingRoomSearchResultList.getSelectedValue());
        }
        }
        //gui.getShRPanel().loadRecipeOsszetevokToView((String)e.getSource(), rKezelo);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse click on recept nev tabla");
        System.out.println("source "+ e.getSource()+ " is a "+ e.getClass());
        Object src = e.getSource();
        if ((JList)src==gui.getShRPanel().getReceptNevList())
        {
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
    
}
