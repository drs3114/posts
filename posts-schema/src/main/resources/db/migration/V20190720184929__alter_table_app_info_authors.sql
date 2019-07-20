alter table app_info_authors
    add constraint FK_appInfoAuthors_athr
        foreign key (authors_atr_id)
            references athr (atr_id);

alter table app_info_authors
    add constraint FK_appInfoAuthors_appInfo
        foreign key (app_info_app_info_id)
            references app_info (app_info_id);