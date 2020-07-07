
CREATE TABLE IF NOT EXISTS public.USER(
  ID_USER                 SERIAL PRIMARY KEY,
  USERNAME				  VARCHAR(100) UNIQUE NOT NULL,
  PASSWORD				  VARCHAR(100) NOT NULL,
  FIRSTNAME				  VARCHAR(100) NOT NULL,
  LASTNAME				  VARCHAR(100) NOT NULL,
  ACCOUNT_NON_EXPIRED BOOLEAN NOT NULL,
  ACCOUNT_NON_LOCKED BOOLEAN NOT NULL,
  CREDENTIALS_NON_EXPIRED BOOLEAN NOT NULL,
  ENABLED BOOLEAN NOT NULL
);

--liquibase formatted sql

--changeset scholanova:1
CREATE TABLE IF NOT EXISTS public.LOCATION (
  id    SERIAL NOT NULL,
  city_id	VARCHAR(255),
  city_name	VARCHAR(255),
  country_code	VARCHAR(255),
  city_lat	VARCHAR(255),
  city_lon	VARCHAR(255),
PRIMARY KEY (id)
);

--liquibase formatted sql

--changeset scholanova:1
CREATE TABLE IF NOT EXISTS public.USERLOCATION (
  ID_USER       INTEGER NOT NULL,
  location_id   INTEGER NOT NULL,
  PRIMARY KEY (ID_USER, location_id),
FOREIGN KEY (ID_USER) REFERENCES public.USER(ID_USER),
FOREIGN KEY (location_id) REFERENCES public.LOCATION(id)
);


--liquibase formatted sql

--changeset scholanova:1
CREATE TABLE IF NOT EXISTS public.ALERT (
  id            SERIAL NOT NULL,
  caption       VARCHAR(255),
  isrecurrent   BOOLEAN,
  days          VARCHAR(255),
  hour          TIME,
  date          TIMESTAMP,
  ID_USER      INTEGER NOT NULL,
  location_id   INTEGER NOT NULL,
  PRIMARY KEY (id),
FOREIGN KEY (ID_USER) REFERENCES public.USER(ID_USER),
FOREIGN KEY (location_id) REFERENCES public.LOCATION(id)
);

