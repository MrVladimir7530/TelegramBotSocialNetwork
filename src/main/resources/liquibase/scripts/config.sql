--liquibase formatted sql

--changeset VolkovVladimir:create_table_user
create table if not exists users(
    chat_id bigint primary key,
    first_name varchar(255),
    last_name varchar(255),
    user_name varchar(255),
    phone_number varchar(255)
);

