create table role (
id int(11) not null auto_increment,
role_name varchar(25) not null,
user_id int(11),
user_name varchar(15) not null,
primary key(id)
);

create table my_workouts (
  id int(11) not null auto_increment,
  workout varchar(255),
  date_created Date,
  date_modified Date,
  primary key(id)
);

alter table role
add constraint role_user_name_fkey
foreign key (user_name)
references user (user_name)
on delete cascade
on update cascade;