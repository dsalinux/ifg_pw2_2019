-- Script Postgress

-- Database: sistema-comercial

-- DROP DATABASE "sistema-comercial";

CREATE DATABASE "sistema-comercial"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'pt_BR.UTF-8'
    LC_CTYPE = 'pt_BR.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


-- Selecionando a base de dados
\c "sistema-comercial";

-- Table: public.usuario

-- DROP TABLE public.usuario;

CREATE TABLE public.usuario
(
    senha character varying(32) COLLATE pg_catalog."default" NOT NULL,
    nome character varying(80) COLLATE pg_catalog."default" NOT NULL,
    login character varying(40) COLLATE pg_catalog."default" NOT NULL,
    id serial NOT NULL,
    email character varying(1200) COLLATE pg_catalog."default" NOT NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to postgres;