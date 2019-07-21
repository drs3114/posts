alter table author_websites
    add constraint FK_authorWebsites_athr
        foreign key (author_atr_id)
            references athr (atr_id);