create table app
(
    app_id   bigint not null auto_increment,
    app_nm   varchar(255),
    app_info bigint,
    primary key (app_id)
) engine = InnoDB;