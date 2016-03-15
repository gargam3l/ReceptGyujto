/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Chlebovics Kornél
 */
public class Recept {
    private String megnevezes;
    private String leiras;
    private ArrayList<Osszetevok> osszetevok;

    /**
     * Üres konstruktor
     */
    public Recept() {
        this.leiras="";
        this.megnevezes="";
        this.osszetevok=new ArrayList<>();
    }

    /**
     * Paraméteres konstruktor
     * @param megnevezes
     * @param leiras
     * @param osszetevok 
     */
    public Recept(String megnevezes, String leiras, ArrayList<Osszetevok> osszetevok) {
        this.megnevezes = megnevezes;
        this.leiras = leiras;
        this.osszetevok = osszetevok;
    }
    
    /**
     * Egy Recepthez hozzádunk egy összetevőt
    */
    public void osszetevotHozzaad(int mennyiseg_egyseg, String mennyiseg_tipus, String osszetevo_fajta)
    {
        this.osszetevok.add(new Osszetevok(mennyiseg_egyseg, mennyiseg_tipus, osszetevo_fajta));
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public String getLeiras() {
        return leiras;
    }

    public ArrayList<Osszetevok> getOsszetevok() {
        return osszetevok;
    }
    
    
    
}
