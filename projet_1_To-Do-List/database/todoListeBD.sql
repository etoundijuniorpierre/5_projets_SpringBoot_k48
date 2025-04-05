--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.1

-- Started on 2025-04-05 14:31:35

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 57746)
-- Name: todolist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.todolist (
    id bigint NOT NULL,
    description text,
    status character varying(255) NOT NULL,
    title character varying(255) NOT NULL,
    CONSTRAINT todolist_status_check CHECK (((status)::text = ANY ((ARRAY['a_faire'::character varying, 'encours'::character varying, 'termine'::character varying])::text[])))
);


ALTER TABLE public.todolist OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 57754)
-- Name: todolist_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.todolist_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.todolist_seq OWNER TO postgres;

--
-- TOC entry 4843 (class 0 OID 57746)
-- Dependencies: 217
-- Data for Name: todolist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.todolist (id, description, status, title) FROM stdin;
\.


--
-- TOC entry 4850 (class 0 OID 0)
-- Dependencies: 218
-- Name: todolist_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.todolist_seq', 1, false);


--
-- TOC entry 4697 (class 2606 OID 57753)
-- Name: todolist todolist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.todolist
    ADD CONSTRAINT todolist_pkey PRIMARY KEY (id);


-- Completed on 2025-04-05 14:31:35

--
-- PostgreSQL database dump complete
--

