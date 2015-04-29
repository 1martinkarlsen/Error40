DROP TABLE dell_users CASCADE CONSTRAINTS PURGE;
DROP TABLE dell_admin CASCADE CONSTRAINTS PURGE;
DROP TABLE dell_seller CASCADE CONSTRAINTS PURGE;
DROP TABLE dell_partner CASCADE CONSTRAINTS PURGE;
DROP TABLE dell_budget CASCADE CONSTRAINTS PURGE;
DROP TABLE dell_campaigns CASCADE CONSTRAINTS PURGE;
DROP TABLE dell_files CASCADE CONSTRAINTS PURGE;
DROP SEQUENCE seq_campaigns;
DROP SEQUENCE seq_POE;
DROP SEQUENCE seq_budget;


/* User table */
/* 
    1. Rank = status of user.
        - 1 = Partner         
        - 2 = Seller
        - 3 = Admin


*/
CREATE TABLE dell_users (
    id NUMBER NOT NULL,
    rank NUMBER NOT NULL,
    username varchar2(255) NOT NULL,
    password varchar2(255) NOT NULL,
    firstname varchar2(255) NOT NULL,
    lastname varchar2(255) NOT NULL,
        CONSTRAINT users_pk PRIMARY KEY(id),
        CONSTRAINT dell_users_unique UNIQUE(username)
);

CREATE TABLE dell_admin (
    id NUMBER NOT NULL,
    userID NUMBER NOT NULL,
    budgetID NUMBER NOT NULL,
       CONSTRAINT adminUsers_pk PRIMARY KEY(id)
);

CREATE TABLE dell_seller (
    id NUMBER NOT NULL,
    userID NUMBER NOT NULL,
    budgetID NUMBER NOT NULL,
        CONSTRAINT sellerUsers_pk PRIMARY KEY(id)

);

CREATE TABLE dell_partner (
    id NUMBER NOT NULL,
    phoneNr varchar2(36) NOT NULL,
    email varchar2(255) NOT NULL,
    ShopName varchar2(255) NOT NULL,
    address varchar2(255) NOT NULL,
    userID NUMBER NOT NULL,
        CONSTRAINT partnerUsers_pk PRIMARY KEY(id)
);

/* Budget table */
CREATE TABLE dell_budget (
    id NUMBER NOT NULL,
    value NUMBER NOT NULL,
        CONSTRAINT budget_pk PRIMARY KEY(id)
);


/* table */
CREATE TABLE dell_campaigns (
    id NUMBER NOT NULL,
    name VARCHAR2(255) NOT NULL,
    stepNumber NUMBER NOT NULL,
    description VARCHAR2(255) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    target VARCHAR2(25) NOT NULL,
    objectives VARCHAR2(25) NOT NULL,

    approve_seller_project NUMBER NOT NULL,
    approve_partner_project NUMBER NOT NULL,
    approve_seller_POE NUMBER NOT NULL,

    partnerID NUMBER NOT NULL,
    sellerID NUMBER NOT NULL,
    budgetID NUMBER NOT NULL,
        CONSTRAINT dell_campaigns_pk PRIMARY KEY(id)   
);

/* POE (Prove of execution) */
CREATE TABLE dell_files (
    id NUMBER NOT NULL,
    name VARCHAR2(255),
    poe_url VARCHAR2(255),
    campaignID NUMBER NOT NULL,
        CONSTRAINT dell_POE_pk PRIMARY KEY(id)
        
);



INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('1','3','admin','admin','Claus','Jensen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('2','3','admin2','admin2','Jens','Hansen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('3','2','oh3','pwoh3','Ole','Hald');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('4','2','vh4','pwvh4','Vera','Hedegaard');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('5','2','bh5','pwbh5','Bente','Hemmingsen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('6','2','kh6','pwkh6','Kirsten','Henriksen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('7','2','mh7','pwmh7','Morten','Hermansen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('8','2','ah8','pwah8','Allan','Hjorth');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('9','1','sh9','pwsh9','Søren','Hoffmann');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('10','1','nh10','pwnh10','Naomi','Holm');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('11','1','jh11','pwjh11','Jytte','Holst');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('12','1','bh12','pwbh12','Birthe','Hougård');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('13','1','ni13','pwni13','Nikolaj','Ibsen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('14','1','mi14','pwmi14','Mads','Iversen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('15','1','tj15','pwtj15','Trine','Jacobsen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('16','1','gj16','pwgj16','Georg','Jeppesen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('17','1','am17','pwam17','Adam','Meyer');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('18','1','km18','pwkm18','Knud','Mikkelsen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('19','1','jm19','pwjm19','Jane','Mortensen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('20','1','pm20','pwpm20','Pia','Mølgård');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('21','1','ps21','pwps21','Pernille','Svendsen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('22','1','en22','pwen22','Emanuel','Nielsen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('23','1','an23','pwan23','Anders','Nikolajsen');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('24','1','tn24','pwtn24','Troels','Nygaard');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('25','1','an25','pwan25','Asger','Nørgård');
INSERT INTO dell_users (id,rank,username,password,firstname,lastname) VALUES('26','1','hs26','pwhs26','Henrik','Simonsen');

INSERT INTO dell_admin(id,userID,budgetID) VALUES('1','3','1');
INSERT INTO dell_admin(id,userID,budgetID) VALUES('2','3','1');

INSERT INTO dell_seller(id,userID,budgetID) VALUES('1','3','2');
INSERT INTO dell_seller(id,userID,budgetID) VALUES('2','4','3');
INSERT INTO dell_seller(id,userID,budgetID) VALUES('3','5','4');
INSERT INTO dell_seller(id,userID,budgetID) VALUES('4','6','5');
INSERT INTO dell_seller(id,userID,budgetID) VALUES('5','7','6');
INSERT INTO dell_seller(id,userID,budgetID) VALUES('6','8','7');

INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('1','23232323','hhf@elgiganten.dk','Elgiganten','Tårnvej 23, 2600 Glostrup','9');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('2','24242424','gw@ber.dk','Fona','Bredgade 23, 3220 Haslev','10');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('3','25252525','te@computercity.dk','ComputerCity','Refsvej 9, Give','11');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('4','26262626','ah@computercity.dk','ComputerCity','Kongens Alle 101, 9000 Aalborg','12');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('5','27272727','pu@elgiganten.dk','Elgiganten','Omfartsvej 3, 3700 Rønne','13');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('6','28282828','4rt@elgiganten.dk','Elgiganten','Elmealle 9, 4000 Roskilde','14');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('7','29292929','xn@ber.dk','Fona','Askevej 87, 3800 Helsingør','15');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('8','30303030','crr@ber.dk','Fona','Polensgade 23, 5000 Odense','16');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('9','31313131','as@fisketorvet.dk','Fisketorvet','Havnen 3, 2400 København S','17');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('10','32323232','rrr@daells.dk','Expert','Rødovre Centeret, 2630 Rødovre','18');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('11','33333333','ljy@imerco.dk','Imerco','Amagercenteret, 2300 København S','19');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('12','34343434','arg@imerco.dk','Imerco','Amagerbrogade 320, København S','20');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('13','35353535','bng@martindatastore.dk','Martin Data Store','Isfjeldet 1, Nuuk Grønland','21');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('14','36363636','sry@simonhardwarestore.dk','Simons Hardware Store','Grindevej 1, 900 Torshavn Færøerne','22');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('15','37373737','set@kasperhightech.dk','Kaspers HighTech','Granitvej 1, 3760 Christiansø','23');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('16','38383838','pio@rasmusworldwide.dk','Rasmus World Wide','Sælvej 1, 7060 Læsø','24');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('17','39393939','rew@elgiganten.dk','Elgiganten','Rudolfsvej 5, 5000 Odense','25');
INSERT INTO dell_partner(id,phoneNr,email,ShopName,address,userID) VALUES('18','40404040','qwe@elgiganten.dk','Elgiganten','Valby Langgade 201, 2900 Valby','26');


INSERT INTO dell_budget(id,value) VALUES('1','300000');
INSERT INTO dell_budget(id,value) VALUES('2','30000');
INSERT INTO dell_budget(id,value) VALUES('3','25000');
INSERT INTO dell_budget(id,value) VALUES('4','70000');
INSERT INTO dell_budget(id,value) VALUES('5','45000');
INSERT INTO dell_budget(id,value) VALUES('6','35000');
INSERT INTO dell_budget(id,value) VALUES('7','45000');
INSERT INTO dell_budget(id,value) VALUES('8','3000');
INSERT INTO dell_budget(id,value) VALUES('9','4000');
INSERT INTO dell_budget(id,value) VALUES('10','3000');
INSERT INTO dell_budget(id,value) VALUES('11','2500');
INSERT INTO dell_budget(id,value) VALUES('12','4000');
INSERT INTO dell_budget(id,value) VALUES('13','3000');
INSERT INTO dell_budget(id,value) VALUES('14','1000');
INSERT INTO dell_budget(id,value) VALUES('15','1500');
INSERT INTO dell_budget(id,value) VALUES('16','3000');
INSERT INTO dell_budget(id,value) VALUES('17','4000');
INSERT INTO dell_budget(id,value) VALUES('18','6000');
INSERT INTO dell_budget(id,value) VALUES('19','7500');
INSERT INTO dell_budget(id,value) VALUES('20','4500');
INSERT INTO dell_budget(id,value) VALUES('21','2000');
INSERT INTO dell_budget(id,value) VALUES('22','2000');
INSERT INTO dell_budget(id,value) VALUES('23','2500');
INSERT INTO dell_budget(id,value) VALUES('24','3000');
INSERT INTO dell_budget(id,value) VALUES('25','1500');
INSERT INTO dell_budget(id,value) VALUES('26','500');
INSERT INTO dell_budget(id,value) VALUES('27','750');
INSERT INTO dell_budget(id,value) VALUES('28','200');
INSERT INTO dell_budget(id,value) VALUES('29','6000');
INSERT INTO dell_budget(id,value) VALUES('30','1000');
INSERT INTO dell_budget(id,value) VALUES('31','1200');
INSERT INTO dell_budget(id,value) VALUES('32','1200');
INSERT INTO dell_budget(id,value) VALUES('33','1250');
INSERT INTO dell_budget(id,value) VALUES('34','400');
INSERT INTO dell_budget(id,value) VALUES('35','850');
INSERT INTO dell_budget(id,value) VALUES('36','950');
INSERT INTO dell_budget(id,value) VALUES('37','750');
INSERT INTO dell_budget(id,value) VALUES('38','750');
INSERT INTO dell_budget(id,value) VALUES('39','1200');
INSERT INTO dell_budget(id,value) VALUES('40','300');
INSERT INTO dell_budget(id,value) VALUES('41','600');
INSERT INTO dell_budget(id,value) VALUES('42','990');
INSERT INTO dell_budget(id,value) VALUES('43','750');
INSERT INTO dell_budget(id,value) VALUES('44','1750');
INSERT INTO dell_budget(id,value) VALUES('45','2500');
INSERT INTO dell_budget(id,value) VALUES('46','2150');
INSERT INTO dell_budget(id,value) VALUES('47','300');
INSERT INTO dell_budget(id,value) VALUES('48','950');
INSERT INTO dell_budget(id,value) VALUES('49','2000');
INSERT INTO dell_budget(id,value) VALUES('50','3000');
INSERT INTO dell_budget(id,value) VALUES('51','1000');
INSERT INTO dell_budget(id,value) VALUES('52','900');
INSERT INTO dell_budget(id,value) VALUES('53','400');
INSERT INTO dell_budget(id,value) VALUES('54','400');
INSERT INTO dell_budget(id,value) VALUES('55','1250');
INSERT INTO dell_budget(id,value) VALUES('56','1600');
INSERT INTO dell_budget(id,value) VALUES('57','1800');
INSERT INTO dell_budget(id,value) VALUES('58','1900');
INSERT INTO dell_budget(id,value) VALUES('59','2000');
INSERT INTO dell_budget(id,value) VALUES('60','2100');
INSERT INTO dell_budget(id,value) VALUES('61','1400');
INSERT INTO dell_budget(id,value) VALUES('62','1450');
INSERT INTO dell_budget(id,value) VALUES('63','1550');
INSERT INTO dell_budget(id,value) VALUES('64','1650');
INSERT INTO dell_budget(id,value) VALUES('65','1750');
INSERT INTO dell_budget(id,value) VALUES('66','1850');
INSERT INTO dell_budget(id,value) VALUES('67','1950');
INSERT INTO dell_budget(id,value) VALUES('68','2050');
INSERT INTO dell_budget(id,value) VALUES('69','2150');
INSERT INTO dell_budget(id,value) VALUES('70','2250');
INSERT INTO dell_budget(id,value) VALUES('71','2350');
INSERT INTO dell_budget(id,value) VALUES('72','2450');
INSERT INTO dell_budget(id,value) VALUES('73','2550');
INSERT INTO dell_budget(id,value) VALUES('74','2650');
INSERT INTO dell_budget(id,value) VALUES('75','2750');
INSERT INTO dell_budget(id,value) VALUES('76','2850');
INSERT INTO dell_budget(id,value) VALUES('77','2950');

INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('1','Reklame 1','1','Reklame 1 i maj måned',To_Date('10-04-15','DD-MM-YY'),To_Date('12-04-15','DD-MM-YY'),'voksen','sale','0','0','0','9','3','8');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('2','Reklame 2','1','Reklame 1 i maj måned',To_Date('10-04-15','DD-MM-YY'),To_Date('12-04-15','DD-MM-YY'),'voksen','sale','0','0','0','10','3','9');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('3','Reklame 3','2','Reklame 1 i maj måned',To_Date('10-04-15','DD-MM-YY'),To_Date('12-04-15','DD-MM-YY'),'voksen','sale','0','0','0','11','3','10');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('4','Reklame 4','2','Reklame 1 i maj måned',To_Date('10-04-15','DD-MM-YY'),To_Date('12-04-15','DD-MM-YY'),'voksen','sale','0','0','0','12','4','11');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('5','Reklame 5','3','Reklame 1 i maj måned',To_Date('10-04-15','DD-MM-YY'),To_Date('12-04-15','DD-MM-YY'),'voksen','sale','1','0','1','13','4','12');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('6','Reklame 6','3','Reklame 1 i maj måned',To_Date('10-04-15','DD-MM-YY'),To_Date('12-04-15','DD-MM-YY'),'voksen','sale','1','0','1','14','4','13');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('7','Ceron computer fremstød 1','1','Ceron reklame i juli måned',To_Date('20-05-15','DD-MM-YY'),To_Date('26-05-15','DD-MM-YY'),'teenager','sale','0','0','0','11','3','14');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('8','Ceron computer fremstød 2','1','Ceron reklame i juli måned',To_Date('20-05-15','DD-MM-YY'),To_Date('26-05-15','DD-MM-YY'),'teenager','sale','0','0','0','12','4','15');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('9','Ceron computer fremstød 3','1','Ceron reklame i juli måned',To_Date('20-05-15','DD-MM-YY'),To_Date('26-05-15','DD-MM-YY'),'teenager','sale','0','0','0','13','4','16');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('10','Ceron computer fremstød 4','1','Ceron reklame i juli måned',To_Date('20-05-15','DD-MM-YY'),To_Date('26-05-15','DD-MM-YY'),'teenager','sale','1','0','1','14','4','17');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('11','Ceron computer fremstød 5','2','Ceron reklame i juli måned',To_Date('20-05-15','DD-MM-YY'),To_Date('26-05-15','DD-MM-YY'),'teenager','sale','1','0','1','9','3','18');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('12','Ceron computer fremstød 6','2','Ceron reklame i juli måned',To_Date('20-05-15','DD-MM-YY'),To_Date('26-05-15','DD-MM-YY'),'teenager','sale','1','0','1','15','5','19');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('13','Ceron computer fremstød 7','2','Ceron reklame i juli måned',To_Date('20-05-15','DD-MM-YY'),To_Date('26-05-15','DD-MM-YY'),'teenager','sale','1','1','1','16','5','20');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('14','Ceron computer fremstød 8','2','Ceron reklame i juli måned',To_Date('20-05-15','DD-MM-YY'),To_Date('26-05-15','DD-MM-YY'),'teenager','sale','1','1','1','17','5','21');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('15','Ceron computer fremstød 9','2','Ceron reklame i juli måned',To_Date('20-05-15','DD-MM-YY'),To_Date('26-05-15','DD-MM-YY'),'teenager','sale','1','1','1','18','6','22');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('16','Ceron computer fremstød 10','3','Ceron reklame i juli måned',To_Date('20-05-15','DD-MM-YY'),To_Date('26-05-15','DD-MM-YY'),'teenager','sale','1','1','1','19','6','23');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('17','Ceron computer fremstød 11','3','Ceron reklame i juli måned',To_Date('20-05-15','DD-MM-YY'),To_Date('26-05-15','DD-MM-YY'),'teenager','sale','1','1','1','10','3','24');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('18','Ceron computer fremstød 12','3','Ceron reklame i juli måned',To_Date('20-05-15','DD-MM-YY'),To_Date('26-05-15','DD-MM-YY'),'teenager','sale','1','1','1','20','6','25');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('19','Ny bærbar reklame 1','1','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','0','0','0','21','7','26');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('20','Ny bærbar reklame 2','1','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','0','0','0','22','7','27');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('21','Ny bærbar reklame 3','1','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','0','0','0','10','3','28');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('22','Ny bærbar reklame 4','1','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','0','0','0','23','7','29');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('23','Ny bærbar reklame 5','1','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','0','1','24','8','30');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('24','Ny bærbar reklame 6','2','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','0','1','25','8','31');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('25','Ny bærbar reklame 7','2','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','0','1','26','8','32');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('26','Ny bærbar reklame 8','2','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','0','1','11','3','33');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('27','Ny bærbar reklame 9','2','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','1','1','12','4','34');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('28','Ny bærbar reklame 10','2','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','1','1','13','4','35');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('29','Ny bærbar reklame 11','2','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','1','1','14','4','36');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('30','Ny bærbar reklame 12','3','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','1','1','15','5','37');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('31','Ny bærbar reklame 13','3','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','1','1','9','3','38');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('32','Ny bærbar reklame 14','3','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','1','1','16','5','39');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('33','Ny bærbar reklame 15','3','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','1','1','17','5','40');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('34','Ny bærbar reklame 16','3','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','1','1','18','6','41');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('35','Ny bærbar reklame 17','3','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','1','1','19','6','42');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('36','Ny bærbar reklame 18','3','Ny bærbar reklame i august måned',To_Date('03-06-15','DD-MM-YY'),To_Date('08-06-15','DD-MM-YY'),'voksen','sale','1','1','1','20','6','43');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('37','Studiestart 1','1','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','0','0','0','21','7','44');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('38','Studiestart 2','1','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','0','0','0','22','7','45');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('39','Studiestart 3','1','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','0','0','0','10','3','46');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('40','Studiestart 4','1','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','0','0','0','23','7','47');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('41','Studiestart 5','2','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','0','0','0','24','8','48');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('42','Studiestart 6','2','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','1','0','1','25','8','49');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('43','Studiestart 7','2','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','1','0','1','26','8','50');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('44','Studiestart 8','2','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','1','0','1','11','3','51');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('45','Studiestart 9','2','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','1','0','1','12','4','52');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('46','Studiestart 10','2','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','1','1','1','13','4','53');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('47','Studiestart 11','2','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','1','1','1','14','4','54');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('48','Studiestart 12','3','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','1','1','1','15','5','55');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('49','Studiestart 13','3','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','1','1','1','16','5','56');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('50','Studiestart 14','3','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','1','1','1','9','3','57');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('51','Studiestart 15','3','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','1','1','1','17','5','58');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('52','Studiestart 16','3','Studiestart reklame i januar måned',To_Date('12-06-15','DD-MM-YY'),To_Date('20-06-15','DD-MM-YY'),'studerende','sale','1','1','1','18','6','59');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('53','On the spot reklame 1','1','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','0','0','0','19','6','60');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('54','On the spot reklame 2','1','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','0','0','0','20','6','61');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('55','On the spot reklame 3','1','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','0','0','0','21','7','62');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('56','On the spot reklame 4','1','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','0','0','0','22','7','63');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('57','On the spot reklame 5','1','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','0','1','23','7','64');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('58','On the spot reklame 6','1','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','0','1','24','8','65');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('59','On the spot reklame 7','2','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','0','1','25','8','66');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('60','On the spot reklame 8','2','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','0','1','26','8','67');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('61','On the spot reklame 9','2','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','1','1','9','3','68');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('62','On the spot reklame 10','2','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','1','1','11','3','69');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('63','On the spot reklame 11','2','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','1','1','12','4','70');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('64','On the spot reklame 12','2','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','1','1','13','4','71');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('65','On the spot reklame 13','3','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','1','1','14','4','72');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('66','On the spot reklame 14','3','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','1','1','10','3','73');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('67','On the spot reklame 15','3','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','1','1','15','5','74');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('68','On the spot reklame 16','3','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','1','1','16','5','75');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('69','On the spot reklame 17','3','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','1','1','17','5','76');
INSERT INTO dell_campaigns(id,name,stepNumber,description,start_date,end_date,target,objectives,approve_seller_project,approve_partner_project,approve_seller_POE,partnerID,sellerID,budgetID) VALUES('70','On the spot reklame 18','3','Julegave fremstød i december måned',To_Date('22-06-15','DD-MM-YY'),To_Date('26-06-15','DD-MM-YY'),'voksen','sale','1','1','1','18','6','77');


INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('1','Fil desc: Reklame 1','POE URL: Reklame 1','1');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('2','Fil desc: Reklame 2','POE URL: Reklame 2','2');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('3','Fil desc: Reklame 3','POE URL: Reklame 3','3');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('4','Fil desc: Reklame 4','POE URL: Reklame 4','4');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('5','Fil desc: Reklame 5','POE URL: Reklame 5','5');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('6','Fil desc: Reklame 6','POE URL: Reklame 6','6');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('7','Fil desc: Ceron computer fremstød 1','POE URL: Ceron computer fremstød 1','7');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('8','Fil desc: Ceron computer fremstød 2','POE URL: Ceron computer fremstød 2','8');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('9','Fil desc: Ceron computer fremstød 3','POE URL: Ceron computer fremstød 3','9');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('10','Fil desc: Ceron computer fremstød 4','POE URL: Ceron computer fremstød 4','10');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('11','Fil desc: Ceron computer fremstød 5','POE URL: Ceron computer fremstød 5','11');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('12','Fil desc: Ceron computer fremstød 6','POE URL: Ceron computer fremstød 6','12');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('13','Fil desc: Ceron computer fremstød 7','POE URL: Ceron computer fremstød 7','13');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('14','Fil desc: Ceron computer fremstød 8','POE URL: Ceron computer fremstød 8','14');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('15','Fil desc: Ceron computer fremstød 9','POE URL: Ceron computer fremstød 9','15');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('16','Fil desc: Ceron computer fremstød 10','POE URL: Ceron computer fremstød 10','16');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('17','Fil desc: Ceron computer fremstød 11','POE URL: Ceron computer fremstød 11','17');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('18','Fil desc: Ceron computer fremstød 12','POE URL: Ceron computer fremstød 12','18');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('19','Fil desc: Ny bærbar reklame 1','POE URL: Ny bærbar reklame 1','19');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('20','Fil desc: Ny bærbar reklame 2','POE URL: Ny bærbar reklame 2','20');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('21','Fil desc: Ny bærbar reklame 3','POE URL: Ny bærbar reklame 3','21');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('22','Fil desc: Ny bærbar reklame 4','POE URL: Ny bærbar reklame 4','22');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('23','Fil desc: Ny bærbar reklame 5','POE URL: Ny bærbar reklame 5','23');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('24','Fil desc: Ny bærbar reklame 6','POE URL: Ny bærbar reklame 6','24');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('25','Fil desc: Ny bærbar reklame 7','POE URL: Ny bærbar reklame 7','25');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('26','Fil desc: Ny bærbar reklame 8','POE URL: Ny bærbar reklame 8','26');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('27','Fil desc: Ny bærbar reklame 9','POE URL: Ny bærbar reklame 9','27');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('28','Fil desc: Ny bærbar reklame 10','POE URL: Ny bærbar reklame 10','28');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('29','Fil desc: Ny bærbar reklame 11','POE URL: Ny bærbar reklame 11','29');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('30','Fil desc: Ny bærbar reklame 12','POE URL: Ny bærbar reklame 12','30');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('31','Fil desc: Ny bærbar reklame 13','POE URL: Ny bærbar reklame 13','31');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('32','Fil desc: Ny bærbar reklame 14','POE URL: Ny bærbar reklame 14','32');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('33','Fil desc: Ny bærbar reklame 15','POE URL: Ny bærbar reklame 15','33');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('34','Fil desc: Ny bærbar reklame 16','POE URL: Ny bærbar reklame 16','34');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('35','Fil desc: Ny bærbar reklame 17','POE URL: Ny bærbar reklame 17','35');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('36','Fil desc: Ny bærbar reklame 18','POE URL: Ny bærbar reklame 18','36');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('37','Fil desc: Studiestart 1','POE URL: Studiestart 1','37');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('38','Fil desc: Studiestart 2','POE URL: Studiestart 2','38');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('39','Fil desc: Studiestart 3','POE URL: Studiestart 3','39');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('40','Fil desc: Studiestart 4','POE URL: Studiestart 4','40');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('41','Fil desc: Studiestart 5','POE URL: Studiestart 5','41');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('42','Fil desc: Studiestart 6','POE URL: Studiestart 6','42');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('43','Fil desc: Studiestart 7','POE URL: Studiestart 7','43');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('44','Fil desc: Studiestart 8','POE URL: Studiestart 8','44');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('45','Fil desc: Studiestart 9','POE URL: Studiestart 9','45');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('46','Fil desc: Studiestart 10','POE URL: Studiestart 10','46');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('47','Fil desc: Studiestart 11','POE URL: Studiestart 11','47');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('48','Fil desc: Studiestart 12','POE URL: Studiestart 12','48');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('49','Fil desc: Studiestart 13','POE URL: Studiestart 13','49');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('50','Fil desc: Studiestart 14','POE URL: Studiestart 14','50');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('51','Fil desc: Studiestart 15','POE URL: Studiestart 15','51');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('52','Fil desc: Studiestart 16','POE URL: Studiestart 16','52');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('53','Fil desc: On the spot reklame 1','POE URL: On the spot reklame 1','53');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('54','Fil desc: On the spot reklame 2','POE URL: On the spot reklame 2','54');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('55','Fil desc: On the spot reklame 3','POE URL: On the spot reklame 3','55');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('56','Fil desc: On the spot reklame 4','POE URL: On the spot reklame 4','56');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('57','Fil desc: On the spot reklame 5','POE URL: On the spot reklame 5','57');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('58','Fil desc: On the spot reklame 6','POE URL: On the spot reklame 6','58');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('59','Fil desc: On the spot reklame 7','POE URL: On the spot reklame 7','59');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('60','Fil desc: On the spot reklame 8','POE URL: On the spot reklame 8','60');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('61','Fil desc: On the spot reklame 9','POE URL: On the spot reklame 9','61');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('62','Fil desc: On the spot reklame 10','POE URL: On the spot reklame 10','62');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('63','Fil desc: On the spot reklame 11','POE URL: On the spot reklame 11','63');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('64','Fil desc: On the spot reklame 12','POE URL: On the spot reklame 12','64');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('65','Fil desc: On the spot reklame 13','POE URL: On the spot reklame 13','65');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('66','Fil desc: On the spot reklame 14','POE URL: On the spot reklame 14','66');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('67','Fil desc: On the spot reklame 15','POE URL: On the spot reklame 15','67');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('68','Fil desc: On the spot reklame 16','POE URL: On the spot reklame 16','68');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('69','Fil desc: On the spot reklame 17','POE URL: On the spot reklame 17','69');
INSERT INTO dell_files(id,name,poe_url,campaignID) VALUES('70','Fil desc: On the spot reklame 18','POE URL: On the spot reklame 18','70');





ALTER TABLE dell_campaigns
    ADD CONSTRAINT dell_campaigns_fk_partner FOREIGN KEY(partnerID)
        REFERENCES dell_users(id)
    ADD CONSTRAINT dell_campaigns_fk_seller FOREIGN KEY(sellerID)
        REFERENCES dell_users(id)
    ADD CONSTRAINT dell_campaigns_fk_budgetID FOREIGN KEY(budgetID)
        REFERENCES dell_budget(id);
-- 
ALTER TABLE dell_files
    ADD CONSTRAINT dell_files_fk FOREIGN KEY(campaignID)
        REFERENCES dell_campaigns(id);

ALTER TABLE dell_admin
    ADD CONSTRAINT dell_admin_uID_fk FOREIGN KEY(userID)
        REFERENCES dell_users(id)
    ADD CONSTRAINT dell_admin_budgetID_fk FOREIGN KEY(budgetID)
        REFERENCES dell_budget(id);

ALTER TABLE dell_seller
    ADD CONSTRAINT dell_seller_uID_fk FOREIGN KEY(userID)
        REFERENCES dell_users(id)
    ADD CONSTRAINT dell_seller_budgetID_fk FOREIGN KEY(budgetID)
        REFERENCES dell_budget(id);

ALTER TABLE dell_partner
    ADD CONSTRAINT dell_partner_uID_fk FOREIGN KEY(userID)
        REFERENCES dell_users(id);
    

/* Sequences */
CREATE SEQUENCE seq_campaigns /* For campaigns */
    MINVALUE 1
    START WITH 102
    INCREMENT BY 1
    CACHE 1000;

CREATE SEQUENCE seq_POE /* For POE */
    MINVALUE 1
    START WITH 102
    INCREMENT BY 1
    CACHE 1000;

CREATE SEQUENCE seq_budget /* For budget */
    MINVALUE 1
    START WITH 102
    INCREMENT BY 1
    CACHE 1000;