create table ceres (
  id    integer primary key autoincrement,
  key   text not null unique,
  value text not null
);

drop table ceres;

insert or replace into ceres (key, value)
values (?, ?);

select *
from ceres;

select *
from ceres
where key=?;