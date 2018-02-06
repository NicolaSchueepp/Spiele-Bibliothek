create database spieleBibliothek;
use spieleBibliothek;
SET foreign_key_checks = 0;

create table game (
id int auto_increment not null,
bezeichnung varchar(80) not null,
hersteller varchar(45) not null,
preis float not null,
erscheinungsjahr int not null,
genre varchar(45) not null,
beschreibung text not null,
cover varchar(85),
primary key(ID)
);

create table benutzer (
id int auto_increment not null,
benutzername varchar(45) not null,
passwort varchar(45) not null,
email varchar(80) not null,
primary key(ID)
);

create table spieleliste (
benutzer_ID int not null,
game_ID int not null,
Foreign Key(benutzer_ID) references benutzer(ID),
foreign key(game_ID) references game(ID)
);

create table bewertung (
game_ID int not null,
benutzer_ID int not null,
bewertung int not null,
foreign key(game_ID) references game(ID),
foreign key(benutzer_ID) references benutzer(ID)
);

LOAD DATA LOCAL INFILE 'D:\\Game.csv'
INTO TABLE game
CHARACTER SET utf8
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS (Bezeichnung, Hersteller, Preis, Erscheinungsjahr, Genre, Beschreibung);

insert into benutzer
(Benutzername, Passwort, Email)
Values('Admin', '1234', 'admin@help.bbcag');

Explain benutzer;

Select * from Game;
Select * from benutzer;