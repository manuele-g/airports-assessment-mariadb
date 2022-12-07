--------------- as ROOT user ---------------------

CREATE DATABASE ASSESSMENTDB CHARACTER SET utf8 COLLATE utf8_unicode_ci;

CREATE USER 'DEVELOPER' IDENTIFIED BY '**choose-your-password**';

GRANT USAGE ON *.* TO 'DEVELOPER'@'%' IDENTIFIED BY '**choose-your-password**';

GRANT ALL PRIVILEGES ON ASSESSMENTDB.* TO 'DEVELOPER'@'%';

FLUSH PRIVILEGES;