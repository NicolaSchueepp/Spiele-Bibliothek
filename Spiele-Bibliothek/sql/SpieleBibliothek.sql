create database spieleBibliothek;
use spieleBibliothek;
SET foreign_key_checks = 0;

create table Game (
ID int auto_increment not null,
Bezeichnung varchar(80) not null,
Hersteller varchar(45) not null,
Preis float not null,
Erscheinungsjahr int not null,
Genre varchar(45) not null,
Beschreibung text not null,
Cover varchar(85),
primary key(ID)
);

create table Benutzer (
ID int auto_increment not null,
Benutzername varchar(45) not null,
Passwort varchar(45) not null,
Email float not null,
primary key(ID)
);

create table Spieleliste (
Benutzer_ID int not null,
Game_ID int not null,
Foreign Key(Benutzer_ID) references Benutzer(ID),
foreign key(Game_ID) references Game(ID)
);

create table Bewertung (
Game_ID int not null,
Benutzer_ID int not null,
Bewertung int not null,
foreign key(Game_ID) references Game(ID),
foreign key(Benutzer_ID) references Benutzer(ID)
);

LOAD DATA LOCAL INFILE 'D:\\Game.csv'
INTO TABLE game
CHARACTER SET utf8
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS (Bezeichnung, Hersteller, Preis, Erscheinungsjahr, Genre, Beschreibung);


Select * from Game;