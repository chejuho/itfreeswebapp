        
c:\mysql\bin>mysqld-nt --install

c:\mysql\bin>NET start mysql 

root�̃p�X��?�h�ύX

create database kankokujincom;
mysql -u root mysql
mysql> UPDATE user SET Password=PASSWORD('itfrees747') WHERE user='root';
mysql> FLUSH PRIVILEGES;                       