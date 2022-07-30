CREATE SCHEMA IF NOT EXISTS event_service
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS event_service.event_film
(
    uuid uuid NOT NULL,
    dt_create integer NOT NULL,
    dt_update integer NOT NULL,
    title character varying COLLATE pg_catalog."default",
    description character varying COLLATE pg_catalog."default",
    dt_event integer,
    dt_end_of_sale integer,
    type character varying COLLATE pg_catalog."default",
    status character varying COLLATE pg_catalog."default",
    country character varying COLLATE pg_catalog."default",
    release_year integer,
    release_date date,
    duration integer,
    CONSTRAINT event_film_pkey PRIMARY KEY (uuid)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS event_service.event_film
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS event_service.event_concert
(
    uuid uuid NOT NULL,
    dt_create integer NOT NULL,
    dt_update integer NOT NULL,
    title character varying COLLATE pg_catalog."default",
    description character varying COLLATE pg_catalog."default",
    dt_event integer,
    dt_end_of_sale integer,
    type character varying COLLATE pg_catalog."default",
    status character varying COLLATE pg_catalog."default",
    category character varying COLLATE pg_catalog."default",
    CONSTRAINT event_concert_pkey PRIMARY KEY (uuid)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS event_service.event_concert
    OWNER to postgres;