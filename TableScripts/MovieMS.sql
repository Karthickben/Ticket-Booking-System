--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4
-- Dumped by pg_dump version 11.4

-- Started on 2020-06-02 15:55:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 19492)
-- Name: movie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movie (
    movie_id integer NOT NULL,
    admin_id character varying(255) NOT NULL,
    movie_cast character varying(500) NOT NULL,
    censor_certificate character varying(255) NOT NULL,
    description character varying(1000) NOT NULL,
    director character varying(100) NOT NULL,
    duration character varying(255) NOT NULL,
    genre character varying(50) NOT NULL,
    language character varying(50) NOT NULL,
    last_updated_timestamp timestamp without time zone NOT NULL,
    movie_name character varying(100) NOT NULL,
    music_director character varying(100) NOT NULL,
    number_of_ratings integer,
    rating double precision
);


ALTER TABLE public.movie OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 19500)
-- Name: movie_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.movie_id
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.movie_id OWNER TO postgres;

--
-- TOC entry 2687 (class 2606 OID 19499)
-- Name: movie movie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (movie_id);


-- Completed on 2020-06-02 15:55:43

--
-- PostgreSQL database dump complete
--

