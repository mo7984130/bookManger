-- auto-generated definition
create schema bookManger collate utf8mb4_0900_ai_ci;

-- auto-generated definition
create table book
(
    id          int auto_increment,
    bookName    varchar(255) not null,
    owner       varchar(255) not null,
    addTime     varchar(255) not null,
    type        varchar(255) null,
    borrower    varchar(255) null,
    lendTime    varchar(255) null,
    returnTime  varchar(255) null,
    isAvailable int          null,
    constraint book_id_uindex
        unique (id)
);

alter table book
    add primary key (id);

