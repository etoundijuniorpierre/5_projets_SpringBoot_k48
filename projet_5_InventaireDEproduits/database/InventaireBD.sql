--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.1

-- Started on 2025-04-05 16:12:04

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
-- TOC entry 217 (class 1259 OID 57796)
-- Name: produit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produit (
    id bigint NOT NULL,
    nom character varying(255),
    prix real,
    quantite bigint
);


ALTER TABLE public.produit OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 57803)
-- Name: produit_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produit_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.produit_seq OWNER TO postgres;

--
-- TOC entry 4844 (class 0 OID 57796)
-- Dependencies: 217
-- Data for Name: produit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produit (id, nom, prix, quantite) FROM stdin;
\.


--
-- TOC entry 4851 (class 0 OID 0)
-- Dependencies: 218
-- Name: produit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produit_seq', 1, false);


--
-- TOC entry 4696 (class 2606 OID 57800)
-- Name: produit produit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produit
    ADD CONSTRAINT produit_pkey PRIMARY KEY (id);


--
-- TOC entry 4698 (class 2606 OID 57802)
-- Name: produit ukp3flguk26lkj16433geia6xx8; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produit
    ADD CONSTRAINT ukp3flguk26lkj16433geia6xx8 UNIQUE (nom);


-- Completed on 2025-04-05 16:12:04

--
-- PostgreSQL database dump complete
--

