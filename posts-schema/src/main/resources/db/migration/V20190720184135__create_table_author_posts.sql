create table athr_posts
(
    author_atr_id bigint not null,
    posts_pst_id  bigint not null,
    primary key (author_atr_id, posts_pst_id)
) engine = InnoDB;