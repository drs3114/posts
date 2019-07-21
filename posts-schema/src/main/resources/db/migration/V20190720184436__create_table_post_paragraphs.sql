create table post_paragraphs
(
    post_pst_id      bigint not null,
    paragraphs_pg_id bigint not null,
    primary key (post_pst_id, paragraphs_pg_id)
) engine = InnoDB;