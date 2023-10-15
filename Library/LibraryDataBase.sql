CREATE DATABASE  IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `library`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `author` (
  `idAuthor` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(200) NOT NULL,
  `LastName` varchar(200) NOT NULL,
  PRIMARY KEY (`idAuthor`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Arthur',' Golden'),(2,'C.S.','Lewis'),(4,'Charlotte ','BrontÃ'),(5,'Dan ','Brown '),(6,'Douglas ','Adams'),(7,'Emily ','BrontÃ'),(8,'F. Scott ','Fitzgerald'),(9,'Fyodor ','Dostoyevsky'),(10,'George ','Orwell'),(11,'Harper ','Lee'),(12,'J.K. ','Rowling'),(13,'Jane ','Austen'),(14,'John ','Green'),(15,'Kathryn ','Stockett '),(16,'L.M. ','Montgomery'),(17,'Lewis ','Carroll'),(18,'Margaret ','Mitchell'),(19,'Markus ','Zusak '),(20,'Orson Scott ','Card'),(21,'Oscar ','Wilde'),(22,'Paulo ','Coelho '),(23,'Ray ','Bradbury'),(24,'Shel ','Silverstein'),(25,'Stephen ','Chbosky'),(26,'Stephenie ','Meyer'),(27,'Suzanne ','Collins'),(28,'Veronica ','Roth '),(29,'Victor ','Hugo'),(30,'William ','Golding'),(31,'William ','Shakespeare');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `idBooks` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(200) NOT NULL,
  `Author` varchar(200) NOT NULL,
  `Year of Publication` int DEFAULT NULL,
  `Publisher` varchar(200) NOT NULL,
  `Subject` varchar(200) NOT NULL,
  PRIMARY KEY (`idBooks`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'The Hunger Games','Suzanne Collins',2008,'Scholastic Press','[\'Young Adult\', \'Fiction\', \'Dystopia\', \'Fantasy\', \'Science Fiction\', \'Romance\', \'Adventure\', \'Teen\', \'Post Apocalyptic\', \'Action\']'),(2,'Harry Potter and the Order of the Phoenix','J.K. Rowling',2004,'Scholastic Inc.','[\'Fantasy\', \'Young Adult\', \'Fiction\', \'Magic\', \'Childrens\', \'Adventure\', \'Audiobook\', \'Middle Grade\', \'Classics\', \'Science Fiction Fantasy\']'),(3,'To Kill a Mockingbird','Harper Lee',2006,'Harper Perennial Modern Classics','[\'Classics\', \'Fiction\', \'Historical Fiction\', \'School\', \'Literature\', \'Young Adult\', \'Historical\', \'Novels\', \'Read For School\', \'High School\']'),(4,'Pride and Prejudice','Jane Austen',2000,'Modern Library','[\'Classics\', \'Fiction\', \'Romance\', \'Historical Fiction\', \'Literature\', \'Historical\', \'Novels\', \'Historical Romance\', \'Classic Literature\', \'Adult\']'),(5,'Twilight','Stephenie Meyer',2006,'Little, Brown and Company','[\'Young Adult\', \'Fantasy\', \'Romance\', \'Vampires\', \'Fiction\', \'Paranormal\', \'Paranormal Romance\', \'Supernatural\', \'Teen\', \'Urban Fantasy\']'),(6,'The Book Thief','Markus Zusak ',2006,'Alfred A. Knopf','[\'Historical Fiction\', \'Fiction\', \'Young Adult\', \'Historical\', \'Classics\', \'War\', \'Holocaust\', \'World War II\', \'Books About Books\', \'Audiobook\']'),(7,'Animal Farm','George Orwell',1956,'Signet Classics','[\'Classics\', \'Fiction\', \'Dystopia\', \'Fantasy\', \'Literature\', \'Politics\', \'School\', \'Science Fiction\', \'Novels\', \'Read For School\']'),(8,'The Chronicles of Narnia','C.S. Lewis',2002,'HarperCollins','[\'Fantasy\', \'Classics\', \'Fiction\', \'Young Adult\', \'Childrens\', \'Christian\', \'Adventure\', \'Science Fiction Fantasy\', \'Middle Grade\', \'Christian Fiction\']'),(9,'J.R.R. Tolkien 4-Book Boxed Set: The Hobbit and The Lord of the Rings','J.R.R. Tolkien',2012,'Ballantine Books','[\'Fantasy\', \'Fiction\', \'Classics\', \'Adventure\', \'Science Fiction Fantasy\', \'Epic Fantasy\', \'High Fantasy\', \'Young Adult\', \'Literature\', \'Magic\']'),(10,'Gone with the Wind','Margaret Mitchell',1999,'Warner Books','[\'Classics\', \'Historical Fiction\', \'Fiction\', \'Romance\', \'Historical\', \'War\', \'Literature\', \'Civil War\', \'Historical Romance\', \'Novels\']'),(11,'The Fault in Our Stars','John Green',2012,'Dutton Books','[\'Young Adult\', \'Romance\', \'Fiction\', \'Contemporary\', \'Realistic Fiction\', \'Teen\', \'Coming Of Age\', \'Drama\', \'Novels\', \'Love\']'),(12,'The Hitchhiker\'s Guide to the Galaxy','Douglas Adams',2007,'Del Rey','[\'Science Fiction\', \'Fiction\', \'Humor\', \'Fantasy\', \'Classics\', \'Comedy\', \'Science Fiction Fantasy\', \'Audiobook\', \'Adventure\', \'Novels\']'),(13,'The Giving Tree','Shel Silverstein',1964,'HarperCollins Publishers','[\'Childrens\', \'Picture Books\', \'Classics\', \'Fiction\', \'Poetry\', \'Young Adult\', \'Fantasy\', \'Juvenile\', \'Kids\', \'Short Stories\']'),(14,'Wuthering Heights','Emily BrontÃ',2002,'Norton','[\'Classics\', \'Fiction\', \'Romance\', \'Gothic\', \'Literature\', \'Historical Fiction\', \'19th Century\', \'Novels\', \'Classic Literature\', \'Historical\']'),(15,'The Da Vinci Code','Dan Brown ',2006,'Anchor','[\'Fiction\', \'Mystery\', \'Thriller\', \'Suspense\', \'Mystery Thriller\', \'Historical Fiction\', \'Adventure\', \'Novels\', \'Crime\', \'Adult\']'),(16,'Memoirs of a Geisha','Arthur Golden',2005,'Vintage Books USA','[\'Fiction\', \'Historical Fiction\', \'Romance\', \'Historical\', \'Classics\', \'Japan\', \'Adult\', \'Novels\', \'Asia\', \'Adult Fiction\']'),(17,'The Picture of Dorian Gray','Oscar Wilde',2004,'Random House: Modern Library','[\'Classics\', \'Fiction\', \'Horror\', \'Fantasy\', \'Literature\', \'Gothic\', \'Novels\', \'19th Century\', \'LGBT\', \'Classic Literature\']'),(18,'Alice\'s Adventures in Wonderland & Through the Looking-Glass','Lewis Carroll',2000,'Penguin Group (USA)','[\'Classics\', \'Fantasy\', \'Fiction\', \'Childrens\', \'Young Adult\', \'Literature\', \'Adventure\', \'Novels\', \'19th Century\', \'British Literature\']'),(19,'Jane Eyre','Charlotte BrontÃ',2003,'Penguin','[\'Classics\', \'Fiction\', \'Romance\', \'Historical Fiction\', \'Literature\', \'Gothic\', \'Historical\', \'19th Century\', \'School\', \'Classic Literature\']'),(20,'Les MisÃ©rables','Victor Hugo',1987,'Signet Classics','[\'Classics\', \'Fiction\', \'Historical Fiction\', \'Literature\', \'France\', \'Historical\', \'Novels\', \'French Literature\', \'Romance\', \'Classic Literature\']'),(21,'Fahrenheit 451','Ray Bradbury',2011,'Simon & Schuster','[\'Classics\', \'Fiction\', \'Science Fiction\', \'Dystopia\', \'School\', \'Literature\', \'Novels\', \'Fantasy\', \'Adult\', \'Science Fiction Fantasy\']'),(22,'Divergent','Veronica Roth ',2012,'Katherine Tegen Books','[\'Young Adult\', \'Dystopia\', \'Fiction\', \'Fantasy\', \'Science Fiction\', \'Romance\', \'Adventure\', \'Teen\', \'Post Apocalyptic\', \'Action\']'),(23,'Lord of the Flies','William Golding',1999,'Penguin Books','[\'Classics\', \'Fiction\', \'Young Adult\', \'School\', \'Literature\', \'Dystopia\', \'Read For School\', \'Novels\', \'High School\', \'Adventure\']'),(24,'Romeo and Juliet','William Shakespeare',2004,'Simon Schuster','[\'Classics\', \'Plays\', \'Fiction\', \'Romance\', \'School\', \'Drama\', \'Read For School\', \'Literature\', \'High School\', \'Poetry\']'),(25,'The Alchemist','Paulo Coelho ',2014,'HarperOne','[\'Fiction\', \'Classics\', \'Fantasy\', \'Philosophy\', \'Novels\', \'Spirituality\', \'Literature\', \'Self Help\', \'Inspirational\', \'Adventure\']'),(26,'Crime and Punishment','Fyodor Dostoyevsky',2002,'Penguin','[\'Classics\', \'Fiction\', \'Russia\', \'Literature\', \'Russian Literature\', \'Novels\', \'Philosophy\', \'Crime\', \'19th Century\', \'School\']'),(27,'The Perks of Being a Wallflower','Stephen Chbosky',1999,'MTV Books/Pocket Books','[\'Young Adult\', \'Fiction\', \'Contemporary\', \'Coming Of Age\', \'Romance\', \'Realistic Fiction\', \'LGBT\', \'Classics\', \'Mental Health\', \'Teen\']'),(28,'The Great Gatsby','F. Scott Fitzgerald',2004,'Scribner','[\'Classics\', \'Fiction\', \'School\', \'Literature\', \'Historical Fiction\', \'Romance\', \'Novels\', \'Read For School\', \'High School\', \'American\']'),(29,'City of Bones','Cassandra Clare ',2007,'Margaret K. McElderry Books','[\'Fantasy\', \'Young Adult\', \'Paranormal\', \'Romance\', \'Urban Fantasy\', \'Fiction\', \'Vampires\', \'Supernatural\', \'Angels\', \'Magic\']'),(30,'Ender\'s Game','Orson Scott Card',2004,'Macmillan Audio','[\'Science Fiction\', \'Fiction\', \'Young Adult\', \'Fantasy\', \'Classics\', \'Science Fiction Fantasy\', \'Dystopia\', \'War\', \'Audiobook\', \'Adventure\']'),(31,'The Help','Kathryn Stockett ',2009,'Amy Einhorn Books/G.P. Putnam\'s Sons','[\'Fiction\', \'Historical Fiction\', \'Historical\', \'Adult\', \'Adult Fiction\', \'Contemporary\', \'Audiobook\', \'Classics\', \'Chick Lit\', \'Book Club\']'),(32,'Anne of Green Gables','L.M. Montgomery',2003,'Signet Book','[\'Classics\', \'Fiction\', \'Young Adult\', \'Childrens\', \'Historical Fiction\', \'Middle Grade\', \'Historical\', \'Audiobook\', \'Canada\', \'Coming Of Age\']'),(33,'Harry Potter and the Sorcerer\'s Stone','J.K. Rowling',1997,'Scholastic Inc','[\'Fantasy\', \'Fiction\', \'Young Adult\', \'Magic\', \'Childrens\', \'Middle Grade\', \'Adventure\', \'Classics\', \'Audiobook\', \'Science Fiction Fantasy\']'),(34,'Harry Potter and the Goblet of Fire','J.K. Rowling',2002,'Scholastic Inc','Fantasy'),(35,'Harry Potter and the Half-Blood Prince','J.K. Rowling',2006,'Scholastic','Fantasy'),(36,'Harry Potter and the Chamber of Secrets','J.K. Rowling',1999,'Arthur A. Levine Books / Scholastic Inc.','Fantasy'),(37,'Harry Potter and the Deathly Hallows','J.K. Rowling',2007,'Arthur A. Levine Books / Scholastic Inc.','Fantasy'),(38,'Harry Potter and the Prisoner of Azkaban','J.K. Rowling',2000,'Arthur A. Levine Books / Scholastic Inc.','Fantasy'),(39,'1984','George Orwell',1949,'Houghton Mifflin Harcourt','Science Fiction');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher` (
  `idPublisher` int NOT NULL AUTO_INCREMENT,
  `Publisher` varchar(200) NOT NULL,
  PRIMARY KEY (`idPublisher`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` VALUES (1,'Scholastic Press'),(2,'Scholastic Inc.'),(3,'Harper Perennial Modern Classics'),(4,'Modern Library'),(5,'Little, Brown and Company'),(6,'Alfred A. Knopf'),(7,'Signet Classics'),(8,'HarperCollins'),(9,'Ballantine Books'),(10,'Warner Books'),(11,'Dutton Books'),(12,'Del Rey'),(13,'HarperCollins Publishers'),(14,'Norton'),(15,'Anchor'),(16,'Arthur A. Levine Books / Scholastic Inc.'),(17,'Houghton Mifflin Harcourt');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-06 19:00:00
