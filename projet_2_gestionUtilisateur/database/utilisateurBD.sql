PGDMP                      }         
   utilisateurBD    17.2    17.2 
    ð           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            ñ           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            ò           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            ó           1262    57764 
   utilisateurBD    DATABASE     „   CREATE DATABASE "utilisateurBD" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'French_Cameroon.1252';
    DROP DATABASE "utilisateurBD";
                     postgres    false            Ù            1259    57765    utilisateur    TABLE     ½   CREATE TABLE public.utilisateur (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    nom character varying(50) NOT NULL,
    password character varying(255) NOT NULL
);
    DROP TABLE public.utilisateur;
       public         heap r       postgres    false            Ú            1259    57774    utilisateur_seq    SEQUENCE     y   CREATE SEQUENCE public.utilisateur_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.utilisateur_seq;
       public               postgres    false            ì          0    57765    utilisateur 
   TABLE DATA           ?   COPY public.utilisateur (id, email, nom, password) FROM stdin;
    public               postgres    false    217   Y
       ô           0    0    utilisateur_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.utilisateur_seq', 51, true);
          public               postgres    false    218            X           2606    57773 '   utilisateur ukrma38wvnqfaf66vvmi57c71lo 
   CONSTRAINT     c   ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT ukrma38wvnqfaf66vvmi57c71lo UNIQUE (email);
 Q   ALTER TABLE ONLY public.utilisateur DROP CONSTRAINT ukrma38wvnqfaf66vvmi57c71lo;
       public                 postgres    false    217            Z           2606    57771    utilisateur utilisateur_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.utilisateur DROP CONSTRAINT utilisateur_pkey;
       public                 postgres    false    217            ì     xœUÎ»r‚@ …áš}

kÀ…1¡‹r°É¤Y`‘‹,*á"OŸa&ÆIùŸâ›³dpŠßî8o.»ÍÁÖ¤mfñb	yAKÁ“ÝóçÉßîN8í¯µÒ©zÌ{ïAîÃYŸœ låcŸƒ¶â¹n 3Ov.¶$˜>Ø›ŽAÔ‘fþÆÒ]„t¾&°1”­P¨nš‡X¤üÂÔDT©a3U6™'Õ“EvžþÞjc¾o¼JŠ-Ž¡–®~{Ê°Ãe*ûbd¼„“hE¯åÐFn„3–ì+˜ŠÐìŸü;°—‚ÜnäÁ-ï6=gQ.Ù%]ksFpˆdo°Ö=aä:HA…¦Ña5éúA³Á  øTˆrÕ     
