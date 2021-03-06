DROP DATABASE if exists Receptgyujto;

CREATE DATABASE Receptgyujto;

CONNECT Receptgyujto;

CREATE TABLE Recept
(
id int NOT NULL PRIMARY KEY,
nev varchar(30),
elkeszites varchar(2000),
datum date
);

CREATE SEQUENCE seq_recept
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 100;

CREATE TABLE Osszetevo
(
id int NOT NULL PRIMARY KEY,
nev varchar(30),
datum date
);

CREATE SEQUENCE seq_osszetevo
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 100;

CREATE TABLE Mennyiseg
(
id int NOT NULL PRIMARY KEY,
nev varchar(255),
datum date
);

CREATE SEQUENCE seq_mennyiseg
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 100;

CREATE TABLE Kozponti
(
recept_id int NOT NULL,
osszetevo_id int NOT NULL,
mennyiseg int,
mennyiseg_id int NOT NULL,
CONSTRAINT fk_recept FOREIGN KEY(recept_id) REFERENCES Recept(id),
CONSTRAINT fk_osszetevo FOREIGN KEY(osszetevo_id) REFERENCES Osszetevo(id),
CONSTRAINT fk_mennyiseg FOREIGN KEY(mennyiseg_id) REFERENCES Mennyiseg(id)
);

INSERT INTO Recept(id,nev,elkeszites,datum)
VALUES
(seq_recept.nextval,'Rántott csirkecomb kukoricás rizzsel','A csirkecombokat enyhén sós vízben megfőzzük, aztán bepanírozzuk először lisztbe, aztán tojásba, és végül a zsemlemorzsába forgatjuk bele.Bő olajban kisütjük a rántott csirkecombokat.Közben megfőzzük a rizst, kukoricát pirítunk hozzá, és összekeverjük a kukoricát a rizzsel.',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --1
(seq_recept.nextval,'Holstein szelet hasábburgonyával','A húst klopfoljuk ki vékonyra, majd ízlés szerint sózzuk, borsozzuk, és hagyjuk kicsit állni, hogy az ízek jól átjárják.
Egy teflon serpenyőben hevítsük fel az olajat, majd az előzőleg a lisztbe megforgatott húst helyezzük bele, mérsékeljük a lángot, és sütés közben többször átfordítva, szép lassan süssük mindkét oldalát pirosra. Tálalásig tartsuk melegen.
A tojást szintén teflon serpenyőben, egy kevés olajon süssük meg, a sütési idő attól függ, hogy mennyire keményre szeretnénk sütni a sárgáját.
A krumplit pucoljuk meg, vágjuk hasábokra. Enyhén sós vízben főzzük kb. 5 percig, majd szűrjük le, hűtsük ki, ne maradjon vizes a krumpli! Tegyük be a fagyasztóba, hogy teljesen kifagyjon. (Érdemes egyszerre nagyobb mennyiséget előkészíteni, majd a fagyasztóban tárolni felhasználásig.)
Öntsük bele az olajat egy serpenyőbe, hevítsük fel. A forró olajba óvatosan tegyünk bele kb. 2 nagy marék krumplit, keverjük kicsit össze, majd pár perc alatt süssük szép pirosra. (Sütés közben ne nagyon kevergessük, mert különben széttörik a krumpli.) Szűrőkanállal szedjük ki a megsült krumplit papírtörlőre, és tálalásig tartsuk melegen.
Tálalás előtt ízlés szerint sózzuk meg a krumplit, majd halmozzuk tányérra, helyezzünk a tetejére egy szelet sült húst és egy tükörtojást. Ízlés szerint szórjuk meg egy csipet pirospaprikával, majd úgy kínáljuk.',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --2
(seq_recept.nextval,'Rakott krumpli','A krumplikat 10-15 percre beáztatjuk hideg vízbe, majd alaposan megsikáljuk és leöblítjük. A tojásokat megmossuk.
A krumplit annyi hideg vízzel öntjük fel, hogy bőven ellepje. Hozzáadunk 1 evőkanál sót (ettől ízletesebb lesz), és a forrástól számított 20 percig, fedő alatt, szelíd tűzön puhára főzzük. A tojásokat erősen sós, hideg vízben feltesszük főni, és a forrástól számított 8 percig főzzük, majd hideg vízbe merítve azonnal lehűtjük. A krumpli alól leöntjük a vizet, még melegen meghámozzuk, és hűlni hagyjuk. A kihűlt tojásokat ugyancsak meghámozzuk, elnegyedeljük vagy felkarikázzuk.
A kolbászt meleg vízzel leöblítjük (így könnyen lehúzhatjuk a héját), azután vékonyan felkarikázzuk. Elkeverjük a tejfölben a tojássárgákat. A sütőt 200 °C-ra (gázsütő 3. fokozat) előmelegítjük.
A margarinnal kikenünk egy lapos tűzálló tálat, aljára karikázzuk a krumpli felét, kissé megsózzuk, lazán összekeverjük, és elsimítjuk. Arányosan elosztva a tetejére rendezzük a tojást és a kolbászkarikákat, majd megkenjük a tejföl felével. A maradék krumplit felkarikázzuk, és kissé egymásra csúsztatva a tetejére rendezzük. Egyenletesen bevonjuk a maradék tejföllel, végül a tetejére göndörítjük a szalonnaszeleteket.
A sütőben addig sütjük, amíg a tejföl és a szalonna aranybarnára pirul (35-40 perc). Ezután tálalhatjuk.',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --3
(seq_recept.nextval,'Mákos tészta','A darált mákot a porcukorral összekeverjük, majd a tésztát kifőzzük, leszűrjük. Ezután a vajat felmelegítjük egy lábosban. Majd beletesszük a tésztát, elkeverjük. Végül ozzháadjuk a porcukros mákot, majd összekeverjük.',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --4
(seq_recept.nextval,'Babgulyás','A babot előző este beáztatjuk jó sok vízbe. Másnap a répákat felkarikázzuk, a paradicsomot, és a húst is felaprítjuk. A babot egy edénybe tesszük, teszünk bele babérlevelet, felengedjük vízzel, ami ellepi és elkezdjük főzni had, puhuljon. A hagymát apróra vágjuk, kevés olajon üvegesre dinszteljük. Beletesszük az összenyomott fokhagymát, hozzáadjuk a megmosott felkockázott húst és fehéredésig főzzük. Hozzáadjuk, a pirospaprikát elkeverjük. Ezután mehet bele az apró kocára vágott paradicsom, a karikára vágott répa és zöldség. Felöntjük vízzel és hozzáadjuk a kisebb darabokra vágott füstölt húst. Fél óra főzés után a babot is beletesszük, és a bab főzőlevét is adjuk hozzá, nagyon finom lesz tőle. Együtt főzzük, amíg a hús és a bab is puha lesz. Addig elkészítjük a csipetkét. Egy tálba tesszük a lisztet közepébe a tojást, sót, és jól összegyúrjuk, ha kell, még adunk hozzá lisztet az a lényeg a tészta ne ragadjon a kezünkhöz. Ha puha a hús és a bab is, akkor a tésztát tegyük a levesbe, és jól forraljuk össze. A kész tészták feljönnek a leves tetejére.',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')); --5

INSERT INTO Osszetevo(id,nev,datum)
VALUES
(seq_osszetevo.nextval,'csirkecomb',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --1
(seq_osszetevo.nextval,'rizs',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --2
(seq_osszetevo.nextval,'étolaj',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --3
(seq_osszetevo.nextval,'só',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --4
(seq_osszetevo.nextval,'víz',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --5
(seq_osszetevo.nextval,'kukorica',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --6
(seq_osszetevo.nextval,'liszt',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --7
(seq_osszetevo.nextval,'tojás',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --8
(seq_osszetevo.nextval,'zsemlemorzsa',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --9
(seq_osszetevo.nextval,'sertéskaraj',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --10
(seq_osszetevo.nextval,'bors',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --11
(seq_osszetevo.nextval,'burgonya',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --12
(seq_osszetevo.nextval,'pirospaprika',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --13
(seq_osszetevo.nextval,'kolbász',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --14
(seq_osszetevo.nextval,'tejföl',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --15
(seq_osszetevo.nextval,'margarin',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --16
(seq_osszetevo.nextval,'szalonna',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --17
(seq_osszetevo.nextval,'mák',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --18
(seq_osszetevo.nextval,'porcukor',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --19
(seq_osszetevo.nextval,'tészta',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --20
(seq_osszetevo.nextval,'vaj',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --21
(seq_osszetevo.nextval,'szárazbab',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --22
(seq_osszetevo.nextval,'sárgarépa',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --23
(seq_osszetevo.nextval,'babérlevél',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --24
(seq_osszetevo.nextval,'vöröshagyma',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --25
(seq_osszetevo.nextval,'fokhagyma',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --26
(seq_osszetevo.nextval,'paradicsom',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --27
(seq_osszetevo.nextval,'csipetke',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')); --28
(seq_osszetevo.nextval,'sertéstarja',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')); --29
(seq_osszetevo.nextval,'sertéscsülök',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')); --30
(seq_osszetevo.nextval,'petrezselyem',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')); --31
(seq_osszetevo.nextval,'fűszerpaprika',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')); --32

INSERT INTO Mennyiseg(id,nev,datum)
VALUES
(seq_mennyiseg.nextval,'db',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --1
(seq_mennyiseg.nextval,'gramm',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')), --2
(seq_mennyiseg.nextval,'ml',to_date(sysdate,'yyyy/mm/dd hh24:mi:ss')); --3

INSERT INTO Kozponti(recept_id,osszetevo_id,mennyiseg,mennyiseg_id)
VALUES
(1,1,8,1),
(1,7,150,2),
(1,8,4,1),
(1,9,300,2),
(1,4,7,2),
(1,3,400,3), --eddig az első recept
(2,10,400,2),
(2,8,4,1),
(2,7,20,2),
(2,4,2,2),
(2,11,2,2),
(2,3,100,3),
(2,12,1000,2),
(2,3,500,3), --eddig a második recept
(3,12,1000,2),
(3,8,8,1),
(3,14,100,2),
(3,16,20,2),
(3,17,100,2), --eddig a harmadik recept
(4,20,500,2),
(4,18,200,2),
(4,19,150,2),
(4,21,50,2), --eddig a negyedik recept
(5,25,2,1),
(5,26,4,1),
(5,29,600,2),
(5,30,300,2),
(5,23,3,1),
(5,31,3,1),
(5,27,2,1),
(5,22,500,2),
(5,24,10,1),
(5,32,2,1),
(5,4,2,2),
(5,3,100,3); --eddig az ötödik recept
