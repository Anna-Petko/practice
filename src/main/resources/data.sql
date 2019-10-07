INSERT INTO Organization (name, inn, is_active, full_name, kpp, adress, phone)
	VALUES ('Egmond','123456789000',0,'OOO Egmond Publishing','123456789','Москва, ул. Ленина, д. 5','+78453488921');
  
INSERT INTO Organization (name, inn, is_active, full_name, kpp, adress, phone)
	VALUES ('Optimus','123456789111',1,'OOO Optimus AB','123456897','Москва, ул. Удальцова, д. 21','+78452655341');

INSERT INTO Organization (name, inn, is_active, full_name, kpp, adress, phone)
	VALUES ('ITConsulting','123456789555',1,'OOO ITConsulting','123456928','Москва, ул. Машкова, д. 2','+78452781883');
	
INSERT INTO Document (code, name)
	VALUES ('03', 'Свидетельство о рождении');
INSERT INTO Document (code, name) 
	VALUES ('07', 'Военный билет');
INSERT INTO Document (code, name) 
	VALUES ('08', 'Временное удостоверение, выданное вместо военного билета');
INSERT INTO Document (code, name) 
	VALUES ('10', 'Паспорт иностранного гражданина');
INSERT INTO Document (code, name) 
	VALUES ('11', 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу');
INSERT INTO Document (code, name) 
	VALUES ('12', 'Вид на жительство в Российской Федерации');
INSERT INTO Document (code, name) 
	VALUES ('13', 'Удостоверение беженца');
INSERT INTO Document (code, name) 
	VALUES ('15', 'Разрешение на временное проживание в Российской Федерации');
INSERT INTO Document (code, name) 
	VALUES ('18', 'Свидетельство о предоставлении временного убежища на территории Российской Федерации');
INSERT INTO Document (code, name) 
	VALUES ('21', 'Паспорт гражданина Российской Федерации');
INSERT INTO Document (code, name) 
	VALUES ('23', 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');
INSERT INTO Document (code, name) 
	VALUES ('24', 'Удостоверение личности военнослужащего Российской Федерации');
INSERT INTO Document (code, name) 
	VALUES ('91', 'Иные документы');
	
INSERT INTO Country (name, code) 
	VALUES ('Российская Федерация', '643');
INSERT INTO Country (name, code) 
	VALUES ('Греческая Республика', '300');
INSERT INTO Country (name, code) 
	VALUES ('Германия', '246');
	