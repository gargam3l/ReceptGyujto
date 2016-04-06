/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chlebovics Kornél
 */
public class ReceptTar{
    private ArrayList<Recept> tar;

    public ReceptTar() {
        tar= new ArrayList<>();
    }
    
    
    
    public void receptetHozzaad(Recept recept)
    {
        tar.add(recept);
    }
    
    public Recept megnevezestKeres(String megnevezes)
    {
        
        for(int i=0; i<tar.size(); i++)
        {
            
            if (tar.get(i).getMegnevezes()==megnevezes)
            {
                return tar.get(i);
            }
        }
        return null;
        
        
    }
    
    public DefaultTableModel getReceptTablaFoAdatok()
    {
        String[] columnName ={ "Megnevezés", "Elkészítés"};
        DefaultTableModel eredmeny = new DefaultTableModel(columnName,0);
        
            
        for(int i=0; i<tar.size(); i++)
        {
                Object[] obj={tar.get(i).getMegnevezes(), tar.get(i).getLeiras()}; 
                eredmeny.addRow(obj);
            
        }
        return eredmeny;
    }
    
    

    public ArrayList<Recept> getTar() {
        return tar;
    }
    public int getLength()
    {
        return tar.size();
    }
}
