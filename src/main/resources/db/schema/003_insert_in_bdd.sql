--liquibase formatted sql

--changeset scholanova:1

-- TRUNCATE TABLE public.USERLOCATION;

--INSERT INTO public.USERLOCATION (id_user, location_id)
 --VALUES
 --(1, 1),
 --(2, 3),
 --(3, 2),
 --(4, 4),
 --(3, 3),
 --(2, 2);