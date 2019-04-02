CREATE DATABASE "sistema-comercial";


CREATE TABLE public.usuario
(
    senha character varying(32) COLLATE pg_catalog."default" NOT NULL,
    nome character varying(80) COLLATE pg_catalog."default" NOT NULL,
    login character varying(40) COLLATE pg_catalog."default" NOT NULL,
    id SERIAL,
    email character varying(1200) COLLATE pg_catalog."default" NOT NULL
)
