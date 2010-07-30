
drop table inform;
create table inform (
	id int(10) NOT NULL AUTO_INCREMENT,
	title varchar(255) DEFAULT NULL,
	detail_info text,
	regist_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
);