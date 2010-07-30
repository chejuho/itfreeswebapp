        
c:\mysql\bin>mysqld-nt --install

c:\mysql\bin>NET start mysql 

rootのパスワ?ド変更

create database kankokujincom;
mysql -u root mysql
mysql> UPDATE user SET Password=PASSWORD('itfrees747') WHERE user='root';
mysql> FLUSH PRIVILEGES;                       