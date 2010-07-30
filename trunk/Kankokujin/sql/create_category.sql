
DROP TABLE IF EXISTS t_category;
CREATE TABLE t_category (
  user_id varchar(20) NOT NULL DEFAULT '',
  code varchar(4) NOT NULL DEFAULT '',
  name varchar(200) NOT NULL DEFAULT '',
  level int(2) NOT NULL DEFAULT '0',
  orderNo int(3) NOT NULL DEFAULT '0',
  oya_code varchar(4) DEFAULT NULL,
  PRIMARY KEY (user_id,code)
) TYPE=MyISAM;


DROP TABLE IF EXISTS t_bookmark;
CREATE TABLE t_bookmark (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id varchar(20) NOT NULL DEFAULT '',
  code varchar(4) DEFAULT NULL,
  title varchar(200) DEFAULT NULL,
  url varchar(200) DEFAULT NULL,
  detail varchar(200) DEFAULT NULL,
  PRIMARY KEY (id)
) TYPE=MyISAM;
