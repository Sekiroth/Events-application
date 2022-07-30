CREATE SCHEMA IF NOT EXISTS classifier_service
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS classifier_service.classifier_category
(
    uuid uuid NOT NULL,
    dt_create integer NOT NULL,
    dt_update integer NOT NULL,
    title character varying COLLATE pg_catalog."default",
    CONSTRAINT classifier_category_pkey PRIMARY KEY (uuid)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS classifier_service.classifier_category
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS classifier_service.classifier_country
(
    uuid uuid NOT NULL,
    dt_create integer NOT NULL,
    dt_update integer NOT NULL,
    title character varying COLLATE pg_catalog."default",
    description character varying COLLATE pg_catalog."default",
    CONSTRAINT classifier_country_pkey PRIMARY KEY (uuid)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS classifier_service.classifier_country
    OWNER to postgres;