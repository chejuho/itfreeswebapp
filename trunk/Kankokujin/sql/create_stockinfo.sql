Drop table stockinfo;
CREATE TABLE `stockinfo` (                 
             `idx` int(5) NOT NULL auto_increment,    
             `code` varchar(4) NOT NULL default '',   
             `endprice` varchar(50) default NULL,     
             `compareyest` varchar(50) default NULL,  
             `sell` varchar(50) default NULL,         
             `buy` varchar(50) default NULL,          
             `startprice` varchar(50) default NULL,   
             `highprice` varchar(50) default NULL,    
             `lowprice` varchar(50) default NULL,     
             `stockdate` varchar(30) default NULL,    
             PRIMARY KEY  (`idx`,`code`)              
           )   
           
CREATE TABLE `newstockinfo` (                 
             `idx` int(5) NOT NULL auto_increment,    
             `code` varchar(4) NOT NULL default '',   
             `endprice` varchar(50) default NULL,     
             `compareyest` varchar(50) default NULL,  
             `sell` varchar(50) default NULL,         
             `buy` varchar(50) default NULL,          
             `startprice` varchar(50) default NULL,   
             `highprice` varchar(50) default NULL,    
             `lowprice` varchar(50) default NULL,     
             `stockdate` varchar(30) default NULL,    
             PRIMARY KEY  (`idx`,`code`)              
           )                                 