alter table tickets
add constraint fk_ticket_category
foreign key (category_id)
references categories(id);