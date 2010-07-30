Drop table t_gourmet_category;
CREATE TABLE t_gourmet_category (
cate_code_1 varchar(6)  default NULL,
cate_code_2 varchar(6)  default NULL,
category_name_1 varchar(255)  default NULL,
category_name_1_detail varchar(255)  ,
category_name_2 varchar(255)  default NULL,
category_name_2_detail varchar(255) ,
PRIMARY KEY  (cate_code_1,cate_code_2)
) TYPE=MyISAM;
