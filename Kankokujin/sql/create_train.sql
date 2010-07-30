Drop table t_train;
CREATE TABLE t_train (
station_code varchar(4)  NOT NULL ,
station_kanji varchar(200)  NOT NULL ,
station_kana varchar(200)  ,
line_code varchar(2)  NOT NULL ,
line_kanji varchar(200)  NOT NULL ,
line_kana varchar(200) ,
PRIMARY KEY  (station_code)
) TYPE=MyISAM;
