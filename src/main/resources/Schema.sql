CREATE TABLE IF NOT EXISTS organization (
    id            INTEGER   NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER      NOT NULL COMMENT 'Служебное поле hibernate' ,
    name VARCHAR(50)        NOT NULL COMMENT 'Наименование организации',
    fullName VARCHAR(50)    NOT NULL COMMENT 'Полное Наименование огранизации',
    inn VARCHAR(50)         NOT NULL COMMENT 'ИНН',
    kpp VARCHAR(50)         NOT NULL COMMENT 'КПП',
    address VARCHAR(50)     NOT NULL COMMENT 'Адрес организации',
    phone VARCHAR(50)       NOT NULL COMMENT 'Телефон организации',
    isActive BOOLEAN        NOT NULL COMMENT 'Активность'
);

CREATE TABLE IF NOT EXISTS office (
    id         INTEGER      NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    organization_id       INTEGER     NOT NULL COMMENT 'Идентификатор организации',
    name    VARCHAR(50)     NOT NULL COMMENT 'наименование офиса',
    address VARCHAR(50)     NOT NULL COMMENT 'Адрес офиса',
    phone   VARCHAR(50)     NOT NULL COMMENT 'Телефон офиса',
    isActive BOOLEAN        NOT NULL COMMENT 'Активность'
);

CREATE TABLE IF NOT EXISTS person (
    id  INTEGER                 NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER          NOT NULL COMMENT 'Служебное поле hibernate',
    office_id         INTEGER   NOT NULL COMMENT 'Идентификатор офиса',
    firstName VARCHAR(50)       NOT NULL COMMENT 'Имя',
    secondName    VARCHAR(50)   NOT NULL COMMENT 'Фамилия',
    middleName VARCHAR(50)      NOT NULL COMMENT 'Отчество',
    position VARCHAR(50)        NOT NULL COMMENT 'Должность',
    phone VARCHAR(50)           NOT NULL COMMENT 'Телефон',
    docNumber INTEGER           NOT NULL COMMENT 'Номер документа',
    countries_id INTEGER        NOT NULL COMMENT 'Код страны',
    isIdentified BOOLEAN        NOT NULL COMMENT 'Проверка'


);

CREATE TABLE IF NOT EXISTS doc (
    id      INTEGER  NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    code    INTEGER  NOT NULL COMMENT 'Код документа' ,
    docDate DATE     NOT NULL COMMENT 'Дата выдачи документа',
    docs_id INTEGER  NOT NULL COMMENT 'Внешний ключ на тип документа'
);

CREATE TABLE IF NOT EXISTS docs (
   id   INTEGER        NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
   code INTEGER        NOT NULL COMMENT 'Код типа документа'  ,
   name VARCHAR(150)    NOT NULL COMMENT 'Наименование документа'
);
--здесь типы докуметов

CREATE TABLE IF NOT EXISTS countries (
    id      INTEGER  NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    code    INTEGER  NOT NULL COMMENT 'Код страны' ,
    name VARCHAR(150) NOT NULL COMMENT 'Наименование страны'
);


CREATE INDEX I_organization_id ON office (organization_id);
CREATE INDEX I_office_id ON person (office_id);
CREATE INDEX I_countries_id ON person (countries_id);
CREATE INDEX I_docNumber ON person (docNumber);


ALTER TABLE office ADD FOREIGN KEY (organization_id) REFERENCES organization(id);
ALTER TABLE person ADD FOREIGN KEY (office_id) REFERENCES office(id);
ALTER TABLE person ADD FOREIGN KEY (countries_id) REFERENCES countries(id);
ALTER TABLE person ADD FOREIGN KEY (docNumber) REFERENCES  doc(id);
ALTER TABLE doc ADD FOREIGN KEY (docs_id) REFERENCES docs(id);





