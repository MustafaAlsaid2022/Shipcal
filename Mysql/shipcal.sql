CREATE DATABASE `shipcal`;

use shipcal;


CREATE TABLE `shipment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL CHECK (name <> ''),
  `weight` float NOT NULL CHECK (weight <> ''),
  `color` varchar(45) NOT NULL CHECK (color <> ''),
  `destination` varchar(45) NOT NULL CHECK (destination <> ''),
  `cost` float NOT NULL CHECK (cost <> ''),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;