CREATE TABLE `s_gateways` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_gateway_name` varchar(255) DEFAULT NULL,
  `s_gateway_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;



CREATE TABLE `s_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_email` varchar(255) DEFAULT NULL,
  `s_first_name` varchar(255) DEFAULT NULL,
  `s_last_name` varchar(255) DEFAULT NULL,
  `s_password` varchar(255) DEFAULT NULL,
  `s_phone_number` varchar(255) DEFAULT NULL,
  `s_recovery_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


