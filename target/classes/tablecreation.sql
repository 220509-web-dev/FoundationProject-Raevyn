set search_path to art_app;

create table app_users (
id            int generated always as identity primary key,
first_name    varchar not null,
last_name     varchar not null,
email         varchar unique not null,
username      varchar unique not null check (length(username)>=4),
password      varchar not null check (length(password)>=4)
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
user_id      int references app_users(id),
category_id  int references categories(id)
);

create table collections (
id          int generated always as identity primary key,
name        varchar null,
owner_id    int references app_users(id),
category_id int references categories(id)
);

create table indiv_collection (
indiv_id int generated always as identity primary key,
collection_id int references Collections(id),
artwork_id int references Artwork(id)
);

SELECT * FROM app_users;
