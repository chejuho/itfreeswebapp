drop table kawase;
CREATE TABLE `kawase` (                           
           `fx_id` int(255) NOT NULL auto_increment,       
           `buy_price` varchar(6) NOT NULL,                        
           `sell_price` varchar(6) NOT NULL,                                   
           `stock_date` varchar(200) NOT NULL,
           `regist_date` timestamp(14) default NULL,  
           PRIMARY KEY  (`fx_id`)                          
         ) TYPE=MyISAM 