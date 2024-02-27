drop schema if exists practica;
drop user if exists usuario_practica;
CREATE database practica;

create user 'usuario_practica'@'%' identified by 'la_Clave.';

grant all privileges on practica.* to 'usuario_practica'@'%';
flush privileges;
use practica;
CREATE TABLE arbol (
id_arbol INT NOT NULL AUTO_INCREMENT,
ruta_imagen VARCHAR(1024),
nombre VARCHAR(50),
tipo_flor VARCHAR(50),
dureza_madera VARCHAR(50),
PRIMARY KEY(id_arbol)
);

INSERT INTO arbol(ruta_imagen,nombre,tipo_flor,dureza_madera) VALUES
('https://medicoplus.com/_next/image?url=https%3A%2F%2Fplustatic.com%2F1774%2Fconversions%2Ftipos-arboles-large.jpg&w=1024&q=75','arbol de prueba','flor 1','dura');

SELECT * FROM arbol;
