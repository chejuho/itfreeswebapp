drop table eigyou_email_list;
CREATE TABLE `eigyou_email_list` (                         
              `mail_id` int(5) NOT NULL auto_increment,         
              `company` varchar(200) NOT NULL default '',       
              `part_name` varchar(200) NOT NULL default '',     
              `view_to_name` varchar(200) NOT NULL default '',  
              `to_name` varchar(200) NOT NULL default '',       
              `to_mail` varchar(200) NOT NULL default '',       
              `flag` int(1) NOT NULL default '0',               
              PRIMARY KEY  (`mail_id`)                          
            ) TYPE=MyISAM   