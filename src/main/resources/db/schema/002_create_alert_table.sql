--liquibase formatted sql

--changeset scholanova:1
ALTER TABLE ALERT
ADD FOREIGN KEY (user_id) REFERENCES public.USER(ID_USER),
ADD FOREIGN KEY (location_id) REFERENCES public.LOCATION(id);