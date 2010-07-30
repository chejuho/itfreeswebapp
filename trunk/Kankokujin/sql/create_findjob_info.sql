Drop table findjob_info;
CREATE TABLE findjob_info (
id int(11) NOT NULL auto_increment,
user_id varchar(40) default NULL,
title varchar(255) default NULL,
tel_no1_1 varchar(4) default NULL,
tel_no1_2 varchar(4) default NULL,
tel_no1_3 varchar(4) default NULL,
tel_no2_1 varchar(4) default NULL,
tel_no2_2 varchar(4) default NULL,
tel_no2_3 varchar(4) default NULL,
email varchar(255) default NULL,
work_sort int(1) default NULL,
birthday varchar(10) default NULL,
sex int(1) default NULL,
appeal_point text default NULL,
detail_info text default NULL,
regist_date timestamp NOT NULL,
update_date timestamp NOT NULL,
read_count int(100) default NULL,
deleteflg char(1) default '0',
PRIMARY KEY  (id)
)TYPE=MyISAM;