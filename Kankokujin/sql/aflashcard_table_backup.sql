/*
SQLyog - Free MySQL GUI v5.19
Host - 5.1.37-community : Database - kankokujincom
*********************************************************************
Server version : 5.1.37-community
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `kankokujincom`;

USE `kankokujincom`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `M_category` */

DROP TABLE IF EXISTS `m_category`;
DROP TABLE IF EXISTS `M_category`;

CREATE TABLE `M_category` (
  `user_id` varchar(20) NOT NULL DEFAULT '',
  `code` varchar(4) NOT NULL DEFAULT '',
  `name` varchar(200) NOT NULL DEFAULT '',
  `level` int(2) NOT NULL DEFAULT '0',
  `orderNo` int(3) NOT NULL DEFAULT '0',
  `oya_code` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `M_category` */

insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('e_admin','0000','Decks',0,1,NULL);
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('j_admin','0000','全体',0,1,NULL);
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('j_admin','0001','英語',1,1,'0000');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('j_admin','0002','韓国語',1,2,'0000');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('j_admin','0003','中国語',1,3,'0000');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('j_admin','0004','その他',1,4,'0000');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0000','전체',0,1,NULL);
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0001','영어',1,1,'0000');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0002','일본어',1,2,'0000');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0003','중국어',1,3,'0000');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0004','기타',1,4,'0000');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0005','토익',2,1,'0001');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0006','토플',2,2,'0001');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0007','텝스',2,3,'0001');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0008','중고등학교',2,4,'0001');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin ','0009','JPT',2,1,'0002');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0010','JPLT1급',2,2,'0002');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0011','JPLT2급',2,3,'0002');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0012','초급',3,1,'0005');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0013','중급',3,2,'0005');
insert into `M_category` (`user_id`,`code`,`name`,`level`,`orderNo`,`oya_code`) values ('k_admin','0014','고급',2,3,'0005');

/*Table structure for table `M_questionGroup` */

DROP TABLE IF EXISTS `m_questiongroup`;
DROP TABLE IF EXISTS `M_questiongroup`;
DROP TABLE IF EXISTS `M_questionGroup`;

CREATE TABLE `M_questionGroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`group_id`,`question_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3885 DEFAULT CHARSET=utf8;

/*Data for the table `M_questiongroup` */



/*Table structure for table `M_questions` */

DROP TABLE IF EXISTS `m_questions`;
DROP TABLE IF EXISTS `M_questions`;

CREATE TABLE `M_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` text NOT NULL,
  `answer` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2902 DEFAULT CHARSET=utf8;

/*Data for the table `M_questions` */



/*Table structure for table `M_user` */

DROP TABLE IF EXISTS `m_user`;
DROP TABLE IF EXISTS `M_user`;

CREATE TABLE `M_user` (
  `user_id` varchar(20) NOT NULL,
  `password` varchar(41) NOT NULL,
  `userName` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `M_user` */

insert into `M_user` (`user_id`,`password`,`userName`) values ('e_admin','3322','eAdmin');
insert into `M_user` (`user_id`,`password`,`userName`) values ('j_admin','3322','jAdmin');
insert into `M_user` (`user_id`,`password`,`userName`) values ('k_admin','3322','kAdmin');

/*Table structure for table `M_user_question_groups` */

DROP TABLE IF EXISTS `M_user_question_groups`;

CREATE TABLE `M_user_question_groups` (
  `user_id` varchar(20) NOT NULL,
  `group_id` int(11) NOT NULL,
  `register_user_id` varchar(20) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `group_name` varchar(255) NOT NULL,
  `categoryCode` varchar(4) NOT NULL,
  `password` varchar(41) NOT NULL,
  PRIMARY KEY (`user_id`,`group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `M_user_question_groups` */
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
