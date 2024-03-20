PGDMP         5                |            promo-v2    15.2    15.1 /    2           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            3           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            4           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            5           1262    41076    promo-v2    DATABASE     �   CREATE DATABASE "promo-v2" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Arabic_Saudi Arabia.1256';
    DROP DATABASE "promo-v2";
                postgres    false            �            1259    41077    CUSTOMER    TABLE     �   CREATE TABLE public."CUSTOMER" (
    customer_id integer NOT NULL,
    customer_name text,
    customer_phone text,
    customer_type_id integer NOT NULL,
    deleted boolean DEFAULT false NOT NULL,
    deleted_at timestamp with time zone
);
    DROP TABLE public."CUSTOMER";
       public         heap    postgres    false            �            1259    41088    CUSTOMER_TYPE    TABLE     �   CREATE TABLE public."CUSTOMER_TYPE" (
    customer_type_id integer NOT NULL,
    customer_type_name text,
    customer_type_description text,
    deleted boolean DEFAULT false NOT NULL,
    deleted_at timestamp with time zone
);
 #   DROP TABLE public."CUSTOMER_TYPE";
       public         heap    postgres    false            �            1259    41152    CUSTOMER_TYPE_GIFT_TYPE    TABLE     �   CREATE TABLE public."CUSTOMER_TYPE_GIFT_TYPE" (
    customer_type_gift_type_id integer NOT NULL,
    customer_type_id integer NOT NULL,
    gift_type_id integer NOT NULL,
    created_at timestamp with time zone DEFAULT now()
);
 -   DROP TABLE public."CUSTOMER_TYPE_GIFT_TYPE";
       public         heap    postgres    false            �            1259    41151 6   CUSTOMER_TYPE_GIFT_TYPE_customer_type_gift_type_id_seq    SEQUENCE     �   CREATE SEQUENCE public."CUSTOMER_TYPE_GIFT_TYPE_customer_type_gift_type_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 O   DROP SEQUENCE public."CUSTOMER_TYPE_GIFT_TYPE_customer_type_gift_type_id_seq";
       public          postgres    false    221            6           0    0 6   CUSTOMER_TYPE_GIFT_TYPE_customer_type_gift_type_id_seq    SEQUENCE OWNED BY     �   ALTER SEQUENCE public."CUSTOMER_TYPE_GIFT_TYPE_customer_type_gift_type_id_seq" OWNED BY public."CUSTOMER_TYPE_GIFT_TYPE".customer_type_gift_type_id;
          public          postgres    false    220            �            1259    41094 "   CUSTOMER_TYPE_customer_type_id_seq    SEQUENCE     �   CREATE SEQUENCE public."CUSTOMER_TYPE_customer_type_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public."CUSTOMER_TYPE_customer_type_id_seq";
       public          postgres    false    215            7           0    0 "   CUSTOMER_TYPE_customer_type_id_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public."CUSTOMER_TYPE_customer_type_id_seq" OWNED BY public."CUSTOMER_TYPE".customer_type_id;
          public          postgres    false    216            �            1259    41095    CUSTOMER_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public."CUSTOMER_customer_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public."CUSTOMER_customer_id_seq";
       public          postgres    false    214            8           0    0    CUSTOMER_customer_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public."CUSTOMER_customer_id_seq" OWNED BY public."CUSTOMER".customer_id;
          public          postgres    false    217            �            1259    41096 	   GIFT_TYPE    TABLE        CREATE TABLE public."GIFT_TYPE" (
    gift_type_id integer NOT NULL,
    gift_type_name text NOT NULL,
    gift_type_description text NOT NULL,
    deleted boolean DEFAULT false NOT NULL,
    deleted_at timestamp with time zone,
    gift_type_code text
);
    DROP TABLE public."GIFT_TYPE";
       public         heap    postgres    false            �            1259    41102    GIFT_TYPE_gift_type_id_seq    SEQUENCE     �   CREATE SEQUENCE public."GIFT_TYPE_gift_type_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public."GIFT_TYPE_gift_type_id_seq";
       public          postgres    false    218            9           0    0    GIFT_TYPE_gift_type_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public."GIFT_TYPE_gift_type_id_seq" OWNED BY public."GIFT_TYPE".gift_type_id;
          public          postgres    false    219            �            1259    41170    REDEEMED_CUSTOMER_GIFT    TABLE     �   CREATE TABLE public."REDEEMED_CUSTOMER_GIFT" (
    redeemed_customer_gift_id integer NOT NULL,
    customer_id integer NOT NULL,
    gift_type_id integer NOT NULL,
    created_at timestamp with time zone DEFAULT now()
);
 ,   DROP TABLE public."REDEEMED_CUSTOMER_GIFT";
       public         heap    postgres    false            �            1259    41169 4   REDEEMED_CUSTOMER_GIFT_redeemed_customer_gift_id_seq    SEQUENCE     �   CREATE SEQUENCE public."REDEEMED_CUSTOMER_GIFT_redeemed_customer_gift_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 M   DROP SEQUENCE public."REDEEMED_CUSTOMER_GIFT_redeemed_customer_gift_id_seq";
       public          postgres    false    223            :           0    0 4   REDEEMED_CUSTOMER_GIFT_redeemed_customer_gift_id_seq    SEQUENCE OWNED BY     �   ALTER SEQUENCE public."REDEEMED_CUSTOMER_GIFT_redeemed_customer_gift_id_seq" OWNED BY public."REDEEMED_CUSTOMER_GIFT".redeemed_customer_gift_id;
          public          postgres    false    222            y           2604    41108    CUSTOMER customer_id    DEFAULT     �   ALTER TABLE ONLY public."CUSTOMER" ALTER COLUMN customer_id SET DEFAULT nextval('public."CUSTOMER_customer_id_seq"'::regclass);
 E   ALTER TABLE public."CUSTOMER" ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    217    214            {           2604    41110    CUSTOMER_TYPE customer_type_id    DEFAULT     �   ALTER TABLE ONLY public."CUSTOMER_TYPE" ALTER COLUMN customer_type_id SET DEFAULT nextval('public."CUSTOMER_TYPE_customer_type_id_seq"'::regclass);
 O   ALTER TABLE public."CUSTOMER_TYPE" ALTER COLUMN customer_type_id DROP DEFAULT;
       public          postgres    false    216    215                       2604    41155 2   CUSTOMER_TYPE_GIFT_TYPE customer_type_gift_type_id    DEFAULT     �   ALTER TABLE ONLY public."CUSTOMER_TYPE_GIFT_TYPE" ALTER COLUMN customer_type_gift_type_id SET DEFAULT nextval('public."CUSTOMER_TYPE_GIFT_TYPE_customer_type_gift_type_id_seq"'::regclass);
 c   ALTER TABLE public."CUSTOMER_TYPE_GIFT_TYPE" ALTER COLUMN customer_type_gift_type_id DROP DEFAULT;
       public          postgres    false    220    221    221            }           2604    41111    GIFT_TYPE gift_type_id    DEFAULT     �   ALTER TABLE ONLY public."GIFT_TYPE" ALTER COLUMN gift_type_id SET DEFAULT nextval('public."GIFT_TYPE_gift_type_id_seq"'::regclass);
 G   ALTER TABLE public."GIFT_TYPE" ALTER COLUMN gift_type_id DROP DEFAULT;
       public          postgres    false    219    218            �           2604    41173 0   REDEEMED_CUSTOMER_GIFT redeemed_customer_gift_id    DEFAULT     �   ALTER TABLE ONLY public."REDEEMED_CUSTOMER_GIFT" ALTER COLUMN redeemed_customer_gift_id SET DEFAULT nextval('public."REDEEMED_CUSTOMER_GIFT_redeemed_customer_gift_id_seq"'::regclass);
 a   ALTER TABLE public."REDEEMED_CUSTOMER_GIFT" ALTER COLUMN redeemed_customer_gift_id DROP DEFAULT;
       public          postgres    false    223    222    223            &          0    41077    CUSTOMER 
   TABLE DATA           w   COPY public."CUSTOMER" (customer_id, customer_name, customer_phone, customer_type_id, deleted, deleted_at) FROM stdin;
    public          postgres    false    214   TA       '          0    41088    CUSTOMER_TYPE 
   TABLE DATA              COPY public."CUSTOMER_TYPE" (customer_type_id, customer_type_name, customer_type_description, deleted, deleted_at) FROM stdin;
    public          postgres    false    215   �A       -          0    41152    CUSTOMER_TYPE_GIFT_TYPE 
   TABLE DATA           {   COPY public."CUSTOMER_TYPE_GIFT_TYPE" (customer_type_gift_type_id, customer_type_id, gift_type_id, created_at) FROM stdin;
    public          postgres    false    221   �A       *          0    41096 	   GIFT_TYPE 
   TABLE DATA              COPY public."GIFT_TYPE" (gift_type_id, gift_type_name, gift_type_description, deleted, deleted_at, gift_type_code) FROM stdin;
    public          postgres    false    218   cB       /          0    41170    REDEEMED_CUSTOMER_GIFT 
   TABLE DATA           t   COPY public."REDEEMED_CUSTOMER_GIFT" (redeemed_customer_gift_id, customer_id, gift_type_id, created_at) FROM stdin;
    public          postgres    false    223   �B       ;           0    0 6   CUSTOMER_TYPE_GIFT_TYPE_customer_type_gift_type_id_seq    SEQUENCE SET     g   SELECT pg_catalog.setval('public."CUSTOMER_TYPE_GIFT_TYPE_customer_type_gift_type_id_seq"', 13, true);
          public          postgres    false    220            <           0    0 "   CUSTOMER_TYPE_customer_type_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public."CUSTOMER_TYPE_customer_type_id_seq"', 3, true);
          public          postgres    false    216            =           0    0    CUSTOMER_customer_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public."CUSTOMER_customer_id_seq"', 2, true);
          public          postgres    false    217            >           0    0    GIFT_TYPE_gift_type_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public."GIFT_TYPE_gift_type_id_seq"', 7, true);
          public          postgres    false    219            ?           0    0 4   REDEEMED_CUSTOMER_GIFT_redeemed_customer_gift_id_seq    SEQUENCE SET     d   SELECT pg_catalog.setval('public."REDEEMED_CUSTOMER_GIFT_redeemed_customer_gift_id_seq"', 4, true);
          public          postgres    false    222            �           2606    41116     CUSTOMER_TYPE CUSTOMER_TYPE_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public."CUSTOMER_TYPE"
    ADD CONSTRAINT "CUSTOMER_TYPE_pkey" PRIMARY KEY (customer_type_id);
 N   ALTER TABLE ONLY public."CUSTOMER_TYPE" DROP CONSTRAINT "CUSTOMER_TYPE_pkey";
       public            postgres    false    215            �           2606    41118    CUSTOMER CUSTOMER_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public."CUSTOMER"
    ADD CONSTRAINT "CUSTOMER_pkey" PRIMARY KEY (customer_id);
 D   ALTER TABLE ONLY public."CUSTOMER" DROP CONSTRAINT "CUSTOMER_pkey";
       public            postgres    false    214            �           2606    41120    GIFT_TYPE GIFT_TYPE_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public."GIFT_TYPE"
    ADD CONSTRAINT "GIFT_TYPE_pkey" PRIMARY KEY (gift_type_id);
 F   ALTER TABLE ONLY public."GIFT_TYPE" DROP CONSTRAINT "GIFT_TYPE_pkey";
       public            postgres    false    218            �           2606    41186 6   REDEEMED_CUSTOMER_GIFT customer_id_gift_type_id_unique 
   CONSTRAINT     �   ALTER TABLE ONLY public."REDEEMED_CUSTOMER_GIFT"
    ADD CONSTRAINT customer_id_gift_type_id_unique UNIQUE (customer_id, gift_type_id);
 b   ALTER TABLE ONLY public."REDEEMED_CUSTOMER_GIFT" DROP CONSTRAINT customer_id_gift_type_id_unique;
       public            postgres    false    223    223            �           2606    41126    CUSTOMER customer_phone_unique 
   CONSTRAINT     e   ALTER TABLE ONLY public."CUSTOMER"
    ADD CONSTRAINT customer_phone_unique UNIQUE (customer_phone);
 J   ALTER TABLE ONLY public."CUSTOMER" DROP CONSTRAINT customer_phone_unique;
       public            postgres    false    214            �           2606    41168 <   CUSTOMER_TYPE_GIFT_TYPE customer_type_id_gift_type_id_unique 
   CONSTRAINT     �   ALTER TABLE ONLY public."CUSTOMER_TYPE_GIFT_TYPE"
    ADD CONSTRAINT customer_type_id_gift_type_id_unique UNIQUE (customer_type_id, gift_type_id);
 h   ALTER TABLE ONLY public."CUSTOMER_TYPE_GIFT_TYPE" DROP CONSTRAINT customer_type_id_gift_type_id_unique;
       public            postgres    false    221    221            �           2606    41128 ,   CUSTOMER_TYPE customer_type_type_name_unique 
   CONSTRAINT     w   ALTER TABLE ONLY public."CUSTOMER_TYPE"
    ADD CONSTRAINT customer_type_type_name_unique UNIQUE (customer_type_name);
 X   ALTER TABLE ONLY public."CUSTOMER_TYPE" DROP CONSTRAINT customer_type_type_name_unique;
       public            postgres    false    215            �           2606    41130 $   GIFT_TYPE gift_type_type_name_unique 
   CONSTRAINT     k   ALTER TABLE ONLY public."GIFT_TYPE"
    ADD CONSTRAINT gift_type_type_name_unique UNIQUE (gift_type_name);
 P   ALTER TABLE ONLY public."GIFT_TYPE" DROP CONSTRAINT gift_type_type_name_unique;
       public            postgres    false    218            �           2606    41131 '   CUSTOMER customer_customer_type_foreign    FK CONSTRAINT     �   ALTER TABLE ONLY public."CUSTOMER"
    ADD CONSTRAINT customer_customer_type_foreign FOREIGN KEY (customer_type_id) REFERENCES public."CUSTOMER_TYPE"(customer_type_id) ON UPDATE CASCADE ON DELETE SET NULL;
 S   ALTER TABLE ONLY public."CUSTOMER" DROP CONSTRAINT customer_customer_type_foreign;
       public          postgres    false    214    215    3208            �           2606    41157 H   CUSTOMER_TYPE_GIFT_TYPE customer_type_gift_type_customer_type_id_foreign    FK CONSTRAINT     �   ALTER TABLE ONLY public."CUSTOMER_TYPE_GIFT_TYPE"
    ADD CONSTRAINT customer_type_gift_type_customer_type_id_foreign FOREIGN KEY (customer_type_id) REFERENCES public."CUSTOMER_TYPE"(customer_type_id) ON UPDATE CASCADE ON DELETE SET NULL;
 t   ALTER TABLE ONLY public."CUSTOMER_TYPE_GIFT_TYPE" DROP CONSTRAINT customer_type_gift_type_customer_type_id_foreign;
       public          postgres    false    3208    221    215            �           2606    41162 D   CUSTOMER_TYPE_GIFT_TYPE customer_type_gift_type_gift_type_id_foreign    FK CONSTRAINT     �   ALTER TABLE ONLY public."CUSTOMER_TYPE_GIFT_TYPE"
    ADD CONSTRAINT customer_type_gift_type_gift_type_id_foreign FOREIGN KEY (gift_type_id) REFERENCES public."GIFT_TYPE"(gift_type_id) ON UPDATE CASCADE ON DELETE SET NULL;
 p   ALTER TABLE ONLY public."CUSTOMER_TYPE_GIFT_TYPE" DROP CONSTRAINT customer_type_gift_type_gift_type_id_foreign;
       public          postgres    false    218    221    3212            �           2606    41175 A   REDEEMED_CUSTOMER_GIFT redeemed_customer_gift_customer_id_foreign    FK CONSTRAINT     �   ALTER TABLE ONLY public."REDEEMED_CUSTOMER_GIFT"
    ADD CONSTRAINT redeemed_customer_gift_customer_id_foreign FOREIGN KEY (customer_id) REFERENCES public."CUSTOMER"(customer_id) ON UPDATE CASCADE ON DELETE SET NULL;
 m   ALTER TABLE ONLY public."REDEEMED_CUSTOMER_GIFT" DROP CONSTRAINT redeemed_customer_gift_customer_id_foreign;
       public          postgres    false    3204    214    223            �           2606    41180 B   REDEEMED_CUSTOMER_GIFT redeemed_customer_gift_gift_type_id_foreign    FK CONSTRAINT     �   ALTER TABLE ONLY public."REDEEMED_CUSTOMER_GIFT"
    ADD CONSTRAINT redeemed_customer_gift_gift_type_id_foreign FOREIGN KEY (gift_type_id) REFERENCES public."GIFT_TYPE"(gift_type_id) ON UPDATE CASCADE ON DELETE SET NULL;
 n   ALTER TABLE ONLY public."REDEEMED_CUSTOMER_GIFT" DROP CONSTRAINT redeemed_customer_gift_gift_type_id_foreign;
       public          postgres    false    223    218    3212            &   ?   x�3���/-.ILK�4423��460��4�L���2Jf$榦 ��L��̌L8�!r1z\\\ �T      '   <   x�3�,JM/�I,�L�I� �4�?.#����Nw��s�$�d��r�� D&F��� ��K      -   d   x�����0Dѳ�"����RK��#� �ק��cd�(��!��Wld�/2p��H�jEc#'Ӂ�ĜhN�o-;���8)Z]1Dnfa��V��Y�� �^�Q�      *   s   x�e�1
�0�Y�mJlY�-z�,-$!C2�z��6�7�J��������S*��]�<������'Mb:UF�yl)6��(%Ea��Ǟbgh��QST��h-Ec��Ǒ�`, ��L      /   J   x�M˱� D�ڞ"}�	1D&`�9�]�_���T�l�Z+�%N�:�#۟�T��_1Ka�	�(����l�     