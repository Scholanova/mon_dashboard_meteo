--liquibase formatted sql

--changeset scholanova:1
CREATE TABLE IF NOT EXISTS public.LOCATION (
  id    SERIAL NOT NULL,
  name	VARCHAR(255),
  insee	VARCHAR(255),
  PRIMARY KEY (id)
);
