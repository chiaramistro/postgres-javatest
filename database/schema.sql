CREATE USER admin WITH PASSWORD 'password';
ALTER ROLE admin WITH Superuser;
ALTER ROLE postgres WITH PASSWORD 'postgres';

CREATE TABLE cats (
  id INTEGER PRIMARY KEY,
  name VARCHAR(20) 
);

