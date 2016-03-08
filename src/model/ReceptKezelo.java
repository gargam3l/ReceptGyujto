/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Chlebovics Kornél
 */
public class ReceptKezelo extends Observable{
    private ReceptTar tar;

    public ReceptKezelo() {
        tar= new ReceptTar();
    }

    
    
    public ReceptKezelo(ReceptTar tar) {
        this.tar = tar;
    }
    
    public void ujRecept(Recept recept)
    {
        tar.receptetHozzaad(recept);
        setChanged();
        notifyObservers(recept);
    }
    
    public Recept keres(String str)
    {
        notifyObservers();
        return tar.megnevezestKeres(str);
        
    }
    
    public ArrayList<String> getNames()
    {
        ArrayList<String> names = new ArrayList<String>();
        for(int i=0; i<tar.getLength();i++)
        {
            names.add(tar.getTar().get(i).getMegnevezes());
        }
        
        return names;
        
    }
    
    
   

    @Override
    public String toString() {
        return "ReceptKezelo{" + "tar=" + tar + '}';
    }
    
}
