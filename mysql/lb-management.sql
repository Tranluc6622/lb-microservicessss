create database test3;
use test3;
 create table test3.book
(
	id binary(255) primary key AUTO_INCREMENT,
    book_name varchar(255) not null,
    first_letter varchar(255) not null,
    author_id varchar(255) not null,
    constraint FK_author_id foreign key (author_id) references author(author_id),
    category_id varchar(255) not null,
    constraint FK_category_id foreign key (category_id) references category(category_id)
);
create table test3.users
(
	id binary(255) primary key auto_increment,
    create_at datetime(6) not null,
    email varchar(255) not null,
    full_name varchar(255) not null,
    password varchar(255) not null,
    role_name varchar(255) not null,
    user_name varchar(255)  not null unique
);
create table test3.author
(
	id nvarchar(255) primary key,
    author_name nvarchar(255) not null
); 
create table test3.category 
(
	id nvarchar(255) primary key,
    category_name nvarchar(30) not null
);
insert into test3.author(id,author_name)
values  ('NA','Nguyen Anh'),
		('CD','Conan Doyle'),
        ('SK','Stephen Kings'),
        ('JR','J.K Rowling');
        
insert into test3.category(id,category_name)
	values  ('De','Detective'),
		('Te','Teenager'),
        ('Hr','Horror'),
        ('Scifi','Science Fictic'),
        ('Adv','Adventure'),
        ('Fa','Fantasy');
        
insert into test3.book(id,book_name,first_letter,author_id,category_id)
values  ('2fb9a38c-4ab2-11ed-b878-0242ac120002' ,'Harry Potter And The Secret Room','H','JR','Adv');
-- 		(2,'Sherlock Holmes','S','CD','De'),
--         (3,'The Shining','T','SK','Hr'),
--         (4,'Mat biec','M','NA','Teen'),
--         (5,'Toi thay hoa vang tren co xanh','T','NA','Teen'),
--         (6,'Ngoi khoc tren cay','N','NA','Teen'),
--         (7,'The Green Miles','T','SK','De'); 
        
select * from test3.author;
select * from test3.book;
select * from test3.category;
select * from test3.users
-- delete from test3.users
-- where user_name = "TranLuc"