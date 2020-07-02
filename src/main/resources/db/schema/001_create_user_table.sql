--liquibase formatted sql

--changeset scholanova:1
CREATE TABLE IF NOT EXISTS public.USER (
  id        NUMERIC NOT NULL,
  lastName	VARCHAR(100),
  firstName	VARCHAR(100),
  email     VARCHAR(100),
  PRIMARY KEY (id)
);