CREATE USER admin WITH PASSWORD 'password';
ALTER ROLE admin WITH Superuser;

CREATE TABLE cats (
  id INTEGER PRIMARY KEY,
  name VARCHAR(20) 
);


