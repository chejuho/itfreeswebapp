drop table eng_email;
CREATE TABLE `eng_email` (                                         
            `mail_id` int(11) NOT NULL auto_increment,                      
            `title` varchar(255) NOT NULL default '',                       
            `to_mail_list` text NOT NULL,                                       
            `contents` text NOT NULL,                                                   
            `insert_date` datetime NOT NULL default '0000-00-00 00:00:00',  
            `update_date` datetime NOT NULL default '0000-00-00 00:00:00',  
            `update_by_user_id` varchar(100) NOT NULL default '',           
            PRIMARY KEY  (`mail_id`)                                        
          ) TYPE=MyISAM  