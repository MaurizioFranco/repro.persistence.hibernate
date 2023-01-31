--drop database cerepro_dev;
--create database cerepro_dev;
--GRANT ALL PRIVILEGES ON cerepro_dev.* TO 'cerepro_dev'@'%' IDENTIFIED BY 'cerepro_dev' WITH GRANT OPTION;
--FLUSH PRIVILEGES;

--drop database cerepro_test;
--create database cerepro_test;
--GRANT ALL PRIVILEGES ON cerepro_test.* TO 'cerepro_test'@'%' IDENTIFIED BY 'cerepro_test' WITH GRANT OPTION;
--FLUSH PRIVILEGES;

--drop database cerepro_stage;
--create database cerepro_stage;
--GRANT ALL PRIVILEGES ON cerepro_stage.* TO 'cerepro_stage'@'%' IDENTIFIED BY 'cerepro_stage' WITH GRANT OPTION;
--FLUSH PRIVILEGES;


drop database IF EXISTS  academyfs07_dev;
create database academyfs07_dev;
CREATE USER 'acfs07_dev'@'%' IDENTIFIED BY 'acfs07_dev';
GRANT ALL PRIVILEGES ON academyfs07_dev.* TO 'acfs07_dev'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

drop database IF EXISTS  academyfs07_test;
create database academyfs07_test;
CREATE USER 'acfs07_test'@'%' IDENTIFIED BY 'acfs07_test';
GRANT ALL PRIVILEGES ON academyfs07_dev.* TO 'acfs07_test'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

drop database IF EXISTS  academyfs07_stage;
create database academyfs07_stage;
CREATE USER 'acfs07_stage'@'%' IDENTIFIED BY 'acfs07_stage';
GRANT ALL PRIVILEGES ON academyfs07_stage.* TO 'acfs07_stage'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
