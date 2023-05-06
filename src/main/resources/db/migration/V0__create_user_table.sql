create table USERS (
       id bigint not null,
        created_time timestamp(6),
        mod_rev integer not null,
        mod_time timestamp(6),
        status varchar(255),
        email varchar(255) not null,
        name varchar(255) not null,
        password varchar(255) not null,
        user_name varchar(100) not null,
        primary key (id)
    );

    alter table if exists USERS
           add constraint UK_k8d0f2n7n88w1a16yhua64onx unique (user_name)