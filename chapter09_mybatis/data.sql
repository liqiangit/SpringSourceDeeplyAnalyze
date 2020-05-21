

drop table if exists user;

create table if not exists user (
  `id` int not null auto_increment primary key,
  `name` varchar(255),
  `age` int
);