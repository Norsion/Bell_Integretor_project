--Документ

INSERT INTO doc VALUES(1,'2003-08-02',8);
INSERT INTO doc VALUES(2,'2005-11-20',11);
INSERT INTO doc VALUES(3,'2007-07-11',3);
INSERT INTO doc VALUES(4,'2001-12-07',2);
INSERT INTO doc VALUES(5,'2002-03-05',1);
INSERT INTO doc VALUES(6,'2004-05-15',1);
INSERT INTO doc VALUES(7,'2004-03-17',8);
INSERT INTO doc VALUES(8,'2003-02-24',8);

--тип документа

INSERT INTO docs VALUES(1, 'Свидетельство о рождении');
INSERT INTO docs VALUES(2, 'Военный билет');
INSERT INTO docs VALUES(2, 'Временное удостоверение, выданное взамен военного билета');
INSERT INTO docs VALUES(3, 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу');
INSERT INTO docs VALUES(4, 'Вид на жительство в Российской Федерации');
INSERT INTO docs VALUES(5, 'Удостоверение беженца');
INSERT INTO docs VALUES(6, 'Разрешение на временное проживание в Российской Федерации');
INSERT INTO docs VALUES(7, 'Свидетельство о предоставлении временного убежища на территории Российской Федерации');
INSERT INTO docs VALUES(8, 'Паспорт гражданина Российской Федерации');
INSERT INTO docs VALUES(9, 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');
INSERT INTO docs VALUES(10, 'Удостоверение личности военнослужащего Российской Федерации');
INSERT INTO docs VALUES(11, 'Иные документы');

--Страна

INSERT INTO countries values(1, 'Россия');
INSERT INTO countries values(2, 'Англия');
INSERT INTO countries values(3, 'Германия');



INSERT INTO organization VALUES(1,0,'FirstOrganization','ooo_FirstOrganization','24214124124','121412412421', 'ул.Московская 24','123321', true);
INSERT INTO organization VALUES(2,0,'SecondOrganization','ooo_SecondOrganization','87576775656','67909665474', 'ул.Чехова 32','321123', true);

--Организация

INSERT INTO office VALUES(11,0, 1, 'Главный офис', 'ул.Московская 24','123321', true);
INSERT INTO office VALUES(12,0, 1, 'Подразделение', 'ул.Мичурина 21','312311', true);

--Офис

INSERT INTO office VALUES(21,0, 1, 'Главный офис', 'ул.Чехова 32','321123', true);
INSERT INTO office VALUES(22,0, 1, 'Подразделение', 'ул.Мичурина 21','412323', true);

--сотрудник

INSERT INTO person VALUES(1,0,11,'Иван','Иванов','Иванович','Менеджер','89273453232',1,1,true);
INSERT INTO person VALUES(2,0,11,'Иван','Петров','Иванович','Бухгалтер','89273454242',2,2,true);

INSERT INTO person VALUES(3,0,12,'Николай','Васильев','Игоревич','Менеджер','89273344343',3,1,true);
INSERT INTO person VALUES(4,0,12,'Александр','Стреляев','Александрович','Менеджер','89277541122',4,3,true);

INSERT INTO person VALUES(5,0,21,'Максим','Сидоров','Юриевич','Менеджер','89273343311',5,3,true);
INSERT INTO person VALUES(6,0,21,'Юрий','Молчанин','Петрович','Менеджер','89271233222',6,2,true);

INSERT INTO person VALUES(7,0,22,'Евгений','Тровин','Александрович','Менеджер','89277678844',7,1,true);
INSERT INTO person VALUES(8,0,22,'Артём','Чалов','Евгениевич','Менеджер','89279976556',8,1,true);






