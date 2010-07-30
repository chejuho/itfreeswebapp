 Drop table t_area;
 CREATE TABLE t_area (area_code_1 varchar(2)  NOT NULL ,
 area_code_2 varchar(4)  NOT NULL , 
 area_name_1 varchar(200)  NOT NULL ,
 area_name_2 varchar(200)  NOT NULL , 
 PRIMARY KEY  (area_code_1,area_code_2)) TYPE=MyISAM;