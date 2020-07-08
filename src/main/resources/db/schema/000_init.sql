
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
  name	VARCHAR(255),
  insee	VARCHAR(255),
PRIMARY KEY (id)
);

--liquibase formatted sql




--liquibase formatted sql

--changeset scholanova:1
CREATE TABLE IF NOT EXISTS public.ALERT (
  id            SERIAL NOT NULL,
  caption       VARCHAR(255),
  isrecurrent   BOOLEAN,
  days          VARCHAR(255),
  "hour"          VARCHAR(255),
  "date"          VARCHAR(255),
  ID_USER      INTEGER NOT NULL,
  location_id   INTEGER NOT NULL,
  PRIMARY KEY (id),
FOREIGN KEY (ID_USER) REFERENCES public.USER(ID_USER),
FOREIGN KEY (location_id) REFERENCES public.LOCATION(id)
);

