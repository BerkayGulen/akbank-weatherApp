DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users
(
    id bigint NOT NULL,
    FIRST_NAME character varying(100) ,
    LAST_NAME character varying(100) ,
    USERNAME character varying(50) ,
    EMAIL character varying(50) ,
    PASSWORD character varying(400) ,
    ID_CUSTOMER_CREATED_BY bigint,
    ID_CUSTOMER_UPDATE_BY bigint,
    CREATE_DATE timestamp ,
    UPDATE_DATE timestamp ,
    CONSTRAINT user_pkey PRIMARY KEY (id)

);
CREATE SEQUENCE IF NOT EXISTS user_id_seq start with 1 increment by 50;
