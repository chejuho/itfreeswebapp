Drop table hudousan_company;
CREATE TABLE hudousan_company (                                  
id int(10) NOT NULL auto_increment,
company_name varchar(255) NOT NULL default '',
license_no varchar(255) NOT NULL default '',
company_address varchar(255) NOT NULL default '',
company_telno varchar(255) NOT NULL default '',
user_id varchar(255) NOT NULL default '',
regist_date timestamp NOT NULL,
update_date timestamp NOT NULL,
read_count int(10) default '0',
deleteflg char(1) default '0',
PRIMARY KEY  (id)
) TYPE=MyISAM;