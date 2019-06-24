drop table comments;
drop table cinguetts;
drop table users;


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


insert into users values('Marco', 'Micheli','marco@gmail.com', 'password','default.jpg',to_date('1993-06-16', 'yyyy-mm-dd'));
insert into users values('Alessandro', 'Ortu','alessandro@gmail.com', 'password','default.jpg',to_date('1992-11-27', 'yyyy-mm-dd'));
insert into users values('Mara', 'Medda','mara@gmail.com', 'password','default.jpg',to_date('1993-10-25', 'yyyy-mm-dd'));
insert into users values('Davide', 'Scintu','davide@gmail.com', 'password','default.jpg',to_date('1995-01-12', 'yyyy-mm-dd'));
insert into users values('Federico', 'Spiga','federico@gmail.com', 'password','default.jpg',to_date('1995-01-10', 'yyyy-mm-dd'));