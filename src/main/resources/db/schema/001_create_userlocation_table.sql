--liquibase formatted sql

--changeset scholanova:1
CREATE TABLE IF NOT EXISTS public.USERLOCATION (
  ID_USER       INTEGER NOT NULL,
  location_id   INTEGER NOT NULL,
  PRIMARY KEY (ID_USER, location_id),
  FOREIGN KEY (ID_USER) REFERENCES public.USER(ID_USER),
  FOREIGN KEY (location_id) REFERENCES public.LOCATION(id)
);