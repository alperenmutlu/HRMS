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

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 16592)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    user_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16580)
-- Name: employers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employers (
    user_id integer NOT NULL,
    website character varying(250) NOT NULL,
    phone_number character varying(30) NOT NULL,
    is_verified boolean NOT NULL,
    company_name character varying(250) NOT NULL
);


ALTER TABLE public.employers OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 24773)
-- Name: verification_codes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.verification_codes (
    id integer NOT NULL,
    user_id integer NOT NULL,
    code character varying(50) NOT NULL,
    is_confirmed boolean NOT NULL,
    created_at date NOT NULL
);


ALTER TABLE public.verification_codes OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 24771)
-- Name: employers_verification_codes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.verification_codes ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.employers_verification_codes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 211 (class 1259 OID 24780)
-- Name: employers_verification_employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employers_verification_employees (
    id integer NOT NULL,
    employer_id integer NOT NULL,
    employee_id integer NOT NULL,
    created_at date DEFAULT CURRENT_DATE NOT NULL
);


ALTER TABLE public.employers_verification_employees OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 24778)
-- Name: employers_verification_employees_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.employers_verification_employees ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.employers_verification_employees_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 205 (class 1259 OID 16642)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 24592)
-- Name: job_positions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_positions (
    id integer NOT NULL,
    job_title character varying(150) NOT NULL,
    created_at date,
    is_active boolean,
    is_deleted boolean
);


ALTER TABLE public.job_positions OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24590)
-- Name: job_positions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.job_positions ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.job_positions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 201 (class 1259 OID 16569)
-- Name: jobseekers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jobseekers (
    user_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    national_id character varying(11) NOT NULL,
    is_verified boolean NOT NULL,
    date_of_birth date NOT NULL
);


ALTER TABLE public.jobseekers OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16564)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(30) NOT NULL,
    created_at date,
    is_active boolean,
    is_deleted boolean
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16616)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2895 (class 2606 OID 16599)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2893 (class 2606 OID 16589)
-- Name: employers employers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2899 (class 2606 OID 24777)
-- Name: verification_codes employers_verification_codes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.verification_codes
    ADD CONSTRAINT employers_verification_codes_pkey PRIMARY KEY (id);


--
-- TOC entry 2901 (class 2606 OID 24784)
-- Name: employers_verification_employees employers_verification_employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers_verification_employees
    ADD CONSTRAINT employers_verification_employees_pkey PRIMARY KEY (id);


--
-- TOC entry 2897 (class 2606 OID 24596)
-- Name: job_positions job_positions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT job_positions_pkey PRIMARY KEY (id);


--
-- TOC entry 2889 (class 2606 OID 24810)
-- Name: jobseekers jobseekers_national_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jobseekers
    ADD CONSTRAINT jobseekers_national_id_key UNIQUE (national_id) INCLUDE (national_id);


--
-- TOC entry 2891 (class 2606 OID 16591)
-- Name: jobseekers jobseekers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jobseekers
    ADD CONSTRAINT jobseekers_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2885 (class 2606 OID 24812)
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email) INCLUDE (email);


--
-- TOC entry 2887 (class 2606 OID 16568)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2906 (class 2606 OID 24823)
-- Name: employers_verification_employees employee_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers_verification_employees
    ADD CONSTRAINT employee_id FOREIGN KEY (employee_id) REFERENCES public.employees(user_id) NOT VALID;


--
-- TOC entry 2907 (class 2606 OID 24828)
-- Name: employers_verification_employees employer_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers_verification_employees
    ADD CONSTRAINT employer_id FOREIGN KEY (employer_id) REFERENCES public.employers(user_id) NOT VALID;


--
-- TOC entry 2903 (class 2606 OID 16623)
-- Name: employers user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2902 (class 2606 OID 16628)
-- Name: jobseekers user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jobseekers
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2904 (class 2606 OID 16633)
-- Name: employees user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2905 (class 2606 OID 24838)
-- Name: verification_codes user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.verification_codes
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;