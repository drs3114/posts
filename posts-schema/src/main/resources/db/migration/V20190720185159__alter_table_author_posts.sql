alter table athr_posts
    add constraint FK_athrPosts_post
        foreign key (posts_pst_id)
            references post (pst_id);

alter table athr_posts
    add constraint FK_athrPosts_athr
        foreign key (author_atr_id)
            references athr (atr_id);