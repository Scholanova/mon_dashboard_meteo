--liquibase formatted sql

--changeset scholanova:1
ALTER TABLE ALERT
ADD FOREIGN KEY (user_id) REFERENCES public.USER(id),
ADD FOREIGN KEY (location_id) REFERENCES public.LOCATION(id);