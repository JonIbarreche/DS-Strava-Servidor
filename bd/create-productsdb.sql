/* DELETE 'productsDB' database*/
DROP SCHEMA strava;
/* DELETE USER 'products_user' AT LOCAL SERVER*/
DROP USER 'strava_user'@'%';

/* CREATE ''productsDB' DATABASE */
CREATE SCHEMA strava;
/* CREATE THE USER 'products_user' AT LOCAL SERVER WITH PASSWORD 'password' */
CREATE USER 'strava_user'@'%' IDENTIFIED BY 'password';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'products_user' AT LOCAL SERVER*/
GRANT ALL ON strava.* TO 'strava_user'@'%';