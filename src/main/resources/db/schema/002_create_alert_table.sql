--liquibase formatted sql

--changeset scholanova:1
ALTER TABLE ALERT
ADD FOREIGN KEY (ID_USER) REFERENCES public.USER(ID_USER),
ADD FOREIGN KEY (location_id) REFERENCES public.LOCATION(id);