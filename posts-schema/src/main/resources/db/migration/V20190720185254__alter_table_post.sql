alter table post
    add constraint FK_post_genre
        foreign key (pst_gnr)
            references genre (gnr_id);

alter table post
    add constraint FK_post_rctn
        foreign key (pst_rctn)
            references rctn (rctn_id);