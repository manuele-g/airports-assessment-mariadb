
CREATE TABLE `Countries` (
  `id` bigint(20) NOT NULL,
  `code` varchar(50) NOT NULL,
  `name` varchar(200) NOT NULL,
  `continent` varchar(50) NOT NULL,
  `wikipedia_link` varchar(200) NOT NULL,
  `keywords` varchar(200) NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `code_un` (`code`),
   UNIQUE KEY `name_un` (`name`),
   INDEX `code_name_un_idx` (`name`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

CREATE TABLE `Airports` (
  `id` bigint(20) NOT NULL,
  `ident` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `name` varchar(200) NOT NULL,
  `latitude_deg` double NOT NULL,
  `longitude_deg` double NOT NULL,
  `elevation_ft` int(11) NULL,
  `continent` varchar(50) NOT NULL,
  `iso_country` varchar(50) NOT NULL,
  `iso_region` varchar(50) NOT NULL,
  `municipality` varchar(50) NOT NULL,
  `scheduled_service` varchar(50) NOT NULL,
  `gps_code` varchar(50) NULL,
  `iata_code` varchar(50) NULL,
  `local_code` varchar(50) NULL,
  `home_link` varchar(200) NULL,
  `wikipedia_link` varchar(200) NULL,
  `keywords` varchar(300) NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY `ident_un` (`ident`),
	CONSTRAINT `fk_countries` FOREIGN KEY (iso_country) REFERENCES Countries (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;


CREATE TABLE `Runways` (
  `id` bigint(20) NOT NULL,
  `airport_ref` bigint(20) NOT NULL,
  `airport_ident` varchar(50) NOT NULL,
  `length_ft` int(11) NULL,
  `width_ft` int(11) NULL,
  `surface` varchar(100) NOT NULL,
  `lighted` tinyint(1) NOT NULL,
  `closed` tinyint(1) NOT NULL,
  `le_ident` varchar(50) NOT NULL,
  `le_latitude_deg` double NULL,
  `le_longitude_deg` double NULL,
  `le_elevation_ft` int(11) NULL,
  `le_heading_degT` int(11) NULL,
  `le_displaced_threshold_ft` int(11) NULL,
  `he_ident` varchar(50) NULL,
  `he_latitude_deg` double NULL,
  `he_longitude_deg` double NULL,
  `he_elevation_ft` int(11) NULL,
  `he_heading_degT` int(11) NULL,
  `he_displaced_threshold_ft` int(11) NULL,
   PRIMARY KEY (`id`),
   CONSTRAINT `fk_airports` FOREIGN KEY (airport_ref) REFERENCES Airports (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;