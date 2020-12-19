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
