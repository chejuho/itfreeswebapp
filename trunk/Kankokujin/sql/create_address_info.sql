Drop table address_info;
CREATE TABLE address_info (
id int(11) NOT NULL auto_increment,
zipcode char(7) default NULL,
address_kana varchar(255) default NULL,
address_kanji varchar(255) default NULL,
PRIMARY KEY (id)
) TYPE=MyISAM;
