alter table app
    add constraint FK_app_appInfo
        foreign key (app_info)
            references app_info (app_info_id);