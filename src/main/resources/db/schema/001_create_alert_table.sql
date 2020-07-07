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
  PRIMARY KEY (id)
);
