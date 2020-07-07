--liquibase formatted sql

--changeset scholanova:1

-- TRUNCATE TABLE public.USER;
-- TRUNCATE TABLE public.LOCATION;

-- not for authentification // because pasword encdde must not be respect
--INSERT INTO public.USER (lastname, firstname, username, password,ACCOUNT_NON_EXPIRED,ACCOUNT_NON_LOCKED,CREDENTIALS_NON_EXPIRED,enabled)
-- VALUES
-- ('Rébecca', 'Armand', 're.armand@meteo.fr', 'manomano',true,true,true,true),
-- ('Aimée', 'Hebert', 'ai.hebert@meteo.fr', 'manomano',true,true,true,true),
-- ('Marielle', 'Pinheiro', 'ma.pinheiro@meteo.fr', 'manomano',true,true,true,true),
-- ('Hilaire', 'Savary', 'hi.savary@meteo.fr', 'manomano',true,true,true,true);
--
--INSERT INTO public.Location (name, insee)
-- VALUES
-- ('Paris 11eme', '75111'),
-- ('Nantes', '44109'),
-- ('Rennes', '35238'),
-- ('Rennes-en-Grenouilles', '53189');