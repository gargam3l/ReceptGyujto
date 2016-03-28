/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Chlebovics Kornél
 */
public class ReceptKezelo extends Observable  implements AdatbazisKapcsolat{
    private ReceptTar tar;
    private static Connection kapcsolat;

    public ReceptKezelo() {
        tar= new ReceptTar();
    }
    public static void kapcsolatNyit() {
    try {
      Class.forName(DRIVER);
      kapcsolat = DriverManager.getConnection(URL, USER, PASSWORD);
    }
    catch (ClassNotFoundException e) {
      System.out.println("Hiba! Hiányzik a JDBC driver.");
    }
    catch (SQLException e) {
      System.out.println("Hiba! Nem sikerült megnyitni a kapcsolatot az adatbázis-szerverrel.");
    }
  }

  public static void kapcsolatZár() {
    try {
      kapcsolat.close();
    }
    catch (SQLException e) {
      System.out.println("Hiba! Nem sikerült lezárni a kapcsolatot az adatbázis-szerverrel.");
    }
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
    
    public void receptetMent (Recept recept)
    {
        try {
            kapcsolatNyit();
            Statement s=kapcsolat.createStatement();
            String sql = "SQL mentéshez";
            s.executeUpdate(sql);
            kapcsolatZár();
        }
    catch(SQLException e) {
      System.out.println(e.getMessage());
    }
    }
    
    public ReceptTar keresMegnevezesre (String kulcs)
    {
        ReceptTar eredmeny = new ReceptTar();
        try {
            kapcsolatNyit();
            Statement s=kapcsolat.createStatement();
            String sql = "SQL kereséshez megnevezésre"+kulcs;
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()) eredmeny.receptetHozzaad(new Recept());
            kapcsolatZár();
        }
    catch(SQLException e) {
      System.out.println(e.getMessage());
    }
        return eredmeny;
    }
    
    public ReceptTar keresOsszetevore (ArrayList<String> kulcs)
    {
        ReceptTar eredmeny = new ReceptTar();
        try {
            kapcsolatNyit();
            Statement s=kapcsolat.createStatement();
            String sql = "SQL kereséshez összetevőkre";
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()) eredmeny.receptetHozzaad(new Recept());
            kapcsolatZár();
        }
    catch(SQLException e) {
      System.out.println(e.getMessage());
    }
        return eredmeny;
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
