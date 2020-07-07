--liquibase formatted sql

--changeset scholanova:1

-- TRUNCATE TABLE public.ALERT;

--INSERT INTO public.ALERT (caption, isrecurrent, days, hour, date, id_user, location_id)
 --VALUES
 --('Velo', 'true', '24', '18:00:00', NULL, 1, 1),
 --('Velo', 'true', '13', '16:00:00', NULL, 2, 3),
 --('Velo', 'true', '36', '11:30:00', NULL, 3, 2),
 --('Velo', 'true', '5', '09:30:00', NULL, 4, 4),
 --('Boulot', 'true', '12345', '08:00:00', NULL, 1, 1),
 --('Boulot', 'true', '1245', '10:00:00', NULL, 2, 3),
 --('Boulot', 'true', '2345', '09:30:00', NULL, 3, 2),
 --('Boulot', 'true', '1234', '07:00:00', NULL, 4, 4),
 --('Café', 'false', '', NULL, '2020-07-15 09:30:00', 3, 2),
 --('Café', 'false', '', NULL, '2020-07-12 10:00:00', 2, 3),
 --('Café', 'false', '', NULL, '2020-07-11 16:30:00', 1, 1),
 --('Café', 'false', '', NULL, '2020-07-10 12:00:00', 4, 4),
 --('Week-end', 'true', '67', '10:00:00', NULL, 1, 1),
 --('Week-end', 'true', '167', '11:00:00', NULL, 3, 3),
 --('Week-end', 'true', '67', '12:00:00', NULL, 2, 2),
 --('Week-end', 'true', '567', '11:00:00', NULL, 4, 4);