drop table comments;
drop table cinguetts;
drop table users;


create table users
(
id number(38,0),
name varchar2(50) NOT NULL,
surname varchar2(50) NOT NULL,
email varchar2(254) NOT NULL UNIQUE,
password varchar2(128) NOT NULL,
urlimageprofile varchar(500) NOT NULL,
birthday date NOT NULL,
constraint pk_users_id primary key(id)
);


create table cinguetts(
id number(38,0),
text varchar2(150) NOT NULL,
user_id number(38,0) NOT NULL,
post_time date NOT NULL,
constraint pk_cinguetts_id primary key(id),
constraint fk_cinguetts_users_id foreign key(user_id) references users(id)
);

create table comments(
id number(38,0),
text varchar2(150) NOT NULL,
post_time date NOT NULL,
user_id number(38,0) NOT NULL,
cinguett_id number(38,0) NOT NULL,
constraint pk_comments_id primary key(id),
constraint fk_comments_cinguetts_id foreign key (cinguett_id) references cinguetts(id),
constraint fk_comments_users_id foreign key (user_id) references users(id)
);


insert into users values(0,'Marco', 'Micheli','marco@gmail.com', 'password','default.jpg',to_date('1993-06-16', 'yyyy-mm-dd'));
insert into users values(1,'Alessandro', 'Ortu','alessandro@gmail.com', 'password','default.jpg',to_date('1992-11-27', 'yyyy-mm-dd'));
insert into users values(2,'Mara', 'Medda','mara@gmail.com', 'password','default.jpg',to_date('1993-10-25', 'yyyy-mm-dd'));
insert into users values(3,'Davide', 'Scintu','davide@gmail.com', 'password','default.jpg',to_date('1995-01-12', 'yyyy-mm-dd'));
insert into users values(4,'Federico', 'Spiga','federico@gmail.com', 'password','default.jpg',to_date('1995-01-10', 'yyyy-mm-dd'));


insert into cinguetts values(0, 'Ciao sono Marco', 0,  TO_DATE('2019-05-15 8:30:25', 'YYYY-MM-DD HH24:MI:SS'));
insert into cinguetts values(1, 'Ciao sono eskere', 2,  TO_DATE('2018-05-15 8:30:25', 'YYYY-MM-DD HH24:MI:SS'));
insert into cinguetts values(2, 'Buongiornissimo', 1,  TO_DATE('2019-04-15 8:30:25', 'YYYY-MM-DD HH24:MI:SS'));
insert into cinguetts values(3, 'Ho voglia di gelato', 4,  TO_DATE('2019-05-16 8:30:25', 'YYYY-MM-DD HH24:MI:SS'));
insert into cinguetts values(4, 'Mi piace la birillica', 3,  TO_DATE('2019-05-15 8:30:20', 'YYYY-MM-DD HH24:MI:SS'));
insert into cinguetts values(5, 'Samu tvb', 2,  TO_DATE('2019-05-15 9:30:10', 'YYYY-MM-DD HH24:MI:SS'));
insert into cinguetts values(6, 'Cinguetter the best', 1,  TO_DATE('2019-05-15 5:30:25', 'YYYY-MM-DD HH24:MI:SS'));
insert into cinguetts values(7, 'Che martedì brutto', 1,  TO_DATE('2019-05-15 16:30:25', 'YYYY-MM-DD HH24:MI:SS'));
insert into cinguetts values(8, 'I love sushi', 2,  TO_DATE('2019-05-15 18:30:25', 'YYYY-MM-DD HH24:MI:SS'));
insert into cinguetts values(9, 'sushimpru', 4,  TO_DATE('2019-05-15 20:30:25', 'YYYY-MM-DD HH24:MI:SS'));
insert into cinguetts values(10, 'Team', 2, TO_DATE('2019-05-15 14:30:25', 'YYYY-MM-DD HH24:MI:SS'));
insert into cinguetts values(11, 'Enjoy Java', 3,  TO_DATE('2019-05-15 15:30:25', 'YYYY-MM-DD HH24:MI:SS'));


insert into comments values(0, 'Bravo bro', TO_DATE('2019-06-25 8:30:25', 'YYYY-MM-DD HH24:MI:SS'), 0, 2 );
insert into comments values(1, 'Buuuu', TO_DATE('2019-06-25 8:40:25', 'YYYY-MM-DD HH24:MI:SS'), 1, 2 );
insert into comments values(2, 'Yeeee', TO_DATE('2019-06-25 8:35:25', 'YYYY-MM-DD HH24:MI:SS'), 1, 1 );
insert into comments values(3, 'Anche a me', TO_DATE('2019-06-25 8:32:25', 'YYYY-MM-DD HH24:MI:SS'), 3, 0 );
insert into comments values(4, 'Tvb anche io', TO_DATE('2019-06-25 8:37:25', 'YYYY-MM-DD HH24:MI:SS'), 3, 0 );

