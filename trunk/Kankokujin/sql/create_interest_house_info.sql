 drop table interest_house_info;
 CREATE TABLE `interest_house_info` (         
                       `user_id` varchar(20) default NULL,        
                       `house_info_id` int(100) default NULL,  
                       `insert_date` date default NULL,           
                       `deleteflg` char(1) default '0',
                       PRIMARY KEY  (`user_id`,`house_info_id`)           
                     ) TYPE=MyISAM   