drop table usa_stock;
CREATE TABLE `usa_stock` (                           
           `stock_id` int(255) NOT NULL auto_increment,       
           `stock_price` varchar(11) NOT NULL,                        
           `stock_time` varchar(10) NOT NULL,  
           `regist_date` timestamp(14) default NULL,                                    
           PRIMARY KEY  (`stock_id`)                          
         ) TYPE=MyISAM 