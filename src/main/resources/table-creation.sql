create schema project_app;

set search_path to project_app;

create table user_roles (
    id      int generated always as identity primary key,
    name    varchar unique not null
);

create table app_users (
    id            int generated always as identity primary key,
    first_name    varchar not null,
    last_name     varchar not null,
    email         varchar unique not null,
    username      varchar unique not null check (length(username)>=4),
    password      varchar not null check (length(password)>=4),
    role_id       int,

    constraint role_id_fk
    foreign key (role_id) 
    references user_roles(id)

);


create table categories (
    id      int generated always as identity primary key,
    name    varchar unique not null
);

create table artwork (
    id           int generated always as identity primary key,
    art_title    varchar not null,
    artist       varchar not null,
    descrip      varchar not null,
    price        varchar not null,
    seller_id    int,
    category_id  int,

    constraint artwork_creator_fk
    foreign key (seller_id)
    references app_users(id),

    constraint artwork_category_fk
    foreign key (category_id)
    references  categories(id)
);

create table collections (
    id          int generated always as identity primary key,
    name        varchar null,
    owner_id    int,
    category_id int,

    constraint collections_owner_fk
    foreign key (owner_id)
    references app_users(id),

    constraint collections_category_fk
    foreign key (category_id)
    references categories(id)
);

create table indiv_collection (
    collection_id int,
    artwork_id int,

    constraint indiv_collection_pk
    primary key (collection_id, artwork_id),

    constraint collection_id_fk
    foreign key (collection_id)
    references collections(id),

    constraint artwork_id_fk
    foreign key (artwork_id)
    references artwork(id)
);
