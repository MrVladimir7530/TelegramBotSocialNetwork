--liquibase formatted sql

--changeset VolkovVladimir:create_table_user
create table if not exists users(
    chat_id bigint primary key,
    first_name varchar(255),
    last_name varchar(255),
    user_name varchar(255),
    phone_number varchar(255)
);

--changeset VolkovVladimir:create_table_admin
create table if not exists admins(
    id bigserial primary key,
    companion_id bigint not null,
    stage varchar(255),
    admin_id bigint not null,
    foreign key(admin_id) references users (chat_id)
)

