create table athr
(
    atr_id      bigint       not null auto_increment,
    atr_eml     varchar(255) not null,
    atr_frst_nm varchar(25)  not null,
    atr_lst_nm  varchar(25)  not null,
    atr_pen_nm  varchar(15),
    primary key (atr_id)
) engine = InnoDB;