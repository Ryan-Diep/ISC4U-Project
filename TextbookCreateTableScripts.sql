usersCREATE TABLE `users` (
  `USER_ID` int NOT NULL,
  `USER_NAME` varchar(50) DEFAULT NULL,
  `FIRST_NAME` varchar(100) DEFAULT NULL,
  `LAST_NAME` varchar(100) DEFAULT NULL,
  `EMAIL_ADDRESS` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `textbooks` (
  `tb_id` int NOT NULL,
  `tb_name` varchar(100) DEFAULT NULL,
  `tb_author` varchar(100) DEFAULT NULL,
  `tb_original_price` decimal(10,2) DEFAULT NULL,
  `tb_current_price` decimal(10,2) DEFAULT NULL,
  `tb_condition` varchar(45) DEFAULT NULL,
  `tb_description` varchar(150) DEFAULT NULL,
  `tb_subject` varchar(150) DEFAULT NULL,
  `tb_seller_id` int DEFAULT NULL,
  PRIMARY KEY (`tb_id`),
  UNIQUE KEY `tb_id_UNIQUE` (`tb_id`),
  KEY `tb_fk1_idx` (`tb_seller_id`),
  CONSTRAINT `tb_fk1` FOREIGN KEY (`tb_seller_id`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `transactions` (
  `trx_id` int NOT NULL,
  `trx_date` datetime DEFAULT NULL,
  `trx_buyer_id` int DEFAULT NULL,
  `trx_tb_id` int DEFAULT NULL,
  PRIMARY KEY (`trx_id`),
  UNIQUE KEY `trx_id_UNIQUE` (`trx_id`),
  KEY `trx_fk1_idx` (`trx_buyer_id`),
  KEY `trx_fk2_idx` (`trx_tb_id`),
  CONSTRAINT `trx_fk1` FOREIGN KEY (`trx_buyer_id`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trx_fk2` FOREIGN KEY (`trx_tb_id`) REFERENCES `textbooks` (`tb_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
