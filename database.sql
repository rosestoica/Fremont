CREATE DATABASE Bike_Hub;
CREATE TABLE User(
	username char(5) PRIMARY KEY,
    password char(10) NOT NULL,
    nume char(15) NOT NULL,
	prenume char(15) NOT NULL,
    varsta int NOT NULL,
    sex char(10) NOT NULL,
    tara char(20) NOT NULL,
    oras char(20) NOT NULL,
    role int NOT NULL,
    o_poza BLOB
);
CREATE TABLE Bikes(
	bikeid char(5) PRIMARY KEY,
    marca char(10) NOT NULL,
    varsta int NOT NULL,
    pret int NOT NULL,
    disponibility int,
    schimbator_viteza int,
    portbagaj_spate int,
    cos_fata int,
    suport_sticla int,
    pompa int,
    gps int,
    oglinda int,
    claxon int,
    b_poza BLOB,
	user char(10),
    FOREIGN KEY (user) REFERENCES User(username)
);