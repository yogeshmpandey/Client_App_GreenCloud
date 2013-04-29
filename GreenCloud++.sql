-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema enterdata
--

CREATE DATABASE IF NOT EXISTS enterdata;
USE enterdata;

--
-- Definition of table `cropdata`
--

DROP TABLE IF EXISTS `cropdata`;
CREATE TABLE `cropdata` (
  `FieldSize` varchar(45) default NULL,
  `CropYield` varchar(45) default NULL,
  `PlantationDate` varchar(45) default NULL,
  `CropType` varchar(45) default NULL,
  `CropName` varchar(45) default NULL,
  `IrrigationMethod` varchar(45) default NULL,
  `SoilType` varchar(45) default NULL,
  `TillageType` varchar(45) default NULL,
  `Latitude` varchar(45) default NULL,
  `longitude` varchar(45) default NULL,
  `City` varchar(45) default NULL,
  `country` varchar(45) default NULL,
  `altitude` varchar(45) default NULL,
  `FarmerName` varchar(45) default NULL,
  `FieldId` int(11) NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY  (`FieldId`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cropdata`
--

/*!40000 ALTER TABLE `cropdata` DISABLE KEYS */;
INSERT INTO `cropdata` (`FieldSize`,`CropYield`,`PlantationDate`,`CropType`,`CropName`,`IrrigationMethod`,`SoilType`,`TillageType`,`Latitude`,`longitude`,`City`,`country`,`altitude`,`FarmerName`,`FieldId`,`username`) VALUES 
 ('44','1200','12-06-2012','Rabi','tomatoes','Surface','Loam','No-Tillage','29.0210379','79.4897383','pantnagar','India','236.549','Bharat Bhushan',1,'bharat'),
 ('56','1200','18-06-2012','Kharif','Rice','Lateral','Sand','Reduced tillage','29.0391379','79.4593337','pantnagar','India','235.986','Yogesh Pandey',2,'yogesh'),
 ('56','1200','25-06-2012','Zayad','Wheat','Sprinkler','Peaty','Conservation tillage','29.1491875','75.72165270000005','hisar','India','212.792','Arpit Gupta',3,'arpit'),
 ('63','1200','28-06-2012','Rabi','Soybean','Drip','Chalky','Intensive tillage','30.349319','76.83257300000002','Ambala','India','278.216','Wamiq Saifi',4,'wamiq'),
 ('69','1200','03-07-2012','Zayad','Brinjal','Lateral','Clay','Reduced tillage','30.210994','74.94547450000005','Bathinda','India','209.436','Gurpreet Singh',5,'gurpreet'),
 ('78','1200','11-07-2012','Kharif','Rose','Localized','Peaty','Conservation tillage','30.32062','76.395126','Patiala','India','255.922','Jasmeet Singh',6,'jasmeet'),
 ('84','1200','16-07-2012','Rabi','Rice','Center Pivot','Loam','Reduced tillage','11.7862533','77.80078530000003','Mettur','India','199.734','Shahid Khan',7,'shahid'),
 ('92','1200','23-07-2012','Zayad','Barley','Localized','Clay','No-Tillage','12.5186113','78.21373649999998','krishnagiri','India','490.101','Shyam Kumar',8,'shyam'),
 ('64','1200','27-07-2012','Rabi','Sorghum','Sprinkler','Peaty','Intensive tillage','11.9575351','79.41904620000003','Kuppam','India','678.397','Sardeep lakhera',9,'sardeep'),
 ('34','1200','30-07-2012','Kharif','Millet','Localized','Sand','Intensive tillage','22.175733','75.58467300000007','Maheshwar','India','158.000','Abhishek Choudhari',10,'abhishek'),
 ('57','1200','10-07-2012','Rabi','Barley','Drip','Clay','Reduced tillage','18.5869444','79.06166669999993','ramadugu','India','305.413','Krishna Pratap',11,'krishna'),
 ('42','1200','07-08-2012','Rabi','Rice','Center Pivot','Peaty','Conservation tillage','23.0317188','72.64320470000007','Khodiar','India','52.672','Vijay Pandey',52,'vijay'),
 ('78','1200','15-05-2012','Kharif','tomatoes','Sprinkler','Sand','Reduced tillage','47.7587628','118.70555890000003','Wilbur','United States','662.273','John Smith',53,'john'),
 ('71','1200','24-05-2012','Rabi','Gram','Drip','Peaty','Reduced tillage','38.6270025','90.1994042','StLouis','United States','140.954','James Smith',54,'james'),
 ('49','1200','25-05-2012','Zayad','Rose','Sprinkler','Peaty','Conservation tillage','30.267153','97.74306079999997','Austin','United States','148.936','Robert Brown',55,'robert'),
 ('38','1200','24-05-2012','Kharif','Wheat','Drip','Sand','Reduced tillage','37.2317643','-79.8114761','Hardy','United States','317.626','Thomas Wilson',56,'thomas'),
 ('63','1200','30-05-2012','Zayad','Millet','Manual','Peaty','Intensive tillage','35.3732921','-119.01871249999999','Bakersfield','United States','123.371','Daniel Martin',57,'daniel'),
 ('30','1200','15-05-2012','Rabi','tomatoes','Surface','Loam','No-Tillage','-26.2041028','28.047305100000017','Johannesburg','South Africa','1755.074','Steven Clark',58,'steven'),
 ('74','1200','12-06-2012','Kharif','Soybean','Lateral','Peaty','Conservation tillage','-29.857876','31.027581000000055','Durban','South Africa','5.623','Dennis Carter',59,'dennis'),
 ('48','1200','21-06-2012','Kharif','Gram','Surface','Peaty','Reduced tillage','-23.891581','29.449600000000032','Polokwane','South Africa','72.622','Patrick Green',60,'patrick'),
 ('81','1200','23-07-2012','Zayad','Rose','Sprinkler','Loam','Conservation tillage','-33.8020653','19.887543100000016','Robertson','South Africa','191.659','Justin Parker',61,'justin'),
 ('51','1200','09-07-2012','Rabi','tomatoes','Surface','Loam','No-Tillage','-25.659691','27.243191000000024','Rustenburg','South Africa','1152.060','Chris Bell',62,'chris'),
 ('39','1200','20-06-2012','Kharif','Soybean','Sprinkler','Sand','Intensive tillage','-25.73134','28.21837000000005','Pretoria','South Africa','1311.940','Edwin Cook',63,'edwin'),
 ('54','1200','16-07-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','-28.09581','26.88087100000007','Virginia','South Africa','1324.031','Ross Taylor',64,'ross'),
 ('54','1200','12-06-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','52.446542','0.6225329999999758','Brandon','UK','12.119','Vimal Kant',65,'Vimal'),
 ('54','1200','12-06-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','53.748575','-2.487528999999995','Blackburn','UK','115.401','Sachin Kumar',66,'sachin'),
 ('54','1200','24-05-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','53.479251','-2.2479260000000068','Manchester','UK','48.190','Rohit Rastogi',67,'Rohit'),
 ('54','1200','30-07-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','53.411277','-2.967446999999993','Islington','UK','41.909','Amit Nagarkoti',68,'Amit'),
 ('54','1200','15-05-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','37.9642529','-91.8318334','Missouri','United States','304.299','Priyam Tyagi',69,'Priyam'),
 ('54','1200','07-08-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','34.0489281','-111.09373110000001','Arizona','United States','1527.288','Ankur Bhardwaj',70,'Ankur'),
 ('54','1200','20-06-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','53.7266683','-127.64762059999998','British Columbia','Canada','1121.031','Joshi',71,'Rajat'),
 ('54','1200','30-05-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','46.8796822','-110.36256579999997','Montana','United States','1625.696','Shubham Kumar',72,'Shubham'),
 ('54','1200','09-07-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','45.83361900000001','1.2611050000000432','Limoges','France','285.032','Ashutosh Chaudhary',73,'Ashutosh'),
 ('54','1200','15-05-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','9.5279875','31.66823469999997','Malakal','Sudan','399.859','Amitash Goel',74,'Amitash'),
 ('54','1200','21-06-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','27.194189','2.473932999999988','Bafia','Cameroon','494.839','Abhinav Kumar',75,'Abhinav'),
 ('54','1200','25-06-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','-0.3030988','36.080025999999975','Nakuru','Kenya','1806.092','Shivam Sharma',76,'Shivam'),
 ('54','1200','30-07-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','14.8666667','-15.883333300000004','Touba','Senegal','46.843','Rahul Verma',77,'Rahul'),
 ('54','1200','21-06-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','-17.82922','31.053961000000072','Harare','Zimbabwe','1489.684','Rakesh Mishra',78,'Rakesh'),
 ('54','1200','21-06-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','-12.6828145','132.47005420000005','Kakadu','Australia','17.012','Jitendra Gupta',79,'Jitendra'),
 ('54','1200','21-06-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','-17.82922','31.053961000000072','Alice Springs','Australia','580.512','Ravi Mishra',80,'Ravi'),
 ('54','1200','21-06-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','-35.2819998','149.12868430000003','Canberra','Australia','576.755','Akash Deep',81,'Akash'),
 ('54','1200','21-06-2012','Rabi','tomatoes','Sprinkler','Sand','No-Tillage','-37.4713077','144.7851531','Victoria','Australia','335.107','Tarun Aggrawal',82,'Tarun');
/*!40000 ALTER TABLE `cropdata` ENABLE KEYS */;


--
-- Definition of table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`username`,`password`) VALUES 
 ('',''),
 ('abhijit','1234'),
 ('Abhinav','1234'),
 ('abhishek','1234'),
 ('Akash','1234'),
 ('aman','1234'),
 ('Amit','1234'),
 ('Amitash','1234'),
 ('ams','1234'),
 ('Ankur','1234'),
 ('arpit','1234'),
 ('Ashutosh','1234'),
 ('bharat','1234'),
 ('chris','1234'),
 ('daniel','1234'),
 ('dennis','1234'),
 ('dishank','1234'),
 ('edwin','1234'),
 ('gaurav','1234'),
 ('gurpreet','1234'),
 ('james','1234'),
 ('jasmeet','1234'),
 ('Jitendra','1234'),
 ('john','1234'),
 ('justin','1234'),
 ('krishna','1234'),
 ('o','o'),
 ('patrick','1234'),
 ('Priyam','1234'),
 ('Rahul','1234'),
 ('Rajat','1234'),
 ('Rakesh','1234'),
 ('Ravi','1234'),
 ('robert','1234'),
 ('Rohit','1234'),
 ('ross','1234'),
 ('sachin','1234'),
 ('shahid','1234'),
 ('Shivam','1234'),
 ('Shubham','1234'),
 ('shyam','1234'),
 ('steven','1234'),
 ('Tarun','1234'),
 ('thomas','1234'),
 ('vijay','1234'),
 ('Vimal','1234'),
 ('wamiq','1234'),
 ('william','1234'),
 ('yogesh','1234');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


--
-- Definition of table `sensordata`
--

DROP TABLE IF EXISTS `sensordata`;
CREATE TABLE `sensordata` (
  `WaterConsumed` varchar(45) default NULL,
  `MaxHumidity` varchar(45) default NULL,
  `MaxTemprature` varchar(45) default NULL,
  `Mintemprature` varchar(45) default NULL,
  `AvgWindSpeed` varchar(45) default NULL,
  `SoilMoisture` varchar(45) default NULL,
  `FertilizersUsed` varchar(45) default NULL,
  `RainFall` varchar(45) default NULL,
  `EnterDate` varchar(45) default NULL,
  `username` varchar(45) default NULL,
  `FertilizerQuantity` varchar(45) default NULL,
  `MinHumidity` varchar(45) default NULL,
  `SunshineHr` varchar(45) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sensordata`
--

/*!40000 ALTER TABLE `sensordata` DISABLE KEYS */;
INSERT INTO `sensordata` (`WaterConsumed`,`MaxHumidity`,`MaxTemprature`,`Mintemprature`,`AvgWindSpeed`,`SoilMoisture`,`FertilizersUsed`,`RainFall`,`EnterDate`,`username`,`FertilizerQuantity`,`MinHumidity`,`SunshineHr`) VALUES 
 ('500','82','34','26','2.5','175','Nitrogen','80','2012-08-11 14:09:02','yogesh','85.9',70,7),
 ('600','84','37','21','3.7','167','Nitrogen','65','2012-08-11 14:13:25','yogesh','98.5',65,8),
 ('540','89','39','27','3.1','247','Phosphate','76','2012-08-11 14:16:51','yogesh','24.7',68,9),
 ('650','91','38','24','2.7','210','Potassium','84','2012-08-11 14:18:22','yogesh','12.6',75,10),
 ('700','86','38','23','1.9','281','Magnesium','72','2012-08-11 14:20:09','yogesh','21.4',62,6),
 ('520','87','33','20','2.6','183','Ferrous Sulphate','88','2012-08-11 14:22:01','yogesh','19.4',61,7),
 ('570','82','35','22','0.7','240','Borax','69','2012-08-11 14:27:45','yogesh','13.8',63,6),
 ('585','87','36','24','1.2','261','Hydrated Lime','69','2012-08-11 14:29:19','yogesh','17.2',65,10),
 ('480','76','33','26','1.8','192','Zinc Sulphate','77','2012-08-11 14:37:21','yogesh','7.4',71,8),
 ('490','94','41','28','2.8','192','Nitromag ','87','2012-08-11 14:41:50','yogesh','18.2',69,11),
 ('430','76','40','23','2.4','230','Magnesium CAP','63','2012-08-11 14:48:52','patrick','17.3',65,6),
 ('470','80','34','20','1.8','158','Magnesium Oxide','71','2012-08-11 14:50:02','patrick','13.4',60,9),
 ('510','87','39','26','2.7','247','Potassium Nitrate','67','2012-08-11 14:51:01','patrick','15.8',59,8),
 ('560','74','35','17','0.8','180','Dolomite','81','2012-08-11 14:52:51','patrick','10.4',66,7),
 ('620','75','38','18','1.8','230','Nitromag ','81','2012-08-11 14:54:53','patrick','8.4',68,8),
 ('480','73','36','19','3.0','230','Nitromag ','81','2012-08-11 14:56:26','patrick','8.4',59,6),
 ('550','82','42','25','2.0','165','Zinc Sulphate','73','2012-08-11 14:57:25','patrick','6.5',71,9),
 ('590','76','34','17','2.3','185','Hydrated Lime','79','2012-08-11 14:59:02','patrick','3.4',69,10),
 ('630','86','37','16','1.2','173','Borax','85','2012-08-11 14:59:41','patrick','7.3',72,11),
 ('540','82','37','14','2.7','149','Ferrous Sulphate','74','2012-08-11 15:03:03','patrick','14.2',68,7);
/*!40000 ALTER TABLE `sensordata` ENABLE KEYS */;


--
-- Definition of table `suggest`
--

DROP TABLE IF EXISTS `suggest`;
CREATE TABLE `suggest` (
  `username` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Date` varchar(45) NOT NULL,
  `Comment` varchar(100) NOT NULL default 'jhb,'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suggest`
--

/*!40000 ALTER TABLE `suggest` DISABLE KEYS */;
INSERT INTO `suggest` (`username`,`Name`,`Email`,`Date`,`Comment`) VALUES 
 ('bharat','Wamiq Saif','wamiqsaifi90@gmail.com','10-11-13','In large areas of farmland, capturing soil water content () accurately'),
 ('dishank','yogesh','yogesh@gmail.com','12/12/12','In large areas of farmland, capturing soil water content () accurately'),
 ('wamiq','Bharat Bhushan','bhmn1234@gmail.com ','9-7-12','In large areas of farmland, capturing soil water content () accurately'),
 ('yogesh','dishank','dishanktanwar19@gmail.com','12-12-12','In large areas of farmland, capturing soil water content () accurately'),
 ('dishank','Bharat Bhushan','bhmn1234@gmail.com ','3-5-12','In large areas of farmland, capturing soil water content () accurately'),
 ('dishank','Wamiq Saif','wamiqsaifi90@gmail.com','7-8-12','In large areas of farmland, capturing soil water content () accurately');
/*!40000 ALTER TABLE `suggest` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
