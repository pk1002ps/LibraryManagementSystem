/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.5.57 : Database - banking_management_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`banking_management_system` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `banking_management_system`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `BookID` varchar(30) NOT NULL,
  `Title` varchar(30) NOT NULL,
  `AuthorName` char(30) NOT NULL,
  `Publication` varchar(30) NOT NULL,
  `Subject` char(30) NOT NULL,
  `ISBN` varchar(15) NOT NULL,
  `Category` char(30) NOT NULL,
  `Price` int(10) NOT NULL,
  `Quantity` int(5) NOT NULL,
  PRIMARY KEY (`BookID`,`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `book` */

insert  into `book`(`BookID`,`Title`,`AuthorName`,`Publication`,`Subject`,`ISBN`,`Category`,`Price`,`Quantity`) values ('Civ163490','Engireeng Mathematics','Gaur & kaul','SS','Civil','98-123-1234','Math',321,9),('Com112670','Java The Complete Reference','Schidt','TMH','Java','435434545','Computer',400,10),('Com391155','WINDOWS OS','Pramod Singh','What A Busy Day','Operating System','12076','Computer',551,14),('Com60544','C#','RAVAN','Dreams','C','98-12-3456-43','Computer',550,15),('Com912786','OPERATING SYSTEM CONCEPTS','GALVIN','WILEY INDIA EDITION','OS','546781','Computer',400,1),('Ele655740','HTML 5','James','Well Wishers','Compiler','987-32-211','IT',155,9),('Ele898919','J2EE','XYZ','TMH','Oracle','433-43-34-43','Electronics',200,19),('Mag570230','kkk','Anjali','kkk','C','645645646','Magzine',455,102);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `category` char(30) NOT NULL,
  PRIMARY KEY (`id`,`category`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`id`,`category`) values (1,'--Select--'),(1,'Civil'),(2,'Computer'),(3,'Aerospace'),(3,'Electrical'),(4,'Arts'),(4,'Electronics'),(5,'Mechanical'),(6,'Magzine'),(7,'Social Sciences');

/*Table structure for table `issuebooks` */

DROP TABLE IF EXISTS `issuebooks`;

CREATE TABLE `issuebooks` (
  `USN_No` varchar(20) DEFAULT NULL,
  `ISBN` char(20) DEFAULT NULL,
  `BOOK_ID` varchar(30) DEFAULT NULL,
  `TITLE` varchar(40) DEFAULT NULL,
  `AUTHORNAME` char(30) DEFAULT NULL,
  `SUBJECT` varchar(30) DEFAULT NULL,
  `PUBLICATION` char(20) DEFAULT NULL,
  `CATEGORY` char(20) DEFAULT NULL,
  `DATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `issuebooks` */

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Usertype` char(20) DEFAULT NULL,
  `USNNo` varchar(20) NOT NULL,
  `Title` varchar(5) DEFAULT NULL,
  `FIRST_NAME` char(30) DEFAULT NULL,
  `LAST_NAME` char(30) DEFAULT NULL,
  `Gender` varchar(15) DEFAULT NULL,
  `DateOfBirth` varchar(15) DEFAULT NULL,
  `FatherName` char(50) DEFAULT NULL,
  `AddressLine1` varchar(30) DEFAULT NULL,
  `AddressLine2` varchar(30) DEFAULT NULL,
  `City` char(50) DEFAULT NULL,
  `State` char(50) DEFAULT NULL,
  `PinCode` int(6) DEFAULT NULL,
  `ContactNo` varchar(10) NOT NULL,
  PRIMARY KEY (`Username`,`USNNo`,`ContactNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`Username`,`Password`,`Usertype`,`USNNo`,`Title`,`FIRST_NAME`,`LAST_NAME`,`Gender`,`DateOfBirth`,`FatherName`,`AddressLine1`,`AddressLine2`,`City`,`State`,`PinCode`,`ContactNo`) values ('a','a','Admin','1102039','Mr.','Pramod','Kumar','Male','10/02/1993','fff','D-248','Jagatpura','Jaipur','Raj',302017,'8892399191'),('ajay','ajay','Student','1102058','Mr.','Ajay','Pal','Male','22/02/1991','PPP','Nawali,Nawali','Ghazipur','Ghazipur','UP',202020,'9955502255'),('anjali','Anjali12@','Admin','1102020','Mrs.','Anjali','Agarwal','Female','10/07/1992','Ravindra Kumar Singhal','Bhilwara','Azad Nagar','Bhilwara','Rajasthan',302001,'8105817623'),('b','b','Student','1102050','Mr.','Pramod','Kumar','Male','10/02/1993','sss','D-248','Jagatpura','Jaipur','Raj',302017,'773725559'),('c','c','Student','11020222','Mr.','Ranjan','Singh','Male','10/02/1991','s s Singh','D-248','Jagatpura','Jaipur','Raj',302017,'773725559'),('s','s','Student','1102048','Mr.','P','Kumar','Male','10/02/1993','sss','D-248','Jagatpura','Jaipur','Raj',302017,'773725559'),('z','z','Student','huh','Mr.','Pramod','Kumar','Male','10/02/1993','sss','D-248','Jagatpura','Jaipur','Raj',302017,'773725559');

/*Table structure for table `publication` */

DROP TABLE IF EXISTS `publication`;

CREATE TABLE `publication` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `publication` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1021 DEFAULT CHARSET=latin1;

/*Data for the table `publication` */

insert  into `publication`(`id`,`publication`) values (1012,'pearson'),(1013,'tmh'),(1014,'ratt'),(1015,'ssss'),(1016,'Genius'),(1017,'PHP'),(1018,'Ashirvad'),(1019,'pearson'),(1020,'Lazy Lamhe');

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `subject` char(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=latin1;

/*Data for the table `subject` */

insert  into `subject`(`id`,`subject`) values (101,'--Select--'),(102,'Oracle'),(103,'Compiler'),(104,'DSA'),(105,'C'),(106,'C++'),(113,'ffdfdf'),(114,'CN'),(115,'JAVA'),(116,'Digital Electronics'),(117,'Economics'),(118,'History');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
