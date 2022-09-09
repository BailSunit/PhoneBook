create table contact (
id int primary key auto_increment,
user_id int,
foreign key(user_id) references user(id),
name varchar(20),
phone varchar(20),
address varchar(100));

create table user(
id int primary key auto_increment,
username varchar(20),
password varchar(50),
name varchar(50),
phone varchar(20),
email varchar(30),
address varchar(100),
public varchar(20),
constraint usernameU unique (username));
