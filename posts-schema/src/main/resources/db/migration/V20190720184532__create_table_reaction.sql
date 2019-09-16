create table rctn
(
    rctn_id    bigint not null auto_increment,
    rctn_agry  bigint,
    rctn_dslik bigint,
    rctn_hpy   bigint,
    rctn_lik   bigint,
    rctn_sad   bigint,
    primary key (rctn_id)
) engine = InnoDB;