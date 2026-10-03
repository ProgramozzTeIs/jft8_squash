
DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `logged_in` tinyint NOT NULL,
  `first_login_done` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

CREATE TABLE `place` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `rent_fee` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

CREATE TABLE `game` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user1_id` int NOT NULL,
  `user2_id` int NOT NULL,
  `user1_score` int NOT NULL,
  `user2_score` int NOT NULL,
  `place_id` int NOT NULL,
  `game_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user1_id_idx` (`user1_id`),
  KEY `user2_id_idx` (`user2_id`),
  KEY `place_id_idx` (`place_id`),
  CONSTRAINT `place_id` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`),
  CONSTRAINT `user1_id` FOREIGN KEY (`user1_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user2_id` FOREIGN KEY (`user2_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `user` VALUES (1,'Harry Potter','gryffindor','player',1,1),(18,'Cho Chang','ravenclaw','player',1,1),(19,'Draco Malfoy','slytherin','player',1,1),(20,'Cedric Diggory','hufflepuff','player',1,1),(21,'Albus Dumbledore','hogwarts','admin',1,1),(22,'Frodo Baggins','theshire','player',1,1),(23,'Legolas Greenleaf','mirkwood','player',1,1),(24,'Gimli','eredluin','player',1,1),(25,'Gandalf','valinor','admin',1,1),(26,'Kathryn Janeway','voyager','admin',1,1),(27,'Yoda','jedimaster','admin',1,1),(28,'Aragorn','gogondor','player',1,1),(29,'Galadriel','lothlorien','admin',1,1),(30,'Jon Snow','nightswatch','player',1,1),(31,'Arya Stark','valarmorghulis','player',1,1),(32,'Daenerys Targaryen','targaryen','player',1,1),(33,'Night King','deadmenwalk','admin',1,1),(34,'Darth Vader','empire','player',1,1),(35,'Chewbacca','rebellion','player',1,1),(36,'Rick Grimes','alexandria','admin',1,1),(37,'Daryl Dixon','stealthkill','player',1,1),(38,'Michonne','samuraisword','player',1,1),(39,'Samantha Carter','scienceforever','player',1,1),(40,'Teal\'c','indeed','player',1,1),(41,'Eleven','friendsdontlie','player',1,1),(42,'Will Byers','willthewise','player',1,1),(43,'Vecna','upsidedown','admin',1,1),(44,'Demogorgon','flowerface','player',1,1),(45,'Jim Hopper','sheriff','player',1,1),(46,'Dustin Henderson','toothless','player',1,1),(47,'Cersei Lannister','kingslanding','player',1,1),(48,'Jack O\'Neill','forcryingoutloud','player',1,1),(49,'Luke Skywalker','tatooine','player',1,1),(50,'Carl Grimes','sheriffjunior','player',1,1),(51,'Kara Thrace','starbuck','player',1,1),(52,'Lee Adama','apollo','player',1,1),(53,'Han Solo','milleniumfalcon','player',1,1),(54,'Brienne of Tarth','tarth','player',1,1),(55,'Hermione Granger','learntodeath','player',1,1),(56,'Voldemort','horcrux','player',1,1),(57,'Tyrion Lannister','theimp','player',1,1),(58,'Mike Wheeler','dndmaster','player',1,1),(59,'Steve Harrington','stevehair','player',1,1),(60,'Lando Calrissian','cloudcity','player',1,1),(61,'Leia Organa','princess','player',1,1),(62,'Jean-Luc Picard','federation','player',1,1),(63,'The Doctor','hologram','player',1,1),(64,'Seven of Nine','borg','player',1,1),(65,'Elrond','alisagentsmith','player',1,1),(66,'Ned Stark','winteriscoming','player',1,1);

INSERT INTO `place` VALUES (51,'Hawkins High School','Hawkins, Roane County, Indiana',4000),(53,'Death Star','Near Endor, Endor System',8000),(54,'Deep Space Nine','Alpha Quadrant, Bajor System',4000),(55,'Borg Unicomplex','Delta Quadrant, Space grid 0',100),(56,'Holodeck 1','Deck 6, USS Voyager, Delta Quadrant',6000),(57,'Velocity Court','USS Voyager, Delta Quadrant',4000),(58,'Mos Eisley Spaceport','Great Mesra Plateau, Tatooine, Outer Rim',3000),(59,'Jedi Temple','Galactic City, Coruscant, Core Worlds',10000),(60,'Rivendell','Eriador, Middle-earth',5000),(61,'Minas Tirith','Gondor, Middle-earth',3000),(62,'Terminus','Terminus',100),(63,'Woodbury','Georgia, USA',500),(64,'Lothlórien','Lothlórien, Middle-earth',6000),(65,'Great Hall','Hogwarts, Scottish Highlands, Great Britain',2000),(66,'Room of Requirement','Seventh Floor, Hogwarts Castle',5000),(67,'Stargate Command (SGC)','Cheyenne Mountain, Colorado, USA',6000),(68,'Abydos','Abydos, Kaliem Galaxy',2000),(69,'Atlantis, Central Tower','Atlantis City, Lantea, Pegasus Galaxy',7000),(70,'Galactica','Colonial Fleet, Cyrannus System',3000),(71,'Caprica City','Caprica, Twelve Colonies',2000),(72,'The Wall','Northern Westeros',1000),(73,'Winterfell','The North, Westeros',2000),(74,'Hawkins National Laboratory','Hawkins, Roane County, Indiana',800),(75,'Babylon 5','Epsilon III Orbit, Epsilon Eridani System',5000),(76,'Vault 33','Greater Los Angeles, California, USA',8000);

INSERT INTO `game` VALUES (1,1,22,11,7,60,'2026-10-03'),(2,19,35,8,11,53,'2026-10-04'),(3,30,44,11,9,72,'2026-10-05'),(4,37,64,6,11,54,'2026-10-06'),(5,39,51,11,8,67,'2026-10-07'),(6,40,57,9,11,69,'2026-10-08'),(7,41,56,11,5,74,'2026-10-09'),(8,28,34,7,11,61,'2026-10-10'),(9,32,50,11,6,76,'2026-10-11'),(10,52,62,11,9,70,'2026-10-12'),(11,54,65,5,11,64,'2026-10-13'),(12,58,63,11,10,75,'2026-10-14'),(13,49,53,9,11,58,'2026-10-15'),(14,55,60,11,8,66,'2026-10-16'),(15,18,43,6,11,56,'2026-10-17');













