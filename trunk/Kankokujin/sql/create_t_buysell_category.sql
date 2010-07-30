Drop table t_buysell_category;
CREATE TABLE t_buysell_category (
cate_code_1 varchar(6)  NOT NULL ,
cate_code_2 varchar(6)  NOT NULL ,
category_name_1 varchar(255)  NOT NULL ,
category_name_1_detail varchar(255)  NOT NULL ,
category_name_2 varchar(255)  NOT NULL ,
category_name_2_detail varchar(255)  NOT NULL ,
PRIMARY KEY  (cate_code_1,cate_code_2)
) TYPE=MyISAM;
