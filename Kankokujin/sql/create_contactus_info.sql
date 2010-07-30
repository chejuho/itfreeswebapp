Drop table contactus_info;
CREATE TABLE contactus_info (
id int(10) NOT NULL auto_increment,
name varchar(255) default NULL,
email varchar(255) default NULL,
tel_no1_1 varchar(4) default NULL,
tel_no1_2 varchar(4) default NULL,
tel_no1_3 varchar(4) default NULL,
tel_no2_1 varchar(4) default NULL,
tel_no2_2 varchar(4) default NULL,
tel_no2_3 varchar(4) default NULL,
title varchar(255) default NULL,
detail_info text,
regist_date timestamp NOT NULL,
update_date timestamp NOT NULL,
deleteflg char(1) default '0',
PRIMARY KEY  (id)
) TYPE=MyISAM;