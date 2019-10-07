CREATE TABLE IF NOT EXISTS Organization(
	id 					INTEGER 		NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name 				VARCHAR(100) 	NOT NULL,
	inn 				VARCHAR(100) 	NOT NULL,
	is_active 			TINYINT 		default 1,
	full_name 			VARCHAR(100) 	NOT NULL,
	kpp 				VARCHAR(100) 	NOT NULL,
	address 			VARCHAR(100) 	NOT NULL,
	phone 				VARCHAR(100)
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Document(
	id					INTEGER			NOT NULL PRIMARY KEY AUTO_INCREMENT,
    code 				VARCHAR(50) 	NOT NULL,
    name 				VARCHAR(150) 	NOT NULL 
);
COMMENT ON TABLE Document IS 'Тип документа';

CREATE TABLE IF NOT EXISTS Country(
	id					INTEGER			NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name 				VARCHAR(50) 	NOT NULL,
    code 				VARCHAR(50) 	NOT NULL 
);
COMMENT ON TABLE Country IS 'Страна';

CREATE TABLE IF NOT EXISTS Office(
	id					INTEGER			NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name 				VARCHAR(100) 	NOT NULL,
    address 			VARCHAR(100) 	NOT NULL,
   	phone       		VARCHAR(100),          
    organization_id 	INTEGER    		NOT NULL,
    is_active 			TINYINT 		default 1,
    FOREIGN KEY (organization_id) REFERENCES Organization(id) 
   
);
COMMENT ON TABLE Office IS 'Офис';