--liquibase formatted sql

--changeset scholanova:1
CREATE TABLE IF NOT EXISTS public.USERLOCATION (
  user_id       INTEGER NOT NULL,
  location_id   INTEGER NOT NULL,
  PRIMARY KEY (user_id, location_id),
  FOREIGN KEY (user_id) REFERENCES public.USER(ID_USER),
  FOREIGN KEY (location_id) REFERENCES public.LOCATION(id)
);