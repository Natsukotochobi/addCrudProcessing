DROP TABLE IF EXISTS songs;

CREATE TABLE songs (
  id int unsigned AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  artist VARCHAR(100) NOT NULL,
  year int(4) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO songs (title, artist, year) VALUES ("ANTIFRAGILE", "LE SSERAFIM", 2022);
INSERT INTO songs (title, artist, year) VALUES ("Purple", "woo!ah!", 2021);
INSERT INTO songs (title, artist, year) VALUES ("Given-Taken", "ENHYPEN", 2020);