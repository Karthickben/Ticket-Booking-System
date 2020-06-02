--
--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4
-- Dumped by pg_dump version 11.4

-- Started on 2020-06-02 15:56:41

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

--
-- TOC entry 197 (class 1259 OID 19556)
-- Name: bid; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bid
    START WITH 7000001
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bid OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 19548)
-- Name: booking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.booking (
    booking_id integer NOT NULL,
    last_updated_timestamp timestamp without time zone NOT NULL,
    movie_id integer NOT NULL,
    number_of_seats_booked integer NOT NULL,
    screen_id integer NOT NULL,
    seat_numbers character varying(255) NOT NULL,
    show_date date NOT NULL,
    show_time time without time zone NOT NULL,
    show_time_id integer NOT NULL,
    theatre_id integer NOT NULL,
    ticket_price double precision NOT NULL,
    ticket_staus character varying(255),
    total_price double precision NOT NULL,
    user_id character varying(255) NOT NULL
);


ALTER TABLE public.booking OWNER TO postgres;

--
-- TOC entry 2687 (class 2606 OID 19555)
-- Name: booking booking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (booking_id);


-- Completed on 2020-06-02 15:56:46

--
-- PostgreSQL database dump complete
--

