--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.1

-- Started on 2025-04-11 14:41:10

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
-- TOC entry 217 (class 1259 OID 65985)
-- Name: hibernate_sequences; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hibernate_sequences (
    sequence_name character varying(255) NOT NULL,
    next_val bigint
);


ALTER TABLE public.hibernate_sequences OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 65990)
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
-- TOC entry 4848 (class 0 OID 65985)
-- Dependencies: 217
-- Data for Name: hibernate_sequences; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hibernate_sequences (sequence_name, next_val) FROM stdin;
default	100
\.


--
-- TOC entry 4849 (class 0 OID 65990)
-- Dependencies: 218
-- Data for Name: todolist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.todolist (id, description, status, title) FROM stdin;
1	todo list application backend api	encours	todo_1
2	todo list application backend api phase_2	encours	todo_1
3	todo list application backend api	encours	todo_1
4	todo list application : installation des apllications de travail	termine	todo_2
5	todo list application : installation des apllications de travail phase_2	termine	todo_2
6	todo list application : interface frontend 	a_faire	todo_3
7	todo list application : interface frontend phase_2	a_faire	todo_3
\.


--
-- TOC entry 4700 (class 2606 OID 65989)
-- Name: hibernate_sequences hibernate_sequences_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hibernate_sequences
    ADD CONSTRAINT hibernate_sequences_pkey PRIMARY KEY (sequence_name);


--
-- TOC entry 4702 (class 2606 OID 65997)
-- Name: todolist todolist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.todolist
    ADD CONSTRAINT todolist_pkey PRIMARY KEY (id);


-- Completed on 2025-04-11 14:41:10

--
-- PostgreSQL database dump complete
--

