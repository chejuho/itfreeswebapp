DELIMITER $$
DROP FUNCTION IF EXISTS itfreescom.getCodeFullName$$
CREATE FUNCTION itfreescom.getCodeFullName(in_code VARCHAR(3)) RETURNS VARCHAR(100)	
	BEGIN
		DECLARE fullName VARCHAR(100);	
		DECLARE all_code VARCHAR(100);
		SET all_code = getFullCode(in_code);
		SET fullName = getCodeName(all_code);
		RETURN fullName;
	END$$
DELIMITER ;

DELIMITER $$
DROP FUNCTION itfreescom.getCodeName$$		
CREATE FUNCTION itfreescom.getCodeName(in_code VARCHAR(15)) RETURNS VARCHAR(255)	
	BEGIN	
	
		DECLARE out_name VARCHAR(255);
		DECLARE temp_name VARCHAR(20);
		DECLARE code_length INT;
		DECLARE code_number INT;
		DECLARE _index INT;
		
		SET out_name = '';
		SET code_length = length(in_code);
		SET code_number = code_length / 3;
		SET _index = 0;
		
		
		WHILE _index < code_number do 
		    SELECT kanji_name INTO temp_name FROM t_category_info WHERE code = SUBSTRING(in_code,code_length - 2, 3);
		    SET out_name = CONCAT(out_name, temp_name);
		 SET code_length = code_length - 3;	
		 SET _index = _index + 1;
		END WHILE;
		
		RETURN out_name;
	END$$
DELIMITER ;

DELIMITER $$
DROP FUNCTION itfreescom.getFullCode$$				
CREATE FUNCTION itfreescom.getFullCode(in_code VARCHAR(3)) RETURNS VARCHAR(100)	
	BEGIN	
		DECLARE out_code VARCHAR(100);
		DECLARE _oya_code VARCHAR(3);
		SET out_code = in_code;
		SELECT oyacode INTO _oya_code FROM t_category_relation_info WHERE code = in_code;
		SET out_code = CONCAT(out_code,_oya_code);
		WHILE _oya_code != null do 
		    SELECT oyacode INTO _oya_code FROM t_category_relation_info WHERE code = _oya_code;
		    SET out_code = CONCAT(out_code,_oya_code);
		END WHILE;
		RETURN out_code;
	END$$	
DELIMITER ;