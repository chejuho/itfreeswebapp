drop table member;
CREATE TABLE member (
user_id varchar(20) NOT NULL default '',
password varchar(41) default NULL,
tmppassword varchar(41) default NULL,
email1 varchar(100) default NULL,
email2 varchar(100) default NULL,
name varchar(100) default NULL,
telephone1 varchar(4) default NULL,
telephone2 varchar(4) default NULL,
telephone3 varchar(4) default NULL,
mobile1 varchar(4) default NULL,
mobile2 varchar(4) default NULL,
mobile3 varchar(4) default NULL,
address varchar(200) default NULL,
user_level char(1) default '0',
registnum varchar(20) NOT NULL default '',
registflg char(1) default '0',
deleteflg char(1) default '0',
PRIMARY KEY  (user_id)
) TYPE=InnoDB;