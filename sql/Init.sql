CREATE TABLE author
(
    author_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(20) NOT NULL,
    FK_Author_Address INT NULL,
    FK_Author_Email INT NULL,
    FOREIGN KEY (FK_Author_Email) REFERENCES email (email_id),
    FOREIGN KEY (FK_Author_Address) REFERENCES address (address_id)
);

CREATE TABLE email /*OnetoOne Uni*/
(
    email_id int PRIMARY KEY AUTO_INCREMENT,
    email     varchar(20) NOT NULL//rename
);

CREATE TABLE address   /*OnetoOne bi ???*/
(
    address_id int PRIMARY KEY AUTO_INCREMENT,
    city      varchar(20) NOT NULL
);

CREATE TABLE phone  /*OnetoMany*/
(
    phone_id        int PRIMARY KEY AUTO_INCREMENT,
    number    varchar(10) NOT NULL,
    FK_Phone_Author int,
    FOREIGN KEY (FK_Phone_Author) REFERENCES author (author_id) ON DELETE CASCADE
);

CREATE TABLE ad (
                    ad_id int PRIMARY KEY AUTO_INCREMENT,
                    name varchar(30) NOT NULL UNIQUE,
                    FK_Ad_Author INT,
                    FOREIGN KEY (FK_Ad_Author) REFERENCES author (author_id)/*add FK to rubric*/
);
