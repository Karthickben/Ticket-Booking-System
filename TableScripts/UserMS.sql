--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4
-- Dumped by pg_dump version 11.4

-- Started on 2020-06-02 15:54:07

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
-- TOC entry 196 (class 1259 OID 19485)
-- Name: user_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_detail (
    email_id character varying(100) NOT NULL,
    last_updated_timestamp timestamp without time zone NOT NULL,
    password character varying(60) NOT NULL,
    phone_number character varying(30) NOT NULL,
    role character varying(50) NOT NULL,
    user_name character varying(100) NOT NULL
);


ALTER TABLE public.user_detail OWNER TO postgres;

--
-- TOC entry 2684 (class 2606 OID 19491)
-- Name: user_detail uk_1y6xvi5bmkxu6j18fd1vie7qi; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_detail
    ADD CONSTRAINT uk_1y6xvi5bmkxu6j18fd1vie7qi UNIQUE (phone_number);


--
-- TOC entry 2686 (class 2606 OID 19489)
-- Name: user_detail user_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_detail
    ADD CONSTRAINT user_detail_pkey PRIMARY KEY (email_id);


-- Completed on 2020-06-02 15:54:10

--
-- PostgreSQL database dump complete
--

