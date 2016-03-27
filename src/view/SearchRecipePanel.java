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
    private  JLabel cim;
    private JTextField receptNeve;
    private JTable talalatTabla;
    private JButton btnVissza;
    private JFrame pFrame;
    private JPanel guiPanel;
    
    public SearchRecipePanel() {
        this.setLayout(new FlowLayout());
        
        
    }

    void setGuiPanel(JPanel guiPanel) {
        this.guiPanel=guiPanel;
    }

    void setpFrame(JFrame pFrame) {
        this.pFrame=pFrame;
    }
    
}
