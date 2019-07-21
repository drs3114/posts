create table genre
(
    gnr_id   bigint       not null auto_increment,
    gnr_desc varchar(255),
    gnr_nme  varchar(255) not null,
    primary key (gnr_id)
) engine = InnoDB;