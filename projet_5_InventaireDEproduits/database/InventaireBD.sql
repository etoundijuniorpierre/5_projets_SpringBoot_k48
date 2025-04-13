PGDMP  3             
        }            inventaireBD    17.2    17.2 
    ð           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            ñ           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            ò           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            ó           1262    66101    inventaireBD    DATABASE     ƒ   CREATE DATABASE "inventaireBD" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'French_Cameroon.1252';
    DROP DATABASE "inventaireBD";
                     postgres    false            Ù            1259    66102     produit    TABLE     |   CREATE TABLE public.produit (
    id bigint NOT NULL,
    nom character varying(255),
    prix real,
    quantite bigint
);
    DROP TABLE public.produit;
       public         heap r       postgres    false            Ú            1259    66109 
   produit_seq    SEQUENCE     u   CREATE SEQUENCE public.produit_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.produit_seq;
       public               postgres    false            ì          0    66102     produit 
   TABLE DATA           :   COPY public.produit (id, nom, prix, quantite) FROM stdin;
    public               postgres    false    217   É	       ô           0    0 
   produit_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.produit_seq', 51, true);
          public               postgres    false    218            X           2606    66106    produit produit_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.produit
    ADD CONSTRAINT produit_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.produit DROP CONSTRAINT produit_pkey;
       public                 postgres    false    217            Z           2606    66108 #   produit ukp3flguk26lkj16433geia6xx8 
   CONSTRAINT     ]   ALTER TABLE ONLY public.produit
    ADD CONSTRAINT ukp3flguk26lkj16433geia6xx8 UNIQUE (nom);
 M   ALTER TABLE ONLY public.produit DROP CONSTRAINT ukp3flguk26lkj16433geia6xx8;
       public                 postgres    false    217            ì   C   xœ3äLÎÈOÎÏI,á460à450à2â¬LÌ/-*q8
ÆœY¥Å`ž‘kÂ™”™Z”ÊiˆÑãââ —$O     
