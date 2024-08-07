create database ECOMMERCE_CART;
use ECOMMERCE_CART;

DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `products`;
DROP TABLE IF EXISTS `users`;


CREATE TABLE `orders` (
  `o_id` int NOT NULL AUTO_INCREMENT,
  `p_id` int NOT NULL,
  `u_id` int NOT NULL,
  `o_quantity` int NOT NULL,
  `o_date` varchar(450) NOT NULL,
  PRIMARY KEY (`o_id`)
);

INSERT INTO `orders` VALUES 
(25,3,1,3,'2021-05-15'),
(26,2,1,1,'2021-05-15');



CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(450) NOT NULL,
  `category` varchar(450) NOT NULL,
  `price` double NOT NULL,
  `image` varchar(450) NOT NULL,
  PRIMARY KEY (`id`)
) ;


INSERT INTO `products` VALUES 
(1,'New Arrival Femal Shoes','Female Shoes',120,'female-shoes.jpg'),
(2,'Ladies Pure PU Shoulder Bag','Ladis Bag',69.99,'ladis-bag.jpg'),
(3,'Stylish Men Office Suits','Men Clothes',169,'men-suits.jpg'),
(4,'Jaeger-LeCoultre Men Watch','Men Watch',2500.99,'men-watch.jpg'),
(5,'FreeMax e-cigarettes VB-456','E-Cigarattes',310,'smoking-e-cigarette.jpg'),
(6,'GeekVapee e-cigarattes MM-632','E-Cigarattes',555.5,'smoking-e-cigarette-2.jpg');



CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ;


INSERT INTO `users` VALUES 
(1,'Almamun','almamun@mail.com','123456'),
(2, 'Shankar', 'shankarlinghalemani23@gmail.com','910863');