--liquibase formatted sql

--changeset scholanova:1
CREATE TABLE IF NOT EXISTS public.USER (
  id        NUMERIC NOT NULL,
  lastName	VARCHAR(255),
  firstName	VARCHAR(255),
  email     VARCHAR(255),
  password  VARCHAR(255),
  PRIMARY KEY (id)
);
