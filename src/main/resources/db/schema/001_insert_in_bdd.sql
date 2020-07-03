--liquibase formatted sql

--changeset scholanova:1

-- TRUNCATE TABLE public.USER;
-- TRUNCATE TABLE public.LOCATION;

INSERT INTO public.USER (lastname, firstname, email, password)
 VALUES
 ('Rébecca', 'Armand', 're.armand@meteo.fr', 'manomano'),
 ('Aimée', 'Hebert', 'ai.hebert@meteo.fr', 'manomano'),
 ('Marielle', 'Pinheiro', 'ma.pinheiro@meteo.fr', 'manomano'),
 ('Hilaire', 'Savary', 'hi.savary@meteo.fr', 'manomano');

INSERT INTO public.Location (name, insee)
 VALUES
 ('Paris 11eme', '75111'),
 ('Nantes', '44109'),
 ('Rennes', '35238'),
 ('Rennes-en-Grenouilles', '53189');