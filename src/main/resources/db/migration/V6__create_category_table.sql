create table categories (
    id BIGSERIAL primary key,
    name varchar(255) not null,
    description TEXT NOT NULL,
    manager_id BIGSERIAL not null,

    constraint fk_manager
    foreign key (manager_id) references users(id)
);