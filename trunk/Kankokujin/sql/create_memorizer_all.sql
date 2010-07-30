Drop table M_questions;
CREATE TABLE M_questions (
	id int(11) NOT NULL auto_increment,
	question text NOT NULL,
	answer text NOT NULL,
	PRIMARY KEY  (id)
) TYPE=MyISAM;

Drop table M_questionGroup;
CREATE TABLE M_questionGroup (
	group_id int(11) NOT NULL,
	question_id int(11) NOT NULL
	PRIMARY KEY  (group_id, question_id)
) TYPE=MyISAM; 

drop table M_user_question_groups;
CREATE TABLE M_user_question_groups (
  user_id varchar(20) NOT NULL,
  user_name varchar(255) NOT NULL,
  group_id int(11) NOT NULL,
  group_name varchar(255) NOT NULL,
  categoryCode varchar(4) NOT NULL,
  password varchar(41) NOT NULL,
  PRIMARY KEY (user_id,group_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


Drop table M_category;
CREATE TABLE M_category (
  user_id varchar(20) NOT NULL DEFAULT '',
  code varchar(4) NOT NULL DEFAULT '',
  name varchar(200) NOT NULL DEFAULT '',
  level int(2) NOT NULL DEFAULT '0',
  orderNo int(3) NOT NULL DEFAULT '0',
  oya_code varchar(4) DEFAULT NULL,
  PRIMARY KEY (user_id,code)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

drop table M_user;
CREATE TABLE M_user (
user_id varchar(20) NOT NULL ,
password varchar(41) NOT NULL,
userName varchar(255) NOT NULL,
PRIMARY KEY  (user_id)
) TYPE=InnoDB; 


drop table M_progress_info;
CREATE TABLE M_progress_info (
user_id varchar(20) NOT NULL default '',
group_id int(11) NOT NULL,
question_id int(11) default NULL,
memory_sign int(1) NOT NULL default NULL,
quiz_sign int(1) NOT NULL default NULL
PRIMARY KEY  (user_id)
) TYPE=InnoDB; 


drop table M_user_setting;
CREATE TABLE M_user_setting (
user_id varchar(20) NOT NULL default '',
group_id int(11) NOT NULL,
fontsize int(11) default NULL,
slide_time int(1) NOT NULL default NULL,
order int(1) NOT NULL default NULL,
display_mode int(1) NOT NULL default NULL,
display_option int(1) NOT NULL default NULL,
index int(1) NOT NULL default NULL,
PRIMARY KEY  (user_id)
) TYPE=InnoDB; 




          