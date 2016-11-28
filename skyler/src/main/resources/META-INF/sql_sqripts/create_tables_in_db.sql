CREATE TABLE `s_gateways` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_gateway_name` varchar(255) DEFAULT NULL,
  `s_gateway_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `s_sensors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_device_id` int(11) DEFAULT NULL,
  `s_sensore_stat` varchar(255) DEFAULT NULL,
  `s_sensore_type` varchar(255) DEFAULT NULL,
  `s_timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


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

CREATE TABLE `s_joined_gateway_sensors` (
  `s_gateway_fk` int(11) NOT NULL,
  `s_sensor_fk` int(11) NOT NULL,
  UNIQUE KEY `UK_e8qusya39bxxipimwa4fcu768` (`s_sensor_fk`),
  KEY `FK_peomqc4rt1c74prkkejno7ia8` (`s_gateway_fk`),
  CONSTRAINT `FK_e8qusya39bxxipimwa4fcu768` FOREIGN KEY (`s_sensor_fk`) REFERENCES `s_sensors` (`id`),
  CONSTRAINT `FK_peomqc4rt1c74prkkejno7ia8` FOREIGN KEY (`s_gateway_fk`) REFERENCES `s_gateways` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
