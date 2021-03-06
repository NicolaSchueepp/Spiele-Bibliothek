-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: spielebibliothek
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `benutzer`
--

DROP TABLE IF EXISTS `benutzer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `benutzer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Benutzername` varchar(45) NOT NULL,
  `Passwort` varchar(45) NOT NULL,
  `Email` varchar(80) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benutzer`
--

LOCK TABLES `benutzer` WRITE;
/*!40000 ALTER TABLE `benutzer` DISABLE KEYS */;
INSERT INTO `benutzer` VALUES (1,'Admin','1234','admin@help.bbcag');
/*!40000 ALTER TABLE `benutzer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bewertung`
--

DROP TABLE IF EXISTS `bewertung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bewertung` (
  `Game_ID` int(11) NOT NULL,
  `Benutzer_ID` int(11) NOT NULL,
  `Bewertung` int(11) NOT NULL,
  KEY `Game_ID` (`Game_ID`),
  KEY `Benutzer_ID` (`Benutzer_ID`),
  CONSTRAINT `bewertung_ibfk_1` FOREIGN KEY (`Game_ID`) REFERENCES `game` (`ID`),
  CONSTRAINT `bewertung_ibfk_2` FOREIGN KEY (`Benutzer_ID`) REFERENCES `benutzer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bewertung`
--

LOCK TABLES `bewertung` WRITE;
/*!40000 ALTER TABLE `bewertung` DISABLE KEYS */;
INSERT INTO `bewertung` VALUES (22,23,5),(24,1,4),(19,1,0);
/*!40000 ALTER TABLE `bewertung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(80) NOT NULL,
  `Hersteller` varchar(45) NOT NULL,
  `Preis` float NOT NULL,
  `Erscheinungsjahr` int(11) NOT NULL,
  `Genre` varchar(45) NOT NULL,
  `Beschreibung` text NOT NULL,
  `Cover` varchar(85) DEFAULT NULL,
  `Video` varchar(85) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'Fifa 18','Electronic Arts',59.9,2017,'Sport','Die FIFA 18 – Legacy Edition bietet großartiges Gameplay, tolle Spielmodi und Features mit beeindruckender Authentizität. Dabei sind die gleichen Innovationen wie bei FIFA 17 enthalten. Zudem dürfen Sie sich auf eine überarbeitete Gestaltung des Spielmenüs freuen und Sie erhalten aktualisierte Teamtrikots und Teamkader – damit Sie weiterhin auf PlayStation 3 und Xbox 360 spielen können. Erleben Sie jetzt ein packendes und unvergessliches Fußballspiel mit Ihren Superstars!','fifa18.jpg',''),(2,'Monster Hunter: World','Capcom',63,2018,'Rollenspiel','Monster Hunter: World, der jüngste Teil der hochgelobten Action-RPG-Serie mit über 40 Millionen verkauften Einheiten, bietet ein lebendiges, atmendes Ökosystem, in dem Spieler in die Rolle von Jägern schlüpfen, die grausame Kreaturen aufspüren und in Atem beraubenden Kämpfen zur Strecke bringen. Spieler ziehen allein oder mit bis zu drei weiteren Huntern in ihre Abenteuer. Dabei kommt ein neu entworfenes Drop-In-Multiplayersystem zum Tragen, das koopperatives Spielen über Regionsgrenzen hinweg zwischen Japan und dem Westen ermöglicht, und so erstmals die weltweite Spielergemeinschaft vereint. Monster Hunter: World schickt Spieler in Questen, in denen sie Furcht einflößende Monster bekämpfen und während des Spielens ständig ihre Jägerfähigkeiten verbessern. Loot, das Spieler aus besiegten Kreaturen erhalten, können sie nutzen, um neue Ausrüstung und Rüstungsverbesserungen zu fertigen. Spieler bewegen sich nahtlos durch die Kartenareale der lebendigen Spielwelt. Landschaft und Bewohner spielen eine wichtige Rolle für die Strategien der Spieler auf ihrem Weg zum ultimativen Hunter.','monsterHunterWorld.jpg',''),(3,'Grand Theft Auto V','Rockstar',22.92,2013,'Action','Als ein junger Straßengauner, ein ehemaliger Bankräuber und ein beängstigender Psychopath sich mit einigen der furchteinflößendsten und durchgeknalltesten Gestalten der Unterwelt, der US-Regierung und der Unterhaltungsindustrie einlassen, müssen sie eine Reihe von gefährlichen Überfällen durchziehen, um in einer skrupellosen Stadt zu überleben, in der sie niemandem vertrauen können – und am allerwenigsten einander.','grandTheftAutoV.jpg',''),(4,'Call of Duty: WWII','Activision',48.21,2017,'Action','Call of Duty: WWII führt die Serie zu ihren Wurzeln zurück in einem kinoreifen Erlebnis, das den unvergesslichen Heldenmut der Soldaten einfängt, die gemeinsam in einem Krieg kämpften, der die Welt für immer verändert hat. Dieser packende neue Titel von Activision ist ein ehrliches Portrait des Zweiten Weltkriegs, erzählt aus der Perspektive der legendären 1. US-Infanteriedivision und mit einem Ensemble aus vielseitigen Charakteren aus aller Welt. Dank beeindruckender Grafik und intensiver Klangkulisse können die Spieler die Strände der Normandie am D-Day stürmen, durch Frankreich marschieren, um Paris zu befreien, und letztendlich in Deutschland in einer der monumentalsten Schlachten aller Zeiten eindringen.','callOfDutyWWII.jpg',''),(5,'Assassin\'s Creed Origins','Ubisoft',44.09,2017,'Adventure','Das alte Ägypten, der wohl geheimnisvollste Ort der Geschichte und eine Epoche, die das Antlitz der Welt verändern sollte. Der Spieler entdeckt die Geheimnisse hinter den Pyramiden, den vergessenen Mythen, den letzten Pharaonen. Er erfährt die Ursprungsgeschichte der Assassinen-Bruderschaft, geschrieben in längst verschollenen Hieroglyphen. In den letzten vier Jahren hat das Team, das sich auch für das hochgelobte Assassin\'s Creed 4 Black Flag verantwortlich zeichnet, an einem Neustart der Reihe gearbeitet. Der Spieler kämpft nun auf eine völlig neue Art und Weise und kann zwischen Fernkampf- und Nahkampf-Waffen nahtlos wechseln, um es so mit mehreren Gegnern gleichzeitig aufzunehmen. Der Spieler wählt seine Assassinen-Fertigkeiten, während er das alte Ägypten erkundet und sich auf verschiedene Missionen begibt. Er erlebt packende Geschichten auf einer Reise, welche die Zivilisation verändern wird.','assassinsCreedOrigins.jpg','ASSASSIN\'S CREED ORIGINS.mp4'),(6,'Fallout 4','Bethesda Game Studios',12.92,2015,'Rollenspiel','Es lebe die Freiheit! Als einziger Überlebender von Vault 111 betrittst Du in Fallout 4 eine durch den Atomkrieg vernichtete Welt. Nur Du kannst das Schicksal des Ödlands bestimmen. Schließe Dich verschiedenen Fraktionen im Kampf um die Vorherrschaft an oder ziehe allein ins Abenteuer. Die brandneue Grafik- und Licht-Engine der nächsten Generation erweckt die Welt von Fallout zum Leben – realistischer als jemals zuvor.','fallout4.jpg',''),(7,'Dragon Ball FighterZ','Arc System Works',69,2018,'Action','Nach dem Erfolg der Xenoverse Serie ist es an der Zeit ein neues und klassisches 2D Dragon Ball Fighting-Game für diese Konsolengeneration vorzustellen. DRAGON BALL FighterZ stellt den Ursprung dessen dar, so beliebt und berühmt gemacht hat: endlose, spektakuläre Schlachtem mit übermächtigen Kämpfern. In Partnerschaft mit Arc System Works bietet DRAGON BALL FighterZ maximale Highend-Animegrafik und für Fans weltweit ein Gameplay, welches leicht zu erlernen aber schwer zu meistern ist.','dragonBallFigtherZ.jpg',''),(8,'Playerunknown\'s Battlegrounds','Bluehole',29.39,2017,'Ego Shooter','PlayerUnknown’s Battlegrounds (kurz: PUBG) ist der PC-Überraschungshit des Jahres und findet nun auch endlich seinen Weg auf die Xbox One. Meistere packende Online-Schlachten, plündere Vorräte, suche Waffen und gehe als einziger Überlebender aus dem Kampf hervor – allein oder im Team mit deinen Freunden.','playerunknownsBattlegrounds.jpg',''),(9,'Resident Evil 7 Biohazard','Capcom',19.98,2017,'Adventure','Alles in einem: Die Resident Evil 7 biohazard Gold Edition bietet alle Inhalte der umjubelten Originalveröffentlichung, sowie zusätzlich alle drei herunterladbaren Zusatzinhalte: Die bereits veröffentlichten DLCs Banned Footage Vol. 1 und Banned Footage Vol. 2 gehören ebenso zum Umfang der Gold Edition wie der kommende dritte DLC End of Zoe. Die Gold Edition wird in Deutschland, Ostereich und der Schweiz am 2. Februar 2018 für PlayStation 4 (auch in PlayStation VR erlebbar), Xbox One und Windows PCs (Steam und Windows 10 Store) erhältlich sein. ','residentEvil7Biohazard.jpg',''),(10,'Tom Clancy\'s Ghost Recon Wildlands','Ubisoft',30.57,2017,'Action','Bolivien, wenige Jahre nach unserer Zeit: Der wunderschöne, südamerikanische Staat hat sich zum größten Produzenten der Welt für Kokain etabliert. Das beeinflussende und boshafte Santa-Blanca-Drogenkartell hat den Staat in einen Drogenstaat verwandelt und führt diesen zur Gesetzlosigkeit, Furcht, Ungerechtigkeit und Gewalt. Von der berühmten Death Road bis hin zur weltgrößten Salzwüste können Spieler das bisher größte Open World-Action-Adventure-Spiel von Ubisoft erkunden. Spieler entdeckten riesige Regionen mit Inspirationen aus Bolivien und Südamerika und erleben atemberaubende Ausblicke sowie unglaubliche Vielfalt.','tomClancysGhostReconWildlands.jpg',''),(11,'Sea of Thieves','Rare',62.2,2018,'Adventure','Tauche ein in die Welt von Sea of Thieves - voller Piraten, unerwarteten Gefahren und lohnenswerter Beutezüge! Sei der Pirat, der du schon immer sein wolltest und erlebe mit deinen Freunden einzigartige Abenteuer. Stelle deinen ganz persönlichen Piraten-Kodex auf und setz die Segel gen Horizont mit einer sich immer verändernden Crew aus anderen Mitspielern. In Sea of Thieves erlebst du einzigartiges Koop-Gameplay: Die Kombination aus spannenden Erkundungen mit Freunden und der immerwährenden Gefahr ausgehend von sowohl gegnerischen Spielern als auch der Spielwelt selbst, machen Sea of Thieves zu einem völlig neuen Erlebnis!','seaOfThieves.jpg',''),(12,'Dark Souls','From Software',19.39,2011,'Rollenspiel','\"Feuer erlöschen und die Welt fällt in den Ruin. Entwickler FROMSOFTWARE und Game Director Hidetaka Miyazaki setzen mit DARK SOULS III ihre erfolgreiche und innovative Reihe fort. Alte und neue Fans werden sich in den für die Reihe typischen befriedigenden Gameplay und der immersiven Grafik verlieren. Jetzt bleibt nur die Glut zurück... Du bist der Unentfachte. Als Teil des Dark Souls™ III Season Pass kannst du dein Dark Souls™ III-Erlebnis jetzt mit dem DLC-Pack \"\"Die Aschen von Ariandel\"\" erweitern. Reise in die verschneite Welt von Ariandel und entdecke neue Gebiete, Bosse, Feinde, Waffen, Rüstungen, Zauber und mehr. Wirst du dich der Herausforderung stellen und dich erneut der Finsternis ergeben?\"','darkSouls.jpg',''),(13,'Star Wars: Battlefront II','EA Dice',41.15,2017,'Action','Erleben Sie eine neue, packende Story-Kampagne, die die Brücke zwischen „Episode VI: Die Rückkehr der Jedi-Ritter” und „Episode VII: Das Erwachen der Macht” schlägt. Spektakuläre Online-Schlachten mit bis zu 40 anderen Spielern und zahlreiche Fahrzeugen und Raumschiffen sowie die berühmtesten Orten der gesamten Filmreihe bieten Star Wars-Flair pur. Spielen Sie gemeinsam mit einem Freund per Splitscreen-Modus kooperativ an einer Konsole und verbessern und spezialisieren Sie Ihren Helden durch einzigartige Modifikationen. Erwecken Sie die ultimative Star Wars-Fantasie zum Leben!','starWarsBattlefrontII.jpg',''),(14,'Destiny','Bungie',42.33,2017,'Adventure','Bungie, die Schöpfer von Halo®, und Activision, der Publisher von Call of Duty®, präsentieren Destiny - der nächste Schritt in der Evolution des Computer-Entertainments in Form eines epischen Adventures, das mit nichts zu vergleichen ist, was die Spielewelt bisher gesehen hat. In Destiny wirst du zum Hüter der letzten Stadt auf Erden und trägst unglaubliche Kräfte in dir. Erkunde die alten Ruinen unseres Sonnensystems, von den roten Dünen des Mars bis zur üppigen Dschungelwelt der Venus. Besiege die Feinde der Erde. Finde all das wieder, was wir verloren haben. Werde zur Legende.','destiny.jpg',''),(15,'For Honor','Ubisoft',27.04,2017,'Action','In For Honor™, dem neuen Nahkampf-Action-Spiel, das von Ubisoft Montreal in Zusammenarbeit mit weiteren Ubisoft Studios entwickelt wird, beschreitet der Spieler einen Weg voller Zerstörung und kämpft auf dem Schlachtfeld um Ruhm, Ehre und ums Überleben. Die Spieler treten in diesem chaotischen Krieg als Streiter der drei größten Krieger-Fraktionen an: Ritter, Wikinger oder Samurai. For Honor ist ein temporeiches und packendes Spiel, das Können und intuitives Verhalten der Spieler in einem bisher unbekannten Ausmaß erleben lässt. Das innovative Steuerungssystem The Art of Battle von For Honor gibt den Spielern die vollständige Kontrolle über ihren Helden. Jeder Held verfügt über seine ganz ureigenen Talente und Waffen, mit denen sich gegnerische Soldaten, Bogenschützen und Helden beseitigen lassen, die sich den Spielern in einem intensiven, glaubwürdigen Schlachtfeld in den Weg stellen. For Honor bietet einen aufregenden Mehrspieler-Modus als auch eine fesselnde Einzelspieler-Kampagne. Das Spiel ist komplett online mit Freunden oder aber solo gegen die KI spielbar.','forHonor.jpg',''),(16,'ARK: Survival Evolved','Studio Wildcard',54.9,2017,'Adventure','\"Bereiten Sie sich auf das ultimative Dinosaurierabenteuer vor! Sie sind auf einer geheimnisvollen prähistorischen Insel gestrandet. Erkunden ihre Biome und jagen, sammeln, stellen Werkzeuge her, pflanzen Feldfrüchte an und bauen Unterschlüpfe, um zu überleben. Mit List und Geschick können Sie in \"\"ARK\"\" Dinosaurier und andere urzeitliche Kreaturen töten, zähmen, ausbrüten und sogar reiten. Entwickeln Sie Ihre Technologie von primitiven Steinwerkzeugen zu Laserkanonen auf einem T-Rex weiter, während Sie sich online mit hunderten Spielern zusammenschließen oder die Reise allein antreten. Features: Fangen und zähmen Sie Dinosaurier: Entdecken Sie über 100 verschiedene Dinosaurier und prähistorische Kreaturen auf der Insel. Versuchen Sie sie zu zähmen und vergrößern mit ihnen die Dinoherde Ihres Stammes. Überleben ist alles: Hunger, Durst, Sicherheit und Schutz vor dem Wetter suchen sind Teil des Spiels. Wenn Sie zu weit laufen, wird Ihnen nicht nur die Kraft ausgehen, Sie werden auch schnell Hunger und Durst bekommen. Das Wetter basiert auf echten Klimata, daher sollten Sie sich vor Regen und Schnee schützen und aus sonnigen Tagen das Beste machen. Ernten, jagen und bauen: Fällen Sie Bäume und errichten ein neues Zuhause, das Sie zu einer riesigen Dinosaurierbasis ausbauen können. Jagen Sie nach Fleisch, sammeln Pflanzen oder legen Ihren eigenen Garten an! Sammeln Sie Ressourcen, passen alles an: Dank eines umfangreichen Produktionssystems können Sie die gesammelten Materialien der Insel kombinieren und die Farben, Texturen, Formen und den Stil der Wände Ihres Zuhauses, der Rüstung Ihres Charakters, der Waffen und vieles mehr modifizieren. Erkunden Sie die Insel: Lösen Sie das Rätsel um ARK, erkunden eine riesige Insel und finden die Notizbücher des Entdeckers, die viele Hinweise beinhalten! Bahnen Sie sich Ihren Weg zum Endgegner und finden heraus, warum Sie auf dieser urzeitlichen Insel gelandet sind.\"','arkSurvivalEvolved.jpg',''),(17,'Final Fantasy XV','Sqaure Enix',54.9,2016,'Rollenspiel','Betreten Sie die Welt von FINAL FANTASY XV und erleben Sie unglaubliche, actionreiche Kämpfe auf Ihrer Entdeckungsreise. Sie sind Noctis, der Kronprinz des Königreichs Lucis, mit der Mission, Ihre Heimat aus den Klauen der imperialen Armee zu befreien. Reisen Sie durch die atemberaubende Welt von Eos und begegnen Sie überlebensgroßen Bestien und gnadenlosen Feinden. Meistern Sie Waffen- und Magiefertigkeiten sowie die Kraft Ihrer Vorfahren, die in aufregenden Kämpfen das mühelose Teleportieren ermöglicht.','finalFantasyXV.jpg',''),(18,'World of Warcraft','Blizzard',70.55,2004,'Rollenspiel','Azeroth wird von einem Sturm der Zerstörung heimgesucht. Dämonen der Brennenden Legion strömen in unsere Welt und läuten die Rückkehr des dunklen Titanen Sargeras ein, dem Verheerer der Welten. Während eine unaufhaltsame Welle der Vernichtung auf die Allianz und die Horde zurollt, müssen die Helden von Azeroth Erlösung in den Ruinen der Verheerten Inseln suchen – dem verlorenen Hochsitz der uralten Nachtelfenzivilisation und Geburtsstätte von Mythen, die bis zur Schöpfung der Welt selbst zurückgehen. Dort werden sie legendäre verbotene Kräfte meistern, um damit unaussprechliche Alpträume und unaufhaltbare Dämonenarmeen zur Strecke zu bringen und ihre Welt vor dem Joch eines ewig brennenden Schattens zu bewahren.','worldOfWarcraft.jpg',''),(19,'Minecraft','Mojang',25.86,2009,'Gesellschaft','Wie sieht die Welt von Minecraft eigentlich aus? Das hängt ganz von dir ab – und das ist das Besondere an diesem wundervoll kreativen Spiel. Jeder Zentimeter in diesem Reich aus Blöcken kann zerstört und neu erbaut werden, ganz wie es dir beliebt. Die Werkzeuge, die du dafür benötigst, liegen dir quasi zu Füßen. Als Schöpfer stehen dir alle möglichen Materialien zur Verfügung. Fälle Bäume, um Gegenstände aus Holz zu fertigen. Baue Steine ab, um steinerne Strukturen zu bauen, oder baue Pfl anzen an und züchte Tiere, um sie im Handel mit Dorfbewohnern gegen andere nützliche Gegenstände zu tauschen. Du kannst Flüsse und Seen in deiner Welt so ausrichten, wie du es möchtest, um sie dir zunutze zu machen. Baue in die Höhe oder grabe dich in die Tiefe, wie es dir beliebt. Die Welt um dich herum hat eine zufällige Form aus verschiedenen Biomen, wie z. B. Wüste oder Dschungel und erstreckt sich kilometerweit in jede Richtung.','minecraft.jpg',''),(20,'Far Cry 5','Ubisoft',54.09,2018,'Adventure','\"Willkommen in Hope County, Montana. Dieser idyllische Ort ist das Zuhause einer freiheitsliebenden Gemeinde, die von einem fanatischen und an die Apokalypse glaubenden Kult terrorisiert wird. Angeführt vom charismatischen Propheten Joseph Seed und seinen treuen Geschwistern, den Herolden, hat der Kult namens \"\"Project at Eden\'s Gate\"\" schleichend die Kleinstadt und jeden Aspekt des alltäglichen Lebens übernommen. Als die Ankunft des Protagonisten den Kult dazu verleitet, die Region mit Gewalt unter ihre Kontrolle zu bringen, muss er sich erheben und ein Feuer des Widerstandes entfachen, um die Gemeinde zu befreien.\"','farCry5.jpg',''),(21,'The Elder Scrolls V: Skyrim','Bethesda Game Studios',5.87,2001,'Rollenspiel','Die Drachen sind nach Tamriel zurückgekehrt! Nur die Schriftrollen der Altvorderen berichteten von ihrer Existenz. Die Zukunft der Provinz Himmelsrand und sogar des ganzen Kaiserreiches hängt am seidenen Faden. Doch die alten Prophezeihungen künden auch von einem Retter, dem Drachenblut: ein Held, der mit der Machgt der Stimme geboren wurde - und der Einzige, dre sich ihnen entgegenzustellen vermag.','theElderScrollsVSkyrim.jpg',''),(22,'Fortnite','Epic Games',0,2017,'Action','Warum Schutz suchen? Bauen Sie sich ihn auf! Der Sturm kam ohne Vorwarnung. 98 % der Weltbevölkerung verschwanden - dann kamen die Monster. Stürzen Sie sich mit den verbleibenden Helden in den Kampf und halten den Sturm auf. Erkunden Sie ausgedehnte, zerstörbare Welten, in denen kein Spiel dem anderen gleicht. Errichten Sie riesige Festungen, stellen exotische Waffen her, sammeln Beute, und verbessern Ihre Helden. Willkommen zu Fortnite, dem neuen Bau-Actionspiel von Epic Games. DAS EARLY ACCESS-PAKET ENTHÄLT: Seltenes Startheldenpaket (8 Helden) Seltenes Startwaffenpaket (Enthält 4 Waffen / 1 Falle) Exklusive Gründerpistole 10 exklusive Bannersymbole im Spiel 24 tägliche Beutepiñata-Pakete 4 exklusive Gründer-Beutepiñata-Pakete 5 Sofort-Beutepiñata-Pakete 10 EP-Boosts 10 verschenkbare EP-Boosts für Freunde 50 zusätzliche Tresorraum-Slots Features: Rekrutieren Sie Ihre Verteidiger: Bilden Sie ein Team, bestehend aus vier Charakterklassen, aus und nutzen ihre Fähigkeiten im Kampf gegen die Monster Horden Bauen Sie Festungen: Das revolutionäre Bausystem erlaubt es Ihnen extravagante Stützpunkte zu kreieren. Platzieren Sie Scharfschützen, bauen tödliche Fallen uvm. Bauen Sie Waffen: Nutzen Sie Ihre gesammelten Ressourcen und stellen hunderte Schusswaffen, Schwerter und Gadgets her Spielen Sie mit Freunden: Stellen Sie sich dem Sturm im Online-Koop mit bis zu vier Spielern.','fortnite.jpg',''),(23,'NBA 2K18','Visual Concepts',49.9,2017,'Sport','Der am höchsten bewertete* jährliche Sporttitel dieser Konsolengeneration kehrt mit NBA 2K18 zurück und setzt die Tradition der Reihe als “Gold-Standard für Basketball-Simulationen” (Sports Gamers Online) mit einzigartigem Realismus und echtem NBA-Gameplay fort.','nba2K18.jpg',''),(24,'Kingdom Come: Deliverance','Warhorse Studios',41.15,2018,'Rollenspiel','Ein realistisches First-Person-Rollenspiel, das Sie ins mittelalterliche Europa entführt. Wir schreiben das Jahr 1403. Böhmen liegt im Herzen Europas und ist reich an Kultur, Silber und imposanten Burgen. Das Spiel basiert auf einer wahren Historie - einer Geschichte über Könige, Erben, ein Königreich, Belagerungen und blutige Schlachten. Kaiser Karl IV. ist tot und sein ältester Sohn Wenzel IV. wird zum König von Böhmen. Wenzels erzürnter Halbbruder Sigismund nimmt ihn gefangen und fällt mit seiner mächtigen Streitmacht in das Land ein.','kingdomComeDeliverance.jpg',''),(25,'Metal Gear Survive','Konami',49.9,2018,'Action','Die Ereignisse von METAL GEAR SOLID V: THE PHANTOM PAIN spielen neun Jahre nach MGSV: Ground Zeroes und dem Fall von Mother Base. Snake, auch bekannt als Big Boss, erwacht aus einem neun Jahr währenden Koma. Die Story des Spiels setzt im Jahr 1984 an: Der Kalte Krieg ist noch immer Kulisse, und eine globalen Krise zeichnet sich am Horizont ab. Getrieben von dem Wunsch nach Rache, führt Snakes Reise ihn in eine Welt, in der er eine schattenhafte Gruppe namens XOF verfolgt.','metalGearSurvive.jpg',''),(26,'Wolfenstein II: The New Colossus','MachineGames',27.04,2017,'Action','Dein Sieg über General Totenkopf war nur von kurzer Dauer. Das Regime hält die Welt weiterhin in seinem Würgegriff. Jetzt liegt es an dir, erneut in die Rolle von B.J. „Terror-Billy“ Blazkowicz zu schlüpfen, die mutigsten Anführer des zerschlagenen Widerstands zu vereinen und gemeinsam dem Regime entgegenzutreten. An ikonischen Schauplätzen wie der Kleinstadt Roswell in New Mexico, den Sumpflandschaften und Boulevards von New Orleans oder dem durch eine nukleare Explosion zerstörten Manhattan sagst du dem Bösen den Kampf an.','wolfensteinIITheNewColossus.jpg',''),(27,'Need for Speed Payback','Ghost Games',38.8,2017,'Simulation','\"\"\"Payback\"\" spielt in der Unterwelt von Fortune Valley. Nachdem deine Crew auseinandergerissen wurde, findet ihr wieder zusammen, um euch am \"\"House\"\" zu rächen – einem skrupellosen Kartell, das die Casinos, Kriminellen und Cops der Stadt beherrscht. In diesem korrupten Spielerparadies sind die Einsätze hoch und das House gewinnt immer. Stelle dich in der Rolle von Tyler (alias \"\"Racer\"\"), Mac (alias \"\"Showman\"\") und Jess (alias \"\"Wheelman\"\") einer Vielzahl von Herausforderungen und Events. Jeder Fahrer muss Rennen, Missionen und Herausforderungen meistern, um sich den Respekt der Underground-Szene des Valley zu verdienen – nur so können sie am ultimativen Rennen teilnehmen und das House letzten Endes zu Fall bringen.\"','needForSpeedPayback.jpg',''),(28,'Fifa 17','EA Canada',20,2016,'Sport','FIFA 17 – erstmals powered by Frostbite™. FIFA 17 sorgt dank der neuen Engine für mitreißende und noch realistischere Fußballerlebnisse, wie dem neuen Story-Modus The Journey, in dem du dir als Nachwuchstalent Alex Hunter den Traum vom Leben als Fußballprofi erfüllen kannst. Darüber hinaus verändern umfassende Gameplay-Innovationen die Art und Weise, wie die Spieler auf dem Platz agieren, sich bewegen und in Zweikämpfen verhalten, Standards ausführen und neue Angriffstechniken einsetzen, sodass du jederzeit die volle Kontrolle über das Geschehen auf dem Platz hast.','fifa17.jpg',''),(29,'Lost Sphear','Tokyo RPG Factory',44.72,2017,'Rollenspiel','In Lost Shear betreten Spieler eine Welt, in der alles aus Erinnerungen besteht. Wenn eine Erinnerung in Vergessenheit gerät, verschwindet ein Teil der Welt ins weiße Nichts. Die Bewohner kennen dieses Phänomen als LOST. Kanata, ein junger Schwertkämpfer aus Elgarthe, verfügt als einziger über die mysteriöse Macht der Erinnerung und will mit dieser Gabe die Welt, die nach und nach im Nichts versinkt, wiederaufbauen.','lostSphear.jpg','');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spieleliste`
--

DROP TABLE IF EXISTS `spieleliste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spieleliste` (
  `Benutzer_ID` int(11) NOT NULL,
  `Game_ID` int(11) NOT NULL,
  KEY `Benutzer_ID` (`Benutzer_ID`),
  KEY `Game_ID` (`Game_ID`),
  CONSTRAINT `spieleliste_ibfk_1` FOREIGN KEY (`Benutzer_ID`) REFERENCES `benutzer` (`ID`),
  CONSTRAINT `spieleliste_ibfk_2` FOREIGN KEY (`Game_ID`) REFERENCES `game` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spieleliste`
--

LOCK TABLES `spieleliste` WRITE;
/*!40000 ALTER TABLE `spieleliste` DISABLE KEYS */;
INSERT INTO `spieleliste` VALUES (1,24);
/*!40000 ALTER TABLE `spieleliste` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-26 15:15:45
