drop table constant;
create table constant (
idx int(3) not null,
constance_name varchar(100) not null,
constance_value varchar(200),
constance_sort int(3),
PRIMARY KEY (constance_name)
);