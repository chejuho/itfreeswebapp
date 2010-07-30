Drop table notice;
CREATE TABLE notice (
id int(10) NOT NULL auto_increment,
title varchar(255) default NULL,
detail_info text default NULL,
regist_date timestamp NOT NULL
PRIMARY KEY  (id)
) TYPE=MyISAM;
