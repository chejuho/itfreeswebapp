Drop table t_cate;
CREATE TABLE t_cate (
code char(3) default NULL,
kana_name varchar(200) default NULL,
kanji_name varchar(200) default NULL,
sortcode varchar(2) default NULL,
oya_code varchar(3) default NULL,
PRIMARY KEY (code,sortcode)
) TYPE=MyISAM;

Drop table t_areainfo;
CREATE TABLE t_areainfo (
zipcode varchar(7) default NULL,
kana_name varchar(200) default NULL,
kanji_name varchar(200) default NULL,
sortcode varchar(2) default NULL,
oya_code varchar(3) default NULL,
PRIMARY KEY (zipcode)
) TYPE=MyISAM;

Drop table t_stationinfo;
CREATE TABLE t_stationinfo (
  station_kana_name varchar(200) DEFAULT NULL,
  station_kanji_name varchar(200) DEFAULT NULL,
  sortcode varchar(2) default NULL,
  oya_code varchar(3) default NULL,
  PRIMARY KEY (linecode,stationcode)
)  TYPE=MyISAM;