drop table eng_email_list;
CREATE TABLE `eng_email_list` (                               
            `id` int(10) NOT NULL auto_increment,             
            `code` int(1) NOT NULL default '0',               
            `initial` varchar(20) NOT NULL default '',        
            `name` varchar(255) NOT NULL default '',          
            `web_mail` varchar(255) NOT NULL default '',       
            `mobile_mail` varchar(255) NOT NULL default '',  
            `update_by_user_id` varchar(100) NOT NULL default '',                            
            `insert_date` date NOT NULL default '0000-00-00',  
            `update_date` date default NULL,                   
            `no_mail_flg` char(1) default NULL,                      
            PRIMARY KEY  (`id`)                               
          ) TYPE=MyISAM                                            
