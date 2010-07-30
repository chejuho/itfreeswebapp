Drop table mainstockinfo;
CREATE TABLE `mainstockinfo` (                 
             `idx` int(5) NOT NULL auto_increment,    
             `nikkei_aver` varchar(50) NOT NULL default '',   
             `nikkei_plus` varchar(50) default NULL,     
             `jasdaq_aver` varchar(50) default NULL,  
             `jasdaq_plus` varchar(50) default NULL,         
             `dau_aver` varchar(50) default NULL,          
             `dau_plus` varchar(50) default NULL,   
             `kosdaq_aver` varchar(50) default NULL,    
             `kosdaq_plus` varchar(50) default NULL,     
             `stockdate` varchar(30) default NULL,    
             PRIMARY KEY  (`idx`)              
           )                          