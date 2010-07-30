  Drop table t_comunication;
  CREATE TABLE `t_comunication` (
                `id` int(10) NOT NULL auto_increment,
		`ip_address` varchar(155) NOT NULL default '',                   
                `regist_date` timestamp(14) NOT NULL,              
		PRIMARY KEY  (`id`)                     
        ) TYPE=MyISAM;                           