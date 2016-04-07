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
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.*;
import model.ReceptKezelo;
import view.*;

/**
 *
 * @author 604772006
 */
public class Controller {
    private ReceptKezelo rKezelo;
    private GUI gui;
    
    
    public Controller() {
        gui = new GUI(this);
        rKezelo = new ReceptKezelo();
    }
    
    public void Run()
    {
        
        
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                gui.displayGUI();
            }
        });
        
    }

    
    
    public ActionListener getVisszaGombListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 
                 CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                 cardLayout.show(gui.getCards(), "card1");
             }
         };
    }
    
    public ActionListener getUjReceptPanelListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 gui.getNewRPanel().setInitialized(false);
                 CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                cardLayout.show(gui.getCards(), "card2");
                gui.getNewRPanel().inicNewRecipePanelDefault();
                
                
                //összetevő mennyiség típusok betöltése
                gui.getNewRPanel().setOtevoList(rKezelo.otevoMennyTipusok());
             }
         };
    }
    
    public ActionListener getReceptKeresPanelListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 gui.getSrchRPanel().setInitialized(false);
                 CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                    cardLayout.show(gui.getCards(), "card4");
                 gui.getSrchRPanel().inicSearchRecipePanelDefault();   
             }
         };
    }
    
    public ActionListener getReceptMutatPanelListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                    cardLayout.show(gui.getCards(), "card3");
                    
                    //összetevő mennyiség típusok betöltése
                    gui.getShRPanel().setOtevokList(rKezelo.otevoMennyTipusok());
                    //Kiválasztott recepthez összetevők betöltésa
                    rKezelo.getAktualisRecept().setOsszetevok(rKezelo.keresOsszetevoRecepthez(rKezelo.getAktualisRecept().getMegnevezes()));
                    //Recept név betöltése guiba
                    gui.getShRPanel().setReceptNeve(rKezelo.getAktualisRecept().getMegnevezes());
                    //Összetevők töltése guiba
                    gui.getShRPanel().setOsszetevokTable(rKezelo.getAktualisRecept().getOsszetevokTablaban());
                    //Recept leírás betöltése guiba
                    gui.getShRPanel().setLeiras(rKezelo.getAktualisRecept().getLeiras());
                    
                    
             }
         };
    }
    
    public ActionListener getMentesGombListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
    //Tesztelésre, debuggolásra
                 /*
                System.out.println(gui.getNewRPanel().getReceptNeve() +" "
                +gui.getNewRPanel().getReceptLeiras() +" ");
                System.out.println("ment");
                */
                //Működési logika
                //Recept létrehozása a gui-ból vett adatokkal - megnevezés leírás
                System.out.println("ment"); 
                try
                {
                    gui.getNewRPanel().getReceptNeve();
                    
                Recept ujRecept = new Recept(gui.getNewRPanel().getReceptNeve(), gui.getNewRPanel().getReceptLeiras());
                System.out.println(gui.getNewRPanel().getReceptNeve()+" "+ gui.getNewRPanel().getReceptLeiras());
                //Összetevők hozzáadása recepthez - ciklusba kell tenni, miután gui-ban az összetevők tábla implementálva lesz
                for (int i=0;i<gui.getNewRPanel().getOtevoTabla().getRowCount();i++)
                    {
                        Osszetevok otevo=new Osszetevok();
                        otevo.setMennyiseg_egyseg(gui.getNewRPanel().getOtevoTabla().getValueAt(i, 0).toString());
                        System.out.println(gui.getNewRPanel().getOtevoTabla().getValueAt(i, 0).toString());
                                
                        otevo.setMennyiseg_tipus(gui.getNewRPanel().getOtevoTabla().getValueAt(i, 1).toString());
                        System.out.println(gui.getNewRPanel().getOtevoTabla().getValueAt(i, 1).toString());
                        otevo.setOsszetevo_fajta(gui.getNewRPanel().getOtevoTabla().getValueAt(i, 2).toString());
                        System.out.println(gui.getNewRPanel().getOtevoTabla().getValueAt(i, 2).toString());
                        ujRecept.osszetevotHozzaad(otevo);
                    }
                
                //Recept mentése az adatbázisba
                
                rKezelo.receptetMent(ujRecept);
                 
                            
                } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(gui, ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);

                }
                 
                }
         };
    }
    
    public ActionListener getReceptTorlesListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 System.out.println("Törlés gomb");
                 rKezelo.receptetTorol(rKezelo.getAktualisRecept().getMegnevezes());
             }
         };
    }
    
    public ActionListener getReceptSzerkesztListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 System.out.println("Recept szerkesztés gomb");
                 Recept ujRecept = new Recept();
                 ujRecept.setMegnevezes(gui.getShRPanel().getReceptNeve());
                 ujRecept.setLeiras(gui.getShRPanel().getLeiras());
                 DefaultTableModel model = gui.getShRPanel().getOsszetevokTable();
                 for (int i=0; i<model.getRowCount(); i++)
                 {
                     Osszetevok otevo=new Osszetevok();
                     otevo.setMennyiseg_egyseg(model.getValueAt(i, 0).toString());
                     otevo.setMennyiseg_tipus(model.getValueAt(i, 1).toString());
                     otevo.setOsszetevo_fajta(model.getValueAt(i, 2).toString());
                     ujRecept.osszetevotHozzaad(otevo);
                 }
                 
                    rKezelo.receptetSzerkeszt(rKezelo.getAktualisRecept().getMegnevezes(), ujRecept);
             }
         };
    }
    
    public ActionListener getUjReceptOsszetevotHozzaadListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 System.out.println("Hozzáadás gomb");
                 gui.getNewRPanel().addRowToOtevoTabla(new Object[]{gui.getNewRPanel().getOtevoMennyiseg(),rKezelo.getAktualisMennyisegTipus(),gui.getNewRPanel().getOtevoMegnevezes()});
                
             }
         };
    }
    
    public ActionListener getReceptMutatOsszetevotHozzaadListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 System.out.println("Hozzáadás gomb");
                 gui.getShRPanel().addRowToOtevoTabla(new Object[]{gui.getShRPanel().getOtevoMenny(),rKezelo.getAktualisMennyisegTipus(),gui.getShRPanel().getOtevoLeiras()});
                
             }
         };
    }
    
    public ActionListener getReceptKeresListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 
                 
                 String kulcs=gui.getSrchRPanel().getReceptNeve();
            ReceptTar tar=rKezelo.keresMegnevezesre(kulcs);
            //
            gui.getSrchRPanel().setTalalatTabla(tar.getReceptTablaFoAdatok());
             }
         };
    }
    
    public ListSelectionListener getTablaSorListener()
    {
        return new ListSelectionListener() {
             

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && gui.getNewRPanel().isInitialized()) {
                    System.out.println("Sor kiválasztva");
                
                }
            }
         };
    }
    
    public ListSelectionListener getReceptTablaSorListener()
    {
        return new ListSelectionListener() {
             

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && gui.getSrchRPanel().isInitialized()) {
                    System.out.println("Sor kiválasztva");
                
                rKezelo.setAktualisRecept(gui.getSrchRPanel().getTalalatTableAktualisSor());
                System.out.println(rKezelo.getAktualisRecept().getMegnevezes()+" "+rKezelo.getAktualisRecept().getLeiras());
                }
            }
         };
    }
    
    
    public ListSelectionListener getUjReceptListaElemListener()
    {
        return new ListSelectionListener() {
             

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()&& gui.getNewRPanel().isInitialized()) {
                    System.out.println("Elem kiválasztva");
                    rKezelo.setAktualisMennyisegTipus(gui.getNewRPanel().getOtevoListCurrentSelection());
                
                }
            }
         };
    }
    
    public ListSelectionListener getReceptMutatListaElemListener()
    {
        return new ListSelectionListener() {
             

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    System.out.println("Elem kiválasztva");
                    rKezelo.setAktualisMennyisegTipus(gui.getShRPanel().getOtevoListCurrentSelection());
                
                }
            }
         };
    }
    
    
}
