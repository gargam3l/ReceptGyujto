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
        inic();
        //kapcsolatTeszt();
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
            int tablak_szama=0;
            ResultSet rs=s.executeQuery(sql);
            while (rs.next())  tablak_szama=rs.getInt(1);
            kapcsolatZár();
            if(tablak_szama>0) return true;
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
            /*
            String sql = "CREATE DATABASE IF NOT EXISTS Receptgyujto;+"
                    + ""
                    + "CONNECT Receptgyujto;" +
                    "" +
            */
            String sql_recept_tabla =        
                    "CREATE TABLE Recept" +
                    "(" +
                    "id int NOT NULL PRIMARY KEY," +
                    "nev varchar(30)," +
                    "elkeszites varchar(2000)" +
                    ");" ;
            s.executeUpdate(sql_recept_tabla);
            String sql_recept_sequence=
                    "CREATE SEQUENCE seq_recept" +
                    "MINVALUE 1" +
                    "START WITH 1" +
                    "INCREMENT BY 1" +
                    "CACHE 100;" ;
            s.executeUpdate(sql_recept_sequence);
            String sql_osszetevo_table=
                    "CREATE TABLE Osszetevo" +
                    "(" +
                    "id int NOT NULL PRIMARY KEY," +
                    "nev varchar(30)" +
                    ");" ;
            s.executeUpdate(sql_osszetevo_table);
            String sql_osszetevo_sequence=
                    "CREATE SEQUENCE seq_osszetevo" +
                    "MINVALUE 1" +
                    "START WITH 1" +
                    "INCREMENT BY 1" +
                    "CACHE 100;" ;
            s.executeUpdate(sql_osszetevo_sequence);
            String sql_mennyiseg_tabla=
                    "CREATE TABLE Mennyiseg" +
                    "(" +
                    "id int NOT NULL PRIMARY KEY," +
                    "nev varchar(255)" +
                    ");" ;
            s.executeUpdate(sql_mennyiseg_tabla);
            String sql_mennyiseg_sequence=
                    "CREATE SEQUENCE seq_mennyiseg" +
                    "MINVALUE 1" +
                    "START WITH 1" +
                    "INCREMENT BY 1" +
                    "CACHE 100;" ;
            s.executeUpdate(sql_mennyiseg_sequence);
            String sql_kozponti_tabla=
                    "CREATE TABLE Kozponti" +
                    "(" +
                    "recept_id int NOT NULL," +
                    "osszetevo_id int NOT NULL," +
                    "mennyiseg int," +
                    "mennyiseg_id int NOT NULL," +
                    "CONSTRAINT fk_recept FOREIGN KEY(recept_id) REFERENCES Recept(id)," +
                    "CONSTRAINT fk_osszetevo FOREIGN KEY(osszetevo_id) REFERENCES Osszetevo(id)," +
                    "CONSTRAINT fk_mennyiseg FOREIGN KEY(mennyiseg_id) REFERENCES Mennyiseg(id)" +
                    ");";
            s.executeUpdate(sql_kozponti_tabla);
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
            String sql_recept_hozzad = ""
                    + "INSERT INTO Recept(id,nev,elkeszites)" +
                    "VALUES" +
                    "(seq_recept.nextval,'Rántott csirkecomb kukoricás rizzsel','A csirkecombokat enyhén sós vízben megfőzzük, aztán bepanírozzuk először lisztbe, aztán tojásba, és végül a zsemlemorzsába forgatjuk bele.Bő olajban kisütjük a rántott csirkecombokat.Közben megfőzzük a rizst, kukoricát pirítunk hozzá, és összekeverjük a kukoricát a rizzsel.'), --1" +
                    "(seq_recept.nextval,'Holstein szelet hasábburgonyával','A húst klopfoljuk ki vékonyra, majd ízlés szerint sózzuk, borsozzuk, és hagyjuk kicsit állni, hogy az ízek jól átjárják." +
                    "Egy teflon serpenyőben hevítsük fel az olajat, majd az előzőleg a lisztbe megforgatott húst helyezzük bele, mérsékeljük a lángot, és sütés közben többször átfordítva, szép lassan süssük mindkét oldalát pirosra. Tálalásig tartsuk melegen." +
                    "A tojást szintén teflon serpenyőben, egy kevés olajon süssük meg, a sütési idő attól függ, hogy mennyire keményre szeretnénk sütni a sárgáját." +
                    "A krumplit pucoljuk meg, vágjuk hasábokra. Enyhén sós vízben főzzük kb. 5 percig, majd szűrjük le, hűtsük ki, ne maradjon vizes a krumpli! Tegyük be a fagyasztóba, hogy teljesen kifagyjon. (Érdemes egyszerre nagyobb mennyiséget előkészíteni, majd a fagyasztóban tárolni felhasználásig.)" +
                    "Öntsük bele az olajat egy serpenyőbe, hevítsük fel. A forró olajba óvatosan tegyünk bele kb. 2 nagy marék krumplit, keverjük kicsit össze, majd pár perc alatt süssük szép pirosra. (Sütés közben ne nagyon kevergessük, mert különben széttörik a krumpli.) Szűrőkanállal szedjük ki a megsült krumplit papírtörlőre, és tálalásig tartsuk melegen." +
                    "Tálalás előtt ízlés szerint sózzuk meg a krumplit, majd halmozzuk tányérra, helyezzünk a tetejére egy szelet sült húst és egy tükörtojást. Ízlés szerint szórjuk meg egy csipet pirospaprikával, majd úgy kínáljuk.'), --2" +
                    "(seq_recept.nextval,'Rakott krumpli','A krumplikat 10-15 percre beáztatjuk hideg vízbe, majd alaposan megsikáljuk és leöblítjük. A tojásokat megmossuk." +
                    "A krumplit annyi hideg vízzel öntjük fel, hogy bőven ellepje. Hozzáadunk 1 evőkanál sót (ettől ízletesebb lesz), és a forrástól számított 20 percig, fedő alatt, szelíd tűzön puhára főzzük. A tojásokat erősen sós, hideg vízben feltesszük főni, és a forrástól számított 8 percig főzzük, majd hideg vízbe merítve azonnal lehűtjük. A krumpli alól leöntjük a vizet, még melegen meghámozzuk, és hűlni hagyjuk. A kihűlt tojásokat ugyancsak meghámozzuk, elnegyedeljük vagy felkarikázzuk." +
                    "A kolbászt meleg vízzel leöblítjük (így könnyen lehúzhatjuk a héját), azután vékonyan felkarikázzuk. Elkeverjük a tejfölben a tojássárgákat. A sütőt 200 °C-ra (gázsütő 3. fokozat) előmelegítjük." +
                    "A margarinnal kikenünk egy lapos tűzálló tálat, aljára karikázzuk a krumpli felét, kissé megsózzuk, lazán összekeverjük, és elsimítjuk. Arányosan elosztva a tetejére rendezzük a tojást és a kolbászkarikákat, majd megkenjük a tejföl felével. A maradék krumplit felkarikázzuk, és kissé egymásra csúsztatva a tetejére rendezzük. Egyenletesen bevonjuk a maradék tejföllel, végül a tetejére göndörítjük a szalonnaszeleteket." +
                    "A sütőben addig sütjük, amíg a tejföl és a szalonna aranybarnára pirul (35-40 perc). Ezután tálalhatjuk.'), --3" +
                    "(seq_recept.nextval,'Mákos tészta','A darált mákot a porcukorral összekeverjük, majd a tésztát kifőzzük, leszűrjük. Ezután a vajat felmelegítjük egy lábosban. Majd beletesszük a tésztát, elkeverjük. Végül ozzháadjuk a porcukros mákot, majd összekeverjük.'), --4" +
                    "(seq_recept.nextval,'Babgulyás','A babot előző este beáztatjuk jó sok vízbe. Másnap a répákat felkarikázzuk, a paradicsomot, és a húst is felaprítjuk. A babot egy edénybe tesszük, teszünk bele babérlevelet, felengedjük vízzel, ami ellepi és elkezdjük főzni had, puhuljon. A hagymát apróra vágjuk, kevés olajon üvegesre dinszteljük. Beletesszük az összenyomott fokhagymát, hozzáadjuk a megmosott felkockázott húst és fehéredésig főzzük. Hozzáadjuk, a pirospaprikát elkeverjük. Ezután mehet bele az apró kocára vágott paradicsom, a karikára vágott répa és zöldség. Felöntjük vízzel és hozzáadjuk a kisebb darabokra vágott füstölt húst. Fél óra főzés után a babot is beletesszük, és a bab főzőlevét is adjuk hozzá, nagyon finom lesz tőle. Együtt főzzük, amíg a hús és a bab is puha lesz. Addig elkészítjük a csipetkét. Egy tálba tesszük a lisztet közepébe a tojást, sót, és jól összegyúrjuk, ha kell, még adunk hozzá lisztet az a lényeg a tészta ne ragadjon a kezünkhöz. Ha puha a hús és a bab is, akkor a tésztát tegyük a levesbe, és jól forraljuk össze. A kész tészták feljönnek a leves tetejére.'); --5" 
                    ;
            s.executeUpdate(sql_recept_hozzad);
            String sql_osszetevo_hozzaad=
                    "INSERT INTO Osszetevo(id,nev)" +
                    "VALUES" +
                    "(seq_osszetevo.nextval,'csirkecomb'), --1" +
                    "(seq_osszetevo.nextval,'rizs'), --2" +
                    "(seq_osszetevo.nextval,'étolaj'), --3" +
                    "(seq_osszetevo.nextval,'só'), --4" +
                    "(seq_osszetevo.nextval,'víz'), --5" +
                    "(seq_osszetevo.nextval,'kukorica'), --6" +
                    "(seq_osszetevo.nextval,'liszt'), --7" +
                    "(seq_osszetevo.nextval,'tojás'), --8" +
                    "(seq_osszetevo.nextval,'zsemlemorzsa'), --9" +
                    "(seq_osszetevo.nextval,'sertéskaraj'), --10" +
                    "(seq_osszetevo.nextval,'bors'), --11" +
                    "(seq_osszetevo.nextval,'burgonya'), --12" +
                    "(seq_osszetevo.nextval,'pirospaprika'), --13" +
                    "(seq_osszetevo.nextval,'kolbász'), --14" +
                    "(seq_osszetevo.nextval,'tejföl'), --15" +
                    "(seq_osszetevo.nextval,'margarin'), --16" +
                    "(seq_osszetevo.nextval,'szalonna'), --17" +
                    "(seq_osszetevo.nextval,'mák'), --18" +
                    "(seq_osszetevo.nextval,'porcukor'), --19" +
                    "(seq_osszetevo.nextval,'tészta'), --20" +
                    "(seq_osszetevo.nextval,'vaj'), --21" +
                    "(seq_osszetevo.nextval,'szárazbab'), --22" +
                    "(seq_osszetevo.nextval,'sárgarépa'), --23" +
                    "(seq_osszetevo.nextval,'babérlevél'), --24" +
                    "(seq_osszetevo.nextval,'vöröshagyma'), --25" +
                    "(seq_osszetevo.nextval,'fokhagyma'), --26" +
                    "(seq_osszetevo.nextval,'paradicsom'), --27" +
                    "(seq_osszetevo.nextval,'csipetke'); --28" +
                    "(seq_osszetevo.nextval,'sertéstarja'); --29" +
                    "(seq_osszetevo.nextval,'sertéscsülök'); --30" +
                    "(seq_osszetevo.nextval,'petrezselyem'); --31" +
                    "(seq_osszetevo.nextval,'fűszerpaprika'); --32" ;
            s.executeUpdate(sql_osszetevo_hozzaad);
        String sql_mennyiseg_hozzaad=
                    "INSERT INTO Mennyiseg(id,nev)" +
                    "VALUES" +
                    "(seq_mennyiseg.nextval,'db'), --1" +
                    "(seq_mennyiseg.nextval,'gramm'), --2" +
                    "(seq_mennyiseg.nextval,'ml'); --3" ;
        s.executeUpdate(sql_mennyiseg_hozzaad);
        String sql_kozponti_hozzaad=
                    "INSERT INTO Kozponti(recept_id,osszetevo_id,mennyiseg,mennyiseg_id)" +
                    "VALUES" +
                    "(1,1,8,1)," +
                    "(1,7,150,2)," +
                    "(1,8,4,1)," +
                    "(1,9,300,2)," +
                    "(1,4,7,2)," +
                    "(1,3,400,3), --eddig az első recept" +
                    "(2,10,400,2)," +
                    "(2,8,4,1)," +
                    "(2,7,20,2)," +
                    "(2,4,2,2)," +
                    "(2,11,2,2)," +
                    "(2,3,100,3)," +
                    "(2,12,1000,2)," +
                    "(2,3,500,3), --eddig a második recept" +
                    "(3,12,1000,2)," +
                    "(3,8,8,1)," +
                    "(3,14,100,2)," +
                    "(3,16,20,2)," +
                    "(3,17,100,2), --eddig a harmadik recept" +
                    "(4,20,500,2)," +
                    "(4,18,200,2)," +
                    "(4,19,150,2)," +
                    "(4,21,50,2), --eddig a negyedik recept" +
                    "(5,25,2,1)," +
                    "(5,26,4,1)," +
                    "(5,29,600,2)," +
                    "(5,30,300,2)," +
                    "(5,23,3,1)," +
                    "(5,31,3,1)," +
                    "(5,27,2,1)," +
                    "(5,22,500,2)," +
                    "(5,24,10,1)," +
                    "(5,32,2,1)," +
                    "(5,4,2,2)," +
                    "(5,3,100,3); --eddig az ötödik recept";
            s.executeUpdate(sql_kozponti_hozzaad);
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
    
    public boolean receptLetezik(String receptNev)
    {
        try {
            kapcsolatNyit();
            Statement s=kapcsolat.createStatement();
            String sql = "select count(*) from Recept where nev="+receptNev;
            int tablak_szama;
            ResultSet rs=s.executeQuery(sql);
            tablak_szama=rs.getInt(1);
            kapcsolatZár();
            if(tablak_szama>0) return true;
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    public void receptetBeszur (Recept recept)
    {
        try {
            kapcsolatNyit();
            Statement s=kapcsolat.createStatement();
            String sql_recept_id="select seq_recept.nextval from dual";
            ResultSet rs1=s.executeQuery(sql_recept_id);
            String recept_id=rs1.getString(1);
            String sql_recept_tabla = "INSERT INTO Recept(id,nev,elkeszites)" +
                    "VALUES" +
                    "("+recept_id+","+recept.getMegnevezes()+","+recept.getLeiras()+")";
            s.executeUpdate(sql_recept_tabla);
            
            for (Osszetevok otevo: recept.getOsszetevok())
            {
                String sql_otevo_id="select seq_osszetevo.nextval from dual";
                ResultSet rs2=s.executeQuery(sql_recept_id);
                String otevo_id=rs2.getString(1);
                String sql_otevo_hozzad = "INSERT INTO Osszetevo(id,nev)" +
                    "VALUES" +
                    "("+otevo_id+","+otevo.getOsszetevo_fajta()+")";
                s.executeUpdate(sql_otevo_hozzad);
                String sql_mennyiseg_id="select id from Mennyiseg where nev="+otevo.getMennyiseg_tipus();
                ResultSet rs3=s.executeQuery(sql_recept_id);
                String mennyiseg_id=rs3.getString(1);
                String sql_kozponti_hozzaad = "INSERT INTO Kozponti(recept_id,osszetevo_id,mennyiseg,mennyiseg_id)" +
                    "VALUES" +
                    "("+recept_id+","+otevo_id+","+otevo.getMennyiseg_egyseg()+","+mennyiseg_id+ ")";
                s.executeUpdate(sql_kozponti_hozzaad);
            }
            kapcsolatZár();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void receptetMent(Recept recept)
    {
        if (!receptLetezik(recept.getMegnevezes())) receptetBeszur(recept);
                else{
                    //exception logika -recept már létezik
                    System.out.println("Recept már létezik");
                }
    }
    
    public void receptetSzerkeszt(String aktualis, Recept uj)
    {
        try {
            kapcsolatNyit();
            Statement s=kapcsolat.createStatement();
            //Recept nevének és elékszítésének módosítása
            String sql_recept_id="select id from Recept where nev="+aktualis;
            ResultSet rs1=s.executeQuery(sql_recept_id);
            String recept_id=rs1.getString(1);
            String sql_recept_tabla = "update Recept" +
                    "SET" +
                    "nev="+uj.getMegnevezes()+", elkeszites="+uj.getLeiras()
                    +"where id="+recept_id;
            s.executeUpdate(sql_recept_tabla);
            //Összetevőket töröljük ill központi táblát karban tartjuk
            String sql1 = "delete from Osszetevo where osszetevo_id in (select osszetevo_id FROM Kozponti"
                    + "OUTER JOIN Recept ON Kozponti.recept_id=Recept.id"
                    + "WHERE Recept.nev ="+uj.getMegnevezes()+")";
            s.executeUpdate(sql1);
            String sql2 = "delete from Kozponti where recept_id ="+recept_id;
            //Módosított összetevők hozzáadsa, központi tábla karban tartása
            for (Osszetevok otevo: uj.getOsszetevok())
            {
                String sql_otevo_id="select seq_osszetevo.nextval from dual";
                ResultSet rs2=s.executeQuery(sql_recept_id);
                String otevo_id=rs2.getString(1);
                String sql_otevo_hozzad = "INSERT INTO Osszetevo(id,nev)" +
                    "VALUES" +
                    "("+otevo_id+","+otevo.getOsszetevo_fajta()+")";
                s.executeUpdate(sql_otevo_hozzad);
                String sql_mennyiseg_id="select id from Mennyiseg where nev="+otevo.getMennyiseg_tipus();
                ResultSet rs3=s.executeQuery(sql_recept_id);
                String mennyiseg_id=rs3.getString(1);
                String sql_kozponti_hozzaad = "INSERT INTO Kozponti(recept_id,osszetevo_id,mennyiseg,mennyiseg_id)" +
                    "VALUES" +
                    "("+recept_id+","+otevo_id+","+otevo.getMennyiseg_egyseg()+","+mennyiseg_id+ ")";
                s.executeUpdate(sql_kozponti_hozzaad);
            }
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
            
            String sql = "SELECT nev, elkeszites FROM Recept"
                    + "WHERE nev LIKE %"+ kulcs+"%";
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()) 
            {
                
                eredmeny.receptetHozzaad(new Recept(rs.getString("nev"), rs.getString("elkeszites")));
            }
            kapcsolatZár();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return eredmeny;
    }
    
    public void receptetTorol(String receptNev)
    {
        try {
            kapcsolatNyit();
            Statement s=kapcsolat.createStatement();
            String sql1 = "delete from Osszetevo where osszetevo_id in (select osszetevo_id FROM Kozponti"
                    + "OUTER JOIN Recept ON Kozponti.recept_id=Recept.id"
                    + "WHERE Recept.nev ="+receptNev+")";
            s.executeUpdate(sql1);
            String sql2 = "delete from Kozponti where recept_id in (select id FROM Recept"
                    + "WHERE nev ="+receptNev+")";
            s.executeUpdate(sql2);
            String sql3 = "delete from Recept where nev="+receptNev;
            s.executeUpdate(sql3);
            kapcsolatZár();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*
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
    */
    
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
