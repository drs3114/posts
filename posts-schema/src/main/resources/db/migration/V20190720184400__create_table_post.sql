create table post
(
    pst_id   bigint       not null auto_increment,
    pst_nts  varchar(255),
    pst_ttl  varchar(255) not null,
    pst_typ  integer,
    pst_gnr  bigint       not null,
    pst_rctn bigint,
    primary key (pst_id)
) engine = InnoDB;