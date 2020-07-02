--liquibase formatted sql

--changeset scholanova:1
CREATE TABLE IF NOT EXISTS public.USER (
  id        SERIAL NOT NULL,
  lastname	VARCHAR(255),
  firstname	VARCHAR(255),
  email     VARCHAR(255),
  password  VARCHAR(255),
  PRIMARY KEY (id)
);
