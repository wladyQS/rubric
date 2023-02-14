CREATE TABLE author
(
    author_id         INT PRIMARY KEY AUTO_INCREMENT,
    version      INT NOT NULL,
    name              VARCHAR(20) NOT NULL,
    FK_Author_Address INT,
    FK_Author_Email   INT,
    FOREIGN KEY (FK_Author_Email) REFERENCES email (email_id),
    FOREIGN KEY (FK_Author_Address) REFERENCES address (address_id)
);

CREATE TABLE email
(
    email_id      INT PRIMARY KEY AUTO_INCREMENT,
    email_address VARCHAR(20) NOT NULL,
    version      INT NOT NULL
);

CREATE TABLE address
(
    address_id INT PRIMARY KEY AUTO_INCREMENT,
    city       VARCHAR(20) NOT NULL,
    version      INT NOT NULL
);

CREATE TABLE phone
(
    phone_id        INT PRIMARY KEY AUTO_INCREMENT,
    phone_number    VARCHAR(10) NOT NULL,
    version      INT NOT NULL,
    FK_Phone_Author INT,
    FOREIGN KEY (FK_Phone_Author) REFERENCES author (author_id)
);

CREATE TABLE ad
(
    ad_id        INT PRIMARY KEY AUTO_INCREMENT,
    version      INT NOT NULL,
    name         VARCHAR(30) NOT NULL UNIQUE,
    date         DATE,
    text         VARCHAR(200),
    price        DECIMAL,
    FK_Ad_Author INT,
    FK_Ad_Rubric INT,
    FOREIGN KEY (FK_Ad_Author) REFERENCES author (author_id),
    FOREIGN KEY (FK_Ad_Rubric) REFERENCES rubric (rubric_id)
);

CREATE TABLE rubric
(
    rubric_id INT PRIMARY KEY AUTO_INCREMENT,
    version   INT NOT NULL,
    name      VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE matching_ad
(
    matching_ad_id       INT PRIMARY KEY AUTO_INCREMENT,
    version              INT,
    title                VARCHAR(30) NOT NULL UNIQUE,
    price_from           DECIMAL,
    price_to             DECIMAL,
    FK_MatchingAd_Author INT,
    FK_MatchingAd_Rubric INT,
    FOREIGN KEY (FK_MatchingAd_Author) REFERENCES author (author_id),
    FOREIGN KEY (FK_MatchingAd_Rubric) REFERENCES rubric (rubric_id)
);

INSERT INTO email (email_address) VALUES ('westland@gmail.com');
INSERT INTO email (email_address) VALUES ('world@gmail.com');

INSERT INTO address (city) VALUES ('Berlin');
INSERT INTO address (city) VALUES ('Kyev');

INSERT INTO author (name, FK_Author_Address, FK_Author_EMAIL) VALUES ('vova', 1, 1);
INSERT INTO author (name, FK_Author_Address, FK_Author_EMAIL) VALUES ('andriy', 2, 2);

INSERT INTO rubric (name) VALUES ('cars');
INSERT INTO rubric (name) VALUES ('bars');

INSERT INTO ad (name, text, price, FK_AD_Author, FK_AD_Rubric) VALUES ('Opel Astra', 'This car is really good', 200, 1, 1);
INSERT INTO ad (name, text, price, FK_AD_Author, FK_AD_Rubric) VALUES ('Centuki Bar', 'New openning', 50, 2, 2);

INSERT INTO matching_ad (title, price_from, price_to, FK_MatchingAd_Author, FK_MatchingAd_Rubric)
VALUES ('car', 100, 300, 2, 1);
