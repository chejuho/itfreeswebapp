drop table email;
create table email (
 id int(3) NOT NULL auto_increment,     
 email_sort int(1) not null,
 title varchar(255),
 contents text,
 PRIMARY KEY (id)
);
