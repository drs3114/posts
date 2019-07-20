create table prgrph
(
    pg_id    bigint       not null auto_increment,
    pg_cntnt varchar(255) not null,
    pg_ordr  integer,
    primary key (pg_id)
) engine = InnoDB;