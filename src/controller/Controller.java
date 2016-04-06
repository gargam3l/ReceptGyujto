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
        rKezelo.addObserver(gui);
        //gui.addController(this);
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                gui.displayGUI();
            }
        });
        // Teszt adatok
        /*
        ArrayList<Osszetevok> tesztrosszetevok=new ArrayList<Osszetevok>();
        Osszetevok tesztossz=  new Osszetevok("1", "kg", "hús");
        tesztrosszetevok.add(tesztossz);
        rKezelo.ujRecept(new Recept("Gulyás", "Keverj össze mindent és főzd meg", tesztrosszetevok));
        */
    }

    
    //Kitörölni, amikor az összes esménykezelő külön meg lett írva
    
    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("controller -action performed");
        Object src = e.getSource();
        
        if (src!=null)
        {
            if (e.getSource()==gui.getmPanel().getUjRecept())
            {
                //Új recept hozzáadása panel
                CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                cardLayout.show(gui.getCards(), "card2");
                //pFrame.setTitle("Új recept");
                //rKezelo.notifyObservers();
            }
            else if (e.getSource()==gui.getmPanel().getReceptMutat())
                {
                    //Recept megjelenítése panel
                    CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                    cardLayout.show(gui.getCards(), "card3");
                    gui.getShRPanel().loadRecipeNamesToView(rKezelo);
                }
            else if((e.getSource()==gui.getNewRPanel().getBtnVissza()) || (e.getSource()==gui.getSrchRPanel().getBtnVissza()) || (e.getSource()==gui.getShRPanel().getBtnVissza()))
                {
                    //Vissza gomb - vissza a főképernyőre
                    CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                    cardLayout.show(gui.getCards(), "card1");
                }
            else if((e.getSource()==gui.getmPanel().getReceptKeres()))
                {
                    //Recept keresése panel
                    CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                    cardLayout.show(gui.getCards(), "card4");
                }
            else if(e.getSource()==gui.getNewRPanel().getBtnHozzaad())
            {
                //Új összetevő hozzáadása
                //összetevő típus gui.getNewRPanel().getOtevoList().getSelectedValue().toString();
                //gui.getNewRPanel().setOtevoTabla(new TableModel(uj_osszetevo);
                //Tesztelésre, debuggolásra
                System.out.println("hozzad");
            }
            else if(e.getSource()==gui.getNewRPanel().getBtnMentes())
            {
                //Tesztelésre, debuggolásra
                /*System.out.println(gui.getNewRPanel().getReceptNeve().getText() +" "
                +gui.getNewRPanel().getReceptLeiras().getText() +" ");
                System.out.println("ment");
                
                //Működési logika
                //Recept létrehozása a gui-ból vett adatokkal - megnevezés leírás
                Recept ujRecept = new Recept(gui.getNewRPanel().getReceptNeve().getText(), gui.getNewRPanel().getReceptLeiras().getText());
                //Összetevők hozzáadása recepthez - ciklusba kell tenni, miután gui-ban az összetevők tábla implementálva lesz
                for (int i=0;i<gui.getNewRPanel().getOtevoTabla().getModel().getRowCount();i++)
                    {
                        Osszetevok otevo=new Osszetevok();
                        otevo.setMennyiseg_egyseg(gui.getNewRPanel().getOtevoTabla().getModel().getValueAt(i, 0).toString());
                        otevo.setOsszetevo_fajta(gui.getNewRPanel().getOtevoTabla().getModel().getValueAt(i, 1).toString());
                        otevo.setMennyiseg_tipus(gui.getNewRPanel().getOtevoTabla().getModel().getValueAt(i, 2).toString());
                        ujRecept.osszetevotHozzaad(otevo);
                    }
                //ujRecept.osszetevotHozzaad((double) gui.getNewRPanel().getOtevoList().getSelectedValue(), null, null);
                //Recept mentése az adatbázisba
                rKezelo.receptetMent(ujRecept);
                
            }
                
            // Keresés panelen keresés
            //String kulcs=gui.getSrchRecipePanel().getKeresettReceptNeve();
            //ReceptTar tar=rKezelo.keresMegnevezesre(kulcs);
            //
            //gui.getSrchRPanel().setRTable(new TableModel(tar.getTar()));
            
            //Törlés
            //String recept=gui.getSrchRecipePanel().getKeresettReceptNeve();
            //rKezelo.receptetTorol(recept);
            
            //Szerkesztés
            //rkezelo.receptetSzerkeszt(recept, uj);
        }
        else
        {
            throw new NullPointerException("null pointer in actionperf");
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
*/
    
    public ActionListener getVisszaGombListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 //m.deleteSomething();
                 CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                 cardLayout.show(gui.getCards(), "card1");
             }
         };
    }
    
    public ActionListener getUjReceptPanelListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                cardLayout.show(gui.getCards(), "card2");
                //összetevő mennyiség típusok betöltése
                gui.getNewRPanel().setOtevoList(rKezelo.otevoMennyTipusok());
             }
         };
    }
    
    public ActionListener getReceptKeresPanelListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                    cardLayout.show(gui.getCards(), "card4");
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
                    rKezelo.getAktualis().setOsszetevok(rKezelo.keresOsszetevoRecepthez(rKezelo.getAktualis().getMegnevezes()));
                    //Recept név betöltése guiba
                    gui.getShRPanel().setReceptNeve(rKezelo.getAktualis().getMegnevezes());
                    //Összetevők töltése guiba
                    gui.getShRPanel().setOsszetevokTable(rKezelo.getAktualis().getOsszetevokTablaban());
                    //Recept leírás betöltése guiba
                    gui.getShRPanel().setLeiras(rKezelo.getAktualis().getLeiras());
                    
                    
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
                //ujRecept.osszetevotHozzaad((double) gui.getNewRPanel().getOtevoList().getSelectedValue(), null, null);
                //Recept mentése az adatbázisba
                rKezelo.receptetMent(ujRecept);
                 
                }
         };
    }
    
    public ActionListener getReceptTorlesListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 System.out.println("Törlés gomb");
                 //rKezelo.receptetTorol(null);
             }
         };
    }
    
    public ActionListener getReceptSzerkesztListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 System.out.println("Recept szerkesztés gomb");
                 //rKezelo.receptetSzerkeszt(null, null);
             }
         };
    }
    
    public ActionListener getOsszetevotHozzaadListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 System.out.println("Hozzáadás gomb");
                 //rKezelo.receptetSzerkeszt(null, null);
             }
         };
    }
    
    public ActionListener getReceptKeresListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 System.out.println("Keres gomb");
                 //rKezelo.receptetSzerkeszt(null, null);
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
                if (!e.getValueIsAdjusting()) {
                    System.out.println("Sor kiválasztva");
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
         };
    }
    
    public ListSelectionListener getReceptTablaSorListener()
    {
        return new ListSelectionListener() {
             

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    System.out.println("Sor kiválasztva");
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                rKezelo.setAktualis(gui.getSrchRPanel().getTalalatTableAktualisSor());
                System.out.println(rKezelo.getAktualis().getMegnevezes()+" "+rKezelo.getAktualis().getLeiras());
                }
            }
         };
    }
    
    
    public ListSelectionListener getListaElemListener()
    {
        return new ListSelectionListener() {
             

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    System.out.println("Elem kiválasztva");
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
         };
    }
    /*
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
