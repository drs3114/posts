create table app_info
(
    app_info_id    bigint not null auto_increment,
    app_info_desc  varchar(255),
    app_info_typ   integer,
    app_info_webst varchar(255),
    primary key (app_info_id)
) engine = InnoDB;