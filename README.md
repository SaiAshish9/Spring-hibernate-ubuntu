https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04 <br/>
https://www.youtube.com/watch?v=IWXQeXHDerg <br/>
Go to app store.
Search for mysql-workbench.
Click on permission.
Enable Read, add, change, or remove saved password̀s
<br/>
CREATE USER 'hbstudent'@'localhost' IDENTIFIED BY 'hbstudent';
<br/>
GRANT ALL PRIVILEGES ON * . * TO 'hbstudent'@'localhost';
<br/>
ALTER USER 'hbstudent'@'localhost' IDENTIFIED WITH mysql_native_password BY 'hbstudent';
<br/>
CREATE DATABASE  IF NOT EXISTS `hb_student_tracker`;
USE `hb_student_tracker`;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

