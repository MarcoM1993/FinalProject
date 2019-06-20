drop table users;
drop table cinguetts;

create table users
(
name varchar2(50),
surname varchar2(50),
email varchar2(254),
password varchar2(128),
urlimageprofile varchar(500),
birthday date,
constraint pk_users_email primary key(email)
);

create table cinguetts(
id number(38,0),
text varchar2(150),
user_email varchar2(254),
post_time date,
constraint pk_cinguetts_id primary key(id),
constraint fk_cinguetts_users_id foreign key(user_email) references users(email)
);

create table comments(
id number(38,0),
text varchar2(150),
post_time date,
user_email varchar(254),
cinguett_id number(38,0),
constraint pk_comments_id primary key(id),
constraint fk_comments_cinguetts_id foreign key (cinguett_id) references cinguetts(id),
constraint fk_comments_users_email foreign key (user_email) references users(email)
);