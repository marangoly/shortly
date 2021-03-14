DROP TABLE IF EXISTS url;

CREATE TABLE URL (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  short_code VARCHAR(250) NOT NULL,
  long_url VARCHAR(500) NOT NULL
);


INSERT INTO url (short_code, long_url) VALUES ('b', 'https://google.com' );