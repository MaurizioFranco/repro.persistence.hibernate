drop database cerepro_dev;
create database cerepro_dev;
GRANT ALL PRIVILEGES ON cerepro_dev.* TO 'cerepro_dev'@'%' IDENTIFIED BY 'cerepro_dev' WITH GRANT OPTION;
FLUSH PRIVILEGES;

drop database cerepro_test;
create database cerepro_test;
GRANT ALL PRIVILEGES ON cerepro_test.* TO 'cerepro_test'@'%' IDENTIFIED BY 'cerepro_test' WITH GRANT OPTION;
FLUSH PRIVILEGES;

drop database cerepro_stage;
create database cerepro_stage;
GRANT ALL PRIVILEGES ON cerepro_stage.* TO 'cerepro_stage'@'%' IDENTIFIED BY 'cerepro_stage' WITH GRANT OPTION;
FLUSH PRIVILEGES;
