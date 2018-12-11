CREATE TABLE users (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25),
  `last_name` varchar(30),
   user_name varchar(15) NOT NULL,
  `password` varchar(30) Not Null,
  date_of_birth Date,
  `locations_id` int(11),
  PRIMARY KEY (`id`),
  KEY `user_locations` (`locations_id`),
  CONSTRAINT `user_locations` FOREIGN KEY (`locations_id`) REFERENCES `locations` (`id`)
);

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
  user_id int(11) not null,
  mileage int(5),
  primary key(id)
);

CREATE TABLE locations (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  `zip` int(11) NOT NULL,
  PRIMARY KEY (`id`)
  );

create table blog(
id int(11) not null auto_increment,
title varchar(50) not null,
blog varchar(1500) not null,
date_created Date,
user_id int(11),
primary key(id)
);

alter table role
add constraint role_user_name_fkey
foreign key (user_name)
references user (user_name)
on delete cascade
on update cascade;

alter table user
add constraint user_locations_fkey
foreign key (locations_id)
references locations (id)
on delete cascade
on update cascade;

alter table blog
add constraint blog_user_id_fkey
foreign key (user_id)
references user (id)
on delete cascade
on update cascade;
