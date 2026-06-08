create table category_executors (
                                    category_id bigint not null,
                                    user_id bigint not null,

                                    constraint fk_category_executors_category
                                        foreign key (category_id)
                                        references categories(id),

                                    constraint fk_category_assignee_user
                                        foreign key (user_id)
                                            references users(id),

                                    constraint pk_category_assignees
                                        primary key (category_id, user_id)
);