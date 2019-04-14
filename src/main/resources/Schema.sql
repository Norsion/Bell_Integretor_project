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
    orgId       INTEGER     NOT NULL COMMENT 'Идентификатор организации',
    name    VARCHAR(50)     NOT NULL COMMENT 'наименование офиса',
    address VARCHAR(50)     NOT NULL COMMENT 'Адрес офиса',
    phone   VARCHAR(50)     NOT NULL COMMENT 'Телефон офиса',
    isActive BOOLEAN        NOT NULL COMMENT 'Активность'
);

CREATE TABLE IF NOT EXISTS person (
    id  INTEGER                 NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER          NOT NULL COMMENT 'Служебное поле hibernate',
    officeId         INTEGER    NOT NULL COMMENT 'Идентификатор офиса',
    firstName VARCHAR(50)       NOT NULL COMMENT 'Имя',
    secondName    VARCHAR(50)   NOT NULL COMMENT 'Фамилия',
    middleName VARCHAR(50)      NOT NULL COMMENT 'Отчество',
    position VARCHAR(50)        NOT NULL COMMENT 'Должность',
    phone VARCHAR(50)           NOT NULL COMMENT 'Телефон',
    docNumber INTEGER           NOT NULL COMMENT 'Номер документа',
    counties_id INTEGER         NOT NULL COMMENT 'Код страны',
    isIdentified BOOLEAN        NOT NULL COMMENT 'Проверка'


);

CREATE TABLE IF NOT EXISTS doc (
    code    INTEGER  NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    docDate DATE     NOT NULL COMMENT 'Дата выдачи документа',
    docs_id INTEGER  NOT NULL COMMENT 'Внешний ключ на тип документа'
);

CREATE TABLE IF NOT EXISTS docs(
    code INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name VARCHAR(150) NOT NULL UNIQUE COMMENT 'Наименование документа'
);
--здесь типы докуметов

CREATE TABLE IF NOT EXISTS countries(
    code INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name VARCHAR(150) NOT NULL UNIQUE COMMENT 'Наименование страны'
);


CREATE INDEX I_orgIdId ON office (orgId);
CREATE INDEX I_officeId ON person (officeId);


ALTER TABLE office ADD FOREIGN KEY (orgId) REFERENCES organization(id);
ALTER TABLE person ADD FOREIGN KEY (officeId) REFERENCES office(id);
ALTER TABLE person ADD FOREIGN KEY (counties_id) REFERENCES countries(code);
ALTER TABLE person ADD FOREIGN KEY (docNumber) REFERENCES  doc(code);
ALTER TABLE doc ADD FOREIGN KEY (doc_id) REFERENCES docs(code);





