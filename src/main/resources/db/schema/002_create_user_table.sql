--liquibase formatted sql

--changeset scholanova:2
ALTER TABLE public.USER
ADD password VARCHAR(255)