create schema oblig3;
set search_path to oblig3;

CREATE TABLE person 
(
   mobil			varchar,
   fornavn			varchar,
   etternavn		varchar,
   passordhash		varchar,
   passordsalt		varchar,
   kjonn			varchar,
   PRIMARY KEY (mobil)
);