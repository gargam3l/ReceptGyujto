/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import controller.Controller;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import view.GUI;


/**
 *
 * @author 604772006
 */
public class Main {
    public static void main(String[] args) {
        /*
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new GUI().displayGUI();
            }
        });
                */
        try{
        Controller myController = new Controller();
        myController.Run();
        }catch (Exception ex)
        {
            
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);
        
        }
        
        //new comment , commit, push merge test
    }
}
