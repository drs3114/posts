alter table post_paragraphs
    add constraint FK_pstPrgrph_prgrph
        foreign key (paragraphs_pg_id)
            references prgrph (pg_id);

alter table post_paragraphs
    add constraint FK_pstPrgrph_post
        foreign key (post_pst_id)
            references post (pst_id);