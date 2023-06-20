use kittu;
create table atmdb(
acno varchar(10) primary key,
Name varchar(20) not null,
pin int,
balence int);
insert into atmdb values
("ab10020000","10",1234,0);
("ab10020001","k k kasyap",5321,32000),
("ab10020002","k hemasri",9999,45000),
("ab10020003","m p rajpaul",9027,33000),
("ab10020004","m d pranathi",2003,66000),
("ab10020005","m t c v sumaja",0708,28000);
select * from atmdb;



