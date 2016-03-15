/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author Kornél
 */
public class Osszetevok {
   int mennyiseg_egyseg;
   String mennyiseg_tipus;
   String osszetevo_fajta;

    public int getMennyiseg_egyseg() {
        return mennyiseg_egyseg;
    }

    public String getMennyiseg_tipus() {
        return mennyiseg_tipus;
    }

    public String getOsszetevo_fajta() {
        return osszetevo_fajta;
    }

    public void setMennyiseg_egyseg(int mennyiseg_egyseg) {
        this.mennyiseg_egyseg = mennyiseg_egyseg;
    }

    public void setMennyiseg_tipus(String mennyiseg_tipus) {
        this.mennyiseg_tipus = mennyiseg_tipus;
    }

    public void setOsszetevo_fajta(String osszetevo_fajta) {
        this.osszetevo_fajta = osszetevo_fajta;
    }

    public Osszetevok(int mennyiseg_egyseg, String mennyiseg_tipus, String osszetevo_fajta) {
        this.mennyiseg_egyseg = mennyiseg_egyseg;
        this.mennyiseg_tipus = mennyiseg_tipus;
        this.osszetevo_fajta = osszetevo_fajta;
    }

    @Override
    public String toString() {
        return "Osszetevok{" + "mennyiseg_egyseg=" + mennyiseg_egyseg + ", mennyiseg_tipus=" + mennyiseg_tipus + ", osszetevo_fajta=" + osszetevo_fajta + '}';
    }
    
            
}
