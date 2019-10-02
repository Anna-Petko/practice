CREATE TABLE IF NOT EXISTS Organization(
	id 			INTEGER 		NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name 		VARCHAR(100) 	NOT NULL,
	inn 		VARCHAR(100) 	NOT NULL,
	is_active 	TINYINT 		default 1,
	full_name 	VARCHAR(100) 	NOT NULL,
	kpp 		VARCHAR(100) 	NOT NULL,
	adress 		VARCHAR(100) 	NOT NULL,
	phone 		VARCHAR(100)
);
COMMENT ON TABLE Organization IS 'Организация';
