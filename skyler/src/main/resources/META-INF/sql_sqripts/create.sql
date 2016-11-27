CREATE TABLE `s_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_first_name` varchar(45) DEFAULT NULL,
  `s_middle_name` varchar(45) DEFAULT NULL,
  `s_last_name` varchar(45) DEFAULT NULL,
  `s_email` varchar(45) DEFAULT NULL,
  `s_recovery_email` varchar(45) DEFAULT NULL,
  `s_password` varchar(45) DEFAULT NULL,
  `s_phone_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

