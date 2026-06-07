alter table users
add column profile_id bigserial;

alter table users
add constraint fk_user_profile
foreign key (profile_id)
references profiles(id);

alter table users
drop column profile;