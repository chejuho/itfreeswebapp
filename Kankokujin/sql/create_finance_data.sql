drop table finance_data;
CREATE TABLE `finance_data` (                           
           `finance_data_id` int(255) NOT NULL auto_increment,       
           `usd_yen_buy_price` varchar(6) NOT NULL,                        
           `usd_yen_sell_price` varchar(6) NOT NULL,                                   
           `usd_yen_time` varchar(200) NOT NULL,
           `usd_stock_point` varchar(11) NOT NULL,                        
           `usd_stock_time` varchar(10) NOT NULL,              
           `regist_date` timestamp(14) default NULL,  
           PRIMARY KEY  (`finance_data_id`)                          
         ) TYPE=MyISAM 