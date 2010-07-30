drop table realtag;
create table realtag (
 id int(3) NOT NULL auto_increment,     
 title varchar(255) not null,
 tag varchar(255) not null,
 sort char(1) not null,
 PRIMARY KEY (id)
);
