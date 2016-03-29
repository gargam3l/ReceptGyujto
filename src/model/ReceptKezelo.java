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
        //inic();
        kapcsolatTeszt();
        tar= new ReceptTar();
    }
    
    public void kapcsolatTeszt()
    {
        try {
            kapcsolatNyit();
            Statement s=kapcsolat.createStatement();
            String sql = "select * from COUNTRIES where REGION_ID=2";
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString("COUNTRY_NAME"));
           }
            kapcsolatZár();
            
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean tablaLetezik()
    {
        try {
            kapcsolatNyit();
            Statement s=kapcsolat.createStatement();
            String sql = "select count(*) from all_tables where table_name='Recept'";
            int tablak_szama;
            ResultSet rs=s.executeQuery(sql);
            tablak_szama=rs.getInt(1);
            kapcsolatZár();
            if(tablak_szama==1) return true;
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
        
    }
    
    public void tablatLetrehoz()
    {
        try {
            kapcsolatNyit();
            Statement s=kapcsolat.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS Receptgyujto;+"
                    + ""
                    + "CONNECT Receptgyujto;\n" +
                    "\n" +
                    "CREATE TABLE Recept\n" +
                    "(\n" +
                    "id int NOT NULL PRIMARY KEY,\n" +
                    "nev varchar(30),\n" +
                    "elkeszites varchar(2000)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE SEQUENCE seq_recept\n" +
                    "MINVALUE 1\n" +
                    "START WITH 1\n" +
                    "INCREMENT BY 1\n" +
                    "CACHE 100;\n" +
                    "\n" +
                    "CREATE TABLE Osszetevo\n" +
                    "(\n" +
                    "id int NOT NULL PRIMARY KEY,\n" +
                    "nev varchar(30)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE SEQUENCE seq_osszetevo\n" +
                    "MINVALUE 1\n" +
                    "START WITH 1\n" +
                    "INCREMENT BY 1\n" +
                    "CACHE 100;\n" +
                    "\n" +
                    "CREATE TABLE Mennyiseg\n" +
                    "(\n" +
                    "id int NOT NULL PRIMARY KEY,\n" +
                    "nev varchar(255)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE SEQUENCE seq_mennyiseg\n" +
                    "MINVALUE 1\n" +
                    "START WITH 1\n" +
                    "INCREMENT BY 1\n" +
                    "CACHE 100;\n" +
                    "\n" +
                    "CREATE TABLE Kozponti\n" +
                    "(\n" +
                    "recept_id int NOT NULL,\n" +
                    "osszetevo_id int NOT NULL,\n" +
                    "mennyiseg int,\n" +
                    "mennyiseg_id int NOT NULL,\n" +
                    "CONSTRAINT fk_recept FOREIGN KEY(recept_id) REFERENCES Recept(id),\n" +
                    "CONSTRAINT fk_osszetevo FOREIGN KEY(osszetevo_id) REFERENCES Osszetevo(id),\n" +
                    "CONSTRAINT fk_mennyiseg FOREIGN KEY(mennyiseg_id) REFERENCES Mennyiseg(id)\n" +
                    ");";
            s.executeUpdate(sql);
            kapcsolatZár();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tablaTesztAdatok()
    {
        try {
            kapcsolatNyit();
            Statement s=kapcsolat.createStatement();
            String sql = ""
                    + "INSERT INTO Recept(id,nev,elkeszites)\n" +
                    "VALUES\n" +
                    "(seq_recept.nextval,'Rántott csirkecomb kukoricás rizzsel','A csirkecombokat enyhén sós vízben megfőzzük, aztán bepanírozzuk először lisztbe, aztán tojásba, és végül a zsemlemorzsába forgatjuk bele.Bő olajban kisütjük a rántott csirkecombokat.Közben megfőzzük a rizst, kukoricát pirítunk hozzá, és összekeverjük a kukoricát a rizzsel.'), --1\n" +
                    "(seq_recept.nextval,'Holstein szelet hasábburgonyával','A húst klopfoljuk ki vékonyra, majd ízlés szerint sózzuk, borsozzuk, és hagyjuk kicsit állni, hogy az ízek jól átjárják.\n" +
                    "Egy teflon serpenyőben hevítsük fel az olajat, majd az előzőleg a lisztbe megforgatott húst helyezzük bele, mérsékeljük a lángot, és sütés közben többször átfordítva, szép lassan süssük mindkét oldalát pirosra. Tálalásig tartsuk melegen.\n" +
                    "A tojást szintén teflon serpenyőben, egy kevés olajon süssük meg, a sütési idő attól függ, hogy mennyire keményre szeretnénk sütni a sárgáját.\n" +
                    "A krumplit pucoljuk meg, vágjuk hasábokra. Enyhén sós vízben főzzük kb. 5 percig, majd szűrjük le, hűtsük ki, ne maradjon vizes a krumpli! Tegyük be a fagyasztóba, hogy teljesen kifagyjon. (Érdemes egyszerre nagyobb mennyiséget előkészíteni, majd a fagyasztóban tárolni felhasználásig.)\n" +
                    "Öntsük bele az olajat egy serpenyőbe, hevítsük fel. A forró olajba óvatosan tegyünk bele kb. 2 nagy marék krumplit, keverjük kicsit össze, majd pár perc alatt süssük szép pirosra. (Sütés közben ne nagyon kevergessük, mert különben széttörik a krumpli.) Szűrőkanállal szedjük ki a megsült krumplit papírtörlőre, és tálalásig tartsuk melegen.\n" +
                    "Tálalás előtt ízlés szerint sózzuk meg a krumplit, majd halmozzuk tányérra, helyezzünk a tetejére egy szelet sült húst és egy tükörtojást. Ízlés szerint szórjuk meg egy csipet pirospaprikával, majd úgy kínáljuk.'), --2\n" +
                    "(seq_recept.nextval,'Rakott krumpli','A krumplikat 10-15 percre beáztatjuk hideg vízbe, majd alaposan megsikáljuk és leöblítjük. A tojásokat megmossuk.\n" +
                    "A krumplit annyi hideg vízzel öntjük fel, hogy bőven ellepje. Hozzáadunk 1 evőkanál sót (ettől ízletesebb lesz), és a forrástól számított 20 percig, fedő alatt, szelíd tűzön puhára főzzük. A tojásokat erősen sós, hideg vízben feltesszük főni, és a forrástól számított 8 percig főzzük, majd hideg vízbe merítve azonnal lehűtjük. A krumpli alól leöntjük a vizet, még melegen meghámozzuk, és hűlni hagyjuk. A kihűlt tojásokat ugyancsak meghámozzuk, elnegyedeljük vagy felkarikázzuk.\n" +
                    "A kolbászt meleg vízzel leöblítjük (így könnyen lehúzhatjuk a héját), azután vékonyan felkarikázzuk. Elkeverjük a tejfölben a tojássárgákat. A sütőt 200 °C-ra (gázsütő 3. fokozat) előmelegítjük.\n" +
                    "A margarinnal kikenünk egy lapos tűzálló tálat, aljára karikázzuk a krumpli felét, kissé megsózzuk, lazán összekeverjük, és elsimítjuk. Arányosan elosztva a tetejére rendezzük a tojást és a kolbászkarikákat, majd megkenjük a tejföl felével. A maradék krumplit felkarikázzuk, és kissé egymásra csúsztatva a tetejére rendezzük. Egyenletesen bevonjuk a maradék tejföllel, végül a tetejére göndörítjük a szalonnaszeleteket.\n" +
                    "A sütőben addig sütjük, amíg a tejföl és a szalonna aranybarnára pirul (35-40 perc). Ezután tálalhatjuk.'), --3\n" +
                    "(seq_recept.nextval,'Mákos tészta','A darált mákot a porcukorral összekeverjük, majd a tésztát kifőzzük, leszűrjük. Ezután a vajat felmelegítjük egy lábosban. Majd beletesszük a tésztát, elkeverjük. Végül ozzháadjuk a porcukros mákot, majd összekeverjük.'), --4\n" +
                    "(seq_recept.nextval,'Babgulyás','A babot előző este beáztatjuk jó sok vízbe. Másnap a répákat felkarikázzuk, a paradicsomot, és a húst is felaprítjuk. A babot egy edénybe tesszük, teszünk bele babérlevelet, felengedjük vízzel, ami ellepi és elkezdjük főzni had, puhuljon. A hagymát apróra vágjuk, kevés olajon üvegesre dinszteljük. Beletesszük az összenyomott fokhagymát, hozzáadjuk a megmosott felkockázott húst és fehéredésig főzzük. Hozzáadjuk, a pirospaprikát elkeverjük. Ezután mehet bele az apró kocára vágott paradicsom, a karikára vágott répa és zöldség. Felöntjük vízzel és hozzáadjuk a kisebb darabokra vágott füstölt húst. Fél óra főzés után a babot is beletesszük, és a bab főzőlevét is adjuk hozzá, nagyon finom lesz tőle. Együtt főzzük, amíg a hús és a bab is puha lesz. Addig elkészítjük a csipetkét. Egy tálba tesszük a lisztet közepébe a tojást, sót, és jól összegyúrjuk, ha kell, még adunk hozzá lisztet az a lényeg a tészta ne ragadjon a kezünkhöz. Ha puha a hús és a bab is, akkor a tésztát tegyük a levesbe, és jól forraljuk össze. A kész tészták feljönnek a leves tetejére.'); --5\n" +
                    "\n" +
                    "INSERT INTO Osszetevo(id,nev)\n" +
                    "VALUES\n" +
                    "(seq_osszetevo.nextval,'csirkecomb'), --1\n" +
                    "(seq_osszetevo.nextval,'rizs'), --2\n" +
                    "(seq_osszetevo.nextval,'étolaj'), --3\n" +
                    "(seq_osszetevo.nextval,'só'), --4\n" +
                    "(seq_osszetevo.nextval,'víz'), --5\n" +
                    "(seq_osszetevo.nextval,'kukorica'), --6\n" +
                    "(seq_osszetevo.nextval,'liszt'), --7\n" +
                    "(seq_osszetevo.nextval,'tojás'), --8\n" +
                    "(seq_osszetevo.nextval,'zsemlemorzsa'), --9\n" +
                    "(seq_osszetevo.nextval,'sertéskaraj'), --10\n" +
                    "(seq_osszetevo.nextval,'bors'), --11\n" +
                    "(seq_osszetevo.nextval,'burgonya'), --12\n" +
                    "(seq_osszetevo.nextval,'pirospaprika'), --13\n" +
                    "(seq_osszetevo.nextval,'kolbász'), --14\n" +
                    "(seq_osszetevo.nextval,'tejföl'), --15\n" +
                    "(seq_osszetevo.nextval,'margarin'), --16\n" +
                    "(seq_osszetevo.nextval,'szalonna'), --17\n" +
                    "(seq_osszetevo.nextval,'mák'), --18\n" +
                    "(seq_osszetevo.nextval,'porcukor'), --19\n" +
                    "(seq_osszetevo.nextval,'tészta'), --20\n" +
                    "(seq_osszetevo.nextval,'vaj'), --21\n" +
                    "(seq_osszetevo.nextval,'szárazbab'), --22\n" +
                    "(seq_osszetevo.nextval,'sárgarépa'), --23\n" +
                    "(seq_osszetevo.nextval,'babérlevél'), --24\n" +
                    "(seq_osszetevo.nextval,'vöröshagyma'), --25\n" +
                    "(seq_osszetevo.nextval,'fokhagyma'), --26\n" +
                    "(seq_osszetevo.nextval,'paradicsom'), --27\n" +
                    "(seq_osszetevo.nextval,'csipetke'); --28\n" +
                    "(seq_osszetevo.nextval,'sertéstarja'); --29\n" +
                    "(seq_osszetevo.nextval,'sertéscsülök'); --30\n" +
                    "(seq_osszetevo.nextval,'petrezselyem'); --31\n" +
                    "(seq_osszetevo.nextval,'fűszerpaprika'); --32\n" +
                    "\n" +
                    "INSERT INTO Mennyiseg(id,nev)\n" +
                    "VALUES\n" +
                    "(seq_mennyiseg.nextval,'db'), --1\n" +
                    "(seq_mennyiseg.nextval,'gramm'), --2\n" +
                    "(seq_mennyiseg.nextval,'ml'); --3\n" +
                    "\n" +
                    "INSERT INTO Kozponti(recept_id,osszetevo_id,mennyiseg,mennyiseg_id)\n" +
                    "VALUES\n" +
                    "(1,1,8,1),\n" +
                    "(1,7,150,2),\n" +
                    "(1,8,4,1),\n" +
                    "(1,9,300,2),\n" +
                    "(1,4,7,2),\n" +
                    "(1,3,400,3), --eddig az első recept\n" +
                    "(2,10,400,2),\n" +
                    "(2,8,4,1),\n" +
                    "(2,7,20,2),\n" +
                    "(2,4,2,2),\n" +
                    "(2,11,2,2),\n" +
                    "(2,3,100,3),\n" +
                    "(2,12,1000,2),\n" +
                    "(2,3,500,3), --eddig a második recept\n" +
                    "(3,12,1000,2),\n" +
                    "(3,8,8,1),\n" +
                    "(3,14,100,2),\n" +
                    "(3,16,20,2),\n" +
                    "(3,17,100,2), --eddig a harmadik recept\n" +
                    "(4,20,500,2),\n" +
                    "(4,18,200,2),\n" +
                    "(4,19,150,2),\n" +
                    "(4,21,50,2), --eddig a negyedik recept\n" +
                    "(5,25,2,1),\n" +
                    "(5,26,4,1),\n" +
                    "(5,29,600,2),\n" +
                    "(5,30,300,2),\n" +
                    "(5,23,3,1),\n" +
                    "(5,31,3,1),\n" +
                    "(5,27,2,1),\n" +
                    "(5,22,500,2),\n" +
                    "(5,24,10,1),\n" +
                    "(5,32,2,1),\n" +
                    "(5,4,2,2),\n" +
                    "(5,3,100,3); --eddig az ötödik recept";
            s.executeUpdate(sql);
            kapcsolatZár();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void inic()
    {
        if (!tablaLetezik()) tablatLetrehoz();
        tablaTesztAdatok();
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
