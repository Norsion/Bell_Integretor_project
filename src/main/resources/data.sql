--тип документа

INSERT INTO typeofdocument VALUES(1,03, 'Свидетельство о рождении');
INSERT INTO typeofdocument VALUES(2,07, 'Военный билет');
INSERT INTO typeofdocument VALUES(3,08, 'Временное удостоверение, выданное взамен военного билета');
INSERT INTO typeofdocument VALUES(4,10, 'Паспорт иностранного гражданина');
INSERT INTO typeofdocument VALUES(5,11, 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу');
INSERT INTO typeofdocument VALUES(6,12, 'Вид на жительство в Российской Федерации');
INSERT INTO typeofdocument VALUES(7,13, 'Удостоверение беженца');
INSERT INTO typeofdocument VALUES(8,15, 'Разрешение на временное проживание в Российской Федерации');
INSERT INTO typeofdocument VALUES(9,18, 'Свидетельство о предоставлении временного убежища на территории Российской Федерации');
INSERT INTO typeofdocument VALUES(10,21,'Паспорт гражданина Российской Федерации');
INSERT INTO typeofdocument VALUES(11,23,'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');
INSERT INTO typeofdocument VALUES(12,24,'Удостоверение личности военнослужащего Российской Федерации');
INSERT INTO typeofdocument VALUES(13,91,'Иные документы');

--Документ

INSERT INTO document VALUES(1,6112,'2003-08-02',10);
INSERT INTO document VALUES(2,6122,'2005-11-20',10);
INSERT INTO document VALUES(3,3212,'2007-07-11',4);
INSERT INTO document VALUES(4,4321,'2001-12-07',4);
INSERT INTO document VALUES(5,2718,'2002-03-05',1);
INSERT INTO document VALUES(6,9275,'2004-05-15',1);
INSERT INTO document VALUES(7,6947,'2004-03-17',8);
INSERT INTO document VALUES(8,2766,'2003-02-24',8);

--Страна

INSERT INTO countries values(1,643, 'Россия');
INSERT INTO countries values(2,826, 'Англия');
INSERT INTO countries values(3,276, 'Германия');



INSERT INTO organization VALUES(1,0,'FirstOrganization','ooo_FirstOrganization','24214124124','121412412421', 'ул.Московская 24','123321', true);
INSERT INTO organization VALUES(2,0,'SecondOrganization','ooo_SecondOrganization','87576775656','67909665474', 'ул.Чехова 32','321123', true);

--Организация

INSERT INTO office VALUES(11,0, 1, 'Главный офис', 'ул.Московская 24','123321', true);
INSERT INTO office VALUES(12,0, 1, 'Подразделение', 'ул.Мичурина 21','312311', true);

--Офис

INSERT INTO office VALUES(21,0, 2, 'Главный офис', 'ул.Чехова 32','321123', true);
INSERT INTO office VALUES(22,0, 2, 'Подразделение', 'ул.Мичурина 21','412323', true);

--сотрудник

INSERT INTO person VALUES(1,0,11,'Иван','Иванов','Иванович','Менеджер','89273453232',1,1,true);
INSERT INTO person VALUES(2,0,11,'Иван','Петров','Иванович','Бухгалтер','89273454242',2,2,true);

INSERT INTO person VALUES(3,0,12,'Николай','Васильев','Игоревич','Менеджер','89273344343',3,1,true);
INSERT INTO person VALUES(4,0,12,'Александр','Стреляев','Александрович','Менеджер','89277541122',4,3,true);

INSERT INTO person VALUES(5,0,21,'Максим','Сидоров','Юриевич','Менеджер','89273343311',5,3,true);
INSERT INTO person VALUES(6,0,21,'Юрий','Молчанин','Петрович','Менеджер','89271233222',6,2,true);

INSERT INTO person VALUES(7,0,22,'Евгений','Тровин','Александрович','Менеджер','89277678844',7,1,true);
INSERT INTO person VALUES(8,0,22,'Артём','Чалов','Евгениевич','Менеджер','89279976556',8,1,true);






