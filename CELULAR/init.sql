DROP DATABASE IF EXISTS  celulares;
CREATE DATABASE celulares;
    USE celulares;
        CREATE TABLE IF NOT EXISTS celular(
            clave INT AUTO_INCREMENT PRIMARY KEY,
            precio FLOAT,
            marca VARCHAR(80),
            modelo VARCHAR(80) NOT NULL
        );
INSERT INTO celular VALUES(null,980.00,"samsumng","S43");