CREATE SCHEMA IF NOT EXISTS user_service
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS user_service.users
(
    uuid uuid NOT NULL,
    dt_create integer NOT NULL,
    dt_update integer NOT NULL,
    mail character varying COLLATE pg_catalog."default",
    nick character varying COLLATE pg_catalog."default",
    role character varying COLLATE pg_catalog."default",
    status character varying COLLATE pg_catalog."default",
    password character varying COLLATE pg_catalog."default",
    CONSTRAINT user_service_pkey PRIMARY KEY (uuid)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS user_service.users
    OWNER to postgres;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  