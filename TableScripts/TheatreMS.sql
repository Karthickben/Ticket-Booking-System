--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4
-- Dumped by pg_dump version 11.4

-- Started on 2020-06-02 15:52:23

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
-- TOC entry 196 (class 1259 OID 19502)
-- Name: screen; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.screen (
    screenid integer NOT NULL,
    admin_id character varying(50) NOT NULL,
    last_updated_timestamp timestamp without time zone NOT NULL,
    no_of_seating_columns integer NOT NULL,
    no_of_seating_rows integer NOT NULL,
    screen_name character varying(100) NOT NULL,
    screen_status character varying(50) NOT NULL,
    theatre_id integer
);


ALTER TABLE public.screen OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 19507)
-- Name: show; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.show (
    show_id integer NOT NULL,
    admin_id character varying(50) NOT NULL,
    effective_date date,
    last_updated_timestamp timestamp without time zone NOT NULL,
    movie_id integer NOT NULL,
    screen_id integer
);


ALTER TABLE public.show OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 19512)
-- Name: show_timings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.show_timings (
    show_time_id integer NOT NULL,
    admin_id character varying(255) NOT NULL,
    show_date date NOT NULL,
    last_updated_timestamp timestamp without time zone,
    show_time time without time zone NOT NULL,
    status character varying(30) NOT NULL,
    ticket_price double precision NOT NULL,
    show_id integer
);


ALTER TABLE public.show_timings OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 19525)
-- Name: showid; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.showid
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.showid OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 19527)
-- Name: sid; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sid
    START WITH 210000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sid OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 19529)
-- Name: stid; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.stid
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.stid OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 19517)
-- Name: theatre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.theatre (
    theatre_id integer NOT NULL,
    admin_id character varying(50) NOT NULL,
    area character varying(100) NOT NULL,
    building_name character varying(100),
    city character varying(100) NOT NULL,
    last_updated_timestamp timestamp without time zone NOT NULL,
    state character varying(100) NOT NULL,
    theatre_name character varying(150) NOT NULL,
    screen_status character varying(100) NOT NULL,
    theatre_type character varying(50) NOT NULL,
    total_screens integer NOT NULL
);


ALTER TABLE public.theatre OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 19531)
-- Name: tid; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tid
    START WITH 110000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tid OWNER TO postgres;

--
-- TOC entry 2705 (class 2606 OID 19506)
-- Name: screen screen_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screen
    ADD CONSTRAINT screen_pkey PRIMARY KEY (screenid);


--
-- TOC entry 2707 (class 2606 OID 19511)
-- Name: show show_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.show
    ADD CONSTRAINT show_pkey PRIMARY KEY (show_id);


--
-- TOC entry 2709 (class 2606 OID 19516)
-- Name: show_timings show_timings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.show_timings
    ADD CONSTRAINT show_timings_pkey PRIMARY KEY (show_time_id);


--
-- TOC entry 2711 (class 2606 OID 19524)
-- Name: theatre theatre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.theatre
    ADD CONSTRAINT theatre_pkey PRIMARY KEY (theatre_id);


--
-- TOC entry 2714 (class 2606 OID 19543)
-- Name: show_timings fk7mf60f96furfrs320xf3c0n5y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.show_timings
    ADD CONSTRAINT fk7mf60f96furfrs320xf3c0n5y FOREIGN KEY (show_id) REFERENCES public.show(show_id);


--
-- TOC entry 2712 (class 2606 OID 19533)
-- Name: screen fkilngvwq9jgk3is184yjhkx9k; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screen
    ADD CONSTRAINT fkilngvwq9jgk3is184yjhkx9k FOREIGN KEY (theatre_id) REFERENCES public.theatre(theatre_id);


--
-- TOC entry 2713 (class 2606 OID 19538)
-- Name: show fkpmdhsg2pprfg2634ojdwiv181; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.show
    ADD CONSTRAINT fkpmdhsg2pprfg2634ojdwiv181 FOREIGN KEY (screen_id) REFERENCES public.screen(screenid);


-- Completed on 2020-06-02 15:52:23

--
-- PostgreSQL database dump complete
--

