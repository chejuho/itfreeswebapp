Drop table iboard_info;
CREATE TABLE iboard_info (
id int(11) NOT NULL auto_increment,
title varchar(255) default NULL,
pass_word varchar(41) default NULL,
content text NOT NULL,
file_name1 varchar(255) default '',
file_name2 varchar(255) default '',
file_name3 varchar(255) default '',                          
board_id varchar(255) NOT NULL,
user_name varchar(255) NOT NULL,
regist_date timestamp NOT NULL,
update_date timestamp NOT NULL,   
read_count int(4) NOT NULL,
PRIMARY KEY  (id)
) TYPE=MyISAM;

Drop table board;
CREATE TABLE board (
board_id varchar(255) NOT NULL,
board_name varchar(255) NOT NULL,
PRIMARY KEY  (board_id)
) TYPE=MyISAM;                    