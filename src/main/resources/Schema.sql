CREATE TABLE IF NOT EXISTS organization (
    id            INTEGER  NOT NULL    COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL COMMENT 'Имя',
    fullName VARCHAR(50) NOT NULL COMMENT 'Имя',
    inn VARCHAR(50) NOT NULL,
    kpp VARCHAR(50) NOT NULL,
    address VARCHAR(50)  NOT NULL    COMMENT 'Адрес',
    phone VARCHAR(50) NOT NULL,
    isActive BOOLEAN default TRUE
);

CREATE TABLE IF NOT EXISTS office (
    id         INTEGER   PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL,
    orgId       INTEGER NOT NULL ,
    name    VARCHAR(50) NOT NULL ,
    address VARCHAR(50) NOT NULL ,
    phone   VARCHAR(50)   NOT NULL ,
    isActive BOOLEAN default TRUE
);

CREATE TABLE IF NOT EXISTS person (
    id  INTEGER PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL,
    officeId         INTEGER  NOT NULL ,
    firstName VARCHAR(50) NOT NULL ,
    secondName    VARCHAR(50) NOT NULL ,
    middleName VARCHAR(50) NOT NULL ,
    position VARCHAR(50) NOT NULL ,
    phone VARCHAR(50) NOT NULL ,
    docName VARCHAR(50) NOT NULL ,
    docNumber INTEGER NOT NULL ,
    docDate DATE NOT NULL ,
    citizenshipName VARCHAR(50) NOT NULL ,
    citizenshipCode INTEGER NOT NULL ,
    isIdentified BOOLEAN default TRUE


);

CREATE TABLE IF NOT EXISTS docs(
    code INTEGER PRIMARY KEY,
    name VARCHAR(150) NOT NULL UNIQUE
);
--здесь типы докуметов

CREATE TABLE IF NOT EXISTS countries(
    code INTEGER PRIMARY KEY,
    name VARCHAR(150) NOT NULL UNIQUE
);


CREATE INDEX I_orgIdId ON office (orgId);
CREATE INDEX I_officeId ON person (officeId);


ALTER TABLE office ADD FOREIGN KEY (orgId) REFERENCES organization(id);
ALTER TABLE person ADD FOREIGN KEY (officeId) REFERENCES office(id);
ALTER TABLE person ADD FOREIGN KEY (citizenshipCode) REFERENCES countries(code);
ALTER TABLE person ADD FOREIGN KEY (docNumber) REFERENCES docs(code);





